package client.blservice.orderblservice.test;

import java.util.List;

import client.ResultMessage;
import client.blservice.orderblservice.OrderBLService;
import client.vo.ordervo.ArrivalState;
import client.vo.ordervo.OrderVO;

public class OrderBLService_Stub implements OrderBLService{
	OrderVO voDemo;
	@Override
	public ResultMessage createOrder(OrderVO vo) {
		// TODO Auto-generated method stub
		if(vo.getID().length()==10&&vo.getSenderPhone().length()==11&&vo.getReceiverPhone().length()==11){
			this.voDemo=vo;
			System.out.println("Create successfully!");
			return ResultMessage.VALID;
			
		}
		else{
			if(vo.getID().length()!=10)
				System.out.println("Wrong form of ID!");
			else if(vo.getSenderPhone().length()!=11)
				System.out.println("Wrong form of sender's phone number!");
			else
				System.out.println("Wrong form of receiver's phone number!");
			return ResultMessage.INVALID;
		}
	}
	
	
	
	@Override
	public OrderVO view(String id) {
		// TODO Auto-generated method stub
		if(id.length()!=10){
			System.out.println("INVALID id!");
			return null;
		}
		if(id.equals("1234567890")){
			System.out.println("Order infomation...");
		}
		return null;
	}

	@Override
	public void receiverCfm(String id) {
		// TODO Auto-generated method stub
		if(id.equals("1234567890")){
			voDemo.setArrivalState(ArrivalState.YES);
			System.out.println(voDemo.getState());
		}
	}

	@Override
	public void endOrder() {
		// TODO Auto-generated method stub
		System.out.println("OrderPO has been updated!");
	}



	@Override
	public List<OrderVO> viewAll() {
		// TODO Auto-generated method stub
		System.out.println("Show all orders");
		return null;
	}

	
}
