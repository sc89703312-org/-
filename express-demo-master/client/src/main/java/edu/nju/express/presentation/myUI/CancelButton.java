package edu.nju.express.presentation.myUI;

import java.awt.Dimension;

import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JButton;

public class CancelButton extends JButton{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	private static Icon img1 = new ImageIcon("ui/button/cancel1.png");
	private static Icon img2 = new ImageIcon("ui/button/cancel2.png");

	public CancelButton() {
		super(img1);
		this.setRolloverIcon(img2);
		this.setPreferredSize(new Dimension(80,30));
		this.setOpaque(false);
		this.setBorderPainted(false);
		this.setContentAreaFilled(false);
		this.setBounds(500,537,80,30);
	}
	

}
