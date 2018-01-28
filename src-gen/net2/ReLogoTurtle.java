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
import repast.simphony.space.SpatialException;
import repast.simphony.space.grid.Grid;
import repast.simphony.space.grid.GridPoint;

@GeneratedByReLogoBuilder
@SuppressWarnings({"unused","rawtypes","unchecked"})
public class ReLogoTurtle extends BaseTurtle{

	/**
	 * Makes a number of new clusterNodes and then executes a set of commands on the
	 * created clusterNodes.
	 * 
	 * @param number
	 *            a number
	 * @param closure
	 *            a set of commands
	 * @return created clusterNodes
	 */
	@ReLogoBuilderGeneratedFor("net2.relogo.ClusterNode")
	public AgentSet<net2.relogo.ClusterNode> hatchClusterNodes(int number, Closure closure) {
		AgentSet<net2.relogo.ClusterNode> result = new AgentSet<>();
		AgentSet<Turtle> createResult = this.hatch(number,closure,"ClusterNode");
		for (Turtle t : createResult){
			if (t instanceof net2.relogo.ClusterNode){
				result.add((net2.relogo.ClusterNode)t);
			}
		} 
		return result;
	}

	/**
	 * Makes a number of new clusterNodes and then executes a set of commands on the
	 * created clusterNodes.
	 * 
	 * @param number
	 *            a number
	 * @param closure
	 *            a set of commands
	 * @return created clusterNodes
	 */
	@ReLogoBuilderGeneratedFor("net2.relogo.ClusterNode")
	public AgentSet<net2.relogo.ClusterNode> hatchClusterNodes(int number) {
		return hatchClusterNodes(number,null);
	}

	/**
	 * Returns an agentset of clusterNodes from the patch of the caller.
	 * 
	 * @return agentset of clusterNodes from the caller's patch
	 */
	@ReLogoBuilderGeneratedFor("net2.relogo.ClusterNode")
	public AgentSet<net2.relogo.ClusterNode> clusterNodesHere(){
	  Grid grid = getMyObserver().getGrid();
	  GridPoint gridPoint = grid.getLocation(this);
	  AgentSet<net2.relogo.ClusterNode> result = new AgentSet<net2.relogo.ClusterNode>();
	  for (Turtle t : Utility.getTurtlesOnGridPoint(gridPoint,getMyObserver(),"clusterNode")){
			if (t instanceof net2.relogo.ClusterNode)
			result.add((net2.relogo.ClusterNode)t);
		}
		return result;
	}

