package edu.nju.express.businesslogic.receiptbl;

import java.util.ArrayList;

import edu.nju.express.blservice.ReceiptBlService;
import edu.nju.express.businesslogic.hallbl.HallBL;
import edu.nju.express.businesslogic.hallbl.HallReceiptBL;
import edu.nju.express.businesslogic.orderbl.OrderBL;
import edu.nju.express.businesslogic.paymentbl.Paymentbl;
import edu.nju.express.businesslogic.stationbl.StationReceiptBl;
import edu.nju.express.common.ResultMessage;
import edu.nju.express.vo.ReceiptVOBase;



public class ReceiptBl implements ReceiptBlService {

	OrderBL order;
	Paymentbl payment;
	HallReceiptBL hall;
	StationReceiptBl stationbl;

	ArrayList<ReceiptVOBase> list;

	public ReceiptBl() {
//		payment = new MockPayment(null);
		hall = new MockHall(null,null);
		list = new ArrayList<ReceiptVOBase>();
	}

	@Override
	public ArrayList<ReceiptVOBase> view() {
		
		list.addAll(payment.viewAll());
		list.addAll(hall.viewAllArrival());
		list.addAll(hall.viewAllDeliver());
		list.addAll(hall.viewAllTransfer());
//		list.addAll(stationbl.viewAllArrive());
//		list.addAll(stationbl.viewAllTransfer());

		return list;
	}

	@Override
	public void approve(String id) {
		
		for (int i = 0; i < list.size(); i++) {
			switch(id.substring(0, 4)){
			case"2015":	((MockHall)hall).approve(id);break;
			}
		}
	}

	@Override
	public ResultMessage modify(ReceiptVOBase vo) {
		// TODO Auto-generated method stub
		return null;
	}

	
}
