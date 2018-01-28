package net2.limiter;
import com.google.common.base.Ticker;
import com.google.common.util.concurrent.ForkedRateLimiter;

public class PerInstanceRateLimiter implements RateLimiter {
	private final ForkedRateLimiter delegate;
	
	PerInstanceRateLimiter(ForkedRateLimiter delegate) {
		this.delegate = delegate;
	}

	public static PerInstanceRateLimiter create(double permitsPerSecond, Ticker ticker) {
		return new PerInstanceRateLimiter(ForkedRateLimiter.create(permitsPerSecond, ticker));
	}
	
	public boolean tryAcquire(int permits) {
		return delegate.tryAcquire(permits);
	}

}
