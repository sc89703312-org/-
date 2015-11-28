package edu.nju.express.vo;

import java.util.ArrayList;

public class EnterReceiptVO extends ReceiptVOBase{

	String location;
	
	ArrayList<ComGoodsVO> list;
	
	public EnterReceiptVO(ArrayList<ComGoodsVO> list, String id, String date, String location){
		
		this.id ="EnterReceipt"+ id;
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
	
	public void setComGoods(Object data[][]){		
		for(int i=0;i<data.length;i++){			
			for(int j=0;j<list.size();j++)
				if(list.get(j).getOrder().getID().equals((String)data[i][0]))
						list.get(j).setLocation(Integer.parseInt((String)data[i][2]), Integer.parseInt((String)data[i][3]), Integer.parseInt((String)data[i][4]));			
	    }		
	}
	
}
