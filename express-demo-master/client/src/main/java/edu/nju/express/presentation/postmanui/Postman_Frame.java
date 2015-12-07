package edu.nju.express.presentation.postmanui;

import javax.swing.JPanel;

import edu.nju.express.presentation.myUI.MyFrame;

public class Postman_Frame extends MyFrame{
	
	public Postman_Frame() {
		JPanel p = new PostmanMainUI(new PostmanController(this));
		this.add(p);
		this.setVisible(true);
	}

}
