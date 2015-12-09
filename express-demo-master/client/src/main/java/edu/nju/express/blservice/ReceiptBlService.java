package edu.nju.express.blservice;

import java.util.ArrayList;

import edu.nju.express.common.ResultMessage;
import edu.nju.express.vo.ReceiptVOBase;
/**
 * 处理总经理单据管理界面的操作
 * @author Dora
 * @version 2015-12-9 21:23:01
 */

public interface ReceiptBlService{


	/**
	 * 查看所有单据
	 * @author Dora
	 * @return 所有单据vo的集合
	 */
	public ArrayList<ReceiptVOBase> view();
	
	/**
	 * 审批通过一个单据
	 * @author Dora
	 * @param id	单据的id
	 */
	public void approve(String id);
	
	/**
	 * 修改一个单据
	 * @author Dora
	 * @param vo	单据填写信息的vo
	 * @return 操作是否有效
	 */
	public ResultMessage modify(ReceiptVOBase vo);
	
	

}
