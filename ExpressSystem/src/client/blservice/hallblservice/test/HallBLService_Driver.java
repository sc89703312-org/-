package client.blservice.hallblservice.test;

import java.util.ArrayList;
import java.util.List;

import client.blservice.hallblservice.HallBLService;
import client.po.GoodsState;
import client.po.ReceiptState;
import client.vo.arrivalreceiptvo.ArrivalReceiptVO;
import client.vo.deliverreceiptvo.DeliverReceiptVO;
import client.vo.ordervo.ArrivalState;
import client.vo.ordervo.Etype;
import client.vo.ordervo.OrderVO;
import client.vo.transferreceiptvo.TransferReceiptVO;

public class HallBLService_Driver {

	public void drive(HallBLService hs){
		hs.createArrivalReceipt(new ArrivalReceiptVO("025201510260000001","20151026","Shanghai",
				GoodsState.COMPLETE,ReceiptState.SUBMITTED));
		hs.createDeliverReceipt(new DeliverReceiptVO("0250010000001","20151026","deliver1",ReceiptState.SUBMITTED));
		ArrayList<OrderVO> list = new ArrayList<OrderVO>();
		list.add(new OrderVO("SHRF","NJU","NJU","025-83621002","13900001234","SC","NJU","NJU",
				"025-83621001","13900001231",1,20.5,30.0,"book",10*20,5.0,15.0,"1234567890",
				Etype.FAST,ArrivalState.NO,"2 days","Nanjing"));
		hs.createTransferReceipt(new TransferReceiptVO("20161026",ReceiptState.SUBMITTED,"025001",
				"0250012015102600001","Beijing","025001001","Supervisor1","guard1",list));
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		(new HallBLService_Driver()).drive(new HallBLService_Stub());
	}

}
