package client.vo.hallvo;

/*
 * 营业厅信息vo
 */
public class HallVO {
	String id;
	String name;
	String cityID;
	/**
	 * @param id
	 * @param name
	 * @param cityID
	 */
	public HallVO(String id, String name, String cityID) {
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
