package edu.nju.express.businesslogic.balancebl.CreateCost;

import java.rmi.RemoteException;
import static edu.nju.express.init.RMIHelper.paymentDataservice;
import static edu.nju.express.init.RMIHelper.balancedataservice;
import java.util.ArrayList;

import edu.nju.express.blservice.Balanceblservice;
import edu.nju.express.blservice.CostControlService;
import edu.nju.express.businesslogic.balancebl.CostList.Info.CostControlInfo;
import edu.nju.express.businesslogic.bankingbl.Bankingbl;
import edu.nju.express.businesslogic.paymentbl.Info.BankingInfo;
import edu.nju.express.businesslogic.receiptbl.Info.CostApproveInfo;
import edu.nju.express.businesslogic.strategybl.constantsettingbl.ConstantSettingBl;
import edu.nju.express.businesslogic.strategybl.salarysettingbl.SalarySettingBl;
import edu.nju.express.common.ResultMessage;
import edu.nju.express.dataservice.*;
import edu.nju.express.init.RMIHelper;
import edu.nju.express.log.LogController;
import edu.nju.express.po.Balancepo;
import edu.nju.express.po.LogMessage;
import edu.nju.express.po.LoginInfo;
import edu.nju.express.vo.Balancevo;
import edu.nju.express.vo.BankingAccountVO;
/**
 * 
 * @author lenovo
 * @version 2015年12月9日22:22:24
 * 
 * 进行付款单创建管理
 */


public class CostControlbl implements CostControlService,CostControlInfo,CostApproveInfo{

	
    
	/** 银行账户信息 */
	BankingInfo account;
	

	
	
	public CostControlbl(BankingInfo account) {
		// TODO Auto-generated constructor stub
	
	
	this.account = account;
	

	
	
	
	}
	
	
	/**
	 * (non-Javadoc)
	 * @see edu.nju.express.blservice.CostControlService#createCost(edu.nju.express.vo.Balancevo)
	 */
	
	
	/**
	 * @author lenovo
	 * @version 2015年12月9日22:24:11
	 */
	@Override
	public ResultMessage createCost(Balancevo vo) {
		// TODO Auto-generated method stub
		
		


		
		boolean exsit = false;
		
		ArrayList<BankingAccountVO> accounts = account.getAllAccounts();
		
		
		for(int i=0;i<accounts.size();i++){
			if(accounts.get(i).getName().equals(vo.getBanking())){
				exsit = true;
				break;
			}
			
		}
		
		
		if(exsit){
		modify(vo.getBanking(), (int)vo.getMoney());
		
		LogController.insertLog(new LogMessage("建立付款单", LoginInfo.getUserName()));
		
		try {
			balancedataservice.insert(convertVO(vo));
		} catch (RemoteException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
		
		return ResultMessage.VALID;
		
		
		}else {
			return ResultMessage.INVALID;
		}
	}

	
	


	
	
	/**
	 * @author lenovo
	 * @version 2015年12月9日22:24:30
	 */
	@Override
	public void endCostControl() {
		// TODO Auto-generated method stub
		
	}

	

	
	
	public Balancepo convertVO(Balancevo vo){

		
		return new Balancepo(vo.getDate(), vo.getMoney(), 
				                      vo.getName(), vo.getBanking(),
				                      vo.getItem(), vo.getRemark(),
				                    vo.getId() );
	}
	
	
	
	public Balancevo convertPO(Balancepo po){
		return new Balancevo(po.getDate(), po.getMoney(), 
				                      po.getName(), po.getBanking(),
				                      po.getItem(), po.getRemark(),
				                      po.getId());
	}
	
	/**
	 * 对银行账户余额进行修改
	 * @param name
	 * @param cost
	 */
	public void modify(String name,int cost){
		account.modify(-cost, name);
	}




	/**
	 * @author lenovo
	 * @version 2015年12月9日22:26:00
	 * 
	 */
	@Override
	public ArrayList<Balancevo> viewAllCost() {
		// TODO Auto-generated method stub
		ArrayList<Balancevo> temps=new ArrayList<>();
		
		try {
			ArrayList<Balancepo> balancepos = balancedataservice.getAll();
		
		
			for(int i=0;i<balancepos.size();i++){

				temps.add(convertPO(balancepos.get(i)));

			}
		} catch (RemoteException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return temps;
	}
	
	
	
	/**
	 * @author lenovo
	 * @version 2015年12月9日22:26:22
	 * 
	 * 返回所有未审批的付款单
	 */
	@Override
	public ArrayList<Balancevo> viewAllCostSubmitted(){
      ArrayList<Balancevo> temps=new ArrayList<>();
		
		try {
			ArrayList<Balancepo> balancepos = balancedataservice.viewAllCostSubmitted();
		
		
			for(int i=0;i<balancepos.size();i++)
				temps.add(convertPO(balancepos.get(i)));
			
		} catch (RemoteException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return temps;
		
	}
	
	
	
	/**
	 * @author lenovo
	 * @version 2015年12月9日22:27:10
	 * 根据ID审批单据
	 */
	
	@Override
	public void approveCost(String id){
		
		try {
			Balancepo submitted = balancedataservice.findById(id);
			if(submitted!=null){
			submitted.approve();
			balancedataservice.update(submitted, id);
			}
		} catch (RemoteException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}




	@Override
	public double caculatePostManSalary(String id) {
		// TODO Auto-generated method stub
		try {
			return paymentDataservice.caculatePostManSalary(id)*SalarySettingBl.getPostmanWage();
		} catch (RemoteException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return 0;
	}




	@Override
	public double caculateDriverSalary(String turns) {
		// TODO Auto-generated method stub
		return Integer.parseInt(turns)*SalarySettingBl.getDriverWage();
	}




	@Override
	public double caculateFare(String transferID) {
		// TODO Auto-generated method stub
		return 0;
	}




	@Override
	public double caculateClerkSalary() {
		// TODO Auto-generated method stub
		return SalarySettingBl.getClerkSalary();
	}


	@Override
	public ArrayList<Balancevo> viewCostByDate() {
		// TODO Auto-generated method stub
		ArrayList<Balancevo> costs = new  ArrayList<>();
		ArrayList<Balancepo> costList;
		try {
			costList = balancedataservice.getCostByDate();
			
		    for(int i=0;i<costList.size();i++){
			   costs.add(convertPO(costList.get(i)));
		}
			
			
		} catch (RemoteException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return costs;
	}
	
}
