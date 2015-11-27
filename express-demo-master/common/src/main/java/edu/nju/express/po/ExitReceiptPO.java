package edu.nju.express.po;

import java.io.Serializable;
import java.util.ArrayList;

public class ExitReceiptPO extends ReceiptPOBase implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	String location;
	
	ArrayList<ComGoodsPO> goods_list = new ArrayList<ComGoodsPO>();
	
	public ExitReceiptPO(ArrayList<ComGoodsPO> list, String id, String date, String location){
		this.id = id;
		this.date = date;
		this.location = location;
		
		goods_list = list;
	}
	
	public String getID(){
		return id;
	}
	
	public String getLocation(){
		return location;
	}
		
	public ArrayList<ComGoodsPO> getGoods(){
		return this.goods_list;
	}
	
}
