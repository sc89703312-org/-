package edu.nju.express.data.commoditydata;

import java.util.ArrayList;

import edu.nju.express.common.ResultMessage;
import edu.nju.express.po.ExitReceiptPO;

public interface ExitReceiptDao {

	public void add(ExitReceiptPO po);
	public ArrayList<ExitReceiptPO> showAllReceipt();
	public ArrayList<ExitReceiptPO> showAllReceipt(String comID);
	public ArrayList<ExitReceiptPO> showAllSummit();
	public ResultMessage approve(String id);
	public String nextID(String comID);
	
	public void flush();
}
