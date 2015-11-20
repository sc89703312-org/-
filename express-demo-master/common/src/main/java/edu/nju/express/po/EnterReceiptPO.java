package edu.nju.express.po;

import java.io.Serializable;
import java.util.ArrayList;

public class EnterReceiptPO extends ReceiptPOBase implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	String id;
	String location;
	String date;
	
	boolean isApprove;
	
	ArrayList<ComGoodsPO> goods_list = new ArrayList<ComGoodsPO>();
	
	public EnterReceiptPO(ArrayList<ComGoodsPO> list, String id, String date, String location){
		this.id = id;
		this.date = date;
		this.location = location;
		
		isApprove = false;
		
		goods_list = list;
	}
	
	public String getID(){
		return id;
	}
	
	public String getLocation(){
		return location;
	}
	
	public String getDate(){
		return date;
	}
	
	public void approve(){
		isApprove = true;
	}
	
	public void changeComLocation(String orderID, String newComLocation){
		
		int length = goods_list.size();
		
		for(int i=0;i<length;i++){
			if(goods_list.get(i).getOrder().getID()==orderID)
				goods_list.get(i).modifyComLocation(newComLocation);
		}
		
	}
	
	
}
