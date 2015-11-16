package edu.nju.express.businesslogic.hallbl;

import java.util.ArrayList;

import edu.nju.express.blservice.HallReceiptBlService;
import edu.nju.express.common.ResultMessage;
import edu.nju.express.vo.ArrivalReceiptVO;
import edu.nju.express.vo.DeliverReceiptVO;
import edu.nju.express.vo.TransferReceiptVO;

public class HallReceiptBL implements HallReceiptBlService{
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
