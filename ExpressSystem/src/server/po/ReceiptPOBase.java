package server.po;

import client.ResultMessage;

public abstract class ReceiptPOBase {
	
	protected String id;
	protected String date;
	private ReceiptState state;

	public abstract ResultMessage show();
	public void approve(){
		this.state = ReceiptState.APPROVED;
	}
	
	public String getId() {
		return id;
	}
	public String getDate() {
		return date;
	}
	public ReceiptState getState() {
		return state;
	}

}
