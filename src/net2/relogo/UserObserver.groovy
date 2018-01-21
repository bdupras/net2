package net2.relogo

import static repast.simphony.relogo.Utility.*
import static repast.simphony.relogo.UtilityG.*
import static net2.relogo.Utils.*

import repast.simphony.relogo.Stop
import repast.simphony.relogo.Utility
import repast.simphony.relogo.UtilityG
import repast.simphony.relogo.factories.RLWorldDimensions
import repast.simphony.relogo.schedule.Go
import repast.simphony.relogo.schedule.Setup
import net2.ReLogoObserver
import repast.simphony.runtime.RepastMain
import java.util.concurrent.atomic.AtomicInteger

class UserObserver extends ReLogoObserver{
	private AtomicInteger clusterNodeId = new AtomicInteger(0)
	private int CLUSTER_SIZE=781;
	
	@Setup
	def setup(){
		clearAll()
		setDefaultShape(ClusterNode, "square")
		createOrderedClusterNodes(CLUSTER_SIZE) { ClusterNode node ->
			node.clusterInit(clusterNodeId.getAndIncrement(), CLUSTER_SIZE)
			RLWorldDimensions dim = getRLDimensions()
			double[] absCor = relToAbsCor(node.relCor, dim.DDims, dim.origin)
			setxy(absCor[0], absCor[1])
		}
		ask(clusterNodes()) { setup() }
	}

	//	@Go
	//	def go(){
	////		if (getTickCount() > 100) {
	////			stop()
	////		}
	//	}
}