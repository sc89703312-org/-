package client.vo.logisticsvo;

import java.util.ArrayList;

import client.po.ReceiptState;
import client.vo.ReceiptVOBase;
import client.vo.ordervo.OrderVO;

public class TransferReceiptVO extends ReceiptVOBase{

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
	private ArrayList<OrderVO> orderlist;
	
	public TransferReceiptVO(String date,ReceiptState state,String hallID,String transportID,String to, String carID,
			String supervisor,String guard){
		
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
	
	public List<OrderVO> getOrderlist(){
		return orderlist;
	}
	
	public void addOrderItem(OrderVO vo){
		orderlist.add(vo);
	}
}
