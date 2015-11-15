package client.vo.logisticsvo;

import java.io.Serializable;
import java.util.ArrayList;

public class LogisticsVO implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	private String currentLoca;
	
	private ArrayList<String> history;
	
	public LogisticsVO(String currentLocation,ArrayList<String> history){
		this.currentLoca=currentLocation;
		this.history=history;
	}
	
	public String getCurrentLoca(){
		return this.currentLoca;
	}
	
	public ArrayList<String> getHistory(){
		return this.history;
	}
}
