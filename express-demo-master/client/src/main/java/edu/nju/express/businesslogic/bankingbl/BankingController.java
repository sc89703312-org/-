package edu.nju.express.businesslogic.bankingbl;

import java.util.ArrayList;

import edu.nju.express.blservice.BankingBlService;
import edu.nju.express.businesslogic.DataFactory;
import edu.nju.express.common.ResultMessage;
import edu.nju.express.vo.BankingAccountVO;
/**
 * 
 * @author lenovo
 * @version 2015年12月10日12:01:53
 * 
 * 财务人员进行银行账户管理
 */
public class BankingController implements BankingBlService{

	
	private BankingBlService bankingBL;
	
	public BankingController() {
		// TODO Auto-generated constructor stub
	
		bankingBL = DataFactory.createBankingInstance();
	
	
	}
	@Override
	public void addAccount(String name) {
		// TODO Auto-generated method stub
		bankingBL.addAccount(name);
	}

	@Override
	public ResultMessage removeAccount(String name) {
		// TODO Auto-generated method stub
		return bankingBL.removeAccount(name);
	}

	@Override
	public ResultMessage modifyAccount(String newName, String name) {
		// TODO Auto-generated method stub
		return bankingBL.modifyAccount(newName, name);
	}

	@Override
	public ArrayList<BankingAccountVO> showAccount(String subName) {
		// TODO Auto-generated method stub
		return bankingBL.showAccount(subName);
	}

	@Override
	public ArrayList<BankingAccountVO> getAllAccounts() {
		// TODO Auto-generated method stub
		return bankingBL.getAllAccounts();
	}

}
