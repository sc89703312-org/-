package edu.nju.express.businesslogic.hallbl.info;

import java.util.ArrayList;

/**
 * 
 * @author ShiroKo
 * @version 2015-12-9
 * 
 *  营业厅收款单对应的订单ID获取方法的接口
 *
 */

public interface PaymentOrderInfo {

	/** 获得营业厅收款单对应的订单ID
	 * 
	 * @param HallId 营业厅ID
	 * @return 订单的ID的ArrayList
	 */
	public ArrayList<String> getOrderListByHall(String HallId);
}
