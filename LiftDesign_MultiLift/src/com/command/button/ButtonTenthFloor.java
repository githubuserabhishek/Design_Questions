package com.command.button;

import com.manager.LiftManager;

public class ButtonTenthFloor implements Command {

	LiftManager liftManager = null;

	public ButtonTenthFloor(LiftManager liftManager) {
		this.liftManager = liftManager;
	}

	@Override
	public void execute() {
		liftManager.getLift(10);
	}

}
