package edu.nju.express.businesslogic.hallbl;

import java.util.ArrayList;

import edu.nju.express.blservice.HallReceiptBlService;
import edu.nju.express.businesslogic.orderbl.OrderBL;
import edu.nju.express.businesslogic.vehiclebl.Vehiclebl;
import edu.nju.express.common.ResultMessage;
import edu.nju.express.dataservice.HallDataService;
import edu.nju.express.init.RMIHelper;
import edu.nju.express.vo.ArrivalReceiptVO;
import edu.nju.express.vo.DeliverReceiptVO;
import edu.nju.express.vo.HallTransferReceiptVO;
import edu.nju.express.vo.OrderVO;

public class HallReceiptBL implements HallReceiptBlService{
	
	
	
	
	
	
	OrderBL orderBL;
	Vehiclebl vehiclebl;
	
	ArrayList<ArrivalReceiptVO> arrivalList = new ArrayList<ArrivalReceiptVO>();
	ArrayList<HallTransferReceiptVO> transferList = new ArrayList<HallTransferReceiptVO>();
	ArrayList<DeliverReceiptVO> deliverList = new ArrayList<DeliverReceiptVO>();
	
	
	HallDataService hallDataService;
	
	
	
	public HallReceiptBL(OrderBL orderBL,Vehiclebl vehiclebl){
		this.orderBL = orderBL;
		this.vehiclebl = vehiclebl;
		hallDataService = RMIHelper.getHallDataService();
		
	
	}
	
	
	
	
	@Override
	public ResultMessage createArrivalReceipt(ArrivalReceiptVO vo) {
		// TODO Auto-generated method stub

		return ResultMessage.INVALID;
	}

	@Override
	public ResultMessage createTransferReceipt(HallTransferReceiptVO vo) {
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

	public ArrayList<HallTransferReceiptVO> viewAllTransfer() {
		// TODO Auto-generated method stub
		return transferList;
	}

	public ArrayList<DeliverReceiptVO> viewAllDeliver() {
		// TODO Auto-generated method stub
		return deliverList;
	}
	
	
	/**
	 * 
	 * @param id
	 * @return
	 */
	public ResultMessage approveArrival(String id){
		return ResultMessage.INVALID;
	}
	
	public ResultMessage approveTransfer(String id){
		return ResultMessage.INVALID;
	}

	public ResultMessage approveDeliver(String id){
		return ResultMessage.INVALID;
	}
	
	
	

}
