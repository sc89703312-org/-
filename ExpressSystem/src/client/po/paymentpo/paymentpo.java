package client.po.paymentpo;

import java.io.Serializable;

import client.po.ReceiptPOBase;


public class Paymentpo extends ReceiptPOBase  implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = -4832837392996360235L;
	String date;
	double payment;
	String courier_id;
	String order_id;
	String bankaccount;
	String hall_id;
	
	String id ;
	
	public Paymentpo(String d,double p,String c,String o,String b) {
		// TODO Auto-generated constructor stub
	
	date = d ;
	payment = p;
	courier_id = c;
	order_id = o;
	bankaccount = b;
	//to define the id of payment  which composites of date and the id of order
	id = date+" "+order_id;
	hall_id = courier_id.substring(0, 6);
	}
	
	@Override
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
	
	
	@Override
	public String getId(){
		return id;
	}
	
	public String getHall_Id()
	{
		return hall_id;
	}
}
