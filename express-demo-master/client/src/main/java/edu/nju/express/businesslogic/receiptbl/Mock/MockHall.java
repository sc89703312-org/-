package edu.nju.express.businesslogic.receiptbl.Mock;

import java.util.ArrayList;

import edu.nju.express.businesslogic.hallbl.HallReceiptBL;
import edu.nju.express.businesslogic.orderbl.OrderBL;
import edu.nju.express.businesslogic.vehiclebl.Vehiclebl;
import edu.nju.express.common.GoodsState;
import edu.nju.express.common.ReceiptState;
import edu.nju.express.po.DeliverReceiptPO;
import edu.nju.express.vo.ArrivalReceiptVO;
import edu.nju.express.vo.DeliverReceiptVO;
import edu.nju.express.vo.HallTransferReceiptVO;



public class MockHall {

	//public MockHall(OrderBL orderBL, Vehiclebl vehiclebl) {
		//super(null, null);
		// TODO Auto-generated constructor stub
	//}
/*
	ArrayList<DeliverReceiptPO> listPo;
	
	@Override
	public ArrayList<ArrivalReceiptVO> viewAllArrival(){
		ArrayList<ArrivalReceiptVO> list = new ArrayList<ArrivalReceiptVO>();
		list.add(new ArrivalReceiptVO("2015111100001", "2015/11/11",
				"Nanjing", "Nanjing", GoodsState.COMPLETE, ReceiptState.SUBMITTED));
		list.add(new ArrivalReceiptVO("2015111100002", "2015/11/11",
				"Nanjing", "Nanjing", GoodsState.COMPLETE, ReceiptState.SUBMITTED));
		list.add(new ArrivalReceiptVO("2015111100003", "2015/11/11",
				"Shanghai", "Nanjing", GoodsState.COMPLETE, ReceiptState.SUBMITTED));
		return list;
	}
	
	
	@Override
	public ArrayList<DeliverReceiptVO> viewAllDeliver(){
		ArrayList<DeliverReceiptVO> list = new ArrayList<DeliverReceiptVO>();
		list.add(new DeliverReceiptVO("2015110100001", "025/11/03", "D", ReceiptState.SUBMITTED));
		list.add(new DeliverReceiptVO("2015110100004", "025/11/01", "D", ReceiptState.SUBMITTED));
		return list;
	}
	
	@Override
	public ArrayList<HallTransferReceiptVO> viewAllTransfer(){
		
		return new ArrayList<HallTransferReceiptVO>();
	}
	
	public void approve(String id){
		listPo = new ArrayList<DeliverReceiptPO>();
		listPo.add(new DeliverReceiptPO("2015110100001", "025/11/03", "D", ReceiptState.SUBMITTED));
		listPo.add(new DeliverReceiptPO("2015110100004", "025/11/01", "D", ReceiptState.SUBMITTED));
		
		for(int i =0 ;i<listPo.size();i++)
			listPo.get(i).approve();
	}

	
	*/
}

