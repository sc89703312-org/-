package edu.nju.express.presentation.clerk_stationui;

import java.awt.event.MouseEvent;

import javax.swing.ImageIcon;
import javax.swing.JLabel;

import edu.nju.express.common.Etype;
import edu.nju.express.presentation.UIController;
import edu.nju.express.presentation.myUI.LabelTextField;

public class StationRailwayUI extends StationTransportUI{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	
	
	
	public StationRailwayUI(StationController c){
		super(c);
		bg = new JLabel(new ImageIcon("ui/image/station/railway.png"));
		bg.setBounds(0, 0, width, height);
		mainpanel.add(bg);
		
		etype = Etype.ECONOMICAL;
	}
	
	public void addTransportIdField(){
		transportIdField = new LabelTextField("车次号  ", 10);
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
		if(e.getSource().equals(calFeeBtn)){
			calFeeBtn.setIcon(new ImageIcon("ui/image/hall/calFee1.png"));
		}
	}

	@Override
	public void mouseExited(MouseEvent e) {
		// TODO Auto-generated method stub
		if(e.getSource().equals(calFeeBtn)){
			calFeeBtn.setIcon(new ImageIcon("ui/image/hall/calFee0.png"));
		}
	}
}
