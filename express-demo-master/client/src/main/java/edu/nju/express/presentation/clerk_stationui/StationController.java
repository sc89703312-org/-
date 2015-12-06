package edu.nju.express.presentation.clerk_stationui;

import java.awt.event.ActionEvent;

import javax.swing.JFrame;
import javax.swing.JPanel;

import edu.nju.express.presentation.UIController;

public class StationController implements UIController{
	JFrame f;
	JPanel currentPanel;
	
	public StationController(JFrame f){
		this.f = f;
		this.currentPanel = (JPanel) f.getContentPane();
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		if(e.getActionCommand().equals("addAir")){
			f.getContentPane().removeAll();
			f.add(new StationAirUI(this));
			f.validate();
			f.repaint();
		}
		else if(e.getActionCommand().equals("addRailway")){
			f.getContentPane().removeAll();
			f.add(new StationRailwayUI(this));
			f.validate();
			f.repaint();
		}
		else if(e.getActionCommand().equals("addHighway")){
			f.getContentPane().removeAll();
			f.add(new StationHighwayUI(this));
			f.validate();
			f.repaint();
		}
		else if(e.getActionCommand().equals("addArrival")){
			f.getContentPane().removeAll();
			f.add(new StationArrivalUI(this));
			f.validate();
			f.repaint();
		}
		else if(e.getActionCommand().equals("addToHall")){
			f.getContentPane().removeAll();
			f.add(new StationToHallUI(this));
			f.validate();
			f.repaint();
		}
	}
	

}
