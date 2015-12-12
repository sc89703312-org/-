package edu.nju.express.po;

import java.io.Serializable;
import java.util.ArrayList;

import edu.nju.express.common.ReceiptState;



public class HallTransferReceiptPO extends ReceiptPOBase implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	/**单据发自哪个营业厅*/
	private String location;
	/**营业厅编号*/
	private String hallID;
	/**汽运编号*/
	private String transportID;
	/**到达地*/
	private String to;
	/**车辆代号*/
	private String carID;
	/**监装员*/
	private String supervisor;
	/**押运员*/
	private String guard;
	/**本次装车所有托运单号*/
	private ArrayList<OrderPO> orderlist;
	
	public HallTransferReceiptPO(String id, String location, String date,String hallID,String transportID,String to, String carID,
			String supervisor,String guard,ArrayList<OrderPO> orderlist){
		
		this.id = "HallTransferReceipt"+id;
		this.location = location;
		this.date=date;
		this.state = ReceiptState.SUBMITTED;
		this.hallID=hallID;
		this.transportID=transportID;
		this.to=to;
		this.carID=carID;
		this.supervisor=supervisor;
		this.guard=guard;
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
	
	public ArrayList<OrderPO> getOrderlist(){
		return orderlist;
	}

}
