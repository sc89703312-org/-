package client.vo;

import client.po.ReceiptState;

public abstract class ReceiptVOBase {

	ReceiptState state = ReceiptState.SUBMITTED;
	
	
	public ReceiptState getState(){
		return state ;
	}
	
	
}
