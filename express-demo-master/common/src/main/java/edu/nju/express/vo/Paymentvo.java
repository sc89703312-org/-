package edu.nju.express.vo;




public class Paymentvo extends ReceiptVOBase {

	
	
	String date;
	double payment;
	String courier_id;
	String order_id;
	String bankaccount;
	
	public Paymentvo(String d,double p,String c,String o,String b) {
		// TODO Auto-generated constructor stub
		date = d ;
		payment = p;
		courier_id = c;
		order_id = o;
	    bankaccount = b;
	    id ="Payment"+order_id;;
	}
	public String getDate()
	{
		return date;
	}
	
	public double getPay()
	{
		return payment;
	}
	
	public String getOrder_id()
	{
		return order_id;
	}
	
	public String getCourier_id()
	{
		return courier_id;
	}
	
	public String getBankaccount()
	{
		return bankaccount;
	}
	
	public String toString(){
		return "Date :"+date+"  Payment :"+payment+"  Courier_id:"+courier_id+"  Order_id:"+
	                        order_id+"   BankAccount:"+bankaccount;
	}
}
