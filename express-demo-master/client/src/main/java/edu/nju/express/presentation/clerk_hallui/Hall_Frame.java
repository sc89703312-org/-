package edu.nju.express.presentation.clerk_hallui;

import javax.swing.JFrame;
import javax.swing.JPanel;

import edu.nju.express.presentation.myUI.MyFrame;

public class Hall_Frame extends MyFrame{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	public Hall_Frame(){
		this.setSize(900, 600);
        this.setLocationRelativeTo(null);
        this.setUndecorated(true);
   
        JPanel p = new HallTransferUI(new HallController(this));
        this.add(p);
		this.setVisible(true);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}

}
