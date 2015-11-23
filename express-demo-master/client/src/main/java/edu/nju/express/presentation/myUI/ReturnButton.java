package edu.nju.express.presentation.myUI;

import javax.swing.JButton;

public class ReturnButton extends JButton{
	private static final long serialVersionUID = 1L;

	public ReturnButton() {
		super("返回上一层");
		this.setSize(100,30);
		this.setOpaque(false);
		this.setLocation(10,10);
	}
}
