package edu.nju.express.vo;

public class ReceivalVO {
	private String id;
	private String date;
	private String receiverName;
	/**
	 * @param id
	 * @param date
	 * @param receiverName
	 */
	public ReceivalVO(String id, String date, String receiverName) {
		super();
		this.id = id;
		this.date = date;
		this.receiverName = receiverName;
	}
	public String getId() {
		return id;
	}
	public String getDate() {
		return date;
	}
	public String getReceiverName() {
		return receiverName;
	}
	
	@Override
	public String toString() {
		return "ReceivalVO [id=" + id + ", date=" + date + ", receiverName=" + receiverName + "]";
	}
	
	
}
