package edu.nju.express.data.logisticsdata;

import java.util.ArrayList;

import edu.nju.express.common.ResultMessage;
import edu.nju.express.po.LogisticsPO;



public interface LogisticsDao {
	public ResultMessage insert(LogisticsPO po);
	public ResultMessage update(LogisticsPO po);
	public LogisticsPO find(String id);
	public ArrayList<LogisticsPO> getAll();
	public ArrayList<LogisticsPO> showAll();
	public void flush();
}
