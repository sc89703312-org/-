package edu.nju.express.po;

import java.io.Serializable;
import java.util.ArrayList;

import edu.nju.express.common.Etype;



public class TransferReceiptPO extends ReceiptPOBase implements Serializable{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	
	String to;
	String location;
	String transportID;
	String supervisor;
	double cost;
	Etype etype;

	boolean isHandle;
	
	ArrayList<OrderPO> order_list;
	
	public TransferReceiptPO(String id, String date, String to, String location, String transportID, String supervisor, Etype etype, ArrayList<OrderPO> order_list){
		
		this.id = "TransferReceipt"+id;
		this.date = date;
		this.to = to;
		this.location = location;
		this.transportID = transportID;
		this.supervisor = supervisor;
		this.etype = etype;
		
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
	
	public String getTransportID(){
		return this.transportID;
	}
	
    public String getSupervisor(){
    	return this.supervisor;
    }
    
    public Etype getType(){
    	return this.etype;
    }
    
    public double getCost(){
    	return this.cost;
    }

}
