package edu.nju.express.vo;

import java.util.ArrayList;

import edu.nju.express.common.*;



public class ArrivalReceiptVO extends ReceiptVOBase{
	
	private String from;
	private String location;
	private ArrayList<OrderVO> list;
	
	public ArrivalReceiptVO(String id, String date, String from, String location, ArrayList<OrderVO> voList){
		this.id=id;
		this.date=date;
		this.from=from;
		this.location = location;
		this.list = voList;
	}	
	
	public String getLocation(){
		return location;
	}
	
	public String getFrom(){
		return from;
	}
	
	public ArrayList<OrderVO> getOrderList(){
		return this.list;
	}

}
