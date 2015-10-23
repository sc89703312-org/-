package client.po;

import client.ResultMessage;

public abstract class ReceiptPOBase {
	
	protected String id;
	protected String date;
	private ReceiptState state;
	
	public abstract ResultMessage modify();
	public abstract ResultMessage show();
	public void approve(){
		this.state = ReceiptState.APPROVED;
	}
	
	public String getId() {
		System.out.println("test");
		return id;
	}
	public String getDate() {
		return date;
	}
	public ReceiptState getState() {
		return state;
	}

}
