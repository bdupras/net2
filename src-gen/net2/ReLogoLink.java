package net2;

import static repast.simphony.relogo.Utility.*;
import static repast.simphony.relogo.UtilityG.*;
import java.util.Collection;
import java.util.HashSet;
import java.util.Set;
import groovy.lang.Closure;
import repast.simphony.relogo.*;
import repast.simphony.relogo.builder.GeneratedByReLogoBuilder;
import repast.simphony.relogo.builder.ReLogoBuilderGeneratedFor;

@GeneratedByReLogoBuilder
@SuppressWarnings({"unused","rawtypes","unchecked"})
public class ReLogoLink<T> extends BaseLink<T>	{

	/**
	 * Returns an agentset of clusterNodes on a given patch.
	 * 
	 * @param p
	 *            a patch
	 * @return agentset of clusterNodes on patch p
	 */
	@ReLogoBuilderGeneratedFor("net2.relogo.ClusterNode")
	public AgentSet<net2.relogo.ClusterNode> clusterNodesOn(Patch p){
		AgentSet<net2.relogo.ClusterNode> result = new AgentSet<net2.relogo.ClusterNode>();						
		for (Turtle t : Utility.getTurtlesOnGridPoint(p.getGridLocation(),getMyObserver(),"clusterNode")){
			if (t instanceof net2.relogo.ClusterNode)
			result.add((net2.relogo.ClusterNode)t);
		}
		return result;
	}

	/**
	 * Returns an agentset of clusterNodes on the same patch as a turtle.
	 * 
	 * @param t
	 *            a turtle
	 * @return agentset of clusterNodes on the same patch as turtle t
	 */
	@ReLogoBuilderGeneratedFor("net2.relogo.ClusterNode")
	public AgentSet<net2.relogo.ClusterNode> clusterNodesOn(Turtle t){
		AgentSet<net2.relogo.ClusterNode> result = new AgentSet<net2.relogo.ClusterNode>();						
		for (Turtle tt : Utility.getTurtlesOnGridPoint(Utility.ndPointToGridPoint(t.getTurtleLocation()),getMyObserver(),"clusterNode")){
			if (tt instanceof net2.relogo.ClusterNode)
			result.add((net2.relogo.ClusterNode)tt);
		}
		return result;
	}

	/**
	 * Returns an agentset of clusterNodes on the patches in a collection or on the patches
	 * that a collection of turtles are.
	 * 
	 * @param a
	 *            a collection
	 * @return agentset of clusterNodes on the patches in collection a or on the patches
	 *         that collection a turtles are
	 */
	@ReLogoBuilderGeneratedFor("net2.relogo.ClusterNode")
	public AgentSet<net2.relogo.ClusterNode> clusterNodesOn(Collection c){

		if (c == null || c.isEmpty()){
			return new AgentSet<net2.relogo.ClusterNode>();
		}

		Set<net2.relogo.ClusterNode> total = new HashSet<net2.relogo.ClusterNode>();
		if (c.iterator().next() instanceof Turtle){
			for (Object o : c){
				if (o instanceof Turtle){
					Turtle t = (Turtle) o;
					total.addAll(clusterNodesOn(t));
				}
			}
		}
		else {
			for (Object o : c){
				if (o instanceof Patch){
					Patch p = (Patch) o;
					total.addAll(clusterNodesOn(p));
				}
			}
		}
		return new AgentSet<net2.relogo.ClusterNode>(total);
	}

	/**
	 * Queries if object is a clusterNode.
	 * 
	 * @param o
	 *            an object
	 * @return true or false based on whether the object is a clusterNode
	 */
	@ReLogoBuilderGeneratedFor("net2.relogo.ClusterNode")
	public boolean isClusterNodeQ(Object o){
		return (o instanceof net2.relogo.ClusterNode);
	}

