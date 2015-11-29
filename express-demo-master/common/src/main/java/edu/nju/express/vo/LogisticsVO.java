package edu.nju.express.vo;


import java.util.ArrayList;




public class LogisticsVO {


	
	private String id;
	
	private String currentLoca;
	
	private String deliverName = "";
	
	private ArrayList<String> history ;
	
	public LogisticsVO(String id,String currentLocation,
			           String deliverName,ArrayList<String> history){
		
		
		
		this.id=id;
		this.currentLoca=currentLocation;
		this.deliverName = deliverName;
		this.history = history;

	}
	
	
	public String getid(){
		return this.id;
	}
	
	public String getCurrentLoca(){
		return this.currentLoca;
	}
	
	public ArrayList<String> getHistory(){
		return this.history;
	}
	
	public String getDeliver(){
		return this.deliverName;
	}
	
	

	
}
