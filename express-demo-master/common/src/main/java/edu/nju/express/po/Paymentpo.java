package edu.nju.express.po;

import java.io.Serializable;




public class Paymentpo extends ReceiptPOBase  implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = -4832837392996360235L;

	/** 收款金额 */
	double payment;
	/** 快递员编号*/
	String courier_id;
	/** 订单号 */
	String order_id;
	/** 银行账户 */
	String bankaccount;
	/**所属营业厅编号*/
	String hall_id;
	

	public Paymentpo(String d,double p,String c,String o,String b) {
		// TODO Auto-generated constructor stub
	
	date = d ;
	payment = p;
	courier_id = c;
	order_id = o;
	bankaccount = b;
	//to define the id of payment  which composites of date and the id of order
	id ="Payment"+order_id;
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
