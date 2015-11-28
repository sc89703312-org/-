package edu.nju.express.common;

public enum ReceiptState {
	APPROVED("已审批"), SUBMITTED("待审批");

	String name;

	private ReceiptState(String name) {
		this.name = name;
	}

	public String getName() {
		return name;
	}
}
