package server.data.logisticsdata;

import client.po.logisticspo.LogisticsPO;

public interface LogisticsDao {
	public void insert(LogisticsPO po);
	public void update(LogisticsPO po);
	public LogisticsPO find(String id);
}
