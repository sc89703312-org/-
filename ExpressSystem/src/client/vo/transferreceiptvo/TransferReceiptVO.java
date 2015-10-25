package client.vo.transferreceiptvo;

import java.util.List;

import client.vo.ReceiptVOBase;

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
	private List<String> orderlist;
	
	public TransferReceiptVO(String hallID,String transportID,String to, String carID,
			String supervisor,String guard,List<String> list){
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
	
	public List<String> getOrderlist(){
		return orderlist;
	}
}
