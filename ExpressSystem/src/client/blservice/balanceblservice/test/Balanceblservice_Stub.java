package client.blservice.balanceblservice.test;

import java.util.ArrayList;

import client.blservice.balanceblservice.Balanceblservice;
import client.po.balancepo.Item;
import client.vo.balancevo.Balancevo;
import client.vo.paymentvo.Paymentvo;

public class Balanceblservice_Stub implements Balanceblservice{

	
	@Override
	public ArrayList<Double> viewBalance() {
		// TODO Auto-generated method stub
		
		
		ArrayList<Double>  temp= new ArrayList<>();
		double pay = 1000000;
		double cost = 500000;
		double benefit = pay - cost ;
		
		temp.add(pay);
		temp.add(cost);
		temp.add(benefit);
		
		
		
		
		return temp;
	}

	@Override
	public ArrayList<Paymentvo> viewReport(String start, String end) {
		// TODO Auto-generated method stub
		
		ArrayList<Paymentvo> temp = new ArrayList<Paymentvo>();
		temp.add(new Paymentvo("2015/10/23", 300, "025000001"
				                            , "0000000001", "sc89703312"));
		
		
		
		
		return temp;
	}

	@Override
	public void endBalance() {
		// TODO Auto-generated method stub
		System.out.println("BalanceControl ends");
	}

	@Override
	public ArrayList<Balancevo> viewCost(String start, String end) {
		ArrayList<Balancevo> temp =  new ArrayList<Balancevo>();
		temp.add(new Balancevo("2014/9/11", 2000,
				                          "XiaoWang", "sc89703312",
				                          Item.BONUS, ""));
		
		// TODO Auto-generated method stub
		return temp;
	}

}
