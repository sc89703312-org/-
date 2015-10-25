package client.blservice.orderblservice;

import java.util.List;

import client.ResultMessage;
import client.vo.ordervo.OrderVO;

public interface OrderBLService {
	
	public ResultMessage createOrder(OrderVO vo);
	
	public OrderVO view(String id);
	
	public List<OrderVO> viewAll();
	
	public void receiverCfm(String id);
	
	public void endOrder();
}
