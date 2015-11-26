package edu.nju.express.vo;

/*
 * Ӫҵ����Ϣvo
 */
public class HallVO {
	String id;
	String name;

	/**
	 * @param id
	 * @param name
	 * @param cityID
	 */
	public HallVO(String id, String name) {
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
