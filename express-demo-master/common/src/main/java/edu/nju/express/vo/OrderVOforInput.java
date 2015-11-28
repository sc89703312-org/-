package edu.nju.express.vo;

import edu.nju.express.common.Etype;

public class OrderVOforInput {
	private String senderName;
	private String senderAddress;
	private String senderPost;
	private String senderTel;
	private String senderPhone;
	private String receiverName;
	private String receiverAddress;
	private String receiverPost;
	private String receiverTel;
	private String receiverPhone;
	private int num;
	private double weight;
	private String goodsName;
	private double size;
	private double pkgCost;
	private double totalCost;
	private String id;
	private Etype type;
	private String expectedTime;
	/**
	 * @param senderName
	 * @param senderAddress
	 * @param senderPost
	 * @param senderTel
	 * @param senderPhone
	 * @param receiverName
	 * @param receiverAddress
	 * @param receiverPost
	 * @param receiverTel
	 * @param receiverPhone
	 * @param num
	 * @param weight
	 * @param goodsName
	 * @param size
	 * @param pkgCost
	 * @param totalCost
	 * @param id
	 * @param type
	 * @param expectedTime
	 */
	public OrderVOforInput(String senderName, String senderAddress, String senderPost, String senderTel,
			String senderPhone, String receiverName, String receiverAddress, String receiverPost, String receiverTel,
			String receiverPhone, int num, double weight, String goodsName, double size, double pkgCost,
			double totalCost, String id, Etype type, String expectedTime) {
		super();
		this.senderName = senderName;
		this.senderAddress = senderAddress;
		this.senderPost = senderPost;
		this.senderTel = senderTel;
		this.senderPhone = senderPhone;
		this.receiverName = receiverName;
		this.receiverAddress = receiverAddress;
		this.receiverPost = receiverPost;
		this.receiverTel = receiverTel;
		this.receiverPhone = receiverPhone;
		this.num = num;
		this.weight = weight;
		this.goodsName = goodsName;
		this.size = size;
		this.pkgCost = pkgCost;
		this.totalCost = totalCost;
		this.id = id;
		this.type = type;
		this.expectedTime = expectedTime;
	}
	public String getSenderName() {
		return senderName;
	}
	public String getSenderAddress() {
		return senderAddress;
	}
	public String getSenderPost() {
		return senderPost;
	}
	public String getSenderTel() {
		return senderTel;
	}
	public String getSenderPhone() {
		return senderPhone;
	}
	public String getReceiverName() {
		return receiverName;
	}
	public String getReceiverAddress() {
		return receiverAddress;
	}
	public String getReceiverPost() {
		return receiverPost;
	}
	public String getReceiverTel() {
		return receiverTel;
	}
	public String getReceiverPhone() {
		return receiverPhone;
	}
	public int getNum() {
		return num;
	}
	public double getWeight() {
		return weight;
	}
	public String getGoodsName() {
		return goodsName;
	}
	public double getSize() {
		return size;
	}
	public double getPkgCost() {
		return pkgCost;
	}
	public double getTotalCost() {
		return totalCost;
	}
	public String getId() {
		return id;
	}
	public Etype getType() {
		return type;
	}
	public String getExpectedTime() {
		return expectedTime;
	}
	
	
}
