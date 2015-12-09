package edu.nju.express.po;

import java.io.Serializable;

public class HallPo extends PersistentObj implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	/**营业厅名称，即位置*/
	String name;

	
	
	public HallPo(String id, String name) {
		super();
		this.id = id;
		this.name = name;
		this.date ="";
	}
	public String getName() {
		return name;
	}

	
	
}