	/**
	 * Returns the agentset of clusterNodes on the patch at the direction (ndx, ndy) from the
	 * caller.
	 * 
	 * @param nX
	 *            a number
	 * @param nY
	 *            a number
	 * @returns agentset of clusterNodes at the direction (nX, nY) from the caller
	 */
	@ReLogoBuilderGeneratedFor("net2.relogo.ClusterNode")
	public AgentSet<net2.relogo.ClusterNode> clusterNodesAt(Number nX, Number nY){
		double dx = nX.doubleValue();
		double dy = nY.doubleValue();
		double[] displacement = {dx,dy};

		try{
		GridPoint gridPoint = Utility.getGridPointAtDisplacement(getTurtleLocation(),displacement,getMyObserver());
		AgentSet<net2.relogo.ClusterNode> result = new AgentSet<net2.relogo.ClusterNode>();						
		for (Turtle t : Utility.getTurtlesOnGridPoint(gridPoint,getMyObserver(),"clusterNode")){
			if (t instanceof net2.relogo.ClusterNode)
			result.add((net2.relogo.ClusterNode)t);
		}
		return result;
		}
		catch(SpatialException e){
			return new AgentSet<net2.relogo.ClusterNode>();
		}
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
	 * Makes a number of new messageInforms and then executes a set of commands on the
	 * created messageInforms.
	 * 
	 * @param number
	 *            a number
	 * @param closure
	 *            a set of commands
	 * @return created messageInforms
	 */
	@ReLogoBuilderGeneratedFor("net2.relogo.MessageInform")
	public AgentSet<net2.relogo.MessageInform> hatchMessageInforms(int number, Closure closure) {
		AgentSet<net2.relogo.MessageInform> result = new AgentSet<>();
		AgentSet<Turtle> createResult = this.hatch(number,closure,"MessageInform");
		for (Turtle t : createResult){
			if (t instanceof net2.relogo.MessageInform){
				result.add((net2.relogo.MessageInform)t);
			}
		} 
		return result;
	}

	/**
	 * Makes a number of new messageInforms and then executes a set of commands on the
	 * created messageInforms.
	 * 
	 * @param number
	 *            a number
	 * @param closure
	 *            a set of commands
	 * @return created messageInforms
	 */
	@ReLogoBuilderGeneratedFor("net2.relogo.MessageInform")
	public AgentSet<net2.relogo.MessageInform> hatchMessageInforms(int number) {
		return hatchMessageInforms(number,null);
	}

	/**
	 * Returns an agentset of messageInforms from the patch of the caller.
	 * 
	 * @return agentset of messageInforms from the caller's patch
	 */
	@ReLogoBuilderGeneratedFor("net2.relogo.MessageInform")
	public AgentSet<net2.relogo.MessageInform> messageInformsHere(){
	  Grid grid = getMyObserver().getGrid();
	  GridPoint gridPoint = grid.getLocation(this);
	  AgentSet<net2.relogo.MessageInform> result = new AgentSet<net2.relogo.MessageInform>();
	  for (Turtle t : Utility.getTurtlesOnGridPoint(gridPoint,getMyObserver(),"messageInform")){
			if (t instanceof net2.relogo.MessageInform)
			result.add((net2.relogo.MessageInform)t);
		}
		return result;
	}

	/**
	 * Returns the agentset of messageInforms on the patch at the direction (ndx, ndy) from the
	 * caller.
	 * 
	 * @param nX
	 *            a number
	 * @param nY
	 *            a number
	 * @returns agentset of messageInforms at the direction (nX, nY) from the caller
	 */
	@ReLogoBuilderGeneratedFor("net2.relogo.MessageInform")
	public AgentSet<net2.relogo.MessageInform> messageInformsAt(Number nX, Number nY){
		double dx = nX.doubleValue();
		double dy = nY.doubleValue();
		double[] displacement = {dx,dy};

		try{
		GridPoint gridPoint = Utility.getGridPointAtDisplacement(getTurtleLocation(),displacement,getMyObserver());
		AgentSet<net2.relogo.MessageInform> result = new AgentSet<net2.relogo.MessageInform>();						
		for (Turtle t : Utility.getTurtlesOnGridPoint(gridPoint,getMyObserver(),"messageInform")){
			if (t instanceof net2.relogo.MessageInform)
			result.add((net2.relogo.MessageInform)t);
		}
		return result;
		}
		catch(SpatialException e){
			return new AgentSet<net2.relogo.MessageInform>();
		}
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
	 * Makes a number of new packets and then executes a set of commands on the
	 * created packets.
	 * 
	 * @param number
	 *            a number
	 * @param closure
	 *            a set of commands
	 * @return created packets
	 */
	@ReLogoBuilderGeneratedFor("net2.relogo.Packet")
	public AgentSet<net2.relogo.Packet> hatchPackets(int number, Closure closure) {
		AgentSet<net2.relogo.Packet> result = new AgentSet<>();
		AgentSet<Turtle> createResult = this.hatch(number,closure,"Packet");
		for (Turtle t : createResult){
			if (t instanceof net2.relogo.Packet){
				result.add((net2.relogo.Packet)t);
			}
		} 
		return result;
	}

	/**
	 * Makes a number of new packets and then executes a set of commands on the
	 * created packets.
	 * 
	 * @param number
	 *            a number
	 * @param closure
	 *            a set of commands
	 * @return created packets
	 */
	@ReLogoBuilderGeneratedFor("net2.relogo.Packet")
	public AgentSet<net2.relogo.Packet> hatchPackets(int number) {
		return hatchPackets(number,null);
	}

	/**
	 * Returns an agentset of packets from the patch of the caller.
	 * 
	 * @return agentset of packets from the caller's patch
	 */
	@ReLogoBuilderGeneratedFor("net2.relogo.Packet")
	public AgentSet<net2.relogo.Packet> packetsHere(){
	  Grid grid = getMyObserver().getGrid();
	  GridPoint gridPoint = grid.getLocation(this);
	  AgentSet<net2.relogo.Packet> result = new AgentSet<net2.relogo.Packet>();
	  for (Turtle t : Utility.getTurtlesOnGridPoint(gridPoint,getMyObserver(),"packet")){
			if (t instanceof net2.relogo.Packet)
			result.add((net2.relogo.Packet)t);
		}
		return result;
	}

	/**
	 * Returns the agentset of packets on the patch at the direction (ndx, ndy) from the
	 * caller.
	 * 
	 * @param nX
	 *            a number
	 * @param nY
	 *            a number
	 * @returns agentset of packets at the direction (nX, nY) from the caller
	 */
	@ReLogoBuilderGeneratedFor("net2.relogo.Packet")
	public AgentSet<net2.relogo.Packet> packetsAt(Number nX, Number nY){
		double dx = nX.doubleValue();
		double dy = nY.doubleValue();
		double[] displacement = {dx,dy};

		try{
		GridPoint gridPoint = Utility.getGridPointAtDisplacement(getTurtleLocation(),displacement,getMyObserver());
		AgentSet<net2.relogo.Packet> result = new AgentSet<net2.relogo.Packet>();						
		for (Turtle t : Utility.getTurtlesOnGridPoint(gridPoint,getMyObserver(),"packet")){
			if (t instanceof net2.relogo.Packet)
			result.add((net2.relogo.Packet)t);
		}
		return result;
		}
		catch(SpatialException e){
			return new AgentSet<net2.relogo.Packet>();
		}
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
	 * Makes a number of new userTurtles and then executes a set of commands on the
	 * created userTurtles.
	 * 
	 * @param number
	 *            a number
	 * @param closure
	 *            a set of commands
	 * @return created userTurtles
	 */
	@ReLogoBuilderGeneratedFor("net2.relogo.UserTurtle")
	public AgentSet<net2.relogo.UserTurtle> hatchUserTurtles(int number, Closure closure) {
		AgentSet<net2.relogo.UserTurtle> result = new AgentSet<>();
		AgentSet<Turtle> createResult = this.hatch(number,closure,"UserTurtle");
		for (Turtle t : createResult){
			if (t instanceof net2.relogo.UserTurtle){
				result.add((net2.relogo.UserTurtle)t);
			}
		} 
		return result;
	}

	/**
	 * Makes a number of new userTurtles and then executes a set of commands on the
	 * created userTurtles.
	 * 
	 * @param number
	 *            a number
	 * @param closure
	 *            a set of commands
	 * @return created userTurtles
	 */
	@ReLogoBuilderGeneratedFor("net2.relogo.UserTurtle")
	public AgentSet<net2.relogo.UserTurtle> hatchUserTurtles(int number) {
		return hatchUserTurtles(number,null);
	}

	/**
	 * Returns an agentset of userTurtles from the patch of the caller.
	 * 
	 * @return agentset of userTurtles from the caller's patch
	 */
	@ReLogoBuilderGeneratedFor("net2.relogo.UserTurtle")
	public AgentSet<net2.relogo.UserTurtle> userTurtlesHere(){
	  Grid grid = getMyObserver().getGrid();
	  GridPoint gridPoint = grid.getLocation(this);
	  AgentSet<net2.relogo.UserTurtle> result = new AgentSet<net2.relogo.UserTurtle>();
	  for (Turtle t : Utility.getTurtlesOnGridPoint(gridPoint,getMyObserver(),"userTurtle")){
			if (t instanceof net2.relogo.UserTurtle)
			result.add((net2.relogo.UserTurtle)t);
		}
		return result;
	}

	/**
	 * Returns the agentset of userTurtles on the patch at the direction (ndx, ndy) from the
	 * caller.
	 * 
	 * @param nX
	 *            a number
	 * @param nY
	 *            a number
	 * @returns agentset of userTurtles at the direction (nX, nY) from the caller
	 */
	@ReLogoBuilderGeneratedFor("net2.relogo.UserTurtle")
	public AgentSet<net2.relogo.UserTurtle> userTurtlesAt(Number nX, Number nY){
		double dx = nX.doubleValue();
		double dy = nY.doubleValue();
		double[] displacement = {dx,dy};

		try{
		GridPoint gridPoint = Utility.getGridPointAtDisplacement(getTurtleLocation(),displacement,getMyObserver());
		AgentSet<net2.relogo.UserTurtle> result = new AgentSet<net2.relogo.UserTurtle>();						
		for (Turtle t : Utility.getTurtlesOnGridPoint(gridPoint,getMyObserver(),"userTurtle")){
			if (t instanceof net2.relogo.UserTurtle)
			result.add((net2.relogo.UserTurtle)t);
		}
		return result;
		}
		catch(SpatialException e){
			return new AgentSet<net2.relogo.UserTurtle>();
		}
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
	 * Makes a directed userLink from a turtle to the caller then executes a set of
	 * commands on the created userLink.
	 * 
	 * @param t
	 *            a turtle
	 * @param closure
	 *            a set of commands
	 * @return created userLink
	 */
	@ReLogoBuilderGeneratedFor("net2.relogo.UserLink")
	public net2.relogo.UserLink createUserLinkFrom(Turtle t, Closure closure){
		net2.relogo.UserLink link = (net2.relogo.UserLink)this.getMyObserver().getNetwork("UserLink").addEdge(t,this);
		if (closure != null){
			this.ask(link,closure);
		}
		return link;
	}

	/**
	 * Makes a directed userLink from a turtle to the caller.
	 * 
	 * @param t
	 *            a turtle
	 * @return created userLink
	 */
	@ReLogoBuilderGeneratedFor("net2.relogo.UserLink")
	public net2.relogo.UserLink createUserLinkFrom(Turtle t){
			return createUserLinkFrom(t,null);
	}

	/**
	 * Makes directed userLinks from a collection to the caller then executes a set
	 * of commands on the created userLinks.
	 * 
	 * @param a
	 *            a collection
	 * @param closure
	 *            a set of commands
	 * @return created userLinks
	 */
	@ReLogoBuilderGeneratedFor("net2.relogo.UserLink")
	public AgentSet<net2.relogo.UserLink> createUserLinksFrom(Collection<? extends Turtle> a, Closure closure){
		AgentSet<net2.relogo.UserLink> links = new AgentSet<net2.relogo.UserLink>();
		for(Turtle t : a){
			links.add((net2.relogo.UserLink)this.getMyObserver().getNetwork("UserLink").addEdge(t,this));
		}
		if (closure != null){
			this.ask(links,closure);
		}
		return links;
	}

	/**
	 * Makes directed userLinks from a collection to the caller.
	 * 
	 * @param a
	 *            a collection
	 * @return created userLinks
	 */
	@ReLogoBuilderGeneratedFor("net2.relogo.UserLink")
	public AgentSet<net2.relogo.UserLink> createUserLinksFrom(Collection<? extends Turtle> a){
		return createUserLinksFrom(a,null);
	}

	/**
	 * Makes a directed userLink to a turtle from the caller then executes a set of
	 * commands on the created userLink.
	 * 
	 * @param t
	 *            a turtle
	 * @param closure
	 *            a set of commands
	 * @return created userLink
	 */
	@ReLogoBuilderGeneratedFor("net2.relogo.UserLink")
	public net2.relogo.UserLink createUserLinkTo(Turtle t, Closure closure){
		net2.relogo.UserLink link = (net2.relogo.UserLink)this.getMyObserver().getNetwork("UserLink").addEdge(this,t);
		if (closure != null){
			this.ask(link,closure);
		}
		return link;
	}

	/**
	 * Makes a directed userLink to a turtle from the caller.
	 * 
	 * @param t
	 *            a turtle
	 * @return created userLink
	 */
	@ReLogoBuilderGeneratedFor("net2.relogo.UserLink")
	public net2.relogo.UserLink createUserLinkTo(Turtle t){
			return createUserLinkTo(t,null);
	}

	/**
	 * Makes directed userLinks to a collection from the caller then executes a set
	 * of commands on the created userLinks.
	 * 
	 * @param a
	 *            a collection
	 * @param closure
	 *            a set of commands
	 * @return created userLinks
	 */
	@ReLogoBuilderGeneratedFor("net2.relogo.UserLink")
	public AgentSet<net2.relogo.UserLink> createUserLinksTo(Collection<? extends Turtle> a, Closure closure){
		AgentSet<net2.relogo.UserLink> links = new AgentSet<net2.relogo.UserLink>();
		for(Object t : a){
			if (t instanceof Turtle){
				links.add((net2.relogo.UserLink)this.getMyObserver().getNetwork("UserLink").addEdge(this,(Turtle)t));
			}
		}
		if (closure != null){
			this.ask(links,closure);
		}
		return links;
	}

	/**
	 * Makes directed userLinks to a collection from the caller.
	 * 
	 * @param a
	 *            a collection
	 * @return created userLinks
	 */
	@ReLogoBuilderGeneratedFor("net2.relogo.UserLink")
	public AgentSet<net2.relogo.UserLink> createUserLinksTo(Collection<? extends Turtle> a){
		return createUserLinksTo(a,null);
	}

	/**
	 * Queries if there is a directed userLink from a turtle to the caller.
	 * 
	 * @param t
	 *            a turtle
	 * @return true or false based on whether there is a directed userLink from
	 *         turtle t to the caller
	 */
	@ReLogoBuilderGeneratedFor("net2.relogo.UserLink")
	public boolean inUserLinkNeighborQ(Turtle t){
		return this.getMyObserver().getNetwork("UserLink").isPredecessor(t, this);
	}

	/**
	 * Returns the agentset with directed userLinks to the caller.
	 * 
	 * @return agentset with directed userLinks to the caller
	 */
	@ReLogoBuilderGeneratedFor("net2.relogo.UserLink")
	public AgentSet inUserLinkNeighbors(){
		AgentSet result = new AgentSet();
		for(Object o : this.getMyObserver().getNetwork("UserLink").getPredecessors(this)){
			result.add(o);
		}
		return result;
	}

	/**
	 * Returns the directed userLink from a turtle to the caller.
	 * 
	 * @param t
	 *            a turtle
	 * @return directed userLink from turtle t to the caller
	 */
	@ReLogoBuilderGeneratedFor("net2.relogo.UserLink")
	public net2.relogo.UserLink inUserLinkFrom(Turtle t){
		return (net2.relogo.UserLink)this.getMyObserver().getNetwork("UserLink").getEdge(t,this);
	}

	/**
	 * Returns an agentset of directed userLinks from other turtles to the caller.
	 * 
	 * @return agentset of directed userLinks from other turtles to the caller
	 */
	@ReLogoBuilderGeneratedFor("net2.relogo.UserLink")
	public AgentSet<net2.relogo.UserLink> myInUserLinks(){
		AgentSet<net2.relogo.UserLink> result = new AgentSet<net2.relogo.UserLink>();
		for(Object o :  this.getMyObserver().getNetwork("UserLink").getInEdges(this)){
			if (o instanceof net2.relogo.UserLink){
				result.add((net2.relogo.UserLink) o);
			}
		}
		return result;
	}

	/**
	 * Returns an agentset of directed userLinks to other turtles from the caller.
	 * 
	 * @return agentset of directed userLinks to other turtles from the caller
	 */
	@ReLogoBuilderGeneratedFor("net2.relogo.UserLink")
	public AgentSet<net2.relogo.UserLink> myOutUserLinks(){
		AgentSet<net2.relogo.UserLink> result = new AgentSet<net2.relogo.UserLink>();
		for(Object o :  this.getMyObserver().getNetwork("UserLink").getOutEdges(this)){
			if (o instanceof net2.relogo.UserLink){
				result.add((net2.relogo.UserLink) o);
			}
		}
		return result;
	}

	/**
	 * Queries if there is a directed userLink to a turtle from the caller.
	 * 
	 * @param t
	 *            a turtle
	 * @return true or false based on whether there is a directed userLink to
	 *         turtle t from the caller
	 */
	@ReLogoBuilderGeneratedFor("net2.relogo.UserLink")
	public boolean outUserLinkNeighborQ(Turtle t){
		return this.getMyObserver().getNetwork("UserLink").isPredecessor(this, t);
	}

	/**
	 * Returns the agentset with directed userLinks from the caller.
	 * 
	 * @return agentset with directed userLinks from the caller
	 */
	@ReLogoBuilderGeneratedFor("net2.relogo.UserLink")
	public AgentSet outUserLinkNeighbors(){
		AgentSet result = new AgentSet();
		for(Object o : this.getMyObserver().getNetwork("UserLink").getSuccessors(this)){
			result.add(o);
		}
		return result;
	}

	/**
	 * Returns the directed userLink to a turtle from the caller.
	 * 
	 * @param t
	 *            a turtle
	 * @return directed userLink to turtle t from the caller
	 */
	@ReLogoBuilderGeneratedFor("net2.relogo.UserLink")
	public net2.relogo.UserLink outUserLinkTo(Turtle t){
		return (net2.relogo.UserLink)this.getMyObserver().getNetwork("UserLink").getEdge(this, t);
	}

	/**
	 * Reports true if there is a userLink connecting t and the caller.
	 */
	@ReLogoBuilderGeneratedFor("net2.relogo.UserLink")
	public boolean userLinkNeighborQ(Turtle t){
		return this.getMyObserver().getNetwork("UserLink").isAdjacent(this, t);
	}

	/**
	 * Returns the agentset of all turtles found at the other end of
	 * userLinks connected to the calling turtle.
	 */
	@ReLogoBuilderGeneratedFor("net2.relogo.UserLink")
	public AgentSet userLinkNeighbors(){
		AgentSet result = new AgentSet();
		for(Object o : this.getMyObserver().getNetwork("UserLink").getAdjacent(this)){
			result.add(o);
		}
		return result;
	}

	/**
	 * Returns an agentset of the caller's userLinks.
	 * 
	 * @return agentset of the caller's userLinks
	 */
	@ReLogoBuilderGeneratedFor("net2.relogo.UserLink")
	public AgentSet<net2.relogo.UserLink> myUserLinks(){
		AgentSet<net2.relogo.UserLink> result = new AgentSet<net2.relogo.UserLink>();
		for(Object o : this.getMyObserver().getNetwork("UserLink").getEdges(this)){
			if (o instanceof net2.relogo.UserLink){
				result.add((net2.relogo.UserLink)o);
			}
		}
		return result;
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


}