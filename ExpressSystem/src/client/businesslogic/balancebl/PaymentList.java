package client.businesslogic.balancebl;

import java.util.ArrayList;

import client.businesslogic.paymentbl.Paymentbl;
import client.vo.paymentvo.Paymentvo;

public class PaymentList {

	private ArrayList<Paymentvo> tempPayments ;
	Paymentbl paymentbl;
	
	public PaymentList(Paymentbl paymentBl) {
		// TODO Auto-generated constructor stub
	this.paymentbl = paymentBl;
	getAll();
	}
	
	
	
	
	private void getAll() {
		// TODO Auto-generated method stub
		tempPayments = paymentbl.viewAll();
	}




	public ArrayList<Paymentvo> getList(){
		return tempPayments;
	}



	
}
