package client.po.stationpo;

import java.io.Serializable;
import java.util.ArrayList;

import client.po.orderpo.OrderPO;

public class TransferReceiptPO implements Serializable{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	String id;
	String date;
	String to;
	String location;
	
	boolean isApprove;
	
	ArrayList<OrderPO> order_list;
	
	public TransferReceiptPO(String id, String date, String to, String location, ArrayList<OrderPO> order_list){
		this.id = id;
		this.date = date;
		this.to = to;
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
	
	public String getTo(){
		return to;
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
