package edu.nju.express.presentation.postmanui;

import javax.swing.JPanel;

import edu.nju.express.presentation.myUI.MyFrame;

public class Postman_Frame extends MyFrame{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public Postman_Frame() {
		JPanel p = new CreateOrderPanel(new PostmanController(this));
		this.add(p);
		this.setVisible(true);
	}

}
