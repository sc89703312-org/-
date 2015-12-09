package edu.nju.express.businesslogic.balancebl;

import java.util.ArrayList;

import edu.nju.express.vo.Balancevo;
import edu.nju.express.vo.Paymentvo;

/**
 * 
 * @author lenovo
 * @version 2015年12月9日22:33:36
 * 
 * 计算的辅助类 用于结算按不同方式列出的收款单合计   以及计算成本  收入和利润
 */


public class Caculate {

	/** 计算结果*/
	static double answer=0;
	
	/** 
	 * 
	 * @param list
	 * @return double  根据传进的List生成对应的首款合计
	 */
	public static double caculatePay(ArrayList<Paymentvo> list){
		
		answer = 0;
		
		for(int i=0;i<list.size();i++)
			answer+= list.get(i).getPay();
		
		
		return answer;
	}
	
	
	
	/**
	 * 
	 * @param list
	 * @return double 根据传进的付款单生成价格
	 */
	public static double caculateCost(ArrayList<Balancevo> list){
		
		answer = 0;
		
		for(int i=0;i<list.size();i++)
			answer+= list.get(i).getMoney();
		
		
		return answer;
			
	}
	
	
}
