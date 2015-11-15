package client.businesslogic.accountbl;

import java.util.ArrayList;

import client.ResultMessage;
import client.blservice.accountblservice.Accountblservice;
import client.businesslogic.bankingbl.Bankingbl;
import client.businesslogic.strategybl.managementbl.ManagementBl;
import client.businesslogic.strategybl.organizationbl.OrganizationBl;
import client.businesslogic.vehiclebl.CarControl;
import client.vo.accountvo.Accountvo;
import client.vo.bankingvo.BankingAccountVO;
import client.vo.carvo.Carvo;
import client.vo.hallvo.HallVO;
import client.vo.stationvo.StationVO;
import client.vo.uservo.EmployeeVO;


public class Accountbl implements Accountblservice{

	ManagementBl managementBl;
	OrganizationBl organizationBl;
	CarControl carControl;
	Bankingbl bankingbl;
	
	
	
	
	public Accountbl(ManagementBl managementBl,
			         OrganizationBl organizationBl,
			         CarControl carControl,
			         Bankingbl bankingbl) {
		// TODO Auto-generated constructor stub
	
	
		this.managementBl = managementBl;
		this.organizationBl = organizationBl;
		this.carControl = carControl;
		this.bankingbl = bankingbl;
	
	
	
	
	}
	
	
	
	
	@Override
	public ResultMessage createAccount(Accountvo vo) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Accountvo viewAccount(String date) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void endAccount() {
		// TODO Auto-generated method stub
		
	}




	@Override
	public void createAccount() {
		// TODO Auto-generated method stub
		ArrayList<EmployeeVO> employees = managementBl.viewEmployeeList();
		ArrayList<StationVO> stations = organizationBl.viewStationList();
		ArrayList<HallVO> halls = organizationBl.viewHallList();
		ArrayList<BankingAccountVO> accounts= bankingbl.showAccount("") ;
	    ArrayList<Carvo> cars = carControl.getAll();
	}

}
