package edu.nju.express.presentation.myUI;

import javax.swing.JTextField;

public class MyTextFieldV2 extends JTextField {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public MyTextFieldV2(int x, int y, int width, int height){
		this.setBounds(x, y, width, height);
		this.setVisible(true);
		//this.setOpaque(false);	
		//this.setBorder(BorderFactory.createEmptyBorder());
	}
}
