package edu.nju.express.businesslogic.receiptbl.Info;

import java.util.ArrayList;

import edu.nju.express.vo.Balancevo;
import edu.nju.express.vo.Paymentvo;

/**
 * 单据模块用到的结算模块接口
 * @author Dora
 *
 */
public interface CostApproveInfo {

	/**
	 * 查看所有未审批的收款单
	 * @author Dora
	 * @return 所有收款单的vo集合
	 */
    public ArrayList<Balancevo> viewAllCostSubmitted();
	
    /**
     * 根据id通过一个收款单
     * @author Dora
     * @param id
     */
	public void approveCost(String id);
	
	/**
	 * 查看所有收款单
	 * @author Dora
	 * @return 所有收款单vo的集合
	 */
	public ArrayList<Balancevo> viewAllCost();
}
