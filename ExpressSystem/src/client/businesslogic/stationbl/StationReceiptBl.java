package client.businesslogic.stationbl;

import java.util.ArrayList;

import client.ResultMessage;
import client.blservice.stationBlService.StationReceiptBlService;
import client.dataservice.stationdataservice.StationDataService;
import client.main.RMIHelper;
import client.vo.ordervo.OrderVO;

public class StationReceiptBl implements StationReceiptBlService{
	
	StationDataService stationDataService;
	
	public StationReceiptBl(){
		//stationDataService = RMIHelper.getStationDataService();
	}

	@Override
	public ResultMessage creatArriveReceipt(ArrayList<OrderVO> list, String id,
			String date, String from, String location) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public ResultMessage creatTransferReceipt(ArrayList<OrderVO> list,
			String id, String date, String to, String location) {
		// TODO Auto-generated method stub
		return null;
	}
	
	public ResultMessage approve(String id){
		
		ResultMessage result = null;
		
		
		
		return result;
		
	}
	

}
