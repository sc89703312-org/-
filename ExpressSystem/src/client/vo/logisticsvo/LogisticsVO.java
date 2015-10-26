package client.vo.logisticsvo;

import java.io.Serializable;
import java.util.List;

public class LogisticsVO implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	private String currentLoca;
	
	private List<String> history;
	
	public LogisticsVO(String currentLocation,List<String> history){
		this.currentLoca=currentLocation;
		this.history=history;
	}
	
	public String getCurrentLoca(){
		return this.currentLoca;
	}
	
	public List<String> getHistory(){
		return this.history;
	}
}
