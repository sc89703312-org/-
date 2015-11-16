package edu.nju.express.businesslogic.paymentbl;

import java.util.ArrayList;

import edu.nju.express.blservice.Paymentblservice;
import edu.nju.express.common.ResultMessage;
import edu.nju.express.vo.Paymentvo;



public class PaymentController implements Paymentblservice {

	
	Paymentblservice paymentblservice;
	
	public PaymentController(Paymentblservice paymentblservice) {
		// TODO Auto-generated constructor stub
	
		this.paymentblservice = paymentblservice ;
	
	}
	
	
	@Override
	public ResultMessage createReceipt(Paymentvo vo) {
		// TODO Auto-generated method stub
		
		return paymentblservice.createReceipt(vo);
	}

	@Override
	public Paymentvo getPayment(String id) {
		// TODO Auto-generated method stub
		return paymentblservice.getPayment(id);
	}

	@Override
	public ArrayList<Paymentvo> viewAll() {
		// TODO Auto-generated method stub
		return paymentblservice.viewAll();
	}

	@Override
	public void endPayment() {
		// TODO Auto-generated method stub
		paymentblservice.endPayment();
	}

}
