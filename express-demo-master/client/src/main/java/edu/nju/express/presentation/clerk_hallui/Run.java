package edu.nju.express.presentation.clerk_hallui;


import javax.swing.JFrame;
import javax.swing.JPanel;

public class Run {
	
	public static void main(String[] args){
		JFrame frame = new JFrame();
		frame.setSize(900, 600);
		frame.setLocationRelativeTo(null);
		frame.setUndecorated(true);
		
	   
		
		
		
		
		JPanel p = new HallTransferUI(new HallController(frame));
		frame.add(p);
		
		
		frame.setVisible(true);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}
}