	/**
	 * Returns the clusterNode with the given who number.
	 * 
	 * @param number
	 *            a number
	 * @return turtle number
	 */
	@ReLogoBuilderGeneratedFor("net2.relogo.ClusterNode")
	public net2.relogo.ClusterNode clusterNode(Number number){
		Turtle turtle = Utility.turtleU(number.intValue(), getMyObserver());
		if (turtle instanceof net2.relogo.ClusterNode)
			return (net2.relogo.ClusterNode) turtle;
		return null;
	}

	/**
	 * Returns an agentset containing all clusterNodes.
	 * 
	 * @return agentset of all clusterNodes
	 */
	@ReLogoBuilderGeneratedFor("net2.relogo.ClusterNode")
	public AgentSet<net2.relogo.ClusterNode> clusterNodes(){
		AgentSet<net2.relogo.ClusterNode> a = new AgentSet<net2.relogo.ClusterNode>();
		for (Object e : this.getMyObserver().getContext().getObjects(net2.relogo.ClusterNode.class)) {
			if (e instanceof net2.relogo.ClusterNode){
				a.add((net2.relogo.ClusterNode)e);
			}
		}
		return a;
	}

	/**
	 * Returns an agentset of messageInforms on a given patch.
	 * 
	 * @param p
	 *            a patch
	 * @return agentset of messageInforms on patch p
	 */
	@ReLogoBuilderGeneratedFor("net2.relogo.MessageInform")
	public AgentSet<net2.relogo.MessageInform> messageInformsOn(Patch p){
		AgentSet<net2.relogo.MessageInform> result = new AgentSet<net2.relogo.MessageInform>();						
		for (Turtle t : Utility.getTurtlesOnGridPoint(p.getGridLocation(),getMyObserver(),"messageInform")){
			if (t instanceof net2.relogo.MessageInform)
			result.add((net2.relogo.MessageInform)t);
		}
		return result;
	}

	/**
	 * Returns an agentset of messageInforms on the same patch as a turtle.
	 * 
	 * @param t
	 *            a turtle
	 * @return agentset of messageInforms on the same patch as turtle t
	 */
	@ReLogoBuilderGeneratedFor("net2.relogo.MessageInform")
	public AgentSet<net2.relogo.MessageInform> messageInformsOn(Turtle t){
		AgentSet<net2.relogo.MessageInform> result = new AgentSet<net2.relogo.MessageInform>();						
		for (Turtle tt : Utility.getTurtlesOnGridPoint(Utility.ndPointToGridPoint(t.getTurtleLocation()),getMyObserver(),"messageInform")){
			if (tt instanceof net2.relogo.MessageInform)
			result.add((net2.relogo.MessageInform)tt);
		}
		return result;
	}

	/**
	 * Returns an agentset of messageInforms on the patches in a collection or on the patches
	 * that a collection of turtles are.
	 * 
	 * @param a
	 *            a collection
	 * @return agentset of messageInforms on the patches in collection a or on the patches
	 *         that collection a turtles are
	 */
	@ReLogoBuilderGeneratedFor("net2.relogo.MessageInform")
	public AgentSet<net2.relogo.MessageInform> messageInformsOn(Collection c){

		if (c == null || c.isEmpty()){
			return new AgentSet<net2.relogo.MessageInform>();
		}

		Set<net2.relogo.MessageInform> total = new HashSet<net2.relogo.MessageInform>();
		if (c.iterator().next() instanceof Turtle){
			for (Object o : c){
				if (o instanceof Turtle){
					Turtle t = (Turtle) o;
					total.addAll(messageInformsOn(t));
				}
			}
		}
		else {
			for (Object o : c){
				if (o instanceof Patch){
					Patch p = (Patch) o;
					total.addAll(messageInformsOn(p));
				}
			}
		}
		return new AgentSet<net2.relogo.MessageInform>(total);
	}

