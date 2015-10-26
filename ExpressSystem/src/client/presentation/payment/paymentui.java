package client.presentation.payment;

import javax.swing.JFrame;
import javax.swing.WindowConstants;


public class paymentui extends JFrame {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	
	public paymentui() {
		// TODO Auto-generated constructor stub
	
		    this.setSize(800, 300);
	        this.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
	        this.setLocationRelativeTo(null);
	        this.setTitle("Express Management System - Prototype");


	        this.add(new PaymentPanel());

	        this.setVisible(true);
	
	}
	
	
}
