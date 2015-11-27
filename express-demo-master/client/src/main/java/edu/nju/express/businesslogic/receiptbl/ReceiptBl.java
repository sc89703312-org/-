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
import edu.nju.express.businesslogic.receiptbl.Info.OrderApproveInfo;
import edu.nju.express.businesslogic.receiptbl.Info.PaymentApproveInfo;
import edu.nju.express.businesslogic.receiptbl.Info.StationApproveInfo;
import edu.nju.express.businesslogic.stationbl.StationReceiptBl;
import edu.nju.express.common.ResultMessage;
import edu.nju.express.vo.ReceiptVOBase;



public class ReceiptBl implements ReceiptBlService {

	CommodityApproveInfo commodityBL;
	CostApproveInfo costBL;
	HallApproveInfo hallBL;
	OrderApproveInfo orderBL;
	PaymentApproveInfo paymentBL;
	StationApproveInfo stationBL;
	
	
	public ReceiptBl(CommodityApproveInfo commodityBL,
	CostApproveInfo costBL,
	HallApproveInfo hallBL,
	OrderApproveInfo orderBL,
	PaymentApproveInfo paymentBL,
	StationApproveInfo stationBL) {
		// TODO Auto-generated constructor stub	
	this.commodityBL = commodityBL;	
	this.costBL = costBL;	
	this.hallBL = hallBL;	
	this.orderBL = orderBL;	
	this.paymentBL = paymentBL;	
	this.stationBL = stationBL;
	
	}
	
	
	@Override
	public ArrayList<ReceiptVOBase> view() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void approve(String id) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public ResultMessage modify(ReceiptVOBase vo) {
		// TODO Auto-generated method stub
		return null;
	}


	
}
