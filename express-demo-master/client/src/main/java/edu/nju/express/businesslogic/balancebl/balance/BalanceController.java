package edu.nju.express.businesslogic.balancebl.balance;

import java.util.ArrayList;



import edu.nju.express.blservice.Balanceblservice;
import edu.nju.express.businesslogic.DataFactory;
import edu.nju.express.vo.Balancevo;
import edu.nju.express.vo.Paymentvo;




/**
 * 
 * @author lenovo
 * @version 2015年12月10日10:59:12
 * 控制成本管理中界面与业务逻辑的交互
 */
public class BalanceController implements Balanceblservice{

	
	
	private Balanceblservice balanceBL;
	private static BalanceController instance;
	
	private BalanceController() {
		// TODO Auto-generated constructor stub
	
		balanceBL = DataFactory.createBalanceBLInstance();
	
	}
	
	
	 public static BalanceController getInstance() 
	{
		return instance = (instance==null)?new BalanceController():instance;
	}
	
	
	/**
	 * 查看支出  收入和利润
	 */
	@Override
	public double[] viewBalance() {
		// TODO Auto-generated method stub
		return balanceBL.viewBalance();
	}

	@Override
	public ArrayList<Paymentvo> viewReport(String start, String end) {
		// TODO Auto-generated method stub
		return balanceBL.viewReport(start, end);
	}

	@Override
	public ArrayList<Balancevo> viewCost(String start, String end) {
		// TODO Auto-generated method stub
		return balanceBL.viewCost(start, end);
	}

	@Override
	public void endBalance() {
		// TODO Auto-generated method stub
		
	}

}
