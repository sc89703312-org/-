package client.businesslogic.strategybl.organizationbl;

import java.util.ArrayList;

import client.ResultMessage;
import client.blservice.StrategyBlService.OrganizationBlService;
import client.vo.hallvo.HallVO;
import client.vo.stationvo.StationVO;

public class OrganizationBl implements OrganizationBlService{

	
	
	
	@Override
	public ArrayList<StationVO> viewStationList() {
		return null;
	}

	@Override
	public ResultMessage createStation(String id, String name) {
		return null;
	}

	@Override
	public ResultMessage deleteStation(String id) {
		return null;
	}

	@Override
	public ArrayList<HallVO> viewHallList() {
		return null;
	}

	@Override
	public ResultMessage createHall(String id, String name, String cityID) {
		return null;
	}

	@Override
	public ResultMessage deleteHall(String id) {
		// TODO Auto-generated method stub
		return null;
	}

}
