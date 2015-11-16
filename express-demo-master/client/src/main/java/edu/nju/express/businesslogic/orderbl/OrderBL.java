package edu.nju.express.businesslogic.orderbl;

import java.util.ArrayList;

import edu.nju.express.blservice.OrderBLService;
import edu.nju.express.common.ResultMessage;
import edu.nju.express.vo.OrderVO;



public class OrderBL implements OrderBLService{
	
	public OrderBL(){
		
	}
	
	

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
