package edu.nju.express.po;

import java.io.Serializable;




public class Paymentpo extends ReceiptPOBase  implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = -4832837392996360235L;

	double payment;
	String courier_id;
	String order_id;
	String bankaccount;
	String hall_id;
	

	public Paymentpo(String d,double p,String c,String o,String b) {
		// TODO Auto-generated constructor stub
	
	date = d ;
	payment = p;
	courier_id = c;
	order_id = o;
	bankaccount = b;
	//to define the id of payment  which composites of date and the id of order
	id =order_id;
	hall_id = courier_id.substring(0, 6);
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
	
	
	
	public String getHall_Id()
	{
		return hall_id;
	}
}
