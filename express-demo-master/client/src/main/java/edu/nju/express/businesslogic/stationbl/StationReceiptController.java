package edu.nju.express.businesslogic.stationbl;

import java.util.ArrayList;

import edu.nju.express.blservice.StationReceiptBlService;
import edu.nju.express.businesslogic.DataFactory;
import edu.nju.express.common.Etype;
import edu.nju.express.vo.ArriveReceiptVO;
import edu.nju.express.vo.OrderVO;

public class StationReceiptController implements StationReceiptBlService{

	private StationReceiptBlService stationReceipt;
	public StationReceiptController() {
		// TODO Auto-generated constructor stub

		stationReceipt = DataFactory.createStationReceiptBlInstance();
	
	
	}
	
	
	@Override
	public ArriveReceiptVO creatArriveReceipt(String id) {
		// TODO Auto-generated method stub
		return stationReceipt.creatArriveReceipt(id);
	}

	@Override
	public void subArriveReceipt(ArriveReceiptVO vo) {
		// TODO Auto-generated method stub
		stationReceipt.subArriveReceipt(vo);
	}

	@Override
	public ArrayList<OrderVO> showCurrentOrder() {
		// TODO Auto-generated method stub
		return stationReceipt.showCurrentOrder();
	}

	@Override
	public void subTransferReceipt(ArrayList<OrderVO> orderlist, String to,
			String transportID, String supervisor, Etype etype) {
		// TODO Auto-generated method stub
		stationReceipt.subTransferReceipt(orderlist, to, transportID, supervisor, etype);
	}

}
