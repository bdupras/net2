package net2.relogo

import repast.simphony.relogo.factories.AbstractReLogoGlobalsAndPanelFactory

public class UserGlobalsAndPanelFactory extends AbstractReLogoGlobalsAndPanelFactory{
	public void addGlobalsAndPanelComponents(){
		addSliderWL("simulationMaxTps", "Sim Speed Max Ticks/Sec", 0, 1, 1_000, 60)
		addChooserWL("limitStrategy", "Rate Limiter", [
			"none", 
			"non-cooperative optimistic", 
			"centralized/memcahced", 
			"treefill"
			], 0)
		
		addSliderWL("clientRps", "Gen Requests per Second", 0, 100, 10_000, 700)
		addSliderWL("clientIpr", "Gen Items per Request", 1, 1, 100, 1)
		addSliderWL("clusterQuota", "Quota (Items per Second)", 0, 100, 10_000, 1_000)
		addSliderWL("randSeed", "Random Seed", 0, 1, 1_000, 500)
		
		/**
		 * Place custom panels and globals below, for example:
		 * 
	        addGlobal("globalVariable1")	// Globally accessible variable ( variable name)
	        // Slider with label ( variable name, slider label, minimum value, increment, maximum value, initial value )
	        addSliderWL("sliderVariable", "Slider Variable", 0, 1, 10, 5)
	        // Slider without label ( variable name, minimum value, increment, maximum value, initial value )
	        addSlider("sliderVariable2", 0.2, 0.1, 0.8, 0.5)
	        // Chooser with label  ( variable name, chooser label, list of choices , zero-based index of initial value )
	        addChooserWL("chooserVariable", "Chooser Variable", ["yes","no","maybe"], 2)
	        // Chooser without label  ( variable name, list of choices , zero-based index of initial value )
	        addChooser("chooserVariable2", [1, 66, "seven"], 0)
	        // State change button (method name in observer)
	        addStateChangeButton("change")
	        // State change button with label (method name in observer, label)
	        addStateChangeButtonWL("changeSomething","Change Something")
	        
		 */

	}
}