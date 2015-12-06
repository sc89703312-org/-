package edu.nju.express.presentation.clerk_stationui;

import javax.swing.JButton;
import javax.swing.JPanel;

import edu.nju.express.presentation.UIController;

public class StationGuide extends JPanel{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	UIController controller;
	int width = 900;
	int height = 600;
	
	JButton addAir, addRailway, addHighway, addArrival, addToHall;
	
	
	public StationGuide(UIController c){
		this.controller = c;
		initButtons();
		
		
		this.setBounds(0, 0, 100, 600);
		this.setLayout(null);			
		this.setVisible(true);
		this.setOpaque(false);
		
	}
	
	
	

	public void initButtons(){
		
		
		
		addAir = new JButton();
		addAir.setBounds(12,70,80,80);
		addAir.setBorderPainted(false);
		addAir.setOpaque(false);
		addAir.setContentAreaFilled(false);
		addAir.addActionListener(controller);
		addAir.setActionCommand("addAir");
		this.add(addAir);
		
		
		
		addRailway = new JButton();
		addRailway.setBounds(12,167,80,80);
		addRailway.setBorderPainted(false);
		addRailway.setOpaque(false);
		addRailway.setContentAreaFilled(false);
		addRailway.addActionListener(controller);
		addRailway.setActionCommand("addRailway");
		this.add(addRailway);
		
		addHighway = new JButton();
		addHighway.setBounds(12,256,80,80);
		addHighway.setBorderPainted(false);
		addHighway.setOpaque(false);
		addHighway.setContentAreaFilled(false);
		addHighway.addActionListener(controller);
		addHighway.setActionCommand("addHighway");
		this.add(addHighway);
		
		addArrival = new JButton();
		addArrival.setBounds(12,361,80,80);
		addArrival.setBorderPainted(false);
		addArrival.setOpaque(false);
		addArrival.setContentAreaFilled(false);
		addArrival.addActionListener(controller);
		addArrival.setActionCommand("addArrival");
		this.add(addArrival);
		
		addToHall = new JButton();
		addToHall.setBounds(12, 458, 80, 80);
		addToHall.setBorderPainted(false);
		addToHall.setOpaque(false);
		addToHall.setContentAreaFilled(false);
		addToHall.addActionListener(controller);
		addToHall.setActionCommand("addToHall");
		this.add(addToHall);
	}

}
