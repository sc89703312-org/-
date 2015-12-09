package edu.nju.express.businesslogic.commoditybl;

import java.util.ArrayList;

import edu.nju.express.po.OrderPO;
import edu.nju.express.vo.ArriveReceiptVO;
import edu.nju.express.vo.OrderVO;
import edu.nju.express.vo.TransferReceiptVO;

/**
 * 
 * @author ShiroKo
 * @version 2015-12-9 23:17
 * 
 * 中转中心模块与仓库模块相关的业务逻辑接口，获得审批但未处理的单据
 *
 */

public interface StationInfo {
	
	/** 获得所有审批但未处理的到达单
	 * 
	 * @param comID 仓库ID
	 * @return 到达单VO的ArrayList
	 */
	public ArrayList<ArriveReceiptVO> viewApproveArrive(String comID);
	
	/** 获得所有审批但未处理的中转单
	 * 
	 * @param comID 仓库ID
	 * @return 中转单VO的ArrayList
	 */
	public ArrayList<TransferReceiptVO> viewApproveTransfer(String comID);
	
	/** 处理到达单
	 * 
	 * @param id 到达单ID
	 */
	public void handleArrive(String id);
	
	/** 处理中转单
	 * 
	 * @param id 中转单ID
	 */
	public void handleTransfer(String id);

}