	/**
	 * Queries if object is a messageInform.
	 * 
	 * @param o
	 *            an object
	 * @return true or false based on whether the object is a messageInform
	 */
	@ReLogoBuilderGeneratedFor("net2.relogo.MessageInform")
	public boolean isMessageInformQ(Object o){
		return (o instanceof net2.relogo.MessageInform);
	}

	/**
	 * Returns the messageInform with the given who number.
	 * 
	 * @param number
	 *            a number
	 * @return turtle number
	 */
	@ReLogoBuilderGeneratedFor("net2.relogo.MessageInform")
	public net2.relogo.MessageInform messageInform(Number number){
		Turtle turtle = Utility.turtleU(number.intValue(), getMyObserver());
		if (turtle instanceof net2.relogo.MessageInform)
			return (net2.relogo.MessageInform) turtle;
		return null;
	}

	/**
	 * Returns an agentset containing all messageInforms.
	 * 
	 * @return agentset of all messageInforms
	 */
	@ReLogoBuilderGeneratedFor("net2.relogo.MessageInform")
	public AgentSet<net2.relogo.MessageInform> messageInforms(){
		AgentSet<net2.relogo.MessageInform> a = new AgentSet<net2.relogo.MessageInform>();
		for (Object e : this.getMyObserver().getContext().getObjects(net2.relogo.MessageInform.class)) {
			if (e instanceof net2.relogo.MessageInform){
				a.add((net2.relogo.MessageInform)e);
			}
		}
		return a;
	}

	/**
	 * Returns an agentset of packets on a given patch.
	 * 
	 * @param p
	 *            a patch
	 * @return agentset of packets on patch p
	 */
	@ReLogoBuilderGeneratedFor("net2.relogo.Packet")
	public AgentSet<net2.relogo.Packet> packetsOn(Patch p){
		AgentSet<net2.relogo.Packet> result = new AgentSet<net2.relogo.Packet>();						
		for (Turtle t : Utility.getTurtlesOnGridPoint(p.getGridLocation(),getMyObserver(),"packet")){
			if (t instanceof net2.relogo.Packet)
			result.add((net2.relogo.Packet)t);
		}
		return result;
	}

	/**
	 * Returns an agentset of packets on the same patch as a turtle.
	 * 
	 * @param t
	 *            a turtle
	 * @return agentset of packets on the same patch as turtle t
	 */
	@ReLogoBuilderGeneratedFor("net2.relogo.Packet")
	public AgentSet<net2.relogo.Packet> packetsOn(Turtle t){
		AgentSet<net2.relogo.Packet> result = new AgentSet<net2.relogo.Packet>();						
		for (Turtle tt : Utility.getTurtlesOnGridPoint(Utility.ndPointToGridPoint(t.getTurtleLocation()),getMyObserver(),"packet")){
			if (tt instanceof net2.relogo.Packet)
			result.add((net2.relogo.Packet)tt);
		}
		return result;
	}

	/**
	 * Returns an agentset of packets on the patches in a collection or on the patches
	 * that a collection of turtles are.
	 * 
	 * @param a
	 *            a collection
	 * @return agentset of packets on the patches in collection a or on the patches
	 *         that collection a turtles are
	 */
	@ReLogoBuilderGeneratedFor("net2.relogo.Packet")
	public AgentSet<net2.relogo.Packet> packetsOn(Collection c){

		if (c == null || c.isEmpty()){
			return new AgentSet<net2.relogo.Packet>();
		}

		Set<net2.relogo.Packet> total = new HashSet<net2.relogo.Packet>();
		if (c.iterator().next() instanceof Turtle){
			for (Object o : c){
				if (o instanceof Turtle){
					Turtle t = (Turtle) o;
					total.addAll(packetsOn(t));
				}
			}
		}
		else {
			for (Object o : c){
				if (o instanceof Patch){
					Patch p = (Patch) o;
					total.addAll(packetsOn(p));
				}
			}
		}
		return new AgentSet<net2.relogo.Packet>(total);
	}

