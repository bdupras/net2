package net2.comms;

import java.util.Random;
import java.util.concurrent.ConcurrentHashMap;

import com.duprasville.limiters.comms.MessageSource;
import com.duprasville.limiters.comms.Message;
import com.duprasville.limiters.comms.MessageSink;

import net2.ReLogoTurtle;
import net2.relogo.Packet;

public class TurtleMessageSource<E extends ReLogoTurtle> implements MessageSource {
	private final Resolver<E> resolver;
	private final String dstEndpoint;
    private MessageSink onReceive;

	private final ConcurrentHashMap<Long, E> resolvedTurtles = new ConcurrentHashMap<>();
	private final Random random = new Random();

	public TurtleMessageSource(String dstEndpoint, Resolver<E> resolver) {
		this.resolver = resolver;
		this.dstEndpoint = dstEndpoint;
	}

	@Override
	public void send(Message message) {
		E srcTurtle = resolvedTurtles.computeIfAbsent(message.getSrc(), (s) -> resolver.resolve(s));
		E dstTurtle = resolvedTurtles.computeIfAbsent(message.getDst(), (d) -> resolver.resolve(d));
		Packet.newPacket(srcTurtle, dstTurtle, dstEndpoint, message).send();
	}

	@FunctionalInterface
	public interface Resolver<E extends ReLogoTurtle> {
		E resolve(long id);
	}
}
