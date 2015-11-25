package edu.nju.express.presentation.clerk_hallui;

import javax.swing.JFrame;
import javax.swing.JPanel;

public class HallUITester {
	
	public static void main(String[] args){
		JFrame frame = new JFrame();
		frame.setSize(900, 600);
		frame.setLocationRelativeTo(null);
		
		JPanel p = new HallHome(new HallController(frame));
		frame.add(p);
		
		frame.setVisible(true);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}
}
