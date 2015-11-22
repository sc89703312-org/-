package edu.nju.express.po;

import java.io.Serializable;
import java.util.ArrayList;



public class ArriveReceiptPO extends ReceiptPOBase implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	

	String from;
	String location;
	
	boolean isApprove;
	
	ArrayList<OrderPO> order_list;
	
	public ArriveReceiptPO(String id, String date, String from, String location, ArrayList<OrderPO> order_list){
		this.id = id;
		this.date = date;
		this.from = from;
		this.location = location;
		
		this.isApprove = false;
		
		this.order_list = order_list;
	}
	
	public String getID(){
		return id;
	}
	
	public String getDate(){
		return date;
	}
	
	public String getFrom(){
		return from;
	}
	
	public String getLocation(){
		return location;
	}
	
	public void approve(){
		this.isApprove = true;
	}
	
	public ArrayList<OrderPO> getOrderList(){
		return order_list;
	}
	
}
