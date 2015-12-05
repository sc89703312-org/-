package edu.nju.express.presentation.clerk_stationui;

import java.awt.Color;

import javax.swing.JFrame;

import edu.nju.express.presentation.myUI.MyFrame;

public class Run {
	

	public static void main(String[] args){
		int width = 900, height = 600;

		MyFrame frame = new MyFrame();
		frame.setVisible(true);
		frame.setSize(width, height);
		frame.setBackground(new Color(0,0,0,0));					//设置透明
		frame.setLocationRelativeTo(null);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		frame.add(new StationAirUI(new StationController(frame)));
		
	}
}
