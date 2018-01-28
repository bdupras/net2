package net2.limiter;

public interface RateLimiter {
	boolean tryAcquire(int permits);
}
