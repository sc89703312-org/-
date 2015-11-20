package edu.nju.express.po;

import java.io.Serializable;

public class TestPO extends PersistentObj implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	
	
	public TestPO(String id,String date) {
		// TODO Auto-generated constructor stub
	
		this.id = id;
		
		this.date = date;
	
	}
}
