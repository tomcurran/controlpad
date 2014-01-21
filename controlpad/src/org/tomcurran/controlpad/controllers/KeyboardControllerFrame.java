package org.tomcurran.controlpad.controllers;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class KeyboardControllerFrame extends JFrame {

	private static final long serialVersionUID = 4487079229099797951L;

	public KeyboardControllerFrame() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		JPanel container = new JPanel();
		JLabel label = new JLabel("keep focused to use keyboard");
		container.add(label);
		setContentPane(container);
		pack();
	}

}
