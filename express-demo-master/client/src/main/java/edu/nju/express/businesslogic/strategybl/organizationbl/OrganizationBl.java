package edu.nju.express.businesslogic.strategybl.organizationbl;

import java.util.ArrayList;

import edu.nju.express.blservice.OrganizationBlService;
import edu.nju.express.businesslogic.stationbl.StationBl;
import edu.nju.express.common.ResultMessage;
import edu.nju.express.vo.HallVO;
import edu.nju.express.vo.StationVO;



public class OrganizationBl implements OrganizationBlService{

	StationBl stationbl;
	
	
	public OrganizationBl(StationBl stationbl){
		
		this.stationbl = stationbl;
		
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
