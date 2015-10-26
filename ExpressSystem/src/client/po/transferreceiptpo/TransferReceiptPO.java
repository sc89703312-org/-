package client.po.transferreceiptpo;

import java.util.List;

import client.po.ReceiptPOBase;
import client.po.ReceiptState;
import client.vo.ReceiptVOBase;
import client.vo.ordervo.OrderVO;

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
	private List<OrderVO> orderlist;
	
	public TransferReceiptPO(String date,ReceiptState state,String hallID,String transportID,String to, String carID,
			String supervisor,String guard,List<OrderVO> list){
		
		this.date=date;
		this.state=state;
		this.hallID=hallID;
		this.transportID=transportID;
		this.to=to;
		this.carID=carID;
		this.supervisor=supervisor;
		this.guard=guard;
		this.orderlist=list;
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
}
