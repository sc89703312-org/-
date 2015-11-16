package edu.nju.express.vo;

/*
 * ��ת������Ϣvo
 */
public class StationVO {
	String id;
	String name;
	/**
	 * @param id
	 * @param name
	 */
	public StationVO(String id, String name) {
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
