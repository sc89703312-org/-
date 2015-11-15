package client.businesslogic.balancebl;

import java.util.ArrayList;

import client.blservice.balanceblservice.Balanceblservice;
import client.businesslogic.paymentbl.Paymentbl;
import client.vo.balancevo.Balancevo;
import client.vo.paymentvo.Paymentvo;


public class Balancebl implements Balanceblservice{

	PaymentList paymentList;
	
	
	public Balancebl(PaymentList paymentList) {
		// TODO Auto-generated constructor stub
	
		
		this.paymentList = paymentList;
		
		
		
	}
	
	
	
	

	@Override
	public ArrayList<Paymentvo> viewReport(String start, String end) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public ArrayList<Balancevo> viewCost(String start, String end) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void endBalance() {
		// TODO Auto-generated method stub
		
	}





	@Override
	public double[] viewBalance() {
		// TODO Auto-generated method stub
		
		double temp [] = new double[3];
		
		temp[0] = Caculate.caculatePay(paymentList.getList());
		
		temp[1] =0;
		
		temp[2] = 0;
		
		return temp;
	}

}
