package edu.nju.express.vo;

import java.util.ArrayList;

/**
 * 中转中心到达单
 *
 */

public class ArriveReceiptVO extends ReceiptVOBase{

	String from;
	String location;
	
	ArrayList<OrderVO> orderList;
	
	public ArriveReceiptVO(String id, String date, String from, String location, ArrayList<OrderVO> list){
		
		this.id =id;
		this. date = date;
		this.from = from;
		this.location = location;
		
		this.orderList = list;
		
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
