package client.presentation.payment;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.*;

import client.ResultMessage;
import client.blservice.paymentblservice.Paymentblservice;
import client.vo.paymentvo.Paymentvo;



public class AddPaymentDialog extends JDialog {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	
	
	private PaymentPanel parent;
	
	Paymentblservice paymentblservice;
	
	public AddPaymentDialog(PaymentPanel parent) {
		// TODO Auto-generated constructor stub
	
        this.parent = parent;
    	
        this.setContentPane(new AddPaymentPanel());
        this.setSize(500, 300);
        this.setLocationRelativeTo(null);
        this.setResizable(false);
	
        this.paymentblservice = parent.getPaymentblservice();
	}
	
	
	PaymentInfoPanel paymentInfoPanel = new PaymentInfoPanel();
	
	
	
	

	
	class AddPaymentPanel extends JPanel{

		/**
		 * 
		 */
		private static final long serialVersionUID = 1L;
		
		
		public AddPaymentPanel() {
			// TODO Auto-generated constructor stub
	
			this.setLayout(new BoxLayout(this, BoxLayout.Y_AXIS));
			
			paymentInfoPanel.setBorder(BorderFactory.createTitledBorder("Info"));
			
			this.add(paymentInfoPanel);
			
			
			JButton addButton = new JButton("Submit");
            this.add(addButton);
            
            addButton.addActionListener(new SubmitPaymentAction());
		
		
		}
		
		
	}
	
	
	
	    final int LEFT_PADDING = 20;
	    final int TOP_PADDING = 35;
	    final int LABEL_COMPONENT_PADDING = 10;
	    final int PADDING_VERTICAL = 35;
	    final int PADDING_HORIZATION = 20;
	    
	    final int LABEL_WIDTH = 80;
	    final int LABEL_HEIGHT = 30;
	    
	    
	    final int TEXTFILED_WIDTH = 100;
	    final int TEXTFILED_HEIGHT = 30;
	
	
	
	    
	    
	
	class SubmitPaymentAction implements ActionListener{

		@Override
		public void actionPerformed(ActionEvent e) {
			// TODO Auto-generated method stub
			
			String date = paymentInfoPanel.dateTextField.getText();
			double pay = Double.parseDouble(paymentInfoPanel.payTextField.getText());
			String courierid = paymentInfoPanel.courieridTextField.getText();
			String orderid = paymentInfoPanel.orderidTextField.getText();
			String bankaccount = paymentInfoPanel.bankTextField.getText();
			
			Paymentvo vo = new Paymentvo(date, pay, courierid, orderid, bankaccount);			
			
			
			
			ResultMessage temp= paymentblservice.createReceipt(vo);
			
			
			if(temp==ResultMessage.VALID){
				parent.refresh(vo);
				AddPaymentDialog.this.dispose();
			}else {
				JOptionPane.showMessageDialog(null,"BankAccount Error");
			}
			
			
			
		
		}
		
	}
	
	
	
	
	
	
	class PaymentInfoPanel extends JPanel{

		/**
		 * 
		 */
		private static final long serialVersionUID = 1L;
		
		
		private JLabel dateLabel = new JLabel("Date:",JLabel.RIGHT);
		private JTextField dateTextField = new JTextField();
		private JLabel payLabel = new JLabel("Pay:",JLabel.RIGHT);
		private JTextField payTextField = new JTextField();
		private JLabel courieridLabel = new JLabel("Courier_ID:",JLabel.RIGHT);
		private JTextField courieridTextField = new JTextField();
		private JLabel orderidLabel = new JLabel("Order_ID:",JLabel.RIGHT);
		private JTextField orderidTextField = new JTextField();
		private JLabel bankLabel = new JLabel("BankAccount:",JLabel.RIGHT);
		private JTextField bankTextField = new JTextField();
		
		
		
		public PaymentInfoPanel() {
			// TODO Auto-generated constructor stub
		
		this.setLayout(null);
		
		 dateLabel.setBounds(LEFT_PADDING, TOP_PADDING, LABEL_WIDTH, LABEL_HEIGHT);
		
		  dateTextField.setBounds(
          		dateLabel.getX() + dateLabel.getWidth() + LABEL_COMPONENT_PADDING, 
          		dateLabel.getY(), 
          		TEXTFILED_WIDTH, 
          		TEXTFILED_HEIGHT
          	);
		
		  payLabel.setBounds(dateTextField.getX() + dateTextField.getWidth() + PADDING_HORIZATION, 
            		dateLabel.getY(), 
            		LABEL_WIDTH, 
            		LABEL_HEIGHT);
		  
		  payTextField.setBounds(payLabel.getX() + payLabel.getWidth() + LABEL_COMPONENT_PADDING, 
            		payLabel.getY(), 
            		TEXTFILED_WIDTH, 
            		TEXTFILED_HEIGHT);
		  
		  
		  courieridLabel.setBounds(
          		dateLabel.getX(), 
          		dateLabel.getY()+dateLabel.getHeight()+PADDING_VERTICAL, 
          		LABEL_WIDTH, 
          		LABEL_HEIGHT
          	);
          courieridTextField.setBounds(
          		dateTextField.getX(), 
          		courieridLabel.getY(), 
          		TEXTFILED_WIDTH, 
          		TEXTFILED_HEIGHT
          	);
		
          orderidLabel.setBounds(
          		payLabel.getX(), 
          		courieridLabel.getY(), 
          		LABEL_WIDTH, 
          		LABEL_HEIGHT
          	);
          orderidTextField.setBounds(
          		payTextField.getX(), 
          		orderidLabel.getY(), 
          		TEXTFILED_WIDTH, 
          		TEXTFILED_HEIGHT
          	);
          
          bankLabel.setBounds(
          		dateLabel.getX(), 
          		courieridLabel.getY()+courieridLabel.getHeight()+PADDING_VERTICAL,
          		LABEL_WIDTH, 
          		LABEL_HEIGHT
          	);
          bankTextField.setBounds(
          		dateTextField.getX(),
          		bankLabel.getY(), 
          		TEXTFILED_WIDTH, 
          		TEXTFILED_HEIGHT
          	);
          
          
          this.add(dateLabel);
          this.add(dateTextField);
          this.add(payLabel);
          this.add(payTextField);
          this.add(courieridLabel);
          this.add(courieridTextField);
          this.add(orderidLabel);
          this.add(orderidTextField);
          this.add(bankLabel);
          this.add(bankTextField);
          
		}
	}
	
	
	
	
	
	
	
}
