package net2.relogo

import static repast.simphony.relogo.Utility.*
import static repast.simphony.relogo.UtilityG.*
import static net2.relogo.Utils.*

import net2.ReLogoTurtle
import repast.simphony.relogo.Plural
import repast.simphony.relogo.Stop
import repast.simphony.relogo.Turtle
import repast.simphony.relogo.Utility
import repast.simphony.relogo.UtilityG
import repast.simphony.relogo.schedule.Go
import repast.simphony.relogo.schedule.Setup
import repast.simphony.relogo.AgentSet
import repast.simphony.random.RandomHelper
import cern.jet.random.PoissonSlow



class Packet extends ReLogoTurtle {
	private static PoissonSlow poisson = RandomHelper.createPoissonSlow(8)

	public static Packet newPacket(ReLogoTurtle src, ReLogoTurtle dst, String endpoint, payload) {
		src.hatchPackets(1) { Packet p ->
			p.reset()
			p.src = src
			p.dst = dst
			p.endpoint = endpoint
			p.payload = payload
		}.first()
	}

	Turtle src, dst = null
	String endpoint = "equals"
	Object payload = null
	int latency = 1

	public Packet send() {
		sentAt = getTickCount()
		dist = distance(dst)
		moveBy = dist / latency
		sent = true
		createLinkWith(src)
		face(dst)
		this
	}

	private boolean sent = false
	private int sentAt = 0
	private double dist = 0
	private double moveBy = 0

	private def reset() {
		src = dst = null
		endpoint = "equals"
		payload = null
		latency = poisson.nextInt()
		sentAt = 0

		color = green()
		size = 0.25
		shape = "circle"
	}

	private step() {
		if (sent && dst != null) {
			def now = getTickCount()
			def age = Math.max(0, Math.floor(now - sentAt))
			def ttl = Math.floor(latency - age)
			if (ttl > 0) {
				move(moveBy)
			} else if (ttl == 0) {
				moveTo(dst)
				color = red()
				dst."$endpoint"(src, dst, payload)
			} else if (ttl < -5) {
				die()
			}
		}
	}

	@Go(interval=1d, shuffle=true)
	def go() {
		step()
	}
}
