package edu.nju.express.presentation.myUI;

import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JButton;

public class RefreshButton extends JButton{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private final Icon icon2 = new ImageIcon("ui/button/refresh2.png");
	private final Icon icon1 = new ImageIcon("ui/button/refresh1.png");
	
	public RefreshButton() {

		this.setContentAreaFilled(false);
		this.setBounds(764, 80, 70, 30);
		this.setRolloverIcon(icon2);
		this.setIcon(icon1);
		this.setBorderPainted(false);
	}

}
