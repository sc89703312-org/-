package edu.nju.express.po;

import java.io.Serializable;

public class PersistentObj implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	
	public String id;
	public String date;
	
	

	
	
	
	public String getId(){
		return id;
	}
	
	
	public String getDate(){
		return date;
	}
}
