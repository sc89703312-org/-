package edu.nju.express.businesslogic.accountbl.Info;

import java.util.ArrayList;

import edu.nju.express.vo.HallVO;
import edu.nju.express.vo.StationVO;

public interface OrganizationInfo {

	
	public ArrayList<StationVO> viewStationList();
	public ArrayList<HallVO> viewHallList();
}
