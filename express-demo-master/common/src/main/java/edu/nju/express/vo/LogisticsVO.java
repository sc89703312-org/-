package edu.nju.express.vo;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Observable;
import java.util.Observer;



public class LogisticsVO implements Serializable,Observer{
	Observable observable;
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	private String id;
	
	private String currentLoca;
	
	private String deliverName = "";
	
	private ArrayList<String> history ;
	
	public LogisticsVO(String id,String currentLocation,Observable ob){
		this.id=id;
		this.currentLoca=currentLocation;
		history = new ArrayList<String>();
		
		this.observable = ob;
		ob.addObserver(this);
	}
	
	public void setCurrentLoca(String loca){
		if(!loca.equals(currentLoca)){
			this.currentLoca=loca;
			addHistory(loca);
		}
	}
	
	public void setDeliver(String name){
		this.deliverName=name;
	}
	
	 

	public void addHistory(String loca){
		
		this.history.add(loca);
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
	
	

	@Override
	public void update(Observable o, Object arg) {
		// TODO Auto-generated method stub
		OrderVO orderVO = (OrderVO)o;
		setCurrentLoca(orderVO.getCurrentSpot());
		setDeliver(orderVO.getDeliver());
		
	}
}
