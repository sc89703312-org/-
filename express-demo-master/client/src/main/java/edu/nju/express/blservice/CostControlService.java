package edu.nju.express.blservice;

import java.util.ArrayList;

import edu.nju.express.common.Etype;
import edu.nju.express.common.ResultMessage;
import edu.nju.express.vo.Balancevo;

/**
 * @author lenovo 
 * @version 2015年12月9日21:04:17
 * 
 * 
 * 
 * 用于财务人员进行生成付款单的操作
 * 主要有生成付款单   查看所有的付款单    
 * 以及计算各类人员的工资和各种付款
 * 
 */

public interface CostControlService {
	
	
	/**
	 * @author lenovo
	 * @return  ResultMessage  表示新建付款单是否合法
	 * @param   BalanceVO  界面层传来的打包好的VO
	 * @version 2015年12月9日21:06:01
	 * 
	 * 
	 */
	public ResultMessage createCost(Balancevo vo);
	public void endCostControl();
	
	
	
	/**
	 * @author lenovo
	 * @return ArrayList<BalanceVO> 返回所有的付款单
	 * @param  
	 * @version 2015年12月9日21:06:41
	 * 
	 * 
	 */
	public ArrayList<Balancevo> viewAllCost();
	
	
	
	
	/**
	 * @author lenovo
	 * @return double  根据具体的快递员编号进行计算
	 * @param  String id     快递员编号 
	 * @version 2015年12月9日21:07:09
	 * 
	 * 
	 */
	public double caculatePostManSalary(String id);
	
	
	
	
	/**
	 * @author lenovo
	 * @return  double   根据次数计算出司机的工资
	 * @param   Stirng turns     司机运送次数
	 * @version  2015年12月9日21:07:43
	 * 
	 * 
	 */
	public double caculateDriverSalary(String turns);
	
	
	
	
	/**
	 * @author lenovo
	 * @return  double  根据装车单号来计算某次运输费用
	 * @param   String transferID   装车单号
	 * @version 2015年12月9日21:08:18
	 * 
	 * 
	 */
	public double caculateFare(String transferID);
	
	
	
	/**
	 * @author lenovo
	 * @return  double   计算业务员的月工资
	 * @param  
	 * @version 2015年12月9日21:09:06
	 * 
	 * 
	 */
	public double caculateClerkSalary();
}
