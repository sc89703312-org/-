package client.blservice.StrategyBlService.test;

import java.util.ArrayList;

import client.ResultMessage;
import client.blservice.StrategyBlService.OrganizationBlService;
import client.vo.hallvo.HallVO;
import client.vo.stationvo.StationVO;

public class OrganizationBlService_Stub implements OrganizationBlService{

	@Override
	public ArrayList<StationVO> viewStationList() {
		System.out.println("Show the list of all the stations");
		ArrayList<StationVO> list = new ArrayList<StationVO>();
		list.add(new StationVO("025", "Nanjing"));
		return list;
	}

	@Override
	public ResultMessage createStation(String id, String name) {
		ResultMessage rm = ResultMessage.VALID;
		if(id.equals("025"))
			rm = ResultMessage.INVALID;
		return rm;
	}

	@Override
	public ResultMessage deleteStation(String id) {
		ResultMessage rm = ResultMessage.INVALID;
		if(id.equals("025"))
			rm = ResultMessage.VALID;
		return rm;
	}

	@Override
	public ArrayList<HallVO> viewHallList() {
		System.out.println("Show the list of all the halls");
		ArrayList<HallVO> list = new ArrayList<HallVO>();
		list.add(new HallVO("025001","Gulou","025"));
		return list;
	}

	@Override
	public ResultMessage createHall(String id, String name, String cityID) {
		ResultMessage rm = ResultMessage.VALID;
		if(id.equals("025001"))
			rm = ResultMessage.INVALID;
		return rm;
	}

	@Override
	public ResultMessage deleteHall(String id) {
		ResultMessage rm = ResultMessage.INVALID;
		if(id.equals("025001"))
			rm = ResultMessage.VALID;
		return rm;
	}
}
