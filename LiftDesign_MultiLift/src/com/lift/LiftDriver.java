package com.lift;

import java.util.logging.Level;
import java.util.logging.Logger;

import com.logger.LoggerDemo;

public class LiftDriver implements Runnable {
	Logger loggerDemo = LoggerDemo.getLoggerInstance();
	Lift lift = null;

	public LiftDriver(Lift lift) {
		this.lift = lift;
	}

	public void moveLift() {

		System.out.println("\n\nLift will start moving now, present floor " + this.lift.getCurrentFloor());
		loggerDemo.log(Level.INFO, "\n\nLift will start moving now, present floor " + this.lift.getCurrentFloor());
		this.lift.setDestinationFloor(this.lift.getTopFloorFromQueue());

		if (this.lift.isGateOpen()) {
			closeGate();
		}

		if (this.lift.isGoingUp()) {
			moveup();
			openGate();
			try {
				Thread.sleep(2000);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
			closeGate();
		} else {
			moveDown();
			openGate();
			try {
				Thread.sleep(2000);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
			closeGate();
		}

		this.lift.removeTopFloorFromQueue();

	}

	private void moveDown() {

		while (!this.lift.isGateOpen() && this.lift.getCurrentFloor() > this.lift.getDestinationFloor()) {
			this.lift.setDestinationFloor(this.lift.getTopFloorFromQueue());
			System.out.println("Lift is going down " + this.lift.getCurrentFloor());
			loggerDemo.log(Level.INFO, "Lift is going down " + this.lift.getCurrentFloor());
			System.out.println("\\t\\t\\tNext Stoppage is " + this.lift.getDestinationFloor());
			loggerDemo.log(Level.INFO, "\t\t\tNext Stoppage is " + this.lift.getDestinationFloor());
			this.lift.setCurrentFloor(this.lift.getCurrentFloor() - 1);
			try {
				Thread.sleep(3000);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}

		System.out.println("Lift has reached " + this.lift.getCurrentFloor());
		loggerDemo.log(Level.INFO, "Lift has reached " + this.lift.getCurrentFloor());

	}

	private void moveup() {

		while (!this.lift.isGateOpen() && this.lift.getCurrentFloor() < this.lift.getDestinationFloor()) {
			this.lift.setDestinationFloor(this.lift.getTopFloorFromQueue());
			System.out.println("Lift is going up " + this.lift.getCurrentFloor());
			loggerDemo.log(Level.INFO, "Lift is going up " + this.lift.getCurrentFloor());
			System.out.println("\\t\\t\\tNext Stoppage is " + this.lift.getDestinationFloor());
			loggerDemo.log(Level.INFO, "\\t\\t\\tNext Stoppage is " + this.lift.getDestinationFloor());
			this.lift.setCurrentFloor(this.lift.getCurrentFloor() + 1);
			try {
				Thread.sleep(3000);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
			
		}

		System.out.println("Lift has reached " + this.lift.getCurrentFloor());
		loggerDemo.log(Level.INFO, "Lift has reached " + this.lift.getCurrentFloor());
	}

	private void openGate() {
		System.out.println("Gate Opening at floor " + this.lift.getCurrentFloor());
		loggerDemo.log(Level.INFO, "Gate Opening at floor " + this.lift.getCurrentFloor());
		this.lift.setGateOpen(true);
	}

	private void closeGate() {
		System.out.println("Gate Closing at floor " + this.lift.getCurrentFloor());
		loggerDemo.log(Level.INFO, "Gate Closing at floor " + this.lift.getCurrentFloor());
		this.lift.setGateOpen(false);
	}

	@Override
	public void run() {
		if (lift.isQueueEmpty()) {
			return;
		}
		moveLift();
	}

}
