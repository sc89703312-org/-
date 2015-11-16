package edu.nju.express.blservice;

import java.util.ArrayList;

import edu.nju.express.vo.Balancevo;
import edu.nju.express.vo.Paymentvo;




public interface Balanceblservice {

	public double[] viewBalance();
	public ArrayList<Paymentvo>viewReport(String start ,String end);
	public ArrayList<Balancevo> viewCost(String start,String end);
	
	
	public void endBalance();
}
