package edu.nju.express.businesslogic.balancebl.CostList.Info;

import java.util.ArrayList;

import edu.nju.express.vo.Balancevo;
/**
 * 
 * @author lenovo
 * @version 2015年12月9日22:28:02
 * 
 * 获得所有的付款单的接口
 */
public interface CostControlInfo {
/**
 * @author lenovo
 * @return 返回所有的付款单
 */
	public ArrayList<Balancevo> viewAllCost();
}
