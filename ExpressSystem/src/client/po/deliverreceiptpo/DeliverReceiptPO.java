package client.po.deliverreceiptpo;

import client.po.ReceiptPOBase;
import client.po.ReceiptState;

public class DeliverReceiptPO extends ReceiptPOBase{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private String deliver;
	
	public DeliverReceiptPO(String id,String date, String deliver, ReceiptState state){
		this.id=id;
		this.date=date;
		this.deliver=deliver;
		this.state=state;
	}
	
	public String getDeliver(){
		return deliver;
	}
	
	
}
