package edu.nju.express.data.halldata;

import java.util.ArrayList;

import edu.nju.express.common.ResultMessage;
import edu.nju.express.po.ArrivalReceiptPO;

public interface HallArrivalDao {
	public ResultMessage insert(ArrivalReceiptPO po);
	public ResultMessage delete(String id);
	public ArrivalReceiptPO find (String id);
	public ArrayList<ArrivalReceiptPO> getAll();
	public ArrayList<ArrivalReceiptPO> showAll();
	public void approveArrivalReceipt(ArrayList<ArrivalReceiptPO> list);
	public void flush();
}
