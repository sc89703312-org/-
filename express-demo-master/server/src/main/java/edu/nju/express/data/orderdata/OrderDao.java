package edu.nju.express.data.orderdata;

import edu.nju.express.po.OrderPO;



public interface OrderDao {
	public void insert(OrderPO po);
	public void update(OrderPO po);
	public void delete(OrderPO po);
	public OrderPO find(String id);
}