	/**
	 * Queries if object is a packet.
	 * 
	 * @param o
	 *            an object
	 * @return true or false based on whether the object is a packet
	 */
	@ReLogoBuilderGeneratedFor("net2.relogo.Packet")
	public boolean isPacketQ(Object o){
		return (o instanceof net2.relogo.Packet);
	}

	/**
	 * Returns the packet with the given who number.
	 * 
	 * @param number
	 *            a number
	 * @return turtle number
	 */
	@ReLogoBuilderGeneratedFor("net2.relogo.Packet")
	public net2.relogo.Packet packet(Number number){
		Turtle turtle = Utility.turtleU(number.intValue(), getMyObserver());
		if (turtle instanceof net2.relogo.Packet)
			return (net2.relogo.Packet) turtle;
		return null;
	}

	/**
	 * Returns an agentset containing all packets.
	 * 
	 * @return agentset of all packets
	 */
	@ReLogoBuilderGeneratedFor("net2.relogo.Packet")
	public AgentSet<net2.relogo.Packet> packets(){
		AgentSet<net2.relogo.Packet> a = new AgentSet<net2.relogo.Packet>();
		for (Object e : this.getMyObserver().getContext().getObjects(net2.relogo.Packet.class)) {
			if (e instanceof net2.relogo.Packet){
				a.add((net2.relogo.Packet)e);
			}
		}
		return a;
	}

	/**
	 * Returns an agentset of userTurtles on a given patch.
	 * 
	 * @param p
	 *            a patch
	 * @return agentset of userTurtles on patch p
	 */
	@ReLogoBuilderGeneratedFor("net2.relogo.UserTurtle")
	public AgentSet<net2.relogo.UserTurtle> userTurtlesOn(Patch p){
		AgentSet<net2.relogo.UserTurtle> result = new AgentSet<net2.relogo.UserTurtle>();						
		for (Turtle t : Utility.getTurtlesOnGridPoint(p.getGridLocation(),getMyObserver(),"userTurtle")){
			if (t instanceof net2.relogo.UserTurtle)
			result.add((net2.relogo.UserTurtle)t);
		}
		return result;
	}

	/**
	 * Returns an agentset of userTurtles on the same patch as a turtle.
	 * 
	 * @param t
	 *            a turtle
	 * @return agentset of userTurtles on the same patch as turtle t
	 */
	@ReLogoBuilderGeneratedFor("net2.relogo.UserTurtle")
	public AgentSet<net2.relogo.UserTurtle> userTurtlesOn(Turtle t){
		AgentSet<net2.relogo.UserTurtle> result = new AgentSet<net2.relogo.UserTurtle>();						
		for (Turtle tt : Utility.getTurtlesOnGridPoint(Utility.ndPointToGridPoint(t.getTurtleLocation()),getMyObserver(),"userTurtle")){
			if (tt instanceof net2.relogo.UserTurtle)
			result.add((net2.relogo.UserTurtle)tt);
		}
		return result;
	}

	/**
	 * Returns an agentset of userTurtles on the patches in a collection or on the patches
	 * that a collection of turtles are.
	 * 
	 * @param a
	 *            a collection
	 * @return agentset of userTurtles on the patches in collection a or on the patches
	 *         that collection a turtles are
	 */
	@ReLogoBuilderGeneratedFor("net2.relogo.UserTurtle")
	public AgentSet<net2.relogo.UserTurtle> userTurtlesOn(Collection c){

		if (c == null || c.isEmpty()){
			return new AgentSet<net2.relogo.UserTurtle>();
		}

		Set<net2.relogo.UserTurtle> total = new HashSet<net2.relogo.UserTurtle>();
		if (c.iterator().next() instanceof Turtle){
			for (Object o : c){
				if (o instanceof Turtle){
					Turtle t = (Turtle) o;
					total.addAll(userTurtlesOn(t));
				}
			}
		}
		else {
			for (Object o : c){
				if (o instanceof Patch){
					Patch p = (Patch) o;
					total.addAll(userTurtlesOn(p));
				}
			}
		}
		return new AgentSet<net2.relogo.UserTurtle>(total);
	}

	/**
	 * Queries if object is a userTurtle.
	 * 
	 * @param o
	 *            an object
	 * @return true or false based on whether the object is a userTurtle
	 */
	@ReLogoBuilderGeneratedFor("net2.relogo.UserTurtle")
	public boolean isUserTurtleQ(Object o){
		return (o instanceof net2.relogo.UserTurtle);
	}

	/**
	 * Returns the userTurtle with the given who number.
	 * 
	 * @param number
	 *            a number
	 * @return turtle number
	 */
	@ReLogoBuilderGeneratedFor("net2.relogo.UserTurtle")
	public net2.relogo.UserTurtle userTurtle(Number number){
		Turtle turtle = Utility.turtleU(number.intValue(), getMyObserver());
		if (turtle instanceof net2.relogo.UserTurtle)
			return (net2.relogo.UserTurtle) turtle;
		return null;
	}

	/**
	 * Returns an agentset containing all userTurtles.
	 * 
	 * @return agentset of all userTurtles
	 */
	@ReLogoBuilderGeneratedFor("net2.relogo.UserTurtle")
	public AgentSet<net2.relogo.UserTurtle> userTurtles(){
		AgentSet<net2.relogo.UserTurtle> a = new AgentSet<net2.relogo.UserTurtle>();
		for (Object e : this.getMyObserver().getContext().getObjects(net2.relogo.UserTurtle.class)) {
			if (e instanceof net2.relogo.UserTurtle){
				a.add((net2.relogo.UserTurtle)e);
			}
		}
		return a;
	}

	/**
	 * Queries if object is a userLink.
	 * 
	 * @param o
	 *            an object
	 * @return true or false based on whether the object is a userLink
	 */
	@ReLogoBuilderGeneratedFor("net2.relogo.UserLink")
	public boolean isUserLinkQ(Object o){
		return (o instanceof net2.relogo.UserLink);
	}

	/**
	 * Returns an agentset containing all userLinks.
	 * 
	 * @return agentset of all userLinks
	 */
	@ReLogoBuilderGeneratedFor("net2.relogo.UserLink")
	public AgentSet<net2.relogo.UserLink> userLinks(){
		AgentSet<net2.relogo.UserLink> a = new AgentSet<net2.relogo.UserLink>();
		for (Object e : this.getMyObserver().getContext().getObjects(net2.relogo.UserLink.class)) {
			if (e instanceof net2.relogo.UserLink){
				a.add((net2.relogo.UserLink)e);
			}
		}
		return a;
	}

	/**
	 * Returns the userLink between two turtles.
	 * 
	 * @param oneEnd
	 *            an integer
	 * @param otherEnd
	 *            an integer
	 * @return userLink between two turtles
	 */
	@ReLogoBuilderGeneratedFor("net2.relogo.UserLink")
	public net2.relogo.UserLink userLink(Number oneEnd, Number otherEnd) {
		return (net2.relogo.UserLink)(this.getMyObserver().getNetwork("UserLink").getEdge(turtle(oneEnd),turtle(otherEnd)));
	}

	/**
	 * Returns the userLink between two turtles.
	 * 
	 * @param oneEnd
	 *            a turtle
	 * @param otherEnd
	 *            a turtle
	 * @return userLink between two turtles
	 */
	@ReLogoBuilderGeneratedFor("net2.relogo.UserLink")
	public net2.relogo.UserLink userLink(Turtle oneEnd, Turtle otherEnd) {
		return userLink(oneEnd.getWho(), otherEnd.getWho());
	}

	/**
	 * Returns the value of the global variable simulationMaxTps.
	 *
	 * @return the value of the global variable simulationMaxTps
	 */
	@ReLogoBuilderGeneratedFor("global: simulationMaxTps")
	public Object getSimulationMaxTps(){
		return repast.simphony.relogo.ReLogoModel.getInstance().getModelParam("simulationMaxTps");
	}

	/**
	 * Sets the value of the global variable simulationMaxTps.
	 *
	 * @param value
	 *            a value
	 */
	@ReLogoBuilderGeneratedFor("global: simulationMaxTps")
	public void setSimulationMaxTps(Object value){
		repast.simphony.relogo.ReLogoModel.getInstance().setModelParam("simulationMaxTps",value);
	}

	/**
	 * Returns the value of the global variable limitStrategy.
	 *
	 * @return the value of the global variable limitStrategy
	 */
	@ReLogoBuilderGeneratedFor("global: limitStrategy")
	public Object getLimitStrategy(){
		return repast.simphony.relogo.ReLogoModel.getInstance().getModelParam("limitStrategy");
	}

	/**
	 * Sets the value of the global variable limitStrategy.
	 *
	 * @param value
	 *            a value
	 */
	@ReLogoBuilderGeneratedFor("global: limitStrategy")
	public void setLimitStrategy(Object value){
		repast.simphony.relogo.ReLogoModel.getInstance().setModelParam("limitStrategy",value);
	}

	/**
	 * Returns the value of the global variable clientRps.
	 *
	 * @return the value of the global variable clientRps
	 */
	@ReLogoBuilderGeneratedFor("global: clientRps")
	public Object getClientRps(){
		return repast.simphony.relogo.ReLogoModel.getInstance().getModelParam("clientRps");
	}

	/**
	 * Sets the value of the global variable clientRps.
	 *
	 * @param value
	 *            a value
	 */
	@ReLogoBuilderGeneratedFor("global: clientRps")
	public void setClientRps(Object value){
		repast.simphony.relogo.ReLogoModel.getInstance().setModelParam("clientRps",value);
	}

	/**
	 * Returns the value of the global variable clientIpr.
	 *
	 * @return the value of the global variable clientIpr
	 */
	@ReLogoBuilderGeneratedFor("global: clientIpr")
	public Object getClientIpr(){
		return repast.simphony.relogo.ReLogoModel.getInstance().getModelParam("clientIpr");
	}

	/**
	 * Sets the value of the global variable clientIpr.
	 *
	 * @param value
	 *            a value
	 */
	@ReLogoBuilderGeneratedFor("global: clientIpr")
	public void setClientIpr(Object value){
		repast.simphony.relogo.ReLogoModel.getInstance().setModelParam("clientIpr",value);
	}

	/**
	 * Returns the value of the global variable clusterQuota.
	 *
	 * @return the value of the global variable clusterQuota
	 */
	@ReLogoBuilderGeneratedFor("global: clusterQuota")
	public Object getClusterQuota(){
		return repast.simphony.relogo.ReLogoModel.getInstance().getModelParam("clusterQuota");
	}

	/**
	 * Sets the value of the global variable clusterQuota.
	 *
	 * @param value
	 *            a value
	 */
	@ReLogoBuilderGeneratedFor("global: clusterQuota")
	public void setClusterQuota(Object value){
		repast.simphony.relogo.ReLogoModel.getInstance().setModelParam("clusterQuota",value);
	}

	/**
	 * Returns the value of the global variable randSeed.
	 *
	 * @return the value of the global variable randSeed
	 */
	@ReLogoBuilderGeneratedFor("global: randSeed")
	public Object getRandSeed(){
		return repast.simphony.relogo.ReLogoModel.getInstance().getModelParam("randSeed");
	}

	/**
	 * Sets the value of the global variable randSeed.
	 *
	 * @param value
	 *            a value
	 */
	@ReLogoBuilderGeneratedFor("global: randSeed")
	public void setRandSeed(Object value){
		repast.simphony.relogo.ReLogoModel.getInstance().setModelParam("randSeed",value);
	}


}