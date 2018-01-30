package net2.relogo

import static repast.simphony.relogo.Utility.*
import static repast.simphony.relogo.UtilityG.*
import static net2.relogo.Utils.*
import static com.duprasville.limiters.util.Utils.*

import com.duprasville.limiters.RateLimiters
import com.duprasville.limiters.treefill.TreeFillRateLimiter
import com.duprasville.limiters.RateLimiter
import com.duprasville.limiters.util.karytree.KaryLayout
import com.duprasville.limiters.util.karytree.KaryTree
import com.duprasville.limiters.comms.Message
import com.duprasville.limiters.comms.MessageSink
import com.google.common.util.concurrent.ForkedRateLimiter
import net2.ReLogoTurtle
import net2.comms.TurtleMessageSource
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

	@Setup
	def setup() {
		shape = "square"
		color = yellow()
		size = getRelSize()

		int myShare = spread(clusterId, clusterQuota, clusterSize)
		limiter = createRateLimiter(myShare)
	}

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

	private RateLimiter createRateLimiter(long rps) {
		if (rps < 1) {
			RateLimiters.NEVER
		} else {
			TreeFillRateLimiter treefill = new TreeFillRateLimiter(rps, clusterId, clusterSize, tree, messageSource)
			treefillSink = treefill
			treefill
		}
	}

	def clusterNodeResolver = { long resolveId ->
		clusterNodes().with() { ClusterNode clusterNode ->
			clusterNode.clusterId == resolveId
		}.first()
	}

	TurtleMessageSource<ClusterNode> messageSource = new TurtleMessageSource<>("treefillMessage", clusterNodeResolver)

	MessageSink treefillSink = { Message message ->
		show([
			"received a message to default sink",
			message
		])
	}

	// equivalent to an rpc endpoint
	public treefillMessage(ReLogoTurtle src, ReLogoTurtle dst, Message message) {
		treefillSink.receive(message)
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
}
