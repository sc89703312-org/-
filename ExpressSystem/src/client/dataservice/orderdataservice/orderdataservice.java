package client.dataservice.orderdataservice;


import client.po.orderpo.OrderPO;

public interface orderdataservice {
	public void insert(OrderPO po);
	
	public void update(OrderPO po);
	
	public void delete(String id);
	
	public OrderPO find(String id);
}
