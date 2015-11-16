package edu.nju.express.blservice;

import java.util.ArrayList;

import edu.nju.express.common.ResultMessage;
import edu.nju.express.vo.HallVO;
import edu.nju.express.vo.StationVO;


public interface OrganizationBlService {
	public ArrayList<StationVO> viewStationList();
	
	public ResultMessage createStation(String id, String name);
	
	public ResultMessage deleteStation(String id);
	
	public ArrayList<HallVO> viewHallList();
	
	public ResultMessage createHall(String id, String name,String cityID);
	
	public ResultMessage deleteHall(String id);
}
