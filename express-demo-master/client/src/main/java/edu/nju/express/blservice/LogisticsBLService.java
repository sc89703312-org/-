package edu.nju.express.blservice;

import edu.nju.express.vo.LogisticsVO;




public interface LogisticsBLService {

	/**按订单号查看一个订单的物流信息
	 * @author guhan
	 * @param id 订单号
	 * @return 物流信息的信息包
	 */
	public LogisticsVO view(String id);
	
}
