package edu.nju.express.po;

import java.io.Serializable;
import java.util.ArrayList;

import edu.nju.express.common.ReceiptState;



public class HallTransferReceiptPO extends ReceiptPOBase implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private String hallID;
	private String transportID;
	private String to;
	private String carID;
	private String supervisor;
	private String guard;
	private ArrayList<OrderPO> orderlist;
	
	public HallTransferReceiptPO(String date,ReceiptState state,String hallID,String transportID,String to, String carID,
			String supervisor,String guard){
		
		this.id = "HallTransferReceipt"+hallID+transportID;
		this.date=date;
		this.state=state;
		this.hallID=hallID;
		this.transportID=transportID;
		this.to=to;
		this.carID=carID;
		this.supervisor=supervisor;
		this.guard=guard;
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
	
	public ArrayList<OrderPO> getOrderlist(){
		return orderlist;
	}
	
	public void addOrderItem(OrderPO po){
		orderlist.add(po);
	}
}
