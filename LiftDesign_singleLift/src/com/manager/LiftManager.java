package com.manager;

import java.util.logging.Level;
import java.util.logging.Logger;

import com.lift.Lift;
import com.lift.LiftDriver;
import com.logger.LoggerDemo;

public class LiftManager implements Runnable {
	Logger loggerDemo = LoggerDemo.getLoggerInstance();
	LiftDriver liftDriver = null;
	private Lift lift = null;

	public LiftManager(Lift lift) {
		this.lift = lift;
		liftDriver = new LiftDriver(lift);
	}

	public boolean getLift(Integer floor) {
		addFloorToQueue(floor);
		return true;
	}

	private void addFloorToQueue(Integer floor) {
		if (floor >= this.lift.getMinFloor() && floor <= this.lift.getMaxFloor()) {
			System.out.println("Floor " + floor + " Selected, Lift will be assigned soon.");
			loggerDemo.log(Level.INFO, "Floor " + floor + " Selected, Lift will be assigned soon.");
			this.lift.addFloorToQueue(floor);
			System.out.println("Lift has been assigned, please wait...");
			loggerDemo.log(Level.INFO, "Lift has been assigned, please wait...");
		} else {
			System.out.println("Wrong Floor, Re-check & Enter...");
			loggerDemo.log(Level.INFO, "Wrong Floor, Re-check & Enter...");
		}
	}

	public void makeLiftAcitve(Integer liftNumber) {
		this.lift.setActive(true);
	}

	public void makeLiftUnAcitve(Integer liftNumber) {
		this.lift.setActive(false);
	}

	@Override
	public void run() {

		while (true) {

			liftDriver.moveLift();

		}

	}

}
