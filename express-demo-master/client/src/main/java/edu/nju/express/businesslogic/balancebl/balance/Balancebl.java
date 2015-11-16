package edu.nju.express.businesslogic.balancebl.balance;

import java.util.ArrayList;

import edu.nju.express.blservice.Balanceblservice;
import edu.nju.express.businesslogic.balancebl.Caculate;
import edu.nju.express.businesslogic.balancebl.CostList;
import edu.nju.express.businesslogic.balancebl.PaymentList;
import edu.nju.express.vo.Balancevo;
import edu.nju.express.vo.Paymentvo;




public class Balancebl implements Balanceblservice{

	PaymentList paymentList;
	CostList  costList;
	
	
	public Balancebl(PaymentList paymentList,CostList costList) {
		// TODO Auto-generated constructor stub
	
		
		this.paymentList = paymentList;
		
		this.costList = costList;
		
	}
	
	
	
	
	
	
	

	@Override
	public ArrayList<Paymentvo> viewReport(String start, String end) {
		// TODO Auto-generated method stub
		
		
		return paymentList.getListByDate(start, end);
	}

	
	
	@Override
	public ArrayList<Balancevo> viewCost(String start, String end) {
		// TODO Auto-generated method stub
		
		
      return costList.getListByDate(start, end);
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
		
		temp[1] = Caculate.caculateCost(costList.getList());
		
		temp[2] = temp[0] - temp[1];
		
		return temp;
	}

}
