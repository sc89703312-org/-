package edu.nju.express.presentation.clerk_hallui;

import java.awt.event.ActionEvent;

import javax.swing.JFrame;
import javax.swing.JPanel;

import edu.nju.express.presentation.UIController;

public class HallController implements UIController {
	JPanel currentPanel;
	JFrame frame;
	
	public HallController(JFrame f){
		this.frame = f;
		currentPanel = (JPanel) f.getContentPane();
	}
	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		if(e.getActionCommand().equals("addTransfer")){
			frame.getContentPane().removeAll();
			this.currentPanel = new HallTransferUI(this);
			frame.add(currentPanel);
			frame.validate();
			frame.repaint();
			
		}else if(e.getActionCommand().equals("addArrival")){
			frame.getContentPane().removeAll();
			this.currentPanel = new HallArrivalUI(this);
			frame.add(currentPanel);
			frame.validate();
			frame.repaint();
			
		}else if(e.getActionCommand().equals("addDeliver")){
			frame.getContentPane().removeAll();
			this.currentPanel = new HallDeliverUI(this);
			frame.add(currentPanel);
			frame.validate();
			frame.repaint();
			
		}else if(e.getActionCommand().equals("addPayment")){
			frame.getContentPane().removeAll();
			this.currentPanel = new PaymentUI(this);
			frame.add(currentPanel);
			frame.validate();
			frame.repaint();
			
		}else if(e.getActionCommand().equals("manageDriver")){
			frame.getContentPane().removeAll();
			this.currentPanel = new DriverUI(this);
			frame.add(currentPanel);
			frame.validate();
			frame.repaint();
			
		}else if(e.getActionCommand().equals("manageCar")){
			frame.getContentPane().removeAll();
			this.currentPanel = new CarUI(this);
			frame.add(currentPanel);
			frame.validate();
			frame.repaint();
			
		}
	}

}
