package client.vo.hallvo;

import java.util.ArrayList;

import client.po.ReceiptState;
import client.vo.ReceiptVOBase;
import client.vo.ordervo.OrderVO;

public class DeliverReceiptVO extends ReceiptVOBase{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private String deliver;
	private ArrayList<OrderVO> list;
	
	public DeliverReceiptVO(String id,String date, String deliver, ReceiptState state){
		this.id=id;
		this.date=date;
		this.deliver=deliver;
		this.state=state;
	}
	
	public String getDeliver(){
		return deliver;
	}
	
	public void addOrderItem(OrderVO vo){
		list.add(vo);
	}
}