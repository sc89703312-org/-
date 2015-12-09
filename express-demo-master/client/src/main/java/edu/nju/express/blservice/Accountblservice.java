package edu.nju.express.blservice;

import edu.nju.express.vo.Accountvo;


/**
 * 
 * @author lenovo
 * @version 2015年12月9日20:49:34
 * 
 * 
 * 界面创建账目的接口
 * 
 * 主要方法是创建账目、按照日期查看账目以及结束期初建账的任务
 * 
 * 
 */

public interface Accountblservice {

	/**
	 * @author lenovo
	 * @return
	 * @param
	 * @version 2015年12月9日20:54:07
	 * 
	 * 根据当前日期创建一个新的账目列表
	 */
	public void createAccount();
	
	
	
	
	/**
	 * @author lenovo
	 * @return  AccountVO 即账目的ValueObject 返回给界面显示
	 * @param   Date  选择查看账目日期   一个日期对应账目的ID
	 * @version  2015年12月9日20:55:04
	 * 
	 * 
	 */
	public Accountvo viewAccount(String date);
	
	
	/**
	 * @author lenovo
	 * @return
	 * @param
	 * @version 2015年12月9日20:56:04
	 * 
	 * 
	 */
	public void endAccount();
	
	
}
