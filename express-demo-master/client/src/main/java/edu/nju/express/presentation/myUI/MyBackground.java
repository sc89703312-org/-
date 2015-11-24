package edu.nju.express.presentation.myUI;

import javax.swing.ImageIcon;
import javax.swing.JLabel;

public class MyBackground extends JLabel {
	
	private static final long serialVersionUID = 1L;

	public MyBackground(String str){
		this.setBounds(0, 0, 900, 600);
		this.setIcon(new ImageIcon(str));
		this.setVisible(true);
	}
}
