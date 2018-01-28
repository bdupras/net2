package net2.relogo

import static repast.simphony.relogo.Utility.*
import static repast.simphony.relogo.UtilityG.*
import static net2.relogo.Utils.*
import static com.duprasville.limiters.util.Utils.*

import com.duprasville.limiters.RateLimiters
import com.duprasville.limiters.comms.MessageSender
import com.duprasville.limiters.treefill.TreeFillRateLimiter
import com.duprasville.limiters.RateLimiter
import com.duprasville.limiters.util.karytree.KaryLayout
import com.duprasville.limiters.util.karytree.KaryTree
import com.google.common.util.concurrent.ForkedRateLimiter
import net2.ReLogoTurtle
import net2.comms.TurtleMessageSender
import repast.simphony.relogo.AgentSet
import repast.simphony.relogo.UtilityG
import repast.simphony.relogo.schedule.Go
import repast.simphony.relogo.schedule.Setup

class ClusterNode extends ReLogoTurtle {
	private long clusterId = -1
	private long clusterSize = -1
	private KaryTree tree = null
	private KaryLayout layout = null
	private AgentSet<ClusterNode> parent = null
	private AgentSet<ClusterNode> children = null
	private AgentSet<ClusterNode> base = null
	private RateLimiter limiter = null

	public void clusterInit(int clusterId, int clusterSize) {
		this.clusterId = clusterId
		this.clusterSize = clusterSize
		this.tree = KaryTree.byMinCapacity(5, (long)clusterSize)
		this.layout = new KaryLayout(tree)
	}

	public double getRelSize() {
		layout.relSize(clusterId)
	}

	public double[] getRelCor() {
		[
			layout.relX(clusterId),
			layout.relY(clusterId)
		]
	}

	def clusterNodeResolver = { long resolveId ->
		clusterNodes().with() { ClusterNode clusterNode ->
			clusterNode.clusterId == resolveId
		}.first()
	}

	TurtleMessageSender<ClusterNode> clusterNodeMessageSender = new TurtleMessageSender<>("treefillMessage", clusterNodeResolver);
	public treefillMessage(ClusterNode src, ClusterNode dst, Object msg) {
		clusterNodeMessageSender.receive(src.clusterId, dst.clusterId, msg)
	}

	@Setup
	def setup() {
		shape = "square"
		color = yellow()
		size = getRelSize()

		long parentId = tree.parentOfNode(clusterId)
		parent = clusterNodes().with { ClusterNode cn ->
			parentId == cn.clusterId
		}

		//		long minChild = treeNode.children.min.id
		//		long maxChild = treeNode.children.max.id
		//		children = clusterNodes().with { ClusterNode cn ->
		//			(minChild <= cn.clusterId) && (cn.clusterId <= maxChild)
		//		}
		//
		//		long minBase = tree.base.nodes.min.id
		//		long maxBase = tree.base.nodes.max.id
		//		base = clusterNodes().with { ClusterNode cn ->
		//			(minBase <= cn.clusterId) && (cn.clusterId <= maxBase)
		//		}
		//
		//		int myShare = spread(clusterId, clusterQuota, clusterSize)
		//		limiter = myShare > 0 ? ForkedRateLimiter.create(myShare, RELOGO_TICKER) : RateLimiters.NEVER;

		int myShare = spread(clusterId, clusterQuota, clusterSize)

		limiter = myShare <= 0 ? RateLimiters.NEVER : new TreeFillRateLimiter(myShare, clusterId, clusterSize, tree, clusterNodeMessageSender)
	}


	boolean previouslyRateLimited = false
	public boolean tryAcquire(int itemsRequested) {
		boolean ret
		if (previouslyRateLimited) {
			ret = limiter.tryAcquire(itemsRequested)
			previouslyRateLimited = !ret
		} else {
			ret = true
			previouslyRateLimited = !limiter.tryAcquire(itemsRequested)
		}

		color = ret ? green() : orange()
		ret
	}

	//	@Go(start=1d, interval=30d, pick=10l, shuffle=true)
	//	def go() {
	//		sendHello(parent, this, "hi mom ")
	//	}
	//
	//	def sendHello(AgentSet<ClusterNode> dsts, ClusterNode replyTo, String msg) {
	//		dsts.each { ClusterNode dst ->
	//			sendHello(dst, replyTo, msg)
	//		}
	//	}
	//
	//	def sendHello(ClusterNode dst, ClusterNode replyTo, String msg) {
	//		Packet.newPacket(this, dst, "receiveHello", [msg: msg, replyTo: replyTo]).send()
	//	}
	//
	//	def receiveHello(payload) {
	//		show(payload.msg)
	//		def ClusterNode rt = payload['replyTo']
	//		if (null != rt) {
	//			sendHello(rt, null, "back atcha, " + rt.clusterId)
	//		}
	//	}
}
