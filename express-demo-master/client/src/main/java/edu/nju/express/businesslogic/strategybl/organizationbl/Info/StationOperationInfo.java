package edu.nju.express.businesslogic.strategybl.organizationbl.Info;

import java.util.ArrayList;

import edu.nju.express.common.ResultMessage;
import edu.nju.express.vo.StationVO;
/**
 * 机构管理模块需要的中转站模块接口
 * @author Dora
 *
 */
public interface StationOperationInfo {

	
	public ArrayList<StationVO> showStation();
	
	public ResultMessage addStation(String id,String name);
	
	public ResultMessage deleteStation(String id);
}
