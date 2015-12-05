package edu.nju.express.presentation.clerk_stationui;

import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JPanel;

import edu.nju.express.presentation.UIController;

public class StationAirUI extends JPanel{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	int width = 900, height = 600;
	UIController controller;
	JPanel mainpanel;
	JLabel bg;
	
	
	public StationAirUI(UIController c){
		this.controller = c;
		mainpanel = new JPanel();
		mainpanel.setLayout(null);
		mainpanel.setBounds(0, 0, width, height);
		mainpanel.setOpaque(false);
		mainpanel.setVisible(true);
		
		
		
		bg = new JLabel(new ImageIcon("ui/image/station/air.png"));
		bg.setBounds(0, 0, width, height);
		mainpanel.add(bg);
	}
	
	public void init(){
		
	}

}
