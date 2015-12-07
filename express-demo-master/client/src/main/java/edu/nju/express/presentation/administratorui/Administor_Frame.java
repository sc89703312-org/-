package edu.nju.express.presentation.administratorui;

import javax.swing.JPanel;

import edu.nju.express.presentation.myUI.MyFrame;

public class Administor_Frame extends MyFrame {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public Administor_Frame() {
		JPanel p = new CheckTaskUI(new AdministratorController(this));
		this.add(p);
		this.setVisible(true);
	}

}
