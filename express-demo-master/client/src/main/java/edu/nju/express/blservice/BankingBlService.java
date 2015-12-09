package edu.nju.express.blservice;

import java.util.ArrayList;

import edu.nju.express.common.ResultMessage;
import edu.nju.express.vo.BankingAccountVO;

/**
 * 
 * @author ShiroKo
 *@version 2015-12-9 22:17
 *
 * 银行账户模块的业务逻辑接口，用于进行银行账户名称及余额的增删改查
 *
 */

public interface BankingBlService {
	
	/** 新增一个银行账户
	 * 
	 * @param name 账户名
	 */
	public void addAccount(String name);
	
	/** 删除一个银行账户
	 * 
	 * @param name 账户名
	 * @return 是否删除成功的ResultMessage
	 */
	public ResultMessage removeAccount(String name);
	
	/** 修改一个银行账户的名称
	 * 
	 * @param newName 新名称
	 * @param name 旧名称
	 * @return 是否修改成功的ResultMessage
	 */
	public ResultMessage modifyAccount(String newName, String name);
	
	/** 根据账户名获得相应银行账户
	 * 
	 * @param subName 子名称
	 * @return 银行账户VO的ArrayList
	 */
	public ArrayList<BankingAccountVO> showAccount(String subName);
	
	/** 获得所有银行账户
	 * 
	 * @return 银行账户VO的ArrayList
	 */
	public ArrayList<BankingAccountVO> getAllAccounts();
}
