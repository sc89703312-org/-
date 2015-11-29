package edu.nju.express.businesslogic.strategybl.organizationbl.Info;

import java.util.ArrayList;

import edu.nju.express.common.ResultMessage;
import edu.nju.express.vo.HallVO;

public interface HallOperationInfo {

	
	
	public ArrayList<HallVO> showHall();
	
    public ResultMessage addHall(String id,String name);
	
	public ResultMessage removeHall(String id);
}
