package client.blservice.stationBlService.test;

import java.util.ArrayList;

import client.ResultMessage;
import client.blservice.stationBlService.StationBlService;
import client.vo.ordervo.ArrivalState;
import client.vo.ordervo.Etype;
import client.vo.ordervo.OrderVO;

public class StationBlService_Driver {

	public void drive(StationBlService service){
		
		ResultMessage result;
		
		ArrayList<OrderVO> order_list = new ArrayList<OrderVO>();
		order_list.add(new OrderVO("SHRF","NJU","NJU","025-83621002","13900001234","SC","NJU",
				"NJU","025-83621001","13900001231",1,20.5,30.0,"book",10*20,5.0,15.0,"1234567890",Etype.FAST,
				ArrivalState.NO,"2 days","Nanjing"));
		
		result = service.creatArriveReceipt(order_list, "100", "2015/10/25", "Shanghai", "Nanjing");
		if(result==ResultMessage.VALID)
			System.out.println("SUCCESS");
		else
			System.out.println("FAILED");
		
		result = service.creatTransferReceipt(order_list, "200", "2015/10/25", "Shanghai", "Nanjing");
		if(result==ResultMessage.VALID)
			System.out.println("SUCCESS");
		else
			System.out.println("FAILED");
		
	}
	
	public static void main(String[] args){
		StationBlService_Driver driver = new StationBlService_Driver();
		driver.drive(new StationBlService_Stub());
	}
	
}
