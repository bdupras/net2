package net2.comms

import com.duprasville.limiters.comms.CommNode
import com.duprasville.limiters.comms.Communicator
import com.duprasville.limiters.comms.Message
import com.duprasville.limiters.comms.MessageReceiver

import groovy.lang.Closure
import net2.relogo.ClusterNode
import net2.relogo.Packet
import repast.simphony.relogo.AgentSet
import repast.simphony.relogo.ReLogoAgent

public class AgentCommunicator<E extends ReLogoAgent> implements Communicator {
	final Closure resolver
	
	public AgentCommunicator(Closure resolver) {
		this.resolver = resolver
	}

	@Override
	public void sendTo(CommNode src, CommNode dst, Message msg) {
		
		Packet.newPacket(this, dst, "receiveHello", [msg: msg, replyTo: replyTo]).send()
		// TODO Auto-generated method stub
	}

	@Override
	public CommNode getCommNodeById(long nodeId) {
		ReLogoAgent<E> agent = resolver.call(nodeId)
		return new AgentCommNode(nodeId, agent)
	}

	@Override
	public Message newMessage(Object payload) {
		return new AgentMessage(payload)
	}
}

class AgentCommNode<E extends ReLogoAgent> implements CommNode {
    final long nodeId
    private final E agent
    private MessageReceiver recv

    AgentCommNode(long nodeId, E agent) {
        this.nodeId = nodeId
        this.agent = agent
    }
	
	public ReLogoAgent getAgent() {
		return agent
	}

    @Override
    public void onReceive(MessageReceiver recv) {
        this.recv = recv
    }

    @Override
    public void deliver(CommNode src, CommNode dst, Message msg) {
        recv.apply(src, dst, msg)
    }

    @Override
    public String toString() {
        return "AgentCommNode{" +
                "nodeId=" + nodeId +
                '}'
    }

}

class AgentMessage implements Message {
    private final Object payload

    AgentMessage(Object payload) {
        this.payload = payload
    }

    @Override
    public Object getPayload() {
        return payload
    }

    @Override
    public String toString() {
        return "TestMessage{" +
                "payload=" + payload +
                '}'
    }
}
