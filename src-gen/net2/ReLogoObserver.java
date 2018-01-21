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
public class ReLogoObserver extends BaseObserver{

	/**
	 * Makes a number of randomly oriented clusterNodes and then executes a set of commands on the
	 * created clusterNodes.
	 * 
	 * @param number
	 *            a number
	 * @param closure
	 *            a set of commands
	 * @return created clusterNodes
	 */
	@ReLogoBuilderGeneratedFor("net2.relogo.ClusterNode")
	public AgentSet<net2.relogo.ClusterNode> createClusterNodes(int number, Closure closure) {
		AgentSet<net2.relogo.ClusterNode> result = new AgentSet<>();
		AgentSet<Turtle> createResult = this.crt(number,closure,"ClusterNode");
		for (Turtle t : createResult){
			if (t instanceof net2.relogo.ClusterNode){
				result.add((net2.relogo.ClusterNode)t);
			}
		} 
		return result; 
	}

	/**
	 * Makes a number of randomly oriented clusterNodes and then executes a set of commands on the
	 * created clusterNodes.
	 * 
	 * @param number
	 *            a number
	 * @param closure
	 *            a set of commands
	 * @return created clusterNodes
	 */
	@ReLogoBuilderGeneratedFor("net2.relogo.ClusterNode")
	public AgentSet<net2.relogo.ClusterNode> createClusterNodes(int number) {
		return createClusterNodes(number,null);
	}

	/**
	 * Makes a number of uniformly fanned clusterNodes and then executes a set of commands on the
	 * created clusterNodes.
	 * 
	 * @param number
	 *            a number
	 * @param closure
	 *            a set of commands
	 * @return created clusterNodes
	 */
	@ReLogoBuilderGeneratedFor("net2.relogo.ClusterNode")
	public AgentSet<net2.relogo.ClusterNode> createOrderedClusterNodes(int number, Closure closure) {
		AgentSet<net2.relogo.ClusterNode> result = new AgentSet<>();
		AgentSet<Turtle> createResult = this.cro(number,closure,"ClusterNode");
		for (Turtle t : createResult){
			if (t instanceof net2.relogo.ClusterNode){
				result.add((net2.relogo.ClusterNode)t);
			}
		} 
		return result; 
	}

	/**
	 * Makes a number of uniformly fanned clusterNodes and then executes a set of commands on the
	 * created clusterNodes.
	 * 
	 * @param number
	 *            a number
	 * @param closure
	 *            a set of commands
	 * @return created clusterNodes
	 */
	@ReLogoBuilderGeneratedFor("net2.relogo.ClusterNode")
	public AgentSet<net2.relogo.ClusterNode> createOrderedClusterNodes(int number) {
		return createOrderedClusterNodes(number,null);
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
	 * Returns an agentset containing all clusterNodes.
	 * 
	 * @return agentset of all clusterNodes
	 */
	@ReLogoBuilderGeneratedFor("net2.relogo.ClusterNode")
	public AgentSet<net2.relogo.ClusterNode> clusterNodes(){
		AgentSet<net2.relogo.ClusterNode> a = new AgentSet<net2.relogo.ClusterNode>();
		for (Object e : this.getContext().getObjects(net2.relogo.ClusterNode.class)) {
			if (e instanceof net2.relogo.ClusterNode){
				a.add((net2.relogo.ClusterNode)e);
			}
		}
		return a;
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
		Turtle turtle = Utility.turtleU(number.intValue(), this);
		if (turtle instanceof net2.relogo.ClusterNode)
			return (net2.relogo.ClusterNode) turtle;
		return null;
	}

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
		for (Turtle t : Utility.getTurtlesOnGridPoint(p.getGridLocation(),this,"clusterNode")){
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
		for (Turtle tt : Utility.getTurtlesOnGridPoint(Utility.ndPointToGridPoint(t.getTurtleLocation()),this,"clusterNode")){
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
	 * Makes a number of randomly oriented messageInforms and then executes a set of commands on the
	 * created messageInforms.
	 * 
	 * @param number
	 *            a number
	 * @param closure
	 *            a set of commands
	 * @return created messageInforms
	 */
	@ReLogoBuilderGeneratedFor("net2.relogo.MessageInform")
	public AgentSet<net2.relogo.MessageInform> createMessageInforms(int number, Closure closure) {
		AgentSet<net2.relogo.MessageInform> result = new AgentSet<>();
		AgentSet<Turtle> createResult = this.crt(number,closure,"MessageInform");
		for (Turtle t : createResult){
			if (t instanceof net2.relogo.MessageInform){
				result.add((net2.relogo.MessageInform)t);
			}
		} 
		return result; 
	}

	/**
	 * Makes a number of randomly oriented messageInforms and then executes a set of commands on the
	 * created messageInforms.
	 * 
	 * @param number
	 *            a number
	 * @param closure
	 *            a set of commands
	 * @return created messageInforms
	 */
	@ReLogoBuilderGeneratedFor("net2.relogo.MessageInform")
	public AgentSet<net2.relogo.MessageInform> createMessageInforms(int number) {
		return createMessageInforms(number,null);
	}

	/**
	 * Makes a number of uniformly fanned messageInforms and then executes a set of commands on the
	 * created messageInforms.
	 * 
	 * @param number
	 *            a number
	 * @param closure
	 *            a set of commands
	 * @return created messageInforms
	 */
	@ReLogoBuilderGeneratedFor("net2.relogo.MessageInform")
	public AgentSet<net2.relogo.MessageInform> createOrderedMessageInforms(int number, Closure closure) {
		AgentSet<net2.relogo.MessageInform> result = new AgentSet<>();
		AgentSet<Turtle> createResult = this.cro(number,closure,"MessageInform");
		for (Turtle t : createResult){
			if (t instanceof net2.relogo.MessageInform){
				result.add((net2.relogo.MessageInform)t);
			}
		} 
		return result; 
	}

	/**
	 * Makes a number of uniformly fanned messageInforms and then executes a set of commands on the
	 * created messageInforms.
	 * 
	 * @param number
	 *            a number
	 * @param closure
	 *            a set of commands
	 * @return created messageInforms
	 */
	@ReLogoBuilderGeneratedFor("net2.relogo.MessageInform")
	public AgentSet<net2.relogo.MessageInform> createOrderedMessageInforms(int number) {
		return createOrderedMessageInforms(number,null);
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
	 * Returns an agentset containing all messageInforms.
	 * 
	 * @return agentset of all messageInforms
	 */
	@ReLogoBuilderGeneratedFor("net2.relogo.MessageInform")
	public AgentSet<net2.relogo.MessageInform> messageInforms(){
		AgentSet<net2.relogo.MessageInform> a = new AgentSet<net2.relogo.MessageInform>();
		for (Object e : this.getContext().getObjects(net2.relogo.MessageInform.class)) {
			if (e instanceof net2.relogo.MessageInform){
				a.add((net2.relogo.MessageInform)e);
			}
		}
		return a;
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
		Turtle turtle = Utility.turtleU(number.intValue(), this);
		if (turtle instanceof net2.relogo.MessageInform)
			return (net2.relogo.MessageInform) turtle;
		return null;
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
		for (Turtle t : Utility.getTurtlesOnGridPoint(p.getGridLocation(),this,"messageInform")){
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
		for (Turtle tt : Utility.getTurtlesOnGridPoint(Utility.ndPointToGridPoint(t.getTurtleLocation()),this,"messageInform")){
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
	 * Makes a number of randomly oriented packets and then executes a set of commands on the
	 * created packets.
	 * 
	 * @param number
	 *            a number
	 * @param closure
	 *            a set of commands
	 * @return created packets
	 */
	@ReLogoBuilderGeneratedFor("net2.relogo.Packet")
	public AgentSet<net2.relogo.Packet> createPackets(int number, Closure closure) {
		AgentSet<net2.relogo.Packet> result = new AgentSet<>();
		AgentSet<Turtle> createResult = this.crt(number,closure,"Packet");
		for (Turtle t : createResult){
			if (t instanceof net2.relogo.Packet){
				result.add((net2.relogo.Packet)t);
			}
		} 
		return result; 
	}

	/**
	 * Makes a number of randomly oriented packets and then executes a set of commands on the
	 * created packets.
	 * 
	 * @param number
	 *            a number
	 * @param closure
	 *            a set of commands
	 * @return created packets
	 */
	@ReLogoBuilderGeneratedFor("net2.relogo.Packet")
	public AgentSet<net2.relogo.Packet> createPackets(int number) {
		return createPackets(number,null);
	}

	/**
	 * Makes a number of uniformly fanned packets and then executes a set of commands on the
	 * created packets.
	 * 
	 * @param number
	 *            a number
	 * @param closure
	 *            a set of commands
	 * @return created packets
	 */
	@ReLogoBuilderGeneratedFor("net2.relogo.Packet")
	public AgentSet<net2.relogo.Packet> createOrderedPackets(int number, Closure closure) {
		AgentSet<net2.relogo.Packet> result = new AgentSet<>();
		AgentSet<Turtle> createResult = this.cro(number,closure,"Packet");
		for (Turtle t : createResult){
			if (t instanceof net2.relogo.Packet){
				result.add((net2.relogo.Packet)t);
			}
		} 
		return result; 
	}

	/**
	 * Makes a number of uniformly fanned packets and then executes a set of commands on the
	 * created packets.
	 * 
	 * @param number
	 *            a number
	 * @param closure
	 *            a set of commands
	 * @return created packets
	 */
	@ReLogoBuilderGeneratedFor("net2.relogo.Packet")
	public AgentSet<net2.relogo.Packet> createOrderedPackets(int number) {
		return createOrderedPackets(number,null);
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
	 * Returns an agentset containing all packets.
	 * 
	 * @return agentset of all packets
	 */
	@ReLogoBuilderGeneratedFor("net2.relogo.Packet")
	public AgentSet<net2.relogo.Packet> packets(){
		AgentSet<net2.relogo.Packet> a = new AgentSet<net2.relogo.Packet>();
		for (Object e : this.getContext().getObjects(net2.relogo.Packet.class)) {
			if (e instanceof net2.relogo.Packet){
				a.add((net2.relogo.Packet)e);
			}
		}
		return a;
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
		Turtle turtle = Utility.turtleU(number.intValue(), this);
		if (turtle instanceof net2.relogo.Packet)
			return (net2.relogo.Packet) turtle;
		return null;
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
		for (Turtle t : Utility.getTurtlesOnGridPoint(p.getGridLocation(),this,"packet")){
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
		for (Turtle tt : Utility.getTurtlesOnGridPoint(Utility.ndPointToGridPoint(t.getTurtleLocation()),this,"packet")){
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
	 * Makes a number of randomly oriented userTurtles and then executes a set of commands on the
	 * created userTurtles.
	 * 
	 * @param number
	 *            a number
	 * @param closure
	 *            a set of commands
	 * @return created userTurtles
	 */
	@ReLogoBuilderGeneratedFor("net2.relogo.UserTurtle")
	public AgentSet<net2.relogo.UserTurtle> createUserTurtles(int number, Closure closure) {
		AgentSet<net2.relogo.UserTurtle> result = new AgentSet<>();
		AgentSet<Turtle> createResult = this.crt(number,closure,"UserTurtle");
		for (Turtle t : createResult){
			if (t instanceof net2.relogo.UserTurtle){
				result.add((net2.relogo.UserTurtle)t);
			}
		} 
		return result; 
	}

	/**
	 * Makes a number of randomly oriented userTurtles and then executes a set of commands on the
	 * created userTurtles.
	 * 
	 * @param number
	 *            a number
	 * @param closure
	 *            a set of commands
	 * @return created userTurtles
	 */
	@ReLogoBuilderGeneratedFor("net2.relogo.UserTurtle")
	public AgentSet<net2.relogo.UserTurtle> createUserTurtles(int number) {
		return createUserTurtles(number,null);
	}

	/**
	 * Makes a number of uniformly fanned userTurtles and then executes a set of commands on the
	 * created userTurtles.
	 * 
	 * @param number
	 *            a number
	 * @param closure
	 *            a set of commands
	 * @return created userTurtles
	 */
	@ReLogoBuilderGeneratedFor("net2.relogo.UserTurtle")
	public AgentSet<net2.relogo.UserTurtle> createOrderedUserTurtles(int number, Closure closure) {
		AgentSet<net2.relogo.UserTurtle> result = new AgentSet<>();
		AgentSet<Turtle> createResult = this.cro(number,closure,"UserTurtle");
		for (Turtle t : createResult){
			if (t instanceof net2.relogo.UserTurtle){
				result.add((net2.relogo.UserTurtle)t);
			}
		} 
		return result; 
	}

	/**
	 * Makes a number of uniformly fanned userTurtles and then executes a set of commands on the
	 * created userTurtles.
	 * 
	 * @param number
	 *            a number
	 * @param closure
	 *            a set of commands
	 * @return created userTurtles
	 */
	@ReLogoBuilderGeneratedFor("net2.relogo.UserTurtle")
	public AgentSet<net2.relogo.UserTurtle> createOrderedUserTurtles(int number) {
		return createOrderedUserTurtles(number,null);
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
	 * Returns an agentset containing all userTurtles.
	 * 
	 * @return agentset of all userTurtles
	 */
	@ReLogoBuilderGeneratedFor("net2.relogo.UserTurtle")
	public AgentSet<net2.relogo.UserTurtle> userTurtles(){
		AgentSet<net2.relogo.UserTurtle> a = new AgentSet<net2.relogo.UserTurtle>();
		for (Object e : this.getContext().getObjects(net2.relogo.UserTurtle.class)) {
			if (e instanceof net2.relogo.UserTurtle){
				a.add((net2.relogo.UserTurtle)e);
			}
		}
		return a;
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
		Turtle turtle = Utility.turtleU(number.intValue(), this);
		if (turtle instanceof net2.relogo.UserTurtle)
			return (net2.relogo.UserTurtle) turtle;
		return null;
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
		for (Turtle t : Utility.getTurtlesOnGridPoint(p.getGridLocation(),this,"userTurtle")){
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
		for (Turtle tt : Utility.getTurtlesOnGridPoint(Utility.ndPointToGridPoint(t.getTurtleLocation()),this,"userTurtle")){
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
		for (Object e : this.getContext().getObjects(net2.relogo.UserLink.class)) {
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
		return (net2.relogo.UserLink)(this.getNetwork("UserLink").getEdge(turtle(oneEnd),turtle(otherEnd)));
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


}