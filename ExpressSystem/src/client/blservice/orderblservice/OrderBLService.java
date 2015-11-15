package client.blservice.orderblservice;

import java.util.ArrayList;

import client.ResultMessage;
import client.vo.ordervo.OrderVO;

public interface OrderBLService {
	
	public ResultMessage createOrder(OrderVO vo);
	
	public OrderVO view(String id);
	
	public ArrayList<OrderVO> viewAll();
	
	public void receiverCfm(String id);
	
	public void endOrder();
	
	
}
