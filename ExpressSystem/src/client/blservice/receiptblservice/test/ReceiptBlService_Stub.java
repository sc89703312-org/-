package client.blservice.receiptblservice.test;

import java.util.ArrayList;

import client.ResultMessage;
import client.blservice.receiptblservice.ReceiptBlService;
import client.vo.ReceiptVOBase;

public class ReceiptBlService_Stub implements ReceiptBlService{

	@Override
	public ArrayList<ReceiptVOBase> view() {
		System.out.println("Show the list of receipts.");
		return null;
	}

	@Override
	public void approve(ArrayList<ReceiptVOBase> list) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public ResultMessage modify(ReceiptVOBase vo) {
		// TODO Auto-generated method stub
		return null;
	}

}
