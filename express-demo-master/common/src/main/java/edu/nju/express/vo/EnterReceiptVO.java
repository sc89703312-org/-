package edu.nju.express.vo;

import java.util.ArrayList;

public class EnterReceiptVO {

	String id;
	String location;
	String date;
	
	ArrayList<ComGoodsVO> list;
	
	public EnterReceiptVO(ArrayList<ComGoodsVO> list, String id, String date, String location){
		
		this.id = id;
		this.location = location;
		this.date = date;
		
		this.list = list;
		
	}
	
	public String getID(){
		return this.id;
	}
	
	public String getDate(){
		return this.date;
	}
	
	public String getLocation(){
		return this.location;
	}
	
	public ArrayList<ComGoodsVO> getList(){
		return this.list;
	}
	
}
