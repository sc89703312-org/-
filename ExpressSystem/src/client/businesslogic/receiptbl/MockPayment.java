package client.businesslogic.receiptbl;

import java.util.ArrayList;

import client.businesslogic.bankingbl.Bankingbl;
import client.businesslogic.paymentbl.Paymentbl;
import client.vo.paymentvo.Paymentvo;

public class MockPayment extends Paymentbl{


	public MockPayment(Bankingbl account) {
		super(account);
		// TODO Auto-generated constructor stub
	}

	@Override
	public ArrayList<Paymentvo> viewAll() {
		// TODO Auto-generated method stub
		
		ArrayList<Paymentvo> list = new ArrayList<Paymentvo>();
		list.add(new Paymentvo(
				"2015/11/11", 10000, "025000001",
				"1111111111", "sc"));
		list.add(new Paymentvo(
				"2015/11/11", 20000, "025000001",
				"1111111112", "a"));
		
		return list;
	}
	
}
