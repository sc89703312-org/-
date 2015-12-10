package edu.nju.express.businesslogic.receiptbl;

import java.util.ArrayList;

import edu.nju.express.blservice.ReceiptBlService;
import edu.nju.express.businesslogic.DataFactory;
import edu.nju.express.common.ResultMessage;
import edu.nju.express.vo.ReceiptVOBase;
/**
 * 
 * @author lenovo
 * @version 2015年12月10日11:37:25
 * 
 * 总经理进行单据审批 
 */
public class ReceiptController implements ReceiptBlService{

	private ReceiptBlService receiptBL;
	
	
	public ReceiptController() {
		// TODO Auto-generated constructor stub
	
	receiptBL = DataFactory.createReceiptBlInstance();
	
	}
	
	
	@Override
	public ArrayList<ReceiptVOBase> view() {
		// TODO Auto-generated method stub
		return receiptBL.view();
	}

	@Override
	public void approve(String id) {
		// TODO Auto-generated method stub
		receiptBL.approve(id);
	}

	@Override
	public ResultMessage modify(ReceiptVOBase vo) {
		// TODO Auto-generated method stub
		return null;
	}

}
