package edu.nju.express.businesslogic.strategybl.organizationbl.Info;

import java.util.ArrayList;

import edu.nju.express.vo.HallVO;
import edu.nju.express.vo.StationVO;

public interface AccountInfo {
	public ArrayList<StationVO> viewStationList();
	
	public ArrayList<HallVO> viewHallList();
}
