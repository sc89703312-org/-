package client.businesslogic.orderbl;

import java.util.ArrayList;
import java.util.List;

import client.ResultMessage;
import client.blservice.orderblservice.OrderBLService;
import client.vo.ordervo.OrderVO;

public class OrderBL implements OrderBLService{

	@Override
	public ResultMessage createOrder(OrderVO vo) {
		// TODO Auto-generated method stub
		
		return null;
	}

	@Override
	public OrderVO view(String id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public ArrayList<OrderVO> viewAll() {
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

}
