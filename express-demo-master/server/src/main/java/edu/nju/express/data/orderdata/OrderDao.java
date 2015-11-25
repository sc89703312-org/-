package edu.nju.express.data.orderdata;

import java.util.ArrayList;

import edu.nju.express.po.OrderPO;



public interface OrderDao {
	public void insert(OrderPO po);
	public void update(OrderPO po);
	public void delete(String id);
	public OrderPO find(String id);
	
	public ArrayList<OrderPO> getAll();
	public ArrayList<OrderPO> showAll();
	public void flush();
}
