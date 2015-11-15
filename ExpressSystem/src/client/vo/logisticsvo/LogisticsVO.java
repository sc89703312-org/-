package client.vo.logisticsvo;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Observable;
import java.util.Observer;

import client.vo.ordervo.ArrivalState;
import client.vo.ordervo.OrderVO;

public class LogisticsVO implements Serializable,Observer{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	private String currentLoca;
	
	private String deliverName = null;
	
	private ArrayList<String> history;
	
	public LogisticsVO(String currentLocation){
		this.currentLoca=currentLocation;
	}
	
	public void addHistory(String loca){
		this.history.add(loca);
	}
	
	public String getCurrentLoca(){
		return this.currentLoca;
	}
	
	public ArrayList<String> getHistory(){
		return this.history;
	}

	@Override
	public void update(Observable o, Object arg) {
		// TODO Auto-generated method stub
		OrderVO orderVO = (OrderVO)o;
		this.currentLoca = orderVO.getCurrentSpot();
		if(!orderVO.getDeliver().isEmpty())
			this.deliverName = orderVO.getDeliver();
		addHistory(currentLoca);

	}
}
