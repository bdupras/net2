package net2.relogo

import static repast.simphony.relogo.Utility.*
import static repast.simphony.relogo.UtilityG.*

import org.jscience.physics.amount.Amount

import com.google.common.base.Ticker

import repast.simphony.engine.environment.RunEnvironment
import repast.simphony.engine.schedule.Schedule

import com.google.common.util.concurrent.RateLimiter

class Utils {
	public static long getTickCount() {
		return RunEnvironment.getInstance().getCurrentSchedule().getTickCount();
	}

	public static double[] relToAbsCor(double[] rel, double[] dims, double[] origin) {
		// origin are maximums based on RLWorldDimensions#getOrigin() which returns negated minXPcor,minYPcor
		double x = origin[0] - (((dims[0]-1)) * rel[0])
		double y = origin[1] - (((dims[1]-1)) * rel[1])
		[x, y]
	}

	public static Double convertTimeUnitsToTicks(Amount timeUnitsToConvert) {
		Schedule s = (Schedule)(RunEnvironment.getInstance().getCurrentSchedule())
		s.convertTimeUnitsToTicks(timeUnitsToConvert)
	}

	public static int ONE_SECOND = 1_000 //convertTimeUnitsToTicks(Amount.valueOf(1L, SECOND));

	public static final Ticker RELOGO_TICKER =
	new Ticker() {
		@Override
		public long read() {
			return Utils.getTickCount() * 1_000_000
		}
	};

	private static RateLimiter simRateLimiter = RateLimiter.create(1_000);
	
	public static void speedLimit(int ticksPerSecond) {
		switch (ticksPerSecond) {
			case 0:
				pause()
				break
			case 1_000:
			// no limit
				break
			default:
				simRateLimiter.setRate(ticksPerSecond)
				simRateLimiter.acquire()
				break
		}
	}

	/**
	 * Useful for calculating a single position's fair share of a whole, e.g. 
	 *   - requests per a given mSec when defined in requests per second
	 *   - quota per a given node when defined in quota per cluster
	 * Shares must be whole numbers. Accounts for fractional shares by
	 * allocating an extra share to some positions. 
	 */
	static int spread(long thisPosition, long units, long perPositions) {
		int half = perPositions / 2;
		int whole = units / perPositions;
		int rem = units % perPositions;
		if (rem == 0) {
			return whole;
		} else if (rem < half) {
			return (0 == thisPosition.mod(perPositions.intdiv(rem))) ? whole + 1 : whole;
		} else {
			return (0 == thisPosition.mod(perPositions.intdiv(perPositions - rem))) ? whole : whole + 1;
		}
	}
	
	public static String LIMIT_NONE = "none" 
	public static String LIMIT_NON_COOPERATIVE = "non-cooperative optimistic"
	public static String LIMIT_CENTRALIZED = "centralized/memcahced (not impl)"
	public static String LIMIT_TREEFILL = "treefill (not impl)"
}
