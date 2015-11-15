package client.businesslogic.balancebl.Mock_Test;

import java.util.ArrayList;

import client.businesslogic.paymentbl.MockBanking;
import client.businesslogic.paymentbl.Paymentbl;
import client.vo.paymentvo.Paymentvo;

public class MockPayment extends Paymentbl{
	
	private ArrayList<Paymentvo> tempList = new ArrayList<Paymentvo>();
	
	
	

	public MockPayment(MockBanking account) {
		super(account);
		// TODO Auto-generated constructor stub
		
		tempList.add(new Paymentvo(
				"2015/11/11", 200,
				"025000001", "1111111111",
				"sc"));
		
		tempList.add(new Paymentvo(
				"2015/11/11", 500,
				"025000001", "1111111112",
				"sc"));
		
		tempList.add(new Paymentvo(
				"2015/11/11", 300,
				"025000001", "1111111113",
				"a"));
		
		
	}
	
	
	
	
	@Override
	public ArrayList<Paymentvo> viewAll(){
		return tempList;
		
	}
	

}
