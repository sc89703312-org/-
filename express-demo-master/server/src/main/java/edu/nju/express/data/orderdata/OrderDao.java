package edu.nju.express.data.orderdata;

import java.util.ArrayList;

import edu.nju.express.common.ArrivalState;
import edu.nju.express.common.ResultMessage;
import edu.nju.express.po.OrderPO;



public interface OrderDao {
	public ResultMessage insert(OrderPO po);
	public ResultMessage update(OrderPO po);
	public ResultMessage delete(String id);
	public OrderPO find(String id);
	
	public ArrayList<OrderPO> getAll();
	public ArrayList<OrderPO> showAll();
	public void flush();
	
    public void addHistory(String spot,String id);
	
	public void setDeliver(String name,String id);
	
	public void setArrivalState(ArrivalState arrivalState,String id);
}
