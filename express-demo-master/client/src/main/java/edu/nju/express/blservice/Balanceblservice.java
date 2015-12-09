package edu.nju.express.blservice;

import java.util.ArrayList;

import edu.nju.express.vo.Balancevo;
import edu.nju.express.vo.Paymentvo;

/**
 * 财务人员进行成本管理的接口
 * 用于生成收入、支出和利润
 * 还用于查看选定日期内的收款单和付款单列表
 * 
 * 
 * 
 * 
 * 
 * @author lenovo
 * 
 * 
 * @version 2015年12月9日20:58:22
 * 
 * 
 */


public interface Balanceblservice {

	
	/**
	 * @author lenovo
	 * @return double[]  double[0]为总收入  double[1]为总支出   double[2]为总利润
	 * @param
	 * @version  2015年12月9日20:58:27
	 * 
	 * 
	 */
	public double[] viewBalance();
	
	/**
	 * @author lenovo
	 * @return ArrayList<PaymentVO> 对应时间段内的收款单列表
	 * @param  String start   表示起始时间      String end       表示终止时间
	 * @version 2015年12月9日20:59:39
	 * 
	 * 
	 */
	public ArrayList<Paymentvo>viewReport(String start ,String end);
	
	
	
	
	/**
	 * @author lenovo
	 * @return ArrayList<PaymentPO> 对应时间段内的付款单列表
	 * @param  String start   表示起始时间      String end       表示终止时间
	 * @version  2015年12月9日20:59:42
	 * 
	 * 
	 */
	public ArrayList<Balancevo> viewCost(String start,String end);
	
	
	
	/**
	 * @author lenovo
	 * @return 
	 * @param  
	 * @version 2015年12月9日21:00:04
	 * 
	 * 
	 */
	public void endBalance();
}
