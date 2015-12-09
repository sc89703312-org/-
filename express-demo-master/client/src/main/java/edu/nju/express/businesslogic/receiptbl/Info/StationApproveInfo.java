package edu.nju.express.businesslogic.receiptbl.Info;

import java.util.ArrayList;

import edu.nju.express.common.ResultMessage;
import edu.nju.express.vo.ArriveReceiptVO;
import edu.nju.express.vo.TransferReceiptVO;

/**
 * 单据模块用到的所有中转站模块的接口
 * @author Dora
 * @version 2015-12-9 22:47:45
 */
public interface StationApproveInfo {

	/**
	 * 查看所有未审批的中转站到达单
	 * @author Dora
	 * @return
	 */
	public ArrayList<ArriveReceiptVO> viewAllArriveReceiptSubmitted();
	
	/**
	 * 审批通过通过中转站到达单
	 * @author Dora
	 * @param id
	 * @return 操作是否有效
	 */
	public ResultMessage approveArriveReceipt(String id);
	
	/**
	 * 查看所有到达单
	 * @author Dora
	 * @return
	 */
	public ArrayList<ArriveReceiptVO> viewAllArriveReceipt();
	
	/**
	 * 查看所有未审批的中转单
	 * @author Dora
	 * @return
	 */
	public ArrayList<TransferReceiptVO> viewAllTransferReceiptSubmitted();
	
	/**
	 * 审批一个中转单
	 * @author Dora
	 * @param id
	 * @return 操作是否有效
	 */
	public ResultMessage approveTransferReceipt(String id);
	
	/**
	 * 查看所有中转单
	 * @author Dora
	 * @return
	 */
	public ArrayList<TransferReceiptVO> viewAllTransferReceipt();
}
