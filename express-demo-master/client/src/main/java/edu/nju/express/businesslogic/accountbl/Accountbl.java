package edu.nju.express.businesslogic.accountbl;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;

import edu.nju.express.blservice.Accountblservice;
import edu.nju.express.businesslogic.bankingbl.Bankingbl;
import edu.nju.express.businesslogic.strategybl.managementbl.*;
import edu.nju.express.businesslogic.strategybl.organizationbl.OrganizationBl;
import edu.nju.express.businesslogic.vehiclebl.CarControl;
import edu.nju.express.common.ResultMessage;
import edu.nju.express.dataservice.accountdataservice;
import edu.nju.express.vo.Accountvo;
import edu.nju.express.vo.BankingAccountVO;
import edu.nju.express.vo.Carvo;
import edu.nju.express.vo.EmployeeVO;
import edu.nju.express.vo.HallVO;
import edu.nju.express.vo.StationVO;




public class Accountbl implements Accountblservice{

	ManagementBl managementBl;
	OrganizationBl organizationBl;
	CarControl carControl;
	Bankingbl bankingbl;
	
	
	accountdataservice accountdataservice;
	
	
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
	    
	    
	    SimpleDateFormat sdf1 = new SimpleDateFormat("yyyy/MM/dd");    
	    String str1 = sdf1.format(new Date());    
	    
	    
	    
	    Accountvo accountvo = new Accountvo(halls, stations,
	    		             employees, cars,accounts,str1);
	    
	    
	}
	
	
	
	public String getDate(){
		
		SimpleDateFormat sdf1 = new SimpleDateFormat("yyyy/MM/dd");    
	    String str1 = sdf1.format(new Date());    
	    return str1;
	}

}
