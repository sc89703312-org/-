package edu.nju.express.businesslogic.strategybl.organizationbl.Info;

import java.util.ArrayList;

import edu.nju.express.common.ResultMessage;
import edu.nju.express.vo.StationVO;

public interface StationOperationInfo {

	
	public ArrayList<StationVO> showStation();
	
	public ResultMessage addStation(String id,String name);
	
	public ResultMessage deleteStation(String id);
}
