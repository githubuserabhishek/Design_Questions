package com.client;

import java.util.PriorityQueue;
import java.util.Scanner;

import com.lift.Lift;
import com.lift.LiftDriver;
import com.manager.LiftManager;
import com.manager.RequestManager;

public class DriverProgram {

	public static void main(String[] args) {
		
		
		Lift lift = new Lift(-1, 10);
		LiftManager liftManager = new LiftManager(lift);
		RequestManager rq = new RequestManager(liftManager);
		
		Thread t1 = new Thread(rq);
		Thread t2 = new Thread(liftManager);
		t1.start();
		t2.start();
		
	}
}
