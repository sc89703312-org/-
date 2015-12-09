package edu.nju.express.businesslogic.receiptbl.Info;

import java.util.ArrayList;

import edu.nju.express.vo.Paymentvo;

/**
 * 单据模块用到的成本管理模块的接口
 * @author Dora
 * @version 2015-12-9 22:46:05
 */
public interface PaymentApproveInfo {

	/**
	 * 查看所有未审批的付款单
	 * @author Dora
	 * @return 未审批付款单vo的集合
	 */
	public ArrayList<Paymentvo> viewAllPaymentSubmitted();
	
	/**
	 * 审批一个付款单
	 * @author Dora
	 * @param id
	 */
	public void approvePayment(String id);
	
	/**
	 * 查看所有付款单
	 * @author Dora
	 * @return
	 */
	public ArrayList<Paymentvo> viewAll();
}
