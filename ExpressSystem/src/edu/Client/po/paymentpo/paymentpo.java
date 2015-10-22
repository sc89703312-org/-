package edu.Client.po.paymentpo;

import java.io.Serializable;


public class paymentpo  implements Serializable{

	String date;
	double payment;
	String courier_id;
	String order_id;
	
	
	
	String payment_id ;
	
	public paymentpo(String d,double p,String c,String o) {
		// TODO Auto-generated constructor stub
	
	date = d ;
	payment = p;
	courier_id = c;
	order_id = o;
	
	//to define the id of payment  which composites of date and the id of order
	payment_id = date+" "+order_id;
	
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
}
