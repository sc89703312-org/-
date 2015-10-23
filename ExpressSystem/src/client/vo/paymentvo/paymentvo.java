package client.vo.paymentvo;


public class Paymentvo {

	
	
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
