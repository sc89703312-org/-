package client.businesslogic.strategybl.organizationbl;

import java.util.ArrayList;

import client.ResultMessage;
import client.blservice.StrategyBlService.OrganizationBlService;
import client.businesslogic.hallbl.HallBL;
import client.businesslogic.stationbl.StationBl;
import client.vo.hallvo.HallVO;
import client.vo.stationvo.StationVO;

public class OrganizationBl implements OrganizationBlService{

	StationBl stationbl;
	HallBL hallbl;
	
	
	public OrganizationBl(StationBl stationbl, HallBL hallbl){
		
		this.stationbl = stationbl;
		this.hallbl = hallbl;
	}
	
	@Override
	public ArrayList<StationVO> viewStationList() {
		return stationbl.showStation();
	}

	@Override
	public ResultMessage createStation(String id, String name) {
		return stationbl.addStation(id, name);
	}

	@Override
	public ResultMessage deleteStation(String id) {
		return stationbl.deleteStation(id);
	}

	@Override
	public ArrayList<HallVO> viewHallList() {
		return hallbl.showHall();
	}

	@Override
	public ResultMessage createHall(String id, String name,String cityid) {
		return hallbl.addHall(id, name,cityid);
	}

	@Override
	public ResultMessage deleteHall(String id) {
		// TODO Auto-generated method stub
		return hallbl.removeHall(id);
	}

}
