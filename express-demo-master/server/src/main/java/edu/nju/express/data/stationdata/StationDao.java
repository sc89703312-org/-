package edu.nju.express.data.stationdata;

import java.util.ArrayList;

import edu.nju.express.common.ResultMessage;
import edu.nju.express.po.StationPO;

public interface StationDao {
	
	public String getLocation(String id);
	public ResultMessage add(StationPO po);
	public ResultMessage remove(String id);
	public ArrayList<StationPO> showAllStation();
	public void flush();

}
