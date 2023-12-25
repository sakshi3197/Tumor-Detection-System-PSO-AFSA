package com.Pso;

import java.awt.image.BufferedImage;
import org.boofcv.boofcvtemplatematchingmain.DecodeMsg;

public class Particle {
    private BufferedImage brIm;
	private double fitnessValue;
	private Velocity velocity;
	private Location location;
        public static String getLocation="";
	
	public Particle() {
		super();
	}

	public Particle(double fitnessValue, Velocity velocity, Location location) {
		super();
		this.fitnessValue = fitnessValue;
		this.velocity = velocity;
		this.location = location;
	}
        
        public void Particle1(BufferedImage org, double fitnessValue, Velocity velocity, Location location) {
		brIm=org;
                getLocation=DecodeMsg.decodeMessage(org);
//                System.out.println("getlocation===>"+getLocation);
                this.fitnessValue = fitnessValue;
		this.velocity = velocity;
		this.location = location;
	}

	public Velocity getVelocity() {
		return velocity;
	}

	public void setVelocity(Velocity velocity) {
		this.velocity = velocity;
	}

	public Location getLocation() {
		return location;
	}

	public void setLocation(Location location) {
		this.location = location;
	}

	public double getFitnessValue() {
		fitnessValue = ProblemSet.evaluate(location);
		return fitnessValue;
	}
}
