package org.tomcurran.controlpad;

import java.io.IOException;
import java.util.Observable;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.concurrent.atomic.AtomicReference;

import javax.swing.JFrame;

import org.tomcurran.controlpad.controllers.Controller;
import org.tomcurran.controlpad.controllers.ControllerStateChange;
import org.tomcurran.controlpad.controllers.GameControllerState;
import org.tomcurran.controlpad.controllers.KeyboardController;
import org.tomcurran.controlpad.controllers.KeyboardControllerFrame;
import org.tomcurran.controlpad.controllers.hid.manager.HIDControllerFinder;

import com.codeminders.hidapi.ClassPathLibraryLoader;

public class ControlPad extends Observable {

	private final AtomicReference<Controller> dev = new AtomicReference<Controller>();
	private final AtomicBoolean running = new AtomicBoolean(false);
	private static boolean isHIDLibLoaded = false;

	static {
		isHIDLibLoaded = ClassPathLibraryLoader.loadNativeHIDLibrary();
	}

	private GameControllerState state;
	private GameControllerState oldState;
	private ControllerStateChange stateChange;

	public ControlPad() {
		initController();
	}

	private void initController() {
		Controller current = dev.get();
		if (current != null) {
			try {
				current.close();
			} catch (IOException ex) {
				// TODO Auto-generated catch block
				ex.printStackTrace();
			}
		}
		try {
			dev.set(findController());
		} catch (IOException ex) {
			// TODO Auto-generated catch block
			ex.printStackTrace();
		}
		if (dev.get() == null) {
			System.err.println("No suitable controller found! Using keyboard");
			JFrame frame = new KeyboardControllerFrame();
			frame.setVisible(true);
			dev.set(new KeyboardController(frame));
		} else {
			System.err.println("Gamepad controller found");
		}
	}

	public void start() {
		Thread thread = new Thread(new Runnable() {
			@Override
			public void run() {
				try {
					updateLoop();
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
		});
		thread.setName("DroneController Update Loop");
		thread.start();
	}

	public void stop() {
		running.set(false);
	}

	private void updateLoop() throws IOException {
		if (running.get()) {
			return;
		}
		running.set(true);
		oldState = null;
		while (running.get()) {
			state = dev.get().read();
			stateChange = new ControllerStateChange(oldState, state);
			if (stateChange.isChanged()) {
				setChanged();
				notifyObservers(stateChange);
			}
			oldState = state;
		}
		running.set(false);
	}

	private static Controller findController() throws IOException {
		if (!isHIDLibLoaded) {
			return null;
		}
		return HIDControllerFinder.findController();
	}

}
