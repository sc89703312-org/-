package edu.nju.express.po;

import java.io.Serializable;
import java.util.ArrayList;



public class TransferReceiptPO extends ReceiptPOBase implements Serializable{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	
	String to;
	String location;

	boolean isHandle;
	
	ArrayList<OrderPO> order_list;
	
	public TransferReceiptPO(String id, String date, String to, String location, ArrayList<OrderPO> order_list){
		this.id = "TransferReceipt"+id;
		this.date = date;
		this.to = to;
		this.location = location;
		
		this.isHandle = false;
		
		this.order_list = order_list;
	}
	
	public String getID(){
		return id;
	}
	
	public String getDate(){
		return date;
	}
	
	public String getTo(){
		return to;
	}
	
	public String getLocation(){
		return location;
	}
	
	public boolean isHandle(){
		return this.isHandle;
	}
	
	public void handle(){
		this.isHandle = true;
	}
	
	public ArrayList<OrderPO> getOrderList(){
		return order_list;
	}

}
