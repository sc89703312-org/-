package edu.nju.express.blservice;

import java.util.ArrayList;

import edu.nju.express.common.ResultMessage;
import edu.nju.express.vo.ReceiptVOBase;



public interface ReceiptBlService{

	

	
	public ArrayList<ReceiptVOBase> view();
	
	public void approve(ArrayList<ReceiptVOBase> list);
	
	public ResultMessage modify(ReceiptVOBase vo);
	
	

}
