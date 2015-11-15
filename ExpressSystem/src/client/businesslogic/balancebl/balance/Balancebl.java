package client.businesslogic.balancebl.balance;

import java.util.ArrayList;

import client.blservice.balanceblservice.Balanceblservice;
import client.businesslogic.balancebl.Caculate;
import client.businesslogic.balancebl.PaymentList;
import client.businesslogic.balancebl.CreateCost.CostList;
import client.businesslogic.paymentbl.Paymentbl;
import client.vo.balancevo.Balancevo;
import client.vo.paymentvo.Paymentvo;


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
		
		
		ArrayList<Paymentvo> tempList = new ArrayList<Paymentvo>();
		
		
		
		System.out.println("The length of paymentlist is: "+paymentList.getList().size());
		
		
		for(int i=0;i<paymentList.getList().size();i++){
			
			String date =paymentList.getList().get(i).getDate();
			
			
			if(date.compareTo(end)<=0&&date.compareTo(start)>=0){
				
				System.out.println("The date of: "+date +" is valid");
				
				tempList.add(paymentList.getList().get(i));
			}
		}
		
		
		
		
		return tempList;
	}

	
	
	
	
	
	
	@Override
	public ArrayList<Balancevo> viewCost(String start, String end) {
		// TODO Auto-generated method stub
		
		
       ArrayList<Balancevo> tempList = new ArrayList<Balancevo>();
		
		
		
		System.out.println("The length of costlist is: "+costList.getList().size());
		
		
		for(int i=0;i<costList.getList().size();i++){
			
			String date =costList.getList().get(i).getDate();
			
			
			if(date.compareTo(end)<=0&&date.compareTo(start)>=0){
				
				System.out.println("The date of: "+date +" is valid");
				
				tempList.add(costList.getList().get(i));
			}
		}
		
		
		
		
		return tempList;
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
