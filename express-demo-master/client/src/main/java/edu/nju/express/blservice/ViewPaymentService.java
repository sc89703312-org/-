package edu.nju.express.blservice;

import java.util.ArrayList;

import edu.nju.express.vo.Paymentvo;

/**
 * 
 * @author lenovo
 * @version 2015年12月9日21:54:15
 * 
 * 
 * 主要是财务人员进行收款单查看
 * 
 * 可以有按照日期查看所有营业厅的收款单 
 * 
 * 也可以按照营业厅查看所有的收款单
 * 
 * 并具有对收款单进行合计的功能
 */

public interface ViewPaymentService {


	/**
	 * @author lenovo
	 * @param  String number   营业厅编号
	 * @return  ArrayList<PaymentVO> 收款单的列表
	 * @version 2015年12月9日21:55:58
	 */
	public ArrayList<Paymentvo> viewByHall(String number);
	
	

	/**
	 * @author lenovo
	 * @param  String date  日期
	 * @return  ArrayList<PaymentVO> 收款单列表
	 * @version 2015年12月9日21:57:35
	 */
	public ArrayList<Paymentvo> viewByDate(String date);
	
	

	/**
	 * @author lenovo
	 * @param  
	 * @return  ArrayList<PaymentVO> 收款单列表
	 * @version 2015年12月9日21:58:16
	 */
	public ArrayList<Paymentvo> getAll();
	
	

	/**
	 * @author lenovo
	 * @param  营业厅编号
	 * @return double 按营业厅合计收款单
	 * @version 2015年12月9日22:00:01
	 */
	
	public double sumPaymentByHall(String number);
	
	
	
	
	

	/**
	 * @author lenovo
	 * @param  日期
	 * @return  double  按照日期进行收款单合计
	 * @version 2015年12月9日22:00:43
	 */
	public double sumPaymentByDay(String date);
	
	
	public void endView();
}
