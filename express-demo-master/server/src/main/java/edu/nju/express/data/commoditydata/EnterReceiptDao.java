package edu.nju.express.data.commoditydata;

import java.util.ArrayList;

import edu.nju.express.common.ResultMessage;
import edu.nju.express.po.EnterReceiptPO;

public interface EnterReceiptDao {

	public void add(EnterReceiptPO po);
	public ArrayList<EnterReceiptPO> showAllReceipt();
	public ArrayList<EnterReceiptPO> showAllReceipt(String comID);
	public ArrayList<EnterReceiptPO> showAllSummit();
	public ResultMessage approve(String id);
	public String nextID(String comID);
	
	public void flush();
	
}
