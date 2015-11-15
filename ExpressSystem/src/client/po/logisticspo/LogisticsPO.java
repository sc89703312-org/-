package client.po.logisticspo;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

public class LogisticsPO implements Serializable{
	

		/**
		 * 
		 */
		private static final long serialVersionUID = 1L;
		
		private String currentLoca;
		
		private String deliverName = null;
		
		private ArrayList<String> history;
		
		public LogisticsPO(String currentLoca){
			this.currentLoca=currentLoca;
			
		}
		
		public void setDeliver(String name){
			this.deliverName = name;
		}
		
		public void addHistory(String loca){
			this.history.add(currentLoca);
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
