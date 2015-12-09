package edu.nju.express.businesslogic.paymentbl.Info;

import java.util.ArrayList;



import edu.nju.express.vo.BankingAccountVO;


/**
 * 
 * @author lenovo
 * @version 2015年12月9日22:39:46
 * 
 * 用于为收款单模块提供所有的银行信息以及修改银行账户余额的方法
 */
public interface BankingInfo {

	/**
	 * 
	 * @param pay
	 * @param account
	 * 修改银行账户余额
	 */
	public void modify(int pay,String account) ;
	
	
	/**
	 * 
	 * @return 获得所有的银行账户 
	 */
	public ArrayList<BankingAccountVO> getAllAccounts();
	
	
	/**
	 * 
	 * @param account
	 * @return 获取对应银行账户内的余额
	 */
	public int getMoney(String account);
}
