package edu.nju.express.vo;

import java.util.ArrayList;


public class HallTransferReceiptVO extends ReceiptVOBase{
	
	private String location;
	private String hallID;
	private String transportID;
	private String to;
	private String carID;
	private String supervisor;
	private String guard;
	private ArrayList<OrderVO> orderlist;
	
	public HallTransferReceiptVO(String id, String location, String date,String hallID,String transportID,String to, String carID,
			String supervisor,String guard, ArrayList<OrderVO> orderlist){
		
		this.date=date;
		this.hallID=hallID;
		this.transportID=transportID;
		this.to=to;
		this.carID=carID;
		this.supervisor=supervisor;
		this.guard=guard;
		this.id =id;
		this.orderlist = orderlist;
		
	}
	
	public String getLocation(){
		return location;
	}
	
	public String getHallID(){
		return hallID;
	}
	
	public String getTransportID(){
		return transportID;
	}
	
	public String getDestination(){
		return to;
	}
	
	public String getCarID(){
		return carID;
	}
	
	public String getSupervisor(){
		return supervisor;
	}
	
	public String getGuard(){
		return guard;
	}
	
	public ArrayList<OrderVO> getOrderlist(){
		return orderlist;
	}
	
}
