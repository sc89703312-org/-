package edu.nju.express.businesslogic.balancebl.PaymentList;

import java.util.ArrayList;

import edu.nju.express.businesslogic.paymentbl.Paymentbl;
import edu.nju.express.vo.Paymentvo;


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
	
	
	
	
	public ArrayList<Paymentvo> getListByDate(String start,String end){
		
		
		
        ArrayList<Paymentvo> tempList = new ArrayList<Paymentvo>();
		
		
		
		System.out.println("The length of paymentlist is: "+tempPayments.size());
		
		
		for(int i=0;i<tempPayments.size();i++){
			
			String date =tempPayments.get(i).getDate();
			
			
			if(date.compareTo(end)<=0&&date.compareTo(start)>=0){
				
				System.out.println("The date of: "+date +" is valid");
				
				tempList.add(tempPayments.get(i));
			}
		}
		
		
		
		
		return tempList;
	}

	
	
	
	
	
	public ArrayList<Paymentvo> getListByStation(String number){
		
		ArrayList<Paymentvo> temp = new ArrayList<Paymentvo>();
		
		
		for(int i=0;i<tempPayments.size();i++){
			if(tempPayments.get(i).getCourier_id().substring(0, 6).equals(number)){
				temp.add(tempPayments.get(i));
			}
		}
		
		
		return temp;
		
	}


	
}
