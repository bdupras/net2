package net2.relogo

import repast.simphony.engine.environment.RunEnvironment
import repast.simphony.relogo.factories.RLWorldDimensions

class Utils {
	public static double getTickCount() {
		return RunEnvironment.getInstance().getCurrentSchedule().getTickCount();
	}

	public static double[] relToAbsCor(double[] rel, double[] dims, double[] origin) {
		// origin are maximums based on RLWorldDimensions#getOrigin() which returns negated minXPcor,minYPcor
		double x = origin[0] - (((dims[0]-1)) * rel[0])
		double y = origin[1] - (((dims[1]-1)) * rel[1])
		[x, y]
	}
}
