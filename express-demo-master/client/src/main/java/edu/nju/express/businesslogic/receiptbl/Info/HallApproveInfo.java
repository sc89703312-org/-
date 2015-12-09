package edu.nju.express.businesslogic.receiptbl.Info;

import java.util.ArrayList;

import edu.nju.express.vo.ArrivalReceiptVO;
import edu.nju.express.vo.DeliverReceiptVO;
import edu.nju.express.vo.HallTransferReceiptVO;

/**
 * 单据模块用到的营业厅模块接口
 * @author Dora
 * @version 2015-12-9 22:45:16
 */
public interface HallApproveInfo {

	/**
	 * 查看所有未审批的营业厅到达单
	 * @author Dora
	 * @return 到达单vo的集合
	 */
	public ArrayList<ArrivalReceiptVO> viewAllArrivalReceiptSubmitted();
	
	/**
	 * 审批通过一个营业厅到达单
	 * @author Dora
	 * @param id
	 */
	public void approveArrivalReceipt(String id);
	
	/**
	 * 查看所有营业厅到达单
	 * @author Dora
	 * @return 所有营业厅到达单vo的集合
	 */
	public ArrayList<ArrivalReceiptVO> viewAllArrivalReceipt();
	
	/**
	 * 查看所有营业厅装车单
	 * @author Dora
	 * @return 营业厅装车单vo的集合
	 */
    public ArrayList<HallTransferReceiptVO> viewAllHallTransferReceiptSubmitted();
	
    /**
     * 通过一个营业厅装车单
     * @author Dora
     * @param id
     */
	public void approveHallTransferReceipt(String id);
	
	/**
	 * 查看所有营业厅装车单
	 * @author Dora
	 * @return
	 */
	public ArrayList<HallTransferReceiptVO> viewAllHallTransferReceipt();
	
	/**
	 * 查看所有派件单
	 * @author Dora
	 * @return
	 */
	public ArrayList<DeliverReceiptVO> viewAllDeliverReceiptSubmitted();
	
	/**
	 * 审批一个派件单
	 * @author Dora
	 * @param id
	 */
	public void approveDeliverReceipt(String id);
	
	/**
	 * 查看所有派件单
	 * @author Dora
	 * @return
	 */
	public ArrayList<DeliverReceiptVO> viewAllDeliverReceipt();
	
}
