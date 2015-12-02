package edu.nju.express.data.commoditydata;

import java.util.ArrayList;

import edu.nju.express.common.ResultMessage;
import edu.nju.express.po.ExitReceiptPO;

public interface ExitReceiptDao {

	public void add(ExitReceiptPO po);
	public ArrayList<ExitReceiptPO> showAll();
	public ArrayList<ExitReceiptPO> showAll(String comID);
	public ArrayList<ExitReceiptPO> showAllSummit();
	public ResultMessage approve(String id);
	
}
