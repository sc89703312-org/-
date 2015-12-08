package edu.nju.express.presentation.clerk_stationui;

import javax.swing.JFrame;
import javax.swing.JPanel;

import edu.nju.express.presentation.myUI.MyFrame;

public class Station_Frame extends MyFrame{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public Station_Frame(){
		this.setSize(900, 600);
        this.setLocationRelativeTo(null);
        this.setUndecorated(true);
   
        JPanel p = new StationAirUI(new StationController(this));
        this.add(p);
		this.setVisible(true);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}
}
