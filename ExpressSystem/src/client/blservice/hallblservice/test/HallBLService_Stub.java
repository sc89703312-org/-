package client.blservice.hallblservice.test;

import client.ResultMessage;
import client.blservice.hallblservice.HallBLReceiptService;
import client.vo.hallvo.ArrivalReceiptVO;
import client.vo.hallvo.DeliverReceiptVO;
import client.vo.hallvo.TransferReceiptVO;

public class HallBLService_Stub implements HallBLReceiptService{
	ArrivalReceiptVO arrivalDemo;
	TransferReceiptVO transferDemo;
	DeliverReceiptVO deliverDemo;

	@Override
	public ResultMessage createArrivalReceipt(ArrivalReceiptVO vo) {
		// TODO Auto-generated method stub
		arrivalDemo=vo;
		System.out.println("id:"+arrivalDemo.getId()+"\n"
				+"date:"+arrivalDemo.getDate()+"\n"
				+"from:"+arrivalDemo.getFrom()+"\n"
				+"goodsState:"+arrivalDemo.getGoodsState()+"\n"
				+"state:"+arrivalDemo.getState()+"\n");
		return null;
	}

	@Override
	public ResultMessage createTransferReceipt(TransferReceiptVO vo) {
		// TODO Auto-generated method stub
		transferDemo=vo;
		System.out.println(
				//id is transportID
				"date:"+transferDemo.getDate()+"\n"
				+"state:"+transferDemo.getState()+"\n"
				+"HallID:"+transferDemo.getHallID()+"\n"
				+"transportID:"+transferDemo.getTransportID()+"\n"
				+"carID:"+transferDemo.getCarID()+"\n"
				+"to:"+transferDemo.getDestination()+"\n"
				+"supervisor:"+transferDemo.getSupervisor()+"\n"
				+"guard:"+transferDemo.getGuard()+"\n"
				);
		return null;
	}

	@Override
	public ResultMessage createDeliverReceipt(DeliverReceiptVO vo) {
		// TODO Auto-generated method stub
		deliverDemo=vo;
		System.out.println("id:"+deliverDemo.getId()+"\n"
				+"date:"+deliverDemo.getDate()+"\n"
				+"deliver:"+deliverDemo.getDeliver()+"\n"
				+"state:"+deliverDemo.getState()+"\n");
		return null;
	}

}
