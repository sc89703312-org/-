package client.blservice.orderblservice.test;

import java.util.List;

import client.ResultMessage;
import client.blservice.orderblservice.OrderBLService;
import client.vo.ordervo.OrderVO;

public class OrderBLService_Stub implements OrderBLService{

	@Override
	public ResultMessage createOrder(OrderVO vo) {
		// TODO Auto-generated method stub
		if(vo.getID().length()==10){
			return ResultMessage.VALID;
		}
		else return ResultMessage.INVALID;
	}
	
	
	
	@Override
	public OrderVO view(String id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void receiverCfm(String id) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void endOrder() {
		// TODO Auto-generated method stub
		
	}



	@Override
	public List<OrderVO> viewAll() {
		// TODO Auto-generated method stub
		System.out.println("show all orders");
		return null;
	}

	
}
