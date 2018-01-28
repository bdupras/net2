package net2.comms;

import java.util.Random;
import java.util.concurrent.ConcurrentHashMap;

import com.duprasville.limiters.comms.MessageSender;

import net2.ReLogoTurtle;
import net2.relogo.Packet;

public class TurtleMessageSender<E extends ReLogoTurtle> implements MessageSender {
	private final Resolver<E> resolver;
	private final String dstEndpoint;

	private final ConcurrentHashMap<Long, E> resolvedTurtles = new ConcurrentHashMap<>();
	private final Random random = new Random();

	public TurtleMessageSender(String dstEndpoint, Resolver<E> resolver) {
		this.resolver = resolver;
		this.dstEndpoint = dstEndpoint;
	}

	@Override
	public void send(long src, long dst, Object msg) {
		E srcTurtle = resolvedTurtles.computeIfAbsent(src, (s) -> resolver.resolve(s));
		E dstTurtle = resolvedTurtles.computeIfAbsent(dst, (d) -> resolver.resolve(d));
		Packet.newPacket(srcTurtle, dstTurtle, dstEndpoint, msg).send();
	}

	@Override
	public void sendAny(long src, long[] dst, Object msg) {
		int i = random.nextInt(dst.length);
		send(src, dst[i], msg);
	}

	@FunctionalInterface
	public interface Resolver<E extends ReLogoTurtle> {
		E resolve(long id);
	}
}
