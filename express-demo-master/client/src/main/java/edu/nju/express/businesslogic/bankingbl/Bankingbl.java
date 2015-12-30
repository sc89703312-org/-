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
import static edu.nju.express.init.RMIHelper.bankingDataService;
/**
 * 
 * @author ShiroKo
 * @version 2015-12-9 22:47
 * 
 *  银行账户的业务逻辑模块，用于实现银行账户的增删改查
 *
 */

public class Bankingbl implements BankingBlService, BankingInfo{
	
	/* 银行账户模块的数据层接口 */
	
	
	/*
	 * 构造方法
	 */
	public Bankingbl(){
		
	}

	/*
	 * (non-Javadoc)
	 * @see edu.nju.express.blservice.BankingBlService#addAccount(java.lang.String)
	 * @author ShiroKo
	 * @version 2015-12-9 22:49
	 */
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

	/*
	 * (non-Javadoc)
	 * @see edu.nju.express.blservice.BankingBlService#removeAccount(java.lang.String)
	 * 	 * @author ShiroKo
	 * @version 2015-12-9 22:49
	 */
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

	/*
	 * (non-Javadoc)
	 * @see edu.nju.express.blservice.BankingBlService#modifyAccount(java.lang.String, java.lang.String)
	 * 	 * @author ShiroKo
	 * @version 2015-12-9 22:49
	 */
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

	/*
	 * (non-Javadoc)
	 * @see edu.nju.express.blservice.BankingBlService#showAccount(java.lang.String)
	 * 	 * @author ShiroKo
	 * @version 2015-12-9 22:49
	 */
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
	
	/*
	 * (non-Javadoc)
	 * @see edu.nju.express.businesslogic.paymentbl.Info.BankingInfo#modify(int, java.lang.String)
	 * 	 * @author ShiroKo
	 * @version 2015-12-9 22:49
	 */
	@Override
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
	
    /*
     * (non-Javadoc)
     * @see edu.nju.express.businesslogic.paymentbl.Info.BankingInfo#getMoney(java.lang.String)
     * 	 * @author ShiroKo
	 * @version 2015-12-9 22:49
     */
	@Override
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

	/*
	 * (non-Javadoc)
	 * @see edu.nju.express.blservice.BankingBlService#getAllAccounts()
	 * 	 * @author ShiroKo
	 * @version 2015-12-9 22:49
	 */
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
