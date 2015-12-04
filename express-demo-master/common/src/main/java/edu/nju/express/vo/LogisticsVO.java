package edu.nju.express.vo;


import java.util.ArrayList;




public class LogisticsVO {


	
	private String id;
	
	private String currentLoca;
	
	private String deliverName = "";
	
	private ArrayList<String> history ;
	
	private double price;
	
	private String from;
	
	private String to;
	
	private String name;
	
	public LogisticsVO(String id,String currentLocation,
			           String deliverName,ArrayList<String> history,
			           double price,String from,String to,
			           String name){
		
		
		
		this.id=id;
		this.currentLoca=currentLocation;
		this.deliverName = deliverName;
		this.history = history;
		this.from = from;
		this.to = to;
		this.name = name;
		this.price = price;

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
	
	public String getFrom(){
		return this.from;
	}

	public String getTo(){
		return this.to;
	}
	
	public String getName(){
		return this.name;
	}
	
	
	public String getPrice(){
		return this.price+"";
	}
}
