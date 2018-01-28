package net2.relogo;

import com.google.common.base.Ticker;

import repast.simphony.engine.environment.RunEnvironment;

public class ReLogoTicker extends Ticker {
	public ReLogoTicker() {
		super();
		
	}
	@Override
	public long read() {
		long nanosPerTick = 1_000 * 1_000; 
		return (long)(RunEnvironment.getInstance().getCurrentSchedule().getTickCount() * nanosPerTick);
	}

}
