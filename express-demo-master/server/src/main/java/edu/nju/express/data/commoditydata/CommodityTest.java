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
		
//		OrderPO order1 = new OrderPO("SHRF","NJU","NJU","025-83621002","13900001234","SC","NJU",
//				"NJU","025-83621001","13900001231",1,20.5,30.0,"book",10*20,5.0,15.0,"1234567890",Etype.FAST,
//				ArrivalState.NO,"2 days","Nanjing");
//		
//		OrderPO order2 = new OrderPO("SHRF","NJU","NJU","025-83621002","13900001234","SC","NJU",
//				"NJU","025-83621001","13900001231",1,20.5,30.0,"book",10*20,5.0,15.0,"1234567891",Etype.FAST,
//				ArrivalState.NO,"2 days","Nanjing");
//		
//		OrderPO order3 = new OrderPO("SHRF","NJU","NJU","025-83621002","13900001234","SC","NJU",
//				"NJU","025-83621001","13900001231",1,20.5,30.0,"book",10*20,5.0,15.0,"1234567892",Etype.FAST,
//				ArrivalState.NO,"2 days","Nanjing");
//		
//		ArrayList<OrderPO> list = new ArrayList<OrderPO>();
//		list.add(order1);
//		list.add(order2);
//		list.add(order3);
//		
//		ArriveReceiptPO arrivepo = new ArriveReceiptPO("025000000","2015/12/09","ShangHai","NanJing",list);
//		TransferReceiptPO transferpo = new TransferReceiptPO("025100000","2015/12/09","ShangHai","NanJing","23333","小刘",Etype.ECONOMICAL,list);
//		
//        try {
//			StationDataService_Impl station = new StationDataService_Impl();
//			station.addArriveReceipt(arrivepo);
//			station.addTransferReceipt(transferpo);
//			station.approveArriveReceipt("025000000");
//			station.approveTransferReceipt("025100000");
//			station.flush();
//		} catch (RemoteException e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		}
		
		try {
			StationDataService_Impl impl = new StationDataService_Impl();
			ArrayList<ArriveReceiptPO> polist = impl.getApproveArrive("025");
			System.out.println(polist.size());
		} catch (RemoteException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
	
}
