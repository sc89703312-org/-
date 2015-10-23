package client.po.paymentpo;

import java.io.Serializable;


public class Paymentpo  implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = -4832837392996360235L;
	String date;
	double payment;
	String courier_id;
	String order_id;
	String bankaccount;
	
	
	String payment_id ;
	
	public Paymentpo(String d,double p,String c,String o,String b) {
		// TODO Auto-generated constructor stub
	
	date = d ;
	payment = p;
	courier_id = c;
	order_id = o;
	bankaccount = b;
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
	
	public String getBankaccount()
	{
		return bankaccount;
	}
}
