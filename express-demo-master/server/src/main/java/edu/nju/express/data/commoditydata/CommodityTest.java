package edu.nju.express.data.commoditydata;

import java.rmi.RemoteException;
import java.util.ArrayList;

import edu.nju.express.common.ArrivalState;
import edu.nju.express.common.Etype;
import edu.nju.express.dataimpl.StationDataService_Impl;
import edu.nju.express.po.ArriveReceiptPO;
import edu.nju.express.po.OrderPO;
import edu.nju.express.po.TransferReceiptPO;

public class CommodityTest {

	public static void main(String[] args){
		
		OrderPO order1 = new OrderPO("SHRF","NJU","NJU","025-83621002","13900001234","SC","NJU",
				"NJU","025-83621001","13900001231",1,20.5,30.0,"book",10*20,5.0,15.0,"1234567890",Etype.FAST,
				ArrivalState.NO,"2 days","Nanjing");
		
		OrderPO order2 = new OrderPO("SHRF","NJU","NJU","025-83621002","13900001234","SC","NJU",
				"NJU","025-83621001","13900001231",1,20.5,30.0,"book",10*20,5.0,15.0,"1234567891",Etype.FAST,
				ArrivalState.NO,"2 days","Nanjing");
		
		OrderPO order3 = new OrderPO("SHRF","NJU","NJU","025-83621002","13900001234","SC","NJU",
				"NJU","025-83621001","13900001231",1,20.5,30.0,"book",10*20,5.0,15.0,"1234567892",Etype.FAST,
				ArrivalState.NO,"2 days","Nanjing");
		
		ArrayList<OrderPO> list = new ArrayList<OrderPO>();
		list.add(order1);
		list.add(order2);
		list.add(order3);
		
		ArriveReceiptPO arrivepo = new ArriveReceiptPO("025000000","2015/12/09","ShangHai","南京",list);
		TransferReceiptPO transferpo = new TransferReceiptPO("025100000","2015/12/09","ShangHai","南京","23333","小刘",Etype.ECONOMICAL,list);
		
        try {
			StationDataService_Impl station = new StationDataService_Impl();
			station.addArriveReceipt(arrivepo);
			station.addTransferReceipt(transferpo);
			station.approveArriveReceipt("025000000");
			station.approveTransferReceipt("025100000");
			station.flush();
		} catch (RemoteException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		OrderPO order4 = new OrderPO("SHRF","NJU","NJU","025-83621002","13900001234","SC","NJU",
				"NJU","025-83621001","13900001231",1,20.5,30.0,"book",10*20,5.0,15.0,"1234567893",Etype.ECONOMICAL,
				ArrivalState.NO,"2 days","Nanjing");
		
		OrderPO order5 = new OrderPO("SHRF","NJU","NJU","025-83621002","13900001234","SC","NJU",
				"NJU","025-83621001","13900001231",1,20.5,30.0,"book",10*20,5.0,15.0,"1234567894",Etype.STANDARD,
				ArrivalState.NO,"2 days","Nanjing");
		
		OrderPO order6 = new OrderPO("SHRF","NJU","NJU","025-83621002","13900001234","SC","NJU",
				"NJU","025-83621001","13900001231",1,20.5,30.0,"book",10*20,5.0,15.0,"1234567895",Etype.ECONOMICAL,
				ArrivalState.NO,"2 days","Nanjing");
		
		ArrayList<OrderPO> list2 = new ArrayList<OrderPO>();
		list2.add(order4);
		list2.add(order5);
		list2.add(order6);
		
		ArriveReceiptPO arrivepo2 = new ArriveReceiptPO("025000001","2015/12/09","ShangHai","南京",list2);
		TransferReceiptPO transferpo2 = new TransferReceiptPO("025100001","2015/12/09","ShangHai","南京","23333","小刘",Etype.ECONOMICAL,list2);
		
        try {
			StationDataService_Impl station = new StationDataService_Impl();
			station.addArriveReceipt(arrivepo2);
			station.addTransferReceipt(transferpo2);
			station.approveArriveReceipt("025000001");
			station.approveTransferReceipt("025100001");
			station.flush();
		} catch (RemoteException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	
		
	}
	
}
