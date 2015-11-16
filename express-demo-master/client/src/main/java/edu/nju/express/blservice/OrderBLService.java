package edu.nju.express.blservice;

import java.util.ArrayList;
import edu.nju.express.vo.*;
import edu.nju.express.common.*;



public interface OrderBLService {
	
	public ResultMessage createOrder(OrderVO vo);
	
	public OrderVO view(String id);
	
	public ArrayList<OrderVO> viewAll();
	
	public void receiverCfm(String id);
	
	public void endOrder();
	
	
}
