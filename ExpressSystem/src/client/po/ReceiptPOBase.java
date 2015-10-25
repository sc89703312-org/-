package client.po;

import java.io.Serializable;
import client.po.ReceiptState;

public abstract class ReceiptPOBase implements Serializable{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	protected String id;
	protected String date;
	protected ReceiptState state = ReceiptState.SUBMITTED;

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

