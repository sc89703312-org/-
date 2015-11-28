package edu.nju.express.common;

public class ConcludeTypeById {

	
	public static int conclude(String ID){
		if (ID.startsWith("Payment")) {
			return 0;
		}else if (ID.startsWith("Cost")) {
			return 1;
		}else if (ID.startsWith("ArriveReceipt")) {
			return 2;
		}else if (ID.startsWith("TransferReceipt")) {
			return 3;
		}else if (ID.startsWith("EnterReceipt")) {
			return 4;
		}else if (ID.startsWith("ExitReceipt")) {
			return 5;
		}else if (ID.startsWith("ArrivalReceipt")) {
			return 6;
		}else if (ID.startsWith("DeliverReceipt")) {
			return 7;
		}else {
			return 8;
		}
	}
}
