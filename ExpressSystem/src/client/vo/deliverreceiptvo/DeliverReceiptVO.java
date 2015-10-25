package client.vo.deliverreceiptvo;

import client.po.ReceiptState;
import client.vo.ReceiptVOBase;

public class DeliverReceiptVO extends ReceiptVOBase{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private String deliver;
	
	public DeliverReceiptVO(String id,String date, String deliver, ReceiptState state){
		this.id=id;
		this.date=date;
		this.deliver=deliver;
		this.state=state;
	}
	
	public String getDeliver(){
		return deliver;
	}
}
