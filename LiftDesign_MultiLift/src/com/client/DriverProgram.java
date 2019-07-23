package com.client;

import java.util.ArrayList;

import com.command.button.ButtonFifthFloor;
import com.command.button.ButtonLowerGroundFloor;
import com.command.button.ButtonTenthFloor;
import com.command.button.Command;
import com.lift.Lift;
import com.lift.LiftOne;
import com.lift.LiftTwo;
import com.manager.LiftManager;

public class DriverProgram {

	public static void main(String[] args) {
		
		
		LiftTwo liftTwo = new LiftTwo(-1, 10);
		LiftOne liftOne = new LiftOne(-1, 10);
		
		ArrayList<Lift> lifts = new ArrayList<>();
		lifts.add(liftOne);
		lifts.add(liftTwo);
		
		LiftManager liftManager = new LiftManager(lifts);
		
		liftManager.makeLiftAcitve(0);
		liftManager.makeLiftAcitve(1);
		
		/*RequestManager rq = new RequestManager(liftManager);
		
		Thread t1 = new Thread(rq);
		t1.start();*/
		
		Command bLG = new ButtonLowerGroundFloor(liftManager);
		Command b5F = new ButtonFifthFloor(liftManager);
		Command b10F = new ButtonTenthFloor(liftManager);
		
		b5F.execute();
		b10F.execute();
		bLG.execute();
		
	}
}
