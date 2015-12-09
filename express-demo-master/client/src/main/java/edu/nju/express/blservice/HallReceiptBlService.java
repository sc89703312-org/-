package edu.nju.express.blservice;

import java.util.ArrayList;

import edu.nju.express.common.ResultMessage;
import edu.nju.express.vo.ArrivalReceiptVO;
import edu.nju.express.vo.DeliverReceiptVO;
import edu.nju.express.vo.HallTransferReceiptVO;
import edu.nju.express.vo.OrderVO;

public interface HallReceiptBlService {

	
		/**创建一个营业厅的到达单
		 * @author guhan
		 * @param id 营业厅到达单编号
		 * @return 一个到达单的VO
		 */
		public ArrivalReceiptVO createArrivalReceipt(String id);
		
		/**提交一个到达单
		 * @author guhan
		 * @param vo 到达单的信息包
		 */
		public void subArrivalReceipt(ArrivalReceiptVO vo);
		
		/**获取本营业厅滞留的订单单号
		 * @author guhan
		 * @return 订单VO的list
		 */
		public ArrayList<OrderVO> showCurrentOrder();
		
		/**提交一个装车单
		 * @author guhan
		 * @param transportID 汽运编号
		 * @param to 到达地
		 * @param carID 车辆代号
		 * @param supervisor 监装员
		 * @param guard 押运员
		 * @param orderlist 本次装箱所有托运单号
		 */
		public void subHallTransferReceipt(String transportID, String to, String carID, String supervisor, String guard, ArrayList<OrderVO> orderlist);
		
		/**提交一个派件单
		 * @author guhan
		 * @param deliver 派件员
		 * @param orderlist 派件员被分配的订单List
		 */
        public void subDeliverReceipt(String deliver, ArrayList<OrderVO> orderlist);
		
	}
