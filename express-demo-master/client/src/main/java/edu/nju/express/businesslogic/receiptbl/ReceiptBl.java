package edu.nju.express.businesslogic.receiptbl;

import java.util.ArrayList;

import edu.nju.express.blservice.ReceiptBlService;
import edu.nju.express.businesslogic.hallbl.HallBL;
import edu.nju.express.businesslogic.hallbl.HallReceiptBL;
import edu.nju.express.businesslogic.orderbl.OrderBL;
import edu.nju.express.businesslogic.paymentbl.Paymentbl;
import edu.nju.express.businesslogic.receiptbl.Info.CommodityApproveInfo;
import edu.nju.express.businesslogic.receiptbl.Info.CostApproveInfo;
import edu.nju.express.businesslogic.receiptbl.Info.HallApproveInfo;
import edu.nju.express.businesslogic.receiptbl.Info.PaymentApproveInfo;
import edu.nju.express.businesslogic.receiptbl.Info.StationApproveInfo;
import edu.nju.express.businesslogic.stationbl.StationReceiptBl;
import edu.nju.express.common.ConcludeTypeById;
import edu.nju.express.common.ResultMessage;
import edu.nju.express.vo.Paymentvo;
import edu.nju.express.vo.ReceiptVOBase;

/**
 * 处理单据的功能实现
 * @author Dora
 * @version 2015-12-9 21:27:49
 */

public class ReceiptBl implements ReceiptBlService {

	CommodityApproveInfo commodityBL;
	CostApproveInfo costBL;
	HallApproveInfo hallBL;
	PaymentApproveInfo paymentBL;
	StationApproveInfo stationBL;
	
	/**
	 * @param commodityBL
	 * @param costBL
	 * @param hallBL
	 * @param paymentBL
	 * @param stationBL
	 */
	public ReceiptBl(CommodityApproveInfo commodityBL,
	CostApproveInfo costBL,
	HallApproveInfo hallBL,
	PaymentApproveInfo paymentBL,
	StationApproveInfo stationBL) {
	this.commodityBL = commodityBL;	
	this.costBL = costBL;	
	this.hallBL = hallBL;		
	this.paymentBL = paymentBL;	
	this.stationBL = stationBL;
	
	}
	
	
	/**
	 * 查看所有单据
	 * @see CommodityApproveInfo
	 * @see PaymentApproveInfo
	 * @see HallApproveInfo
	 * @see StationApproveInfo
	 */
	@Override
	public ArrayList<ReceiptVOBase> view() {
		// TODO Auto-generated method stub
		
		
		ArrayList<ReceiptVOBase> allReceipts = new ArrayList<>();
		allReceipts.addAll(paymentBL.viewAllPaymentSubmitted());
		allReceipts.addAll(costBL.viewAllCostSubmitted());
		allReceipts.addAll(hallBL.viewAllArrivalReceiptSubmitted());
		allReceipts.addAll(hallBL.viewAllDeliverReceiptSubmitted());
		allReceipts.addAll(hallBL.viewAllHallTransferReceiptSubmitted());
		allReceipts.addAll(stationBL.viewAllArriveReceiptSubmitted());
		allReceipts.addAll(stationBL.viewAllTransferReceiptSubmitted());
//		allReceipts.addAll(commodityBL.viewAllEnterReceipt());
//		allReceipts.addAll(commodityBL.viewAllExitReceipt());
		
		return allReceipts;
	}

	
	
	/**
	 * 审批单据
	 * @see CommodityApproveInfo
	 * @see PaymentApproveInfo
	 * @see HallApproveInfo
	 * @see StationApproveInfo
	 */
	@Override
	public void approve(String id) {
		// TODO Auto-generated method stub
		
		switch (ConcludeTypeById.conclude(id)) {
		case 0:
			paymentBL.approvePayment(id);
			break;
		case 1:
			costBL.approveCost(id);
            break;
		case 2:
            stationBL.approveArriveReceipt(id);
			break;
		case 3:
		    stationBL.approveTransferReceipt(id);        
			break;
		case 4:
		    commodityBL.approveEnterReceipt(id);
			break;
		case 5:
		    commodityBL.approveExitReceipt(id);
			break;
		case 6:
		    hallBL.approveArrivalReceipt(id);
			break;
		case 7:
		    hallBL.approveDeliverReceipt(id);
			break;
		case 8:
		    hallBL.approveHallTransferReceipt(id);
			break;
            
		default:
			break;
		}
		
		
	}

	/**
	 * 修改单据
	 */
	@Override
	public ResultMessage modify(ReceiptVOBase vo) {
		// TODO Auto-generated method stub
		return null;
	}


	
}
