package edu.nju.express.vo;

import java.util.ArrayList;



public class ArriveReceiptVO extends ReceiptVOBase{

	String id;
	String date;
	String from;
	String location;
	
	ArrayList<OrderVO> orderList;
	
	public ArriveReceiptVO(String id, String date, String from, String location, ArrayList<OrderVO> list){
		
		this.id = "ArriveReceipt"+id;
		this. date = date;
		this.from = from;
		this.location = location;
		
	}
	
	public String getID(){
		return this.id;
	}
	
	public String getDate(){
		return this.date;
	}
	
	public String getFrom(){
		return this.from;
	}
	
	public String getLocation(){
		return this.location;
	}
	
	public ArrayList<OrderVO> getList(){
    	return this.orderList;
    }
	
}
