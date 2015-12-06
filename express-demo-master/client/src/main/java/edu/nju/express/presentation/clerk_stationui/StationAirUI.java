package edu.nju.express.presentation.clerk_stationui;

import java.awt.event.MouseEvent;

import javax.swing.ImageIcon;
import javax.swing.JLabel;

import edu.nju.express.presentation.UIController;
import edu.nju.express.presentation.myUI.LabelTextField;

public class StationAirUI extends StationTransportUI{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	public StationAirUI(UIController c){
		super(c);
		bg = new JLabel(new ImageIcon("ui/image/station/air.png"));
		bg.setBounds(0, 0, width, height);
		mainpanel.add(bg);
	}
	
	public void addTransportIdField(){
		transportIdField = new LabelTextField("航班号  ", 10);
		transportIdField.setBounds(120, 130, 300, 45);
		panel.add(transportIdField);
	}

	@Override
	public void mouseClicked(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mousePressed(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mouseReleased(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mouseEntered(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mouseExited(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}

}
