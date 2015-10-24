package client.po.stationpo;

import java.io.Serializable;

public class StationPO implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	String id;
	String name;
	public StationPO(String id, String name) {
		super();
		this.id = id;
		this.name = name;
	}
	
	public String getId() {
		return id;
	}
	public String getName() {
		return name;
	}
	
}
