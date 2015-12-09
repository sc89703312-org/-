package edu.nju.express.businesslogic.accountbl;

import java.rmi.RemoteException;
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
import edu.nju.express.common.Convert;
import edu.nju.express.common.ResultMessage;
import edu.nju.express.dataservice.accountdataservice;
import edu.nju.express.init.RMIHelper;
import edu.nju.express.log.LogController;
import edu.nju.express.po.Accountpo;
import edu.nju.express.po.BankingAccountPO;
import edu.nju.express.po.Carpo;
import edu.nju.express.po.ComGoodsPO;
import edu.nju.express.po.HallPo;
import edu.nju.express.po.LogMessage;
import edu.nju.express.po.LoginInfo;
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
	
	
	    
	    accountdataservice = RMIHelper.getAccountdataservice();
		
	
	}
	
	
	
	


	@Override
	public Accountvo viewAccount(String date) {
		// TODO Auto-generated method stub
		
		Accountpo po=null;
		try {
			po = accountdataservice.find(date);
		} catch (RemoteException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
				
		
		Accountvo vo = new Accountvo
				(convertHallPO(po.getHallList()),
				 convertStationPO(po.getStationList()),
				 convertEmployeePO(po.getUserList()),
				 convertCarPO(po.getCarList()),
				 convertBankingPO(po.getAccountsList()),
				 convertComGoodsPO(po.getCommodity()),
				 po.getDate());
		
		
		return vo;
		
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
	    ArrayList<ComGoodsVO> goods = new ArrayList<>();
	    

	    Accountvo accountvo = new Accountvo(halls, stations,
	    		             employees, cars,accounts,goods,getDate());
	    
	    Accountpo accountpo = new Accountpo(convertHallVO(halls),
	    		                            convertStationVO(stations),
	    		                            convertEmployeeVO(employees),
	    		                            convertCarVO(cars),
	    		                            convertBankingVO(accounts),
	    		                            convertComGoodsVO(goods),
	    		                            getDate());
	    
	    
	    try {
			accountdataservice.insert(accountpo);
		} catch (RemoteException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	    
	    
	    LogController.insertLog(new LogMessage("进行期初建账", LoginInfo.getUserName()));
	   
	}
	
	
	
	public String getDate(){
		
		SimpleDateFormat sdf1 = new SimpleDateFormat("yyyy/MM/dd");    
	    String str1 = sdf1.format(new Date());    
	    return str1;
	}
	
	
	
	
	
	
	public ArrayList<HallVO> convertHallPO (ArrayList<HallPo> polist){
		ArrayList<HallVO> halls = new ArrayList<>();
		
		for(int i=0;i<polist.size();i++){
			halls.add(new HallVO(polist.get(i).getId(), polist.get(i).getName()));
		}
		return halls;
	}
	
	
	public ArrayList<HallPo> convertHallVO (ArrayList<HallVO> volist){
		ArrayList<HallPo> halls = new ArrayList<>();
		
		for(int i=0;i<volist.size();i++){
			halls.add(new HallPo(volist.get(i).getId(), volist.get(i).getName()));
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
	
	
	public ArrayList<UserPO> convertEmployeeVO (ArrayList<EmployeeVO> volist){
		ArrayList<UserPO> employees = new ArrayList<>();
		
		for(int i=0;i<volist.size();i++){
			employees.add(new UserPO(volist.get(i).getId(), volist.get(i).getName(), volist.get(i).getRole(), "******"));
		}
		return employees;
	}

	
	
	public ArrayList<BankingAccountVO> convertBankingPO (ArrayList<BankingAccountPO> polist){
		ArrayList<BankingAccountVO> bankaccounts = new ArrayList<>();
		
		for(int i=0;i<polist.size();i++){
			bankaccounts.add(new BankingAccountVO(polist.get(i).getName(), polist.get(i).getMoney()));
		}
		return bankaccounts;
	}
	
	
	public ArrayList<BankingAccountPO> convertBankingVO (ArrayList<BankingAccountVO> volist){
		ArrayList<BankingAccountPO> bankaccounts = new ArrayList<>();
		
		for(int i=0;i<volist.size();i++){
			bankaccounts.add(new BankingAccountPO(volist.get(i).getName(),volist.get(i).getMoney()));
		}
		return bankaccounts;
	}
	
	
	public ArrayList<Carvo> convertCarPO (ArrayList<Carpo> polist){
		ArrayList<Carvo> cars = new ArrayList<>();
		
		for(int i=0;i<polist.size();i++){
			cars.add(new Carvo(polist.get(i).getId(), polist.get(i).getMotor(),
					polist.get(i).getCar(), polist.get(i).getBase(),
					polist.get(i).getPurchase(), polist.get(i).getUse()));
		}
		return cars;
	}
	
	public ArrayList<Carpo> convertCarVO (ArrayList<Carvo> volist){
		ArrayList<Carpo> cars = new ArrayList<>();
		
		for(int i=0;i<volist.size();i++){
			cars.add(new Carpo(volist.get(i).getId(), volist.get(i).getMotor(),
					volist.get(i).getCar(), volist.get(i).getBase(),
					volist.get(i).getPurchase(), volist.get(i).getUse()));
		}
		return cars;
	}
	
	
	
	public ArrayList<ComGoodsVO> convertComGoodsPO (ArrayList<ComGoodsPO> polist){
		ArrayList<ComGoodsVO> comGoods = new ArrayList<>();
		
		for(int i=0;i<polist.size();i++){
			comGoods.add(new ComGoodsVO(Convert.po_to_vo_order(polist.get(i).getOrder()),
					     polist.get(i).getType(),
					     polist.get(i).getLine(),
					     polist.get(i).getShelf(),
					     polist.get(i).getCell()));
		}
		return comGoods;
	}
	
	
	public ArrayList<ComGoodsPO> convertComGoodsVO (ArrayList<ComGoodsVO> volist){
		ArrayList<ComGoodsPO> comGoods = new ArrayList<>();
		
		for(int i=0;i<volist.size();i++){
			comGoods.add(new ComGoodsPO(Convert.vo_to_po_order(volist.get(i).getOrder()),
					     volist.get(i).getType(),
					     volist.get(i).getLine(),
					     volist.get(i).getShelf(),
					     volist.get(i).getCell()));
		}
		return comGoods;
	}
	
}
