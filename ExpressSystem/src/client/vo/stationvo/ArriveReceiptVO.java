package client.vo.stationvo;

import java.util.ArrayList;

import client.vo.ordervo.OrderVO;

public class ArriveReceiptVO {

	String id;
	String date;
	String from;
	String location;
	
	ArrayList<OrderVO> orderList;
	
	public ArriveReceiptVO(String id, String date, String from, String location, ArrayList<OrderVO> list){
		
		this.id = id;
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
	
}
