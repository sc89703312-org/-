package edu.nju.express.vo;

import java.util.ArrayList;



public class TransferReceiptVO extends ReceiptVOBase{

	String id;
	String date;
	String to;
	String location;
	
	ArrayList<OrderVO> orderList;
	
    public TransferReceiptVO(String id, String date, String to, String location, ArrayList<OrderVO> list){
		
		this.id = id;
		this. date = date;
		this.to = to;
		this.location = location;
		
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
	
}
