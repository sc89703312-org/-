package client.businesslogic.receiptbl;

import java.util.ArrayList;

import client.businesslogic.hallbl.HallBLReceipt;
import client.po.GoodsState;
import client.po.ReceiptState;
import client.po.HallPo.DeliverReceiptPO;
import client.vo.hallvo.ArrivalReceiptVO;
import client.vo.hallvo.DeliverReceiptVO;
import client.vo.hallvo.TransferReceiptVO;

public class MockHall extends HallBLReceipt{

	ArrayList<DeliverReceiptPO> listPo;
	
	@Override
	public ArrayList<ArrivalReceiptVO> viewAllArrival(){
		ArrayList<ArrivalReceiptVO> list = new ArrayList<ArrivalReceiptVO>();
		list.add(new ArrivalReceiptVO("2015111100001", "2015/11/11",
				"Nanjing", GoodsState.COMPLETE, ReceiptState.SUBMITTED));
		list.add(new ArrivalReceiptVO("2015111100002", "2015/11/11",
				"Nanjing", GoodsState.COMPLETE, ReceiptState.SUBMITTED));
		list.add(new ArrivalReceiptVO("2015111100003", "2015/11/11",
				"Shanghai", GoodsState.COMPLETE, ReceiptState.SUBMITTED));
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
	public ArrayList<TransferReceiptVO> viewAllTransfer(){
		
		return new ArrayList<TransferReceiptVO>();
	}
	
	public void approve(String id){
		listPo = new ArrayList<DeliverReceiptPO>();
		listPo.add(new DeliverReceiptPO("2015110100001", "025/11/03", "D", ReceiptState.SUBMITTED));
		listPo.add(new DeliverReceiptPO("2015110100004", "025/11/01", "D", ReceiptState.SUBMITTED));
		
		for(int i =0 ;i<listPo.size();i++)
			listPo.get(i).approve();
	}

}
