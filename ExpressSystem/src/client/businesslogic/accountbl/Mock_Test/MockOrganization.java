package client.businesslogic.accountbl.Mock_Test;

import java.util.ArrayList;

import client.businesslogic.strategybl.organizationbl.OrganizationBl;
import client.vo.hallvo.HallVO;
import client.vo.stationvo.StationVO;

public class MockOrganization extends OrganizationBl {

	ArrayList<StationVO> stations = new ArrayList<StationVO>();
	
	ArrayList<HallVO> halls = new ArrayList<HallVO>();
	
	
	
	
	public MockOrganization() {
		// TODO Auto-generated constructor stub
	
	
		stations.add(new StationVO("a", "Nanjing"));
		
		stations.add(new StationVO("b", "Beijing"));
		
		stations.add(new StationVO("c", "Shanghai"));
		
		halls.add(new HallVO("1",
				"Gulou", "a"));
		
		halls.add(new HallVO("2",
				"Xianlin", "a"));
		
		halls.add(new HallVO("3",
				"Xuanwu", "a"));
		
		halls.add(new HallVO("1",
				"Chaoyang", "b"));
		
		
		

	}
	
	@Override
	public ArrayList<StationVO> viewStationList() {
		return stations;
	}
	
	
	@Override
	public ArrayList<HallVO> viewHallList() {
		return halls;
	}
}
