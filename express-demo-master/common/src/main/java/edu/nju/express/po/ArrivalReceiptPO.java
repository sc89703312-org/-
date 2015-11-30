package edu.nju.express.po;

import java.util.ArrayList;

import edu.nju.express.common.GoodsState;
import edu.nju.express.common.ReceiptState;



public class ArrivalReceiptPO extends ReceiptPOBase{

	/**
	 * 
	 */
	private static final long serialVersionUID = -5743990485972024749L;

	private String from;
	private String location;
	private ArrayList<OrderPO> orderList;
	
	public ArrivalReceiptPO(String id, String date, String from, String location, ArrayList<OrderPO> poList){
		this.id="ArrivalReceipt"+id;
		this.date=date;
		this.from=from;
		this.location = location;
		this.state=ReceiptState.SUBMITTED;
		this.orderList = poList;
	}

	public String getLocation(){
		return location;
	}
	
	public String getFrom(){
		return from;
	}
	
	public ArrayList<OrderPO> getOrderList(){
		return orderList;
	}

}
