package edu.nju.express.po;

import java.io.Serializable;

import edu.nju.express.common.ReceiptState;


public abstract class ReceiptPOBase extends PersistentObj implements Serializable{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	
	
	
	protected ReceiptState state = ReceiptState.SUBMITTED;

	public void approve(){
		this.state = ReceiptState.APPROVED;
	}
	
	
	public ReceiptState getState() {
		return state;
	}
	
	
}

