package client.blservice.orderblservice.test;

import client.blservice.orderblservice.OrderBLService;
import client.vo.ordervo.ArrivalState;
import client.vo.ordervo.Etype;
import client.vo.ordervo.OrderVO;

public class OrderBLService_Driver {
	
	public void driver(OrderBLService os){
		OrderVO voDemo=new OrderVO("SHRF","NJU","NJU","025-83621002","13900001234","SC","NJU","NJU",
				"025-83621001","13900001231",1,20.5,30.0,"book",10*20,5.0,15.0,"1234567890",
				Etype.FAST,ArrivalState.NO,"2 days","Nanjing");
		os.createOrder(voDemo);
		os.view("1234567890");
		os.view("123456789");
		os.receiverCfm("1234567890");
		os.endOrder();
		os.viewAll();
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		(new OrderBLService_Driver()).driver(new OrderBLService_Stub());
	}

}
