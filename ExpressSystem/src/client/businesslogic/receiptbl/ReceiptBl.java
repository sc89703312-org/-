package client.businesslogic.receiptbl;

import java.util.ArrayList;

import client.ResultMessage;
import client.blservice.receiptblservice.ReceiptBlService;
import client.businesslogic.hallbl.HallBL;
import client.businesslogic.orderbl.OrderBL;
import client.businesslogic.paymentbl.Paymentbl;
import client.businesslogic.stationbl.StationReceiptBl;
import client.vo.ReceiptVOBase;

public class ReceiptBl implements ReceiptBlService {

	OrderBL order;
	Paymentbl payment;
	HallBL hall;
	StationReceiptBl stationbl;

	ArrayList<ReceiptVOBase> list = new ArrayList<ReceiptVOBase>();

	public ReceiptBl() {
		payment = new MockPayment(null);
		hall = new MockHall();

	}

	@Override
	public ArrayList<ReceiptVOBase> view() {
		
		list.addAll(payment.viewAll());
		list.addAll(hall.viewAllArrival());
		list.addAll(hall.viewAllDeliver());
		list.addAll(hall.viewAllTransfer());
		list.addAll(stationbl.viewAllArrive());
		list.addAll(stationbl.viewAllTransfer());

		return list;
	}

	@Override
	public void approve(ArrayList<ReceiptVOBase> list) {
		
		for (int i = 0; i < list.size(); i++) {
			String id = list.get(i).getId();
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
