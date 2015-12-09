package edu.nju.express.blservice;

import java.util.ArrayList;
import edu.nju.express.vo.*;
import edu.nju.express.common.*;



public interface OrderBLService {
	
	/**创建订单
	 * @author guhan
	 * @param vo 订单的界面信息包
	 * @return 如果创建的订单号格式不对或已经存在，返回INVALID
	 */
	public ResultMessage createOrder(OrderVO vo);
	
	/**按ID获取订单的VO
	 * @author guhan
	 * @param id 订单号
	 * @return 订单的VO
	 */
	public OrderVO view(String id);
	
	/**获得已有的所有订单号的list
	 * @author guhan
	 * @return 订单的list
	 */
	public ArrayList<OrderVO> viewAll();
	
	/**确认收货，快递员确认
	 * @author guhan
	 * @param id 订单号
	 */
	public void receiverCfm(String id);
	
	/**打印一句话：结束创建订单
	 * @author guhan
	 */
	public void endOrder();
	
	
}
