package edu.nju.express.presentation.clerk_hallui;

import javax.swing.JPanel;
import javax.swing.JButton;

import edu.nju.express.presentation.UIController;



public class HallGuide extends JPanel{
	private static final long serialVersionUID = 1L;
	
	UIController controller;
	JPanel guidePanel;
	JPanel mainPanel;

	int width = 900;
	int height = 600;
	
	JButton addTransfer;
	JButton addArrival;
	JButton addDeliver;
	JButton addPayment;
	JButton driver;
	JButton car;
	
	public HallGuide(UIController controller) {
		this.controller = controller;
		initButtons();
		
		
		
		
		this.setBounds(0, 0, 100, 600);
		this.setLayout(null);			
		this.setVisible(true);
		this.setOpaque(false);
		
	}

	public void initButtons(){
		
		
		
		addTransfer = new JButton();
		addTransfer.setBounds(10,60,80,80);
		addTransfer.setBorderPainted(false);
		addTransfer.setOpaque(false);
		addTransfer.setContentAreaFilled(false);
		addTransfer.addActionListener(controller);
		addTransfer.setActionCommand("addTransfer");
		this.add(addTransfer);
		
		addArrival = new JButton();
		addArrival.setBounds(10,140,80,80);
		addArrival.setBorderPainted(false);
		addArrival.setOpaque(false);
		addArrival.setContentAreaFilled(false);
		addArrival.addActionListener(controller);
		addArrival.setActionCommand("addArrival");
		this.add(addArrival);
		
		addDeliver = new JButton();
		addDeliver.setBounds(10,220,80,80);
		addDeliver.setBorderPainted(false);
		addDeliver.setOpaque(false);
		addDeliver.setContentAreaFilled(false);
		addDeliver.addActionListener(controller);
		addDeliver.setActionCommand("addDeliver");
		this.add(addDeliver);
		
		addPayment = new JButton();
		addPayment.setBounds(10,300,80,80);
		addPayment.setBorderPainted(false);
		addPayment.setOpaque(false);
		addPayment.setContentAreaFilled(false);
		addPayment.addActionListener(controller);
		addPayment.setActionCommand("addPayment");
		this.add(addPayment);
		
		driver = new JButton();
		driver.setBounds(10,380,80,80);
		driver.setBorderPainted(false);
		driver.setOpaque(false);
		driver.setContentAreaFilled(false);
		driver.addActionListener(controller);
		driver.setActionCommand("manageDriver");
		this.add(driver);
		
		car = new JButton();
		car.setBounds(10,460,80,80);
		car.setBorderPainted(false);
		car.setOpaque(false);
		car.setContentAreaFilled(false);
		car.addActionListener(controller);
		car.setActionCommand("manageCar");
		this.add(car);
	
		
	}
	
	
	
}
