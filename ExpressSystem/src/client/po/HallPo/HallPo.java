package client.po.HallPo;

import java.io.Serializable;

public class HallPo implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	String id;
	String name;
	String cityID;
	
	
	public HallPo(String id, String name, String cityID) {
		super();
		this.id = id;
		this.name = name;
		this.cityID = cityID;
	}
	public String getId() {
		return id;
	}
	public String getName() {
		return name;
	}
	public String getCityID() {
		return cityID;
	}

	
	
}


