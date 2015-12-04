package edu.nju.express.presentation.clerk_hallui;


import java.awt.Color;

import javax.swing.JFrame;
import javax.swing.JPanel;

import edu.nju.express.presentation.myUI.MyFrame;

public class Run {
	
	public static void main(String[] args){
		MyFrame frame = new MyFrame();
		frame.setSize(900, 600);
		frame.setBackground(new Color(0,0,0,0));
	   
		
		JPanel p = new HallTransferUI(new HallController(frame));
		frame.add(p);
		
		
		frame.setVisible(true);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}
}
