package client.vo.logisticsvo;

import java.io.Serializable;
import java.util.List;

public class LogisticsVO implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	String currentLoca;
	
	List<String> history;
	
	public String getCurrentLoca(){
		return this.currentLoca;
	}
	
	public List<String> getHistory(){
		return this.history;
	}
}
