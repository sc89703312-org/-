package edu.nju.express.po;

import java.io.Serializable;

public class HallPo extends PersistentObj implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	String name;
	String cityID;
	
	
	public HallPo(String id, String name, String cityID) {
		super();
		this.id = id;
		this.name = name;
		this.cityID = cityID;
		this.date ="";
	}
	public String getName() {
		return name;
	}
	public String getCityID() {
		return cityID;
	}

	
	
}


