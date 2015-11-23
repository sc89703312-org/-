package edu.nju.express.businesslogic.accountbl;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;

import edu.nju.express.blservice.Accountblservice;
import edu.nju.express.businesslogic.accountbl.Info.*;
import edu.nju.express.businesslogic.bankingbl.Bankingbl;
import edu.nju.express.businesslogic.paymentbl.Info.BankingInfo;
import edu.nju.express.businesslogic.strategybl.managementbl.*;
import edu.nju.express.businesslogic.strategybl.organizationbl.OrganizationBl;
import edu.nju.express.businesslogic.vehiclebl.CarControl;
import edu.nju.express.common.ResultMessage;
import edu.nju.express.dataservice.accountdataservice;
import edu.nju.express.po.Accountpo;
import edu.nju.express.po.HallPo;
import edu.nju.express.po.StationPO;
import edu.nju.express.po.UserPO;
import edu.nju.express.vo.Accountvo;
import edu.nju.express.vo.BankingAccountVO;
import edu.nju.express.vo.Carvo;
import edu.nju.express.vo.ComGoodsVO;
import edu.nju.express.vo.EmployeeVO;
import edu.nju.express.vo.HallVO;
import edu.nju.express.vo.StationVO;




public class Accountbl implements Accountblservice{

	ManagementInfo managementBl;
	OrganizationInfo organizationBl;
	CarControlInfo carControl;
	BankingInfo bankingbl;
	CommodityInfo commoditybl;
	
	
	accountdataservice accountdataservice;
	
	
	public Accountbl(ManagementInfo managementBl,
			         OrganizationInfo organizationBl,
			         CarControlInfo carControl,
			         BankingInfo bankingbl,
			         CommodityInfo commodityBl) {
		// TODO Auto-generated constructor stub
	
	
		this.managementBl = managementBl;
		this.organizationBl = organizationBl;
		this.carControl = carControl;
		this.bankingbl = bankingbl;
	    this.commoditybl = commodityBl;
	
	
		
	
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
		ArrayList<BankingAccountVO> accounts= bankingbl.getAllAccounts();
	    ArrayList<Carvo> cars = carControl.getAll();
	    ArrayList<ComGoodsVO> goods = commoditybl.showInventory();
	    

	    Accountvo accountvo = new Accountvo(halls, stations,
	    		             employees, cars,accounts,goods,getDate());
	    
	    
	    
	   
	}
	
	
	
	public String getDate(){
		
		SimpleDateFormat sdf1 = new SimpleDateFormat("yyyy/MM/dd");    
	    String str1 = sdf1.format(new Date());    
	    return str1;
	}
	
	
	public ArrayList<HallVO> convertHallPO (ArrayList<HallPo> polist){
		ArrayList<HallVO> halls = new ArrayList<>();
		
		for(int i=0;i<polist.size();i++){
			halls.add(new HallVO(polist.get(i).getId(), polist.get(i).getName(), polist.get(i).getCityID()));
		}
		return halls;
	}
	
	
	public ArrayList<HallPo> convertHallVO (ArrayList<HallVO> volist){
		ArrayList<HallPo> halls = new ArrayList<>();
		
		for(int i=0;i<volist.size();i++){
			halls.add(new HallPo(volist.get(i).getId(), volist.get(i).getName(), volist.get(i).getCityID()));
		}
		return halls;
	}
	
	
	
	public ArrayList<StationVO> convertStationPO (ArrayList<StationPO> polist){
		ArrayList<StationVO> stations = new ArrayList<>();
		
		for(int i=0;i<polist.size();i++){
			stations.add(new StationVO(polist.get(i).getId(), polist.get(i).getName()));
		}
		return stations;
	}
	
	
	public ArrayList<StationPO> convertStationVO (ArrayList<StationVO> volist){
		ArrayList<StationPO> stations = new ArrayList<>();
		
		for(int i=0;i<volist.size();i++){
			stations.add(new StationPO(volist.get(i).getId(), volist.get(i).getName()));
		}
		return stations;
	}
	
	
	
	
	public ArrayList<EmployeeVO> convertEmployeePO (ArrayList<UserPO> polist){
		ArrayList<EmployeeVO> employees = new ArrayList<>();
		
		for(int i=0;i<polist.size();i++){
			employees.add(new EmployeeVO(polist.get(i).getId(), polist.get(i).getName(), polist.get(i).getRole()));
		}
		return employees;
	}
	
	

}
