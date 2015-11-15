package client.blservice.balanceblservice;

import java.util.ArrayList;

import client.vo.balancevo.Balancevo;
import client.vo.paymentvo.Paymentvo;


public interface Balanceblservice {

	public double[] viewBalance();
	public ArrayList<Paymentvo>viewReport(String start ,String end);
	public ArrayList<Balancevo> viewCost(String start,String end);
	
	
	public void endBalance();
}
