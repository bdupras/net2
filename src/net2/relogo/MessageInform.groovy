package net2.relogo

import static repast.simphony.relogo.Utility.*
import static repast.simphony.relogo.UtilityG.*

import net2.ReLogoTurtle
import repast.simphony.relogo.Plural
import repast.simphony.relogo.Stop
import repast.simphony.relogo.Turtle
import repast.simphony.relogo.Utility
import repast.simphony.relogo.UtilityG
import repast.simphony.relogo.schedule.Go
import repast.simphony.relogo.schedule.Setup

class MessageInform extends ReLogoTurtle {
	Turtle src, dst, target

	def sendTo(Turtle src, Turtle dst) {
		this.src = src
		this.target = this.dst = dst
	}

	def setup() {
		color = cyan()
		size = 0.25
		shape = "circle"
	}

	@Go
	def go() {
		this.face(target)
		move(0.1)
		if (this.clusterNodesHere().contains(target)) {
			color = pink()
		}
	}
	
}
