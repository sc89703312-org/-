package server.dataservice.logisticsdataservice;

import client.po.logisticspo.LogisticsPO;

public interface LogisticsDataService {
	
	public LogisticsPO find(String id);
	
	public void update(LogisticsPO po);
	
	public void insert(LogisticsPO po);
}
