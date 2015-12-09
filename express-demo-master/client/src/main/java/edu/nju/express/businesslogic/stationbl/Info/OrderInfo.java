package edu.nju.express.businesslogic.stationbl.Info;

import edu.nju.express.vo.OrderVO;

/**
 * 
 * @author ShiroKo
 * @version 2015-12-9 22:23
 * 
 *  根据订单ID获得订单的功能接口
 *
 */

public interface OrderInfo {

	/** 根据订单ID获得订单
	 * 
	 * @param string 订单ID
	 * @return 订单的VO
	 */
	OrderVO view(String string);
	
}
