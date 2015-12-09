package edu.nju.express.businesslogic.balancebl.PaymentList.Info;

import java.util.ArrayList;

import edu.nju.express.vo.Paymentvo;
/**
 * 
 * @author lenovo
 * @version 2015年12月9日22:29:53
 * 
 * 获得所有的收款单的接口
 */
public interface PaymentInfo {

	
	/**
	 * @author lenovo
	 * @return  所有的收款单
	 */
	
	public ArrayList<Paymentvo> viewAll();
}
