package com.command.button;

import com.manager.LiftManager;

public class ButtonFifthFloor implements Command {

	LiftManager liftManager = null;

	public ButtonFifthFloor(LiftManager liftManager) {
		this.liftManager = liftManager;
	}

	@Override
	public void execute() {
		liftManager.getLift(5);
	}

}
