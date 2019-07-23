package com.command.button;

import com.manager.LiftManager;

public class ButtonLowerGroundFloor implements Command {

	LiftManager liftManager = null;

	public ButtonLowerGroundFloor(LiftManager liftManager) {
		this.liftManager = liftManager;
	}

	@Override
	public void execute() {
		liftManager.getLift(-1);
	}

}
