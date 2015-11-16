package edu.nju.express.po;

import java.io.Serializable;
import java.util.ArrayList;

public class LogisticsPO implements Serializable{
	

		/**
		 * 
		 */
		private static final long serialVersionUID = 1L;
		
		private String id;
		
		private String currentLoca;
		
		private String deliverName = "";
		
		private ArrayList<String> history;
		
		public LogisticsPO(String id,String currentLoca){
			this.id=id;
			this.currentLoca=currentLoca;
			history = new ArrayList<String>();
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
		
		public String getid(){
			return this.id;
		}
	

}
