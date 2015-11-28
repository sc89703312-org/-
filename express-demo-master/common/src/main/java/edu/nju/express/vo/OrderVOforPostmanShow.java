package edu.nju.express.vo;

import edu.nju.express.common.ReceiptState;

public class OrderVOforPostmanShow {
	private String id;
	private String date;
	private double totalCost;
	private String expectedTime;
	private double pkgCost;
	private ReceiptState state;
	/**
	 * @param id
	 * @param date
	 * @param totalCost
	 * @param expectedTime
	 * @param pkgCost
	 * @param state
	 */
	public OrderVOforPostmanShow(String id, String date, double totalCost, String expectedTime, double pkgCost,
			ReceiptState state) {
		super();
		this.id = id;
		this.date = date;
		this.totalCost = totalCost;
		this.expectedTime = expectedTime;
		this.pkgCost = pkgCost;
		this.state = state;
	}
	public String getId() {
		return id;
	}
	public String getDate() {
		return date;
	}
	public double getTotalCost() {
		return totalCost;
	}
	public String getExpectedTime() {
		return expectedTime;
	}
	public double getPkgCost() {
		return pkgCost;
	}
	public ReceiptState getState() {
		return state;
	}
	
	
}
