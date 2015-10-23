package client.blservice.receiptblservice.test;

import client.blservice.receiptblservice.ReceiptBlService;

public class ReceiptBlSercive_Driver {

	public void drive(ReceiptBlService rs){
		rs.view();
	}
	
	public static void main(String[] args) {
		(new ReceiptBlSercive_Driver()).drive(new ReceiptBlService_Stub());
	}
}
