package edu.nju.express.businesslogic.bankingbl;

import java.rmi.RemoteException;
import java.util.ArrayList;

import edu.nju.express.blservice.BankingBlService;
import edu.nju.express.businesslogic.paymentbl.Info.BankingInfo;
import edu.nju.express.common.ResultMessage;
import edu.nju.express.dataservice.BankingDataService;
import edu.nju.express.init.RMIHelper;
import edu.nju.express.log.LogController;
import edu.nju.express.po.BankingAccountPO;
import edu.nju.express.po.LogMessage;
import edu.nju.express.po.LoginInfo;
import edu.nju.express.vo.BankingAccountVO;



public class Bankingbl implements BankingBlService, BankingInfo{
	
	BankingDataService bankingDataService;
	
	public Bankingbl(){
		bankingDataService = RMIHelper.getBankingDataService();
	}

	@Override
	public void addAccount(String name) {
		// TODO Auto-generated method stub
		
		try {
			bankingDataService.addAccount(name);
			LogController.insertLog(new LogMessage("添加银行账户", LoginInfo.getUserName()));
		} catch (RemoteException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}

	@Override
	public ResultMessage removeAccount(String name) {
		// TODO Auto-generated method stub
		ResultMessage result = ResultMessage.INVALID;
		
		try {
			result = bankingDataService.removeAccount(name);
			LogController.insertLog(new LogMessage("删除银行账户", LoginInfo.getUserName()));
		} catch (RemoteException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return result;
		
	}

	@Override
	public ResultMessage modifyAccount(String newName, String name) {
		// TODO Auto-generated method stub
		
		ResultMessage result = ResultMessage.INVALID;
		
		try {
			result = bankingDataService.modifyName(newName, name);
			LogController.insertLog(new LogMessage("查找银行账户", LoginInfo.getUserName()));
		} catch (RemoteException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return result;
	}

	@Override
	public ArrayList<BankingAccountVO> showAccount(String subName) {
		// TODO Auto-generated method stub
		
		try {
			ArrayList<BankingAccountPO> poList = bankingDataService.getAccount();
			ArrayList<BankingAccountVO> voList = new ArrayList<BankingAccountVO>();
			for(int i=0;i<poList.size();i++){
				BankingAccountPO tempo = poList.get(i);
				String name = tempo.getName();
				if(name.contains(subName))
					voList.add(new BankingAccountVO(name,tempo.getMoney()));
			}
			return voList;
		} catch (RemoteException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return null;
	}
	
    public void modify(int modify,String name) {
    		
    	try {
		    if(modify>=0)
				bankingDataService.income(name, modify);
			else
		    	bankingDataService.expend(name, -modify);
		} catch (RemoteException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}	
	
	public int getMoney(String name){
			
		int result = -1;
		
		try {
			ArrayList<BankingAccountPO> accountList = bankingDataService.getAccount();
			for(int i=0;i<accountList.size();i++)
				if(accountList.get(i).getName().equals(name))
					result = accountList.get(i).getMoney();
		} catch (RemoteException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return result;

    }

	@Override
	public ArrayList<BankingAccountVO> getAllAccounts() {
		// TODO Auto-generated method stub
		
		try {
			ArrayList<BankingAccountPO>  poList = bankingDataService.getAccount();
			ArrayList<BankingAccountVO> voList = new ArrayList<BankingAccountVO>();
			for(int i=0;i<poList.size();i++){
				voList.add(new BankingAccountVO(poList.get(i).getName(),poList.get(i).getMoney()));
			}
			return voList;
		} catch (RemoteException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return null;
	}
	
}
