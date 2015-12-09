package edu.nju.express.presentation.clerk_hallui;

import java.awt.event.ActionEvent;

import javax.swing.JPanel;

import edu.nju.express.blservice.CarControlService;
import edu.nju.express.blservice.HallReceiptBlService;
import edu.nju.express.blservice.OrderBLService;
import edu.nju.express.blservice.Paymentblservice;
import edu.nju.express.blservice.Vehicleblservice;
import edu.nju.express.businesslogic.DataFactory;
import edu.nju.express.presentation.UIController;
import edu.nju.express.presentation.myUI.MyFrame;

public class HallController implements UIController {
	JPanel currentPanel;
	MyFrame frame;
	
	Vehicleblservice vehicle;
	CarControlService car;
	HallReceiptBlService receipt;
	Paymentblservice payment;
	OrderBLService order;
	
	public HallController(MyFrame f){
		this.frame = f;
		currentPanel = (JPanel) f.getContentPane();
		
		this.vehicle = DataFactory.createDriverInstance();
		this.car = DataFactory.createCarBLInstance();
		this.receipt = DataFactory.createHallReceiptBLInstance();
		this.payment = DataFactory.createPaymentBLInstance();
		this.order = DataFactory.createOrderBLInstance();
		
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
			this.currentPanel = new HallPaymentUI(this);
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
