package edu.nju.express.vo;

import edu.nju.express.common.ReceiptState;



public abstract class ReceiptVOBase {

	protected ReceiptState state = ReceiptState.SUBMITTED;
	protected String id;
	protected String date;
	
	public ReceiptState getState(){
		return state ;
	}

	public String getId() {
		return id;
	}

	public String getDate() {
		return date;
	}


	
	
}
