package edu.nju.express.blservice;

import java.util.ArrayList;

import edu.nju.express.common.Etype;
import edu.nju.express.common.ResultMessage;
import edu.nju.express.vo.ArriveReceiptVO;
import edu.nju.express.vo.OrderVO;
import edu.nju.express.vo.TransferReceiptVO;

/**
 * 
 * @author ShiroKo
 * @version 2015-12-9 22:09
 * 
 * 中转中心模块的业务逻辑接口，用于实现中转中心相关单据的生成与提交
 *
 */


public interface StationReceiptBlService {
	
	/** 获得根据中转单或营业厅装车单ID生成的中转中心到达单
	 * 
	 * @param id 中转单或营业厅装车单ID
	 * @return 生成的到达单VO
	 */
	public ArriveReceiptVO creatArriveReceipt(String id);
	
	/** 提交一个中转中心到达单
	 * 
	 * @param vo 一个中转中心到达单的VO
	 */
	public void subArriveReceipt(ArriveReceiptVO vo);
	
	/** 获得该中转中心内所有的订单
	 * 
	 * @return 订单VO的ArrayList
	 */
	public ArrayList<OrderVO> showCurrentOrder();
	
	/** 生成并提交一个中转单
	 * 
	 * @param orderlist 中转的所有订单的ArrayList
	 * @param to 目的地
	 * @param transportID 货运编号
	 * @param supervisor 监装员
	 * @param etype 货运类型
	 */
	public void subTransferReceipt(ArrayList<OrderVO> orderlist, String to, String transportID, String supervisor, Etype etype);
	
}
