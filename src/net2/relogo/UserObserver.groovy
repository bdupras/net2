package net2.relogo

import static com.duprasville.limiters.util.Utils.*
import static net2.relogo.Utils.*
import static repast.simphony.relogo.Utility.*
import static repast.simphony.relogo.UtilityG.*

import com.duprasville.limiters.treefill.Detect
import java.util.concurrent.atomic.AtomicInteger

import net2.ReLogoObserver
import repast.simphony.relogo.AgentSet
import repast.simphony.relogo.factories.RLWorldDimensions
import repast.simphony.relogo.schedule.Go
import repast.simphony.relogo.schedule.Setup

/**
 * TODO LIST
 * - clean up @Setup, setup(), clusterInit(), etc
 * - karytree - remove Node(), Level() and just use primitives
 * - clean up factoring of limiter + layout + agent display + comms/io
 * - observer @Go use nOf(n, clusterNodes()) { AgentSet ... -> ... }?
 * 
 * DEMO features
 * - metrics/sec: requested, acquired, maxRecv, msgComplexity 
 * - strategies: non-cooperative/guava, centralized/memcached, treefill, treefill-p?
 * - treefill with imperfect trees
 * 
 * ADVANCED
 * - multiple limiters simultaneously? (probably complicates back-pressure)
 * - clients as agents? multiple client clusters at different rates?
 * - simulate cluster rolling deploy (rotate ktree?)
 * - pool/recycle packet agents (if GC is an issue) 
 */

class UserObserver extends ReLogoObserver{
	private AtomicInteger clusterNodeId = new AtomicInteger(0)
	private int CLUSTER_SIZE=156; //31 //156 //781;

	@Setup
	def setup(){
		clearAll()
		setDefaultShape(ClusterNode, "square")
		createOrderedClusterNodes(CLUSTER_SIZE) { ClusterNode node ->
			node.clusterInit(clusterNodeId.getAndIncrement(), CLUSTER_SIZE)
			//			setxy(randomXcor(), randomYcor())
			RLWorldDimensions dim = getRLDimensions()
			double[] absCor = relToAbsCor(node.relCor, dim.DDims, dim.origin)
			setxy(absCor[0], absCor[1])
			heading = absCor[2]
			forward(absCor[3])
		}
		ask(clusterNodes()) { setup() }

	}

	long requestsSent = 0L;
	long permitsRequested = 0L;
	long requestsAccepted = 0L;
	long permitsAcquired = 0L;
	long requestsRejected = 0L;
	
	@Go
	def go(){
		long millis = getTickCount() % 1000;
		int requestsToSend = spread((long)clientRps, millis, (long)ONE_SECOND)
		sendRequests(requestsToSend, clientIpr, nOf(requestsToSend, clusterNodes()))
		speedLimit(simulationMaxTps)
		if (millis == 0) {
			show([
				requestsSent: requestsSent,
				permitsRequested: permitsRequested,
				requestsAccepted: requestsAccepted,
				permitsAcquired: permitsAcquired,
				requestsRejected: requestsRejected
			]);
			requestsSent = 0L;
			permitsRequested = 0L;
			requestsAccepted = 0L;
			permitsAcquired = 0L;
			requestsRejected = 0L;
		}
	}

	private void sendRequests(int requestsToSend, int itemsPerRequest, AgentSet<ClusterNode> toClusterNodes) {
		if (requestsToSend > 0) {
			int permits = clientIpr
			ask(toClusterNodes) { ClusterNode node ->
				requestsSent++
				permitsRequested += permits
				if (node.tryAcquire(permits)) {
					requestsAccepted++
					permitsAcquired += permits
				} else {
					requestsRejected++
				}
			}
			int remainingRequests = requestsToSend - toClusterNodes.size()
			sendRequests(remainingRequests, itemsPerRequest, nOf(remainingRequests, toClusterNodes))
		}
	}

}