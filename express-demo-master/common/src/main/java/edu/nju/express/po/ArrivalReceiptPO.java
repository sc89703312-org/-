package edu.nju.express.po;

import java.util.ArrayList;

import edu.nju.express.common.GoodsState;
import edu.nju.express.common.ReceiptState;



public class ArrivalReceiptPO extends ReceiptPOBase{

	/**
	 * 
	 */
	private static final long serialVersionUID = -5743990485972024749L;

	/**出发地*/
	private String from;
	/**当前所在营业厅或中转中心*/
	private String location;
	/**本次到达车辆托运单号*/
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
