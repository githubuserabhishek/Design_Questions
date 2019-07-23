package com.manager;

import java.util.ArrayList;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.logging.Level;
import java.util.logging.Logger;

import com.lift.Lift;
import com.lift.LiftDriver;
import com.logger.LoggerDemo;

public class LiftManager {
	private ExecutorService driverPool = null;
	private Logger loggerDemo = LoggerDemo.getLoggerInstance();
	private ArrayList<LiftDriver> liftDrivers = null;
	private ArrayList<Lift> lifts = null;

	public LiftManager(ArrayList<Lift> lifts) {
		this.lifts = lifts;
		liftDrivers = new ArrayList<LiftDriver>();
		driverPool = Executors.newFixedThreadPool(2);
		for (Lift lift : lifts) {
			liftDrivers.add(new LiftDriver(lift));
		}
	}

	public boolean getLift(Integer floor) {
		assignLift(floor);
		return true;
	}

	private void assignLift(Integer floor) {
		int index = -1;
		for (Lift lift : lifts) {

			index++;

			if (!lift.isActive()) {
				continue;
			}

			if (floor >= lift.getMinFloor() && floor <= lift.getMaxFloor()) {

				if (lift.getCurrentFloor() < floor && lift.isGoingUp()) {

					lift.addFloorToQueue(floor);
					runLiftDriver(index);
					break;
				} else if (lift.getCurrentFloor() > floor) {
					lift.addFloorToQueue(floor);
					runLiftDriver(index);
					break;
				}
				else {
					lift.addFloorToQueue(floor);
					runLiftDriver(index);
					break;
				}

			} else {
				System.out.println("Wrong Floor, Re-check & Enter...");
				loggerDemo.log(Level.INFO, "Wrong Floor, Re-check & Enter...");
			}
		}

	}

	private void runLiftDriver(int index) {
		LiftDriver liftDriver = liftDrivers.get(index);
		driverPool.execute(liftDriver);
	}

	public void makeLiftAcitve(Integer liftNumber) {
		this.lifts.get(liftNumber).setActive(true);
	}

	public void makeLiftUnAcitve(Integer liftNumber) {
		this.lifts.get(liftNumber).setActive(false);
	}

}
