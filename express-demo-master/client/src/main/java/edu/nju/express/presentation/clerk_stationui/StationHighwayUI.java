package edu.nju.express.presentation.clerk_stationui;

import java.awt.Graphics;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JLabel;

import edu.nju.express.common.Etype;
import edu.nju.express.presentation.myUI.LabelTextField;

public class StationHighwayUI extends StationTransportUI{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	Image bg = new ImageIcon("ui/image/station/highway.png").getImage();
	
	public StationHighwayUI(StationController c){
		super(c);
		
		
		etype = Etype.STANDARD;
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
	
	@Override
	protected void paintComponent(Graphics g) {
		g.drawImage(bg, 0, 0, null);
	}

}
