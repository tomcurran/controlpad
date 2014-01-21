package org.tomcurran.controlpad;

import java.util.Observable;
import java.util.Observer;

import org.tomcurran.controlpad.controllers.ControllerStateChange;

public class ExampleApp implements Observer {

	@Override
	public void update(Observable o, Object arg) {
		ControllerStateChange stateChange = (ControllerStateChange) arg;
		if (stateChange.isSquareChanged()) {
			System.out.println("Square changed");
		}
		if (stateChange.isCrossChanged()) {
			System.out.println("Cross changed");
		}
		if (stateChange.isCircleChanged()) {
			System.out.println("Circle changed");
		}
		if (stateChange.isTriangleChanged()) {
			System.out.println("Triangle changed");
		}
		if (stateChange.isL1Changed()) {
			System.out.println("L1 changed");
		}
		if (stateChange.isR1Changed()) {
			System.out.println("R1 changed");
		}
		if (stateChange.isL2Changed()) {
			System.out.println("L2 changed");
		}
		if (stateChange.isR2Changed()) {
			System.out.println("R2 changed");
		}
		if (stateChange.isSelectChanged()) {
			System.out.println("Select changed");
		}
		if (stateChange.isStartChanged()) {
			System.out.println("Start changed");
		}
		if (stateChange.isHomeChanged()) {
			System.out.println("Home changed");
		}
		if (stateChange.isLeftJoystickPressChanged()) {
			System.out.println("Left joystick changed");
		}
		if (stateChange.isRightJoystickPressChanged()) {
			System.out.println("Right joystick changed");
		}
		if (stateChange.isDpadChanged()) {
			System.out.printf("D-Pad: up=%b, down=%b, left=%b, right=%b\n",
					stateChange.isDpadUp(), stateChange.isDpadDown(),
					stateChange.isDpadLeft(), stateChange.isDpadRight());
		}
		/* // orientation changes happened frequently
		if (stateChange.isJoysticksChanged()) {
			System.out.printf(
					"LeftJoystick x=%d,y=%d; RightJoystick x=%d,y=%d\n",
					stateChange.getLeftJoystickX(),
					stateChange.getLeftJoystickY(),
					stateChange.getRightJoystickX(),
					stateChange.getRightJoystickY());
		}
		if (stateChange.isOrientationChanged()) {
			System.out.printf("Orientation: x=%d, y=%d, z=%d\n",
					stateChange.getOrientationX(),
					stateChange.getOrientationY(),
					stateChange.getOrientationZ());
		}
		*/
	}

	public static void main(String[] args) {
		ControlPad controlPad = new ControlPad();
		ExampleApp app = new ExampleApp();
		controlPad.addObserver(app);
		controlPad.start();
	}

}
