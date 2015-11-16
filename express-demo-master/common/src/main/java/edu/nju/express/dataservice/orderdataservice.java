package edu.nju.express.dataservice;

import edu.nju.express.po.OrderPO;




public interface orderdataservice {
	public void insert(OrderPO po);
	
	public void update(OrderPO po);
	
	public void delete(String id);
	
	public OrderPO find(String id);
}
