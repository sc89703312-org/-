package edu.nju.express.presentation.loginui;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

import edu.nju.express.presentation.myUI.MyButton;
import edu.nju.express.presentation.myUI.MyLabel;
import edu.nju.express.presentation.myUI.MyPasswordField;
import edu.nju.express.presentation.myUI.MyTextFieldV2;

public class Run extends JFrame {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	JPanel p;

	

	
	
	public Run() {
		// TODO Auto-generated constructor stub
	
	
		
		this.setSize(900, 600);
		this.setLocationRelativeTo(null);
		this.setUndecorated(true);
   
		p = new LoginUI();
		this.add(p);

		 this.setVisible(true);
	     this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

      
	
	
	

       
	}
	
	
	
	
	
	
	
	
	public static void main(String[] args) {
		new Run();
		
		
	}

}