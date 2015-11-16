package edu.nju.express.po;

import java.io.Serializable;
import java.util.ArrayList;

public class ExitReceiptPO implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	String id;
	String location;
	String date;
	
	boolean isApprove;
	
	ArrayList<ComGoodsPO> goods_list = new ArrayList<ComGoodsPO>();
	
	public ExitReceiptPO(ArrayList<ComGoodsPO> list, String id, String date, String location){
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
		
	
}
