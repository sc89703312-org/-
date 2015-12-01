package edu.nju.express.presentation.loginui;

import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ImageIcon;
import javax.swing.JFrame;

import edu.nju.express.presentation.myUI.MyBackground;
import edu.nju.express.presentation.myUI.MyButton;

public class ErrorUI extends JFrame implements ActionListener {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	
	MyBackground background;
	MyButton confirm;

	Image bg =  new ImageIcon("ui/image/login/error.png").getImage();
	public ErrorUI() {
		// TODO Auto-generated constructor stub
	
		this.setSize(900, 600);
		this.setLocationRelativeTo(null);
		this.setUndecorated(true);
		this.setLayout(null);
	
		
		background = new MyBackground("ui/image/login/error.png");
	    this.add(background);
	     this.setVisible(true);
	     this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

	}
	
	
	
	
	
	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		
	}

}
