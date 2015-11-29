package edu.nju.express.vo;

import java.util.ArrayList;

import edu.nju.express.common.Etype;


public class TransferReceiptVO extends ReceiptVOBase{
	
	String to;
	String location;
	String transportID;
	String supervisor;
	double cost;
	Etype etype;
	
	ArrayList<OrderVO> orderList;
    
    public TransferReceiptVO(String id, String date, String to, String location, String transportID, String supervisor, Etype etype, ArrayList<OrderVO> list){
		
		this.id ="TransferReceipt"+ id;
		this.date = date;
		this.to = to;
		this.location = location;
		this.transportID = transportID;
		this.supervisor = supervisor;
		this.etype = etype;
		
		orderList = list;
		
	}
    
    public String getID(){
		return this.id;
	}
	
	public String getDate(){
		return this.date;
	}
	
	public String getTo(){
		return this.to;
	}
	
	public String getLocation(){
		return this.location;
	}

    public ArrayList<OrderVO> getList(){
    	return this.orderList;
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
