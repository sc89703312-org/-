package client.po.HallPo;

import java.util.List;

import client.po.ReceiptPOBase;
import client.po.ReceiptState;
import client.po.orderpo.OrderPO;
import client.vo.ReceiptVOBase;

public class TransferReceiptPO extends ReceiptPOBase{

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
	private List<OrderPO> orderlist;
	
	public TransferReceiptPO(String date,ReceiptState state,String hallID,String transportID,String to, String carID,
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
	
	public List<OrderPO> getOrderlist(){
		return orderlist;
	}
	
	public void addOrderItem(OrderPO po){
		orderlist.add(po);
	}
}
