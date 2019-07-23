package com.logger;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.logging.FileHandler;
import java.util.logging.Handler;
import java.util.logging.LogManager;
import java.util.logging.Logger;

public class LoggerDemo {

	private static Logger logger = null;

	private LoggerDemo() {

	}

	public static synchronized Logger getLoggerInstance() {
		if (logger == null) {
			try {
				Handler fileHandler = new FileHandler("C:\\Users\\pushkar.c\\eclipse-workspace\\drives\\LiftDesign_singleLift\\src\\com\\logger\\logger.log", 2000, 5);
				logger = Logger.getLogger(LoggerDemo.class.getName());
	            LogManager.getLogManager().readConfiguration(new FileInputStream("C:\\Users\\pushkar.c\\eclipse-workspace\\drives\\LiftDesign_singleLift\\src\\com\\logger\\logger_properties.log"));
				logger.addHandler(fileHandler);
			} catch (SecurityException | IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		return logger;
	}
}
