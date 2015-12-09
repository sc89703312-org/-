package edu.nju.express.businesslogic.receiptbl.Info;

import java.util.ArrayList;

import edu.nju.express.common.ResultMessage;
import edu.nju.express.vo.EnterReceiptVO;
import edu.nju.express.vo.ExitReceiptVO;

/**
 * 单据模块所用到的库存接口
 * @author Dora
 * @version 2015-12-9 22:33:43
 */
public interface CommodityApproveInfo {

	/**
	 * 查看所有未审批的入库单
	 * @author Dora
	 * @return
	 */
	public ArrayList<EnterReceiptVO> viewAllEnterReceiptSubmitted();
	
	/**
	 * 根据id审批通过一个入库单
	 * @author Dora
	 * @param id
	 * @return 操作是否有效
	 */
	public ResultMessage approveEnterReceipt(String id);
	
	/**
	 * 查看所有入库单
	 * @author Dora
	 * @return 操作是否有效
	 */
	public ArrayList<EnterReceiptVO> viewAllEnterReceipt();
	
	/**
	 * 查看所有未审批的出库单
	 * @author Dora
	 * @return 操作是否有效
	 */
	public ArrayList<ExitReceiptVO> viewAllExitReceiptSubmitted();
	
	/**
	 * 审批出库单
	 * @author Dora
	 * @param id
	 * @return 操作是否有效
	 */
	public ResultMessage approveExitReceipt(String id);
	
	/**
	 * 查看所有出库单
	 * @author Dora
	 * @return 操作是否有效
	 */
	public ArrayList<ExitReceiptVO> viewAllExitReceipt();
}
