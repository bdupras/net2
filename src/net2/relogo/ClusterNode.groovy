package net2.relogo

import static repast.simphony.relogo.Utility.*
import static repast.simphony.relogo.UtilityG.*
import static net2.relogo.Utils.*

import com.google.common.util.concurrent.ForkedRateLimiter
import net2.ReLogoTurtle
import net2.karytree.KaryLayout
import net2.karytree.KaryTree
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
	private ForkedRateLimiter limiter = null

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


	@Setup
	def setup() {
		shape = "square"
		color = yellow()
		size = getRelSize()
		KaryTree.Node treeNode = tree.getNode(clusterId)

		long parentId = treeNode.getParent().getId()
		parent = clusterNodes().with { ClusterNode cn ->
			parentId == cn.clusterId
		}

		long minChild = treeNode.children.min.id
		long maxChild = treeNode.children.max.id
		children = clusterNodes().with { ClusterNode cn ->
			(minChild <= cn.clusterId) && (cn.clusterId <= maxChild)
		}

		long minBase = tree.base.nodes.min.id
		long maxBase = tree.base.nodes.max.id
		base = clusterNodes().with { ClusterNode cn ->
			(minBase <= cn.clusterId) && (cn.clusterId <= maxBase)
		}

		int myShare = spread(clusterId, clusterQuota, clusterSize)
		limiter = myShare > 0 ? ForkedRateLimiter.create(myShare, RELOGO_TICKER) : ForkedRateLimiter.ALWAYS_REJECT;
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

	@Go(start=1d, interval=30d, pick=10l, shuffle=true)
	def go() {
		sendHello(parent, this, "hi mom ")
	}

	def sendHello(AgentSet<ClusterNode> dsts, ClusterNode replyTo, String msg) {
		dsts.each { ClusterNode dst ->
			sendHello(dst, replyTo, msg)
		}
	}

	def sendHello(ClusterNode dst, ClusterNode replyTo, String msg) {
		Packet.newPacket(this, dst, "receiveHello", [msg: msg, replyTo: replyTo]).send()
	}

	def receiveHello(payload) {
		show(payload.msg)
		def ClusterNode rt = payload['replyTo']
		if (null != rt) {
			sendHello(rt, null, "back atcha, " + rt.clusterId)
		}
	}
}
