package edu.nju.express.businesslogic.hallbl;

import java.util.ArrayList;

import edu.nju.express.blservice.HallReceiptBlService;
import edu.nju.express.businesslogic.orderbl.OrderBL;
import edu.nju.express.businesslogic.vehiclebl.Vehiclebl;
import edu.nju.express.common.ResultMessage;
import edu.nju.express.vo.ArrivalReceiptVO;
import edu.nju.express.vo.DeliverReceiptVO;
import edu.nju.express.vo.OrderVO;
import edu.nju.express.vo.TransferReceiptVO;

public class HallReceiptBL implements HallReceiptBlService{
	
	OrderBL orderBL;
	Vehiclebl vehiclebl;
	
	ArrayList<ArrivalReceiptVO> arrivalList = new ArrayList<ArrivalReceiptVO>();
	ArrayList<TransferReceiptVO> transferList = new ArrayList<TransferReceiptVO>();
	ArrayList<DeliverReceiptVO> deliverList = new ArrayList<DeliverReceiptVO>();
	
	public HallReceiptBL(OrderBL orderBL,Vehiclebl vehiclebl){
		this.orderBL = orderBL;
		this.vehiclebl = vehiclebl;
	}
	
	@Override
	public ResultMessage createArrivalReceipt(ArrivalReceiptVO vo) {
		// TODO Auto-generated method stub
		if(vo.getId().length()==5){
			arrivalList.add(vo);
			for(OrderVO orderi:vo.getOrderlist()){
				orderi.setCurrentSpot(vo.getCurrentSpot());
			}
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
