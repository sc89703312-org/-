package edu.nju.express.businesslogic.strategybl.organizationbl;

import java.util.ArrayList;

import edu.nju.express.blservice.OrganizationBlService;
import edu.nju.express.businesslogic.DataFactory;
import edu.nju.express.common.ResultMessage;
import edu.nju.express.vo.HallVO;
import edu.nju.express.vo.StationVO;



public class OrganizationController implements OrganizationBlService{

	OrganizationBlService organization;
	private static OrganizationController instance;
	
	
	/**
	 * @param organization
	 */
	private OrganizationController() {
		this.organization = DataFactory.createOrganizationBl();
	}

	
	
	public static OrganizationController getInstance()
	{
		return instance = (instance==null)?new OrganizationController():instance;
	}
	
	@Override
	public ArrayList<StationVO> viewStationList() {
		// TODO Auto-generated method stub
		return organization.viewStationList();
	}

	@Override
	public ResultMessage createStation(String id, String name) {
		// TODO Auto-generated method stub
		return organization.createStation(id, name);
	}

	@Override
	public ResultMessage deleteStation(String id) {
		// TODO Auto-generated method stub
		return organization.deleteStation(id);
	}

	@Override
	public ArrayList<HallVO> viewHallList() {
		return organization.viewHallList();
	}

	@Override
	public ResultMessage createHall(String id, String name) {
		return organization.createHall(id, name);
	}

	@Override
	public ResultMessage deleteHall(String id) {
		return organization.deleteHall(id);
	}

}
