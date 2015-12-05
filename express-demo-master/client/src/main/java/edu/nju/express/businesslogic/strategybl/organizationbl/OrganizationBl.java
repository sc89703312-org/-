package edu.nju.express.businesslogic.strategybl.organizationbl;

import java.util.ArrayList;

import edu.nju.express.blservice.OrganizationBlService;
import edu.nju.express.businesslogic.accountbl.Info.OrganizationInfo;
import edu.nju.express.businesslogic.hallbl.HallBL;
import edu.nju.express.businesslogic.stationbl.StationBl;
import edu.nju.express.businesslogic.strategybl.organizationbl.Info.ConstantAddCityInfo;
import edu.nju.express.businesslogic.strategybl.organizationbl.Info.HallOperationInfo;
import edu.nju.express.businesslogic.strategybl.organizationbl.Info.StationOperationInfo;
import edu.nju.express.common.ResultMessage;
import edu.nju.express.log.LogController;
import edu.nju.express.po.LogMessage;
import edu.nju.express.po.LoginInfo;
import edu.nju.express.vo.HallVO;
import edu.nju.express.vo.StationVO;



public class OrganizationBl implements OrganizationBlService,OrganizationInfo{

	StationOperationInfo stationbl;
	HallOperationInfo hallbl;
	ConstantAddCityInfo constantSettingBL;
	
	public OrganizationBl(StationOperationInfo stationbl,
			              HallOperationInfo hallbl,
			              ConstantAddCityInfo constantSettingBL){
		
		this.stationbl = stationbl;
		this.hallbl = hallbl;
		this.constantSettingBL = constantSettingBL;
	}
	
	@Override
	public ArrayList<StationVO> viewStationList() {
		return stationbl.showStation();
		
	}

	@Override
	public ResultMessage createStation(String id, String name) {
		
     	if(stationbl.addStation(id, name).equals(ResultMessage.VALID))
			constantSettingBL.addCity(name);
		
     	LogController.insertLog(new LogMessage("Add Station", LoginInfo.getUserName()));
		
		return stationbl.addStation(id, name);
		
		
	}

	@Override
	public ResultMessage deleteStation(String id) {
		
		LogController.insertLog(new LogMessage("Delete Station", LoginInfo.getUserName()));
		
		
		return stationbl.deleteStation(id);
		
	}

	@Override
	public ArrayList<HallVO> viewHallList() {
		return hallbl.showHall();
	}

	@Override
	public ResultMessage createHall(String id, String name) {
		
		LogController.insertLog(new LogMessage("Create Hall", LoginInfo.getUserName()));
		
		
		return hallbl.addHall(id, name);
	}

	@Override
	public ResultMessage deleteHall(String id) {
		// TODO Auto-generated method stub
		
		LogController.insertLog(new LogMessage("Delete Hall", LoginInfo.getUserName()));
		
		
		return hallbl.removeHall(id);
	}

}
