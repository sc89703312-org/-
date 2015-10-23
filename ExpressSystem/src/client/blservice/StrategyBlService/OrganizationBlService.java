package client.blservice.StrategyBlService;

import java.util.ArrayList;

import client.ResultMessage;
import client.vo.hallvo.HallVO;
import client.vo.stationvo.StationVO;

public interface OrganizationBlService {
	public ArrayList<StationVO> viewStationList();
	
	public ResultMessage createStation(String id, String name);
	
	public ResultMessage deleteStation(String id);
	
	public ArrayList<HallVO> viewHallList();
	
	public ResultMessage createHall(String id, String name,String cityID);
	
	public ResultMessage deleteHall(String id);
}
