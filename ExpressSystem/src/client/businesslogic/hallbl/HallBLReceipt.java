package client.businesslogic.hallbl;

import java.util.ArrayList;

import client.ResultMessage;
import client.blservice.hallblservice.HallBLReceiptService;
import client.vo.hallvo.ArrivalReceiptVO;
import client.vo.hallvo.DeliverReceiptVO;
import client.vo.hallvo.TransferReceiptVO;

public class HallBLReceipt implements HallBLReceiptService{
	ArrayList<ArrivalReceiptVO> arrivalList = new ArrayList<ArrivalReceiptVO>();
	ArrayList<TransferReceiptVO> transferList = new ArrayList<TransferReceiptVO>();
	ArrayList<DeliverReceiptVO> deliverList = new ArrayList<DeliverReceiptVO>();
	
	@Override
	public ResultMessage createArrivalReceipt(ArrivalReceiptVO vo) {
		// TODO Auto-generated method stub
		if(vo.getId().length()==10){
			this.arrivalList.add(vo);
			return ResultMessage.VALID;
		}
		else
		return ResultMessage.INVALID;
	}

	@Override
	public ResultMessage createTransferReceipt(TransferReceiptVO vo) {
		// TODO Auto-generated method stub
		if(vo.getId().length()==10){
			this.transferList.add(vo);
			return ResultMessage.VALID;
		}
		else
		return ResultMessage.INVALID;
	}

	@Override
	public ResultMessage createDeliverReceipt(DeliverReceiptVO vo) {
		// TODO Auto-generated method stub
		if(vo.getId().length()==10){
			this.deliverList.add(vo);
			return ResultMessage.VALID;
		}
		else
		return ResultMessage.INVALID;
	}

	public ArrayList<ArrivalReceiptVO> viewAllArrival() {
		// TODO Auto-generated method stub
		return arrivalList;
	}

	public ArrayList<TransferReceiptVO> viewAllTransfer() {
		// TODO Auto-generated method stub
		return transferList;
	}

	public ArrayList<DeliverReceiptVO> viewAllDeliver() {
		// TODO Auto-generated method stub
		return deliverList;
	}



}
