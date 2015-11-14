package client.po.HallPo;

import java.util.List;

import client.po.ReceiptPOBase;
import client.po.ReceiptState;
import client.po.orderpo.OrderPO;

public class DeliverReceiptPO extends ReceiptPOBase{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private String deliver;
	private List<OrderPO> list;
	
	public DeliverReceiptPO(String id,String date, String deliver, ReceiptState state){
		this.id=id;
		this.date=date;
		this.deliver=deliver;
		this.state=state;
	}
	
	public String getDeliver(){
		return deliver;
	}
	
	public void addOrderItem(OrderPO po){
		list.add(po);
	}
	
	
}
