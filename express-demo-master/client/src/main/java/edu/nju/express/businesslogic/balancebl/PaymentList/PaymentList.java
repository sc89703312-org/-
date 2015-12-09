package edu.nju.express.businesslogic.balancebl.PaymentList;

import java.util.ArrayList;

import edu.nju.express.businesslogic.balancebl.PaymentList.Info.PaymentInfo;
import edu.nju.express.businesslogic.paymentbl.Paymentbl;
import edu.nju.express.vo.Paymentvo;
/**
 * 
 * @author lenovo
 * @version 2015年12月9日22:30:45
 * 
 * 存放所有营业厅生成的收款单 并提供按日期查看和结算以及按营业厅进行查看和结算
 */

public class PaymentList {

	
	/** 储存VO的列表 */
	private ArrayList<Paymentvo> tempPayments ;
	
	/** 收款单业务逻辑 */
	PaymentInfo paymentbl;
	
	public PaymentList(PaymentInfo paymentBl) {
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
