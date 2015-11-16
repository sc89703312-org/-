package edu.nju.express.businesslogic.commoditybl.Mock_Test;

import java.util.ArrayList;
import edu.nju.express.businesslogic.stationbl.StationReceiptBl;
import edu.nju.express.common.ArrivalState;
import edu.nju.express.common.Etype;
import edu.nju.express.vo.ArriveReceiptVO;
import edu.nju.express.vo.OrderVO;
import edu.nju.express.vo.TransferReceiptVO;

public class MockStation extends StationReceiptBl{
	
	ArrayList<ArriveReceiptVO> arriveList = new ArrayList<ArriveReceiptVO>();
	ArrayList<TransferReceiptVO> transferList = new ArrayList<TransferReceiptVO>();
	
	public MockStation(){
		super(null);
		
		ArrayList<OrderVO> orderList = new ArrayList<OrderVO>();
		OrderVO order = new OrderVO("SHRF","NJU","NJU","025-83621002","13900001234","SC","NJU",
				"NJU","025-83621001","13900001231",1,20.5,30.0,"book",10*20,5.0,15.0,"1234567890",Etype.FAST,
				ArrivalState.NO,"2 days","Nanjing");
		orderList.add(order);
		
		ArriveReceiptVO arrivevo = new ArriveReceiptVO("000000001","2015/11/16","Shanghai","Nanjing",orderList);
		TransferReceiptVO transfervo = new TransferReceiptVO("000000002","2015/11/16","Shanghai","Nanjing",orderList);
		
		arriveList.add(arrivevo);
		transferList.add(transfervo);
		
	}
	
	
	public ArrayList<ArriveReceiptVO> viewApproveArrive(){
		return arriveList;
	}
	
	
	public ArrayList<TransferReceiptVO> viewApproveTransfer(){
		return transferList;
	}

}
