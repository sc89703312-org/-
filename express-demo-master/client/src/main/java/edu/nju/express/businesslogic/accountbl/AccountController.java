package edu.nju.express.businesslogic.accountbl;



import edu.nju.express.blservice.Accountblservice;
import edu.nju.express.businesslogic.DataFactory;

import edu.nju.express.vo.Accountvo;

/**
 * 
 * @author lenovo
 * @version 2015年12月10日10:50:52
 * 
 * 用于控制Account的界面层和业务逻辑层交互
 */

public class AccountController implements Accountblservice {

	/** Account的业务逻辑 */
	private Accountblservice accountbl;
	
	public AccountController() {
		// TODO Auto-generated constructor stub
	
	accountbl = DataFactory.createAccountblInstance();
	}

	/**
	 * 期初建账
	 */
	@Override
	public void createAccount() {
		// TODO Auto-generated method stub
		accountbl.createAccount();
	}

	/**
	 * @author lenovo
	 * @version 2015年12月10日10:56:01
	 * 查看账目
	 */
	@Override
	public Accountvo viewAccount(String date) {
		// TODO Auto-generated method stub
		return accountbl.viewAccount(date);
	}

	@Override
	public void endAccount() {
		// TODO Auto-generated method stub
		accountbl.endAccount();
	}
	
	
	

}
