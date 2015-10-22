package edu.Client.vo.paymentvo;


public class paymentvo {

	
	
	String date;
	double payment;
	String courier_id;
	String order_id;
	
	
	public paymentvo(String d,double p,String c,String o) {
		// TODO Auto-generated constructor stub
		date = d ;
		payment = p;
		courier_id = c;
		order_id = o;
	
	}
	
}
