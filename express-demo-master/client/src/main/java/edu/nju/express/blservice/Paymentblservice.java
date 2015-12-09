package edu.nju.express.blservice;

import java.util.ArrayList;

import edu.nju.express.common.ResultMessage;
import edu.nju.express.vo.Paymentvo;




/**
 * @author lenovo

 * @version 2015年12月9日21:10:09
 * 
 * 
 * 用于营业厅的业务员对收款单进行创建和查看
 * 
 * 
 * 
 */


public interface Paymentblservice {
	
	
	/**
	 * @author lenovo
	 * @param PaymentVO 界面层打包好的VO
	 * @return ResultMessage   返回新建收款单是否合法
	 * @version 2015年12月9日21:43:03
	 */

	public ResultMessage  createReceipt(Paymentvo vo);
	
	

	/**
	 * @author lenovo
	 * @param   String id   收款单的ID
	 * @return  PaymentVO  将其打包好传回给对应界面
	 * @version  2015年12月9日21:44:29
	 */
	public Paymentvo getPayment(String id);
	
	
	

	/**
	 * @author lenovo
	 * @param  
	 * @return  ArrayList<PaymentVO>  将对应的Payment对象转化为VO的列表返回给界面
	 * @version  2015年12月9日21:44:35
	 */
	public ArrayList<Paymentvo> viewAll();
	
	
	

	/**
	 * @author lenovo
	 * @param 
	 * @return 
	 * @version  2015年12月9日21:45:33
	 */
	public void endPayment();
}
