package client.presentation.payment;

import java.awt.BorderLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.List;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;

import client.blservice.paymentblservice.Paymentblservice;
import client.businesslogic.paymentbl.Paymentbl;
import client.businesslogic.paymentbl.Mock_Test.MockBanking;
import client.vo.paymentvo.Paymentvo;

public class PaymentPanel extends JPanel {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	
	Paymentblservice paymentblservice = new Paymentbl(new MockBanking());
	
	 private static final String[] TABLE_HEADER = new String[] {
          "Date","Pay","Courier_ID","Order_ID","Bank Account","State"};
	 
	 private JTable paymentListTable;	
	  private DefaultTableModel defaultTableModel;
	  private JButton addButton;
	  Object[][] payments;
	
	
	public PaymentPanel() {
		// TODO Auto-generated constructor stub
	
	
	
	 payments = getPayments();
	 System.out.println(payments.length);
     defaultTableModel = new DefaultTableModel(payments, TABLE_HEADER);
     paymentListTable = new JTable(defaultTableModel);
     addButton = new JButton("add");

     addButton.addActionListener(new ActionListener() {
         @Override
         public void actionPerformed(ActionEvent e) {
             new AddPaymentDialog(PaymentPanel.this).setVisible(true);
         }
     });
     
     this.setLayout(new BorderLayout());
     this.add(new JScrollPane(paymentListTable), BorderLayout.CENTER);
     this.add(addButton, BorderLayout.SOUTH);
	
	
	
	}
	
	
	
	 private Object[][] getPayments() {
	        ArrayList<Paymentvo> payments = paymentblservice.viewAll();
	        Object[][] payment = new Object[payments.size()][];
	        for (int i = 0; i < payments.size(); i++) {
	            Object[] pay = changeToAnObject(payments.get(i));
	            payment[i] = pay;
	        }
	        return payment;
	    }

	    private Object[] changeToAnObject(Paymentvo vo) {
	        Object[] payment = new Object[TABLE_HEADER.length];
	        payment[0] = vo.getDate();
	        payment[1]=vo.getPay();
	        payment[2]=vo.getCourier_id();
	        payment[3]=vo.getOrder_id();
	        payment[4]=vo.getBankaccount();
	        payment[5]=vo.getState();
	        return payment;
	    }
	    
	    
	    public Paymentblservice getPaymentblservice (){
	    	return paymentblservice;
	    }



		public void refresh(Paymentvo vo) {
			// TODO Auto-generated method stub	
			defaultTableModel.addRow(changeToAnObject(vo));
		}


}
