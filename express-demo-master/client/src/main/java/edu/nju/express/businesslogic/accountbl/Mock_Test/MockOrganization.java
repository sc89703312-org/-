package edu.nju.express.businesslogic.accountbl.Mock_Test;

import java.util.ArrayList;

import edu.nju.express.businesslogic.strategybl.organizationbl.OrganizationBl;
import edu.nju.express.vo.HallVO;
import edu.nju.express.vo.StationVO;



public class MockOrganization extends OrganizationBl {

	ArrayList<StationVO> stations = new ArrayList<StationVO>();
	
	ArrayList<HallVO> halls = new ArrayList<HallVO>();
	
	
	
	
	public MockOrganization() {
		// TODO Auto-generated constructor stub
		super(null);
	
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
