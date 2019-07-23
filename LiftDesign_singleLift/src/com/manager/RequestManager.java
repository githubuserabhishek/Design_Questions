package com.manager;

import java.util.Scanner;
import java.util.logging.Level;
import java.util.logging.Logger;

import com.logger.LoggerDemo;

public class RequestManager implements Runnable {
	Logger loggerDemo = LoggerDemo.getLoggerInstance();
	private LiftManager liftManager = null;

	public RequestManager(LiftManager liftManager) {
		this.liftManager = liftManager;
	}

	@Override
	public void run() {

		Scanner sc = null;
		Integer floor = 0;

		sc = new Scanner(System.in);
		while (floor >= -2) {
			System.err.print("\n\n\nEnter floor : ");
			loggerDemo.log(Level.INFO,"Enter floor : ");
			floor = sc.nextInt();
			liftManager.getLift(floor);
		}
		sc.close();

	}

}
