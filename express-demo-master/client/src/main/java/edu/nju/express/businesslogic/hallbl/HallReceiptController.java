package edu.nju.express.businesslogic.hallbl;

import java.util.ArrayList;

import edu.nju.express.blservice.HallReceiptBlService;
import edu.nju.express.businesslogic.DataFactory;
import edu.nju.express.vo.ArrivalReceiptVO;
import edu.nju.express.vo.OrderVO;

public class HallReceiptController implements HallReceiptBlService {

	
	private HallReceiptBlService hallReceiptBL;
	private static HallReceiptController instance;
	
	private HallReceiptController() {
		// TODO Auto-generated constructor stub
	
	
		hallReceiptBL = DataFactory.createHallReceiptBLInstance();
	
	
	}
	
	
	public static HallReceiptController getInstance()
	{
		return instance = (instance==null)?new HallReceiptController():instance;
	}
	
	
	@Override
	public ArrivalReceiptVO createArrivalReceipt(String id) {
		// TODO Auto-generated method stub
		return hallReceiptBL.createArrivalReceipt(id);
	}

	@Override
	public void subArrivalReceipt(ArrivalReceiptVO vo) {
		// TODO Auto-generated method stub
		hallReceiptBL.subArrivalReceipt(vo);
	}

	@Override
	public ArrayList<OrderVO> showCurrentOrder() {
		// TODO Auto-generated method stub
		return hallReceiptBL.showCurrentOrder();
	}

	@Override
	public void subHallTransferReceipt(String transportID, String to,
			String carID, String supervisor, String guard,
			ArrayList<OrderVO> orderlist) {
		// TODO Auto-generated method stub
		hallReceiptBL.subHallTransferReceipt(transportID, to, carID, supervisor, guard, orderlist);
	}

	@Override
	public void subDeliverReceipt(String deliver, ArrayList<OrderVO> orderlist) {
		// TODO Auto-generated method stub
		hallReceiptBL.subDeliverReceipt(deliver, orderlist);
	}

}
