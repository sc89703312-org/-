package edu.nju.express.data.commoditydata;

import java.util.ArrayList;

import edu.nju.express.common.ResultMessage;
import edu.nju.express.po.EnterReceiptPO;

public interface EnterReceiptDao {

	public void add(EnterReceiptPO po);
	public ArrayList<EnterReceiptPO> showAll();
	public ArrayList<EnterReceiptPO> showAll(String comID);
	public ArrayList<EnterReceiptPO> showAllSummit();
	public ResultMessage approve(String id);
	
}
