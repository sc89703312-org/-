package client.po.arrivalreceiptpo;

import client.po.GoodsState;
import client.po.ReceiptPOBase;
import client.po.ReceiptState;

public class ArrivalReceiptPO extends ReceiptPOBase{

	/**
	 * 
	 */
	private static final long serialVersionUID = -5743990485972024749L;
//	protected String id;
//	protected String date;
	private String from;
	private GoodsState goodsState;
	
	public ArrivalReceiptPO(String id, String date, String from, GoodsState gstate,ReceiptState state){
		this.id=id;
		this.date=date;
		this.from=from;
		this.goodsState=gstate;
		this.state=state;
	}

	
	
	public String getFrom(){
		return from;
	}
	
	public GoodsState getGoodsState(){
		return goodsState;
	}

}
