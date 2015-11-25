package edu.nju.express.data.logisticsdata;

import java.util.ArrayList;

import edu.nju.express.po.LogisticsPO;



public interface LogisticsDao {
	public void insert(LogisticsPO po);
	public void update(LogisticsPO po);
	public LogisticsPO find(String id);
	public ArrayList<LogisticsPO> getAll();
	public ArrayList<LogisticsPO> showAll();
	public void flush();
}
