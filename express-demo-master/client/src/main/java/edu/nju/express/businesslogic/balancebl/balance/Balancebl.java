package edu.nju.express.businesslogic.balancebl.balance;

import java.util.ArrayList;

import edu.nju.express.blservice.Balanceblservice;
import edu.nju.express.businesslogic.balancebl.Caculate;
import edu.nju.express.businesslogic.balancebl.CostList.CostList;
import edu.nju.express.businesslogic.balancebl.PaymentList.PaymentList;
import edu.nju.express.log.LogController;
import edu.nju.express.po.LogMessage;
import edu.nju.express.po.LoginInfo;
import edu.nju.express.vo.Balancevo;
import edu.nju.express.vo.Paymentvo;

 /**
  * 
  * @author lenovo
  * @version 2015年12月9日22:19:43
  * 
  * 进行成本管理
  */



public class Balancebl implements Balanceblservice{

	/**
	 * 收款单列表
	 * 
	 */
	PaymentList paymentList;
	
	/**付款单列表*/
	CostList  costList;
	
	
	public Balancebl(PaymentList paymentList,CostList costList) {
		// TODO Auto-generated constructor stub
	
		
		this.paymentList = paymentList;
		
		this.costList = costList;
		
	}
	
	
	
	
	
	/**
	 * @author lenovo
	 * @version 2015年12月9日22:20:50
	 */
	

	@Override
	public ArrayList<Paymentvo> viewReport(String start, String end) {
		// TODO Auto-generated method stub
		
		
		return paymentList.getListByDate(start, end);
	}

	
	/**
	 * @author lenovo
	 * @version 2015年12月9日22:21:22
	 */
	@Override
	public ArrayList<Balancevo> viewCost(String start, String end) {
		// TODO Auto-generated method stub
		
		
      return costList.getListByDate(start, end);
	}
	
	

	
	/**
	 * @author lenovo
	 * @version 2015年12月9日22:21:22
	 */

	@Override
	public void endBalance() {
		// TODO Auto-generated method stub
		
	}




	
	/**
	 * @author lenovo
	 * @version 2015年12月9日22:21:22
	 */

	@Override
	public double[] viewBalance() {
		// TODO Auto-generated method stub
		
		double temp [] = new double[3];
		
		temp[0] = Caculate.caculatePay(paymentList.getList());
		
		temp[1] = Caculate.caculateCost(costList.getList());
		
		temp[2] = temp[0] - temp[1];
		
		LogController.insertLog(new LogMessage("结算成本收入", LoginInfo.getUserName()));
		
		return temp;
	}

}
