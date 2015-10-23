package client.blservice.receiptblservice;

import java.util.ArrayList;

import client.ResultMessage;
import client.vo.ReceiptVOBase;

public interface ReceiptBlService{

	public ArrayList<ReceiptVOBase> view();
	
	public void approve(ArrayList<ReceiptVOBase> list);
	
	public ResultMessage modify(ReceiptVOBase vo);
	
	

}
