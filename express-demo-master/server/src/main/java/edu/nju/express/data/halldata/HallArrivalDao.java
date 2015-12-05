package edu.nju.express.data.halldata;

import java.util.ArrayList;

import edu.nju.express.common.ResultMessage;
import edu.nju.express.po.ArrivalReceiptPO;

public interface HallArrivalDao {
	public ResultMessage insert(ArrivalReceiptPO po);
	public ResultMessage delete(String id);
	public ArrivalReceiptPO find (String id);
	public String nextID(String location, String hallID);
	public ArrayList<ArrivalReceiptPO> getAll(String location);
	public ArrayList<ArrivalReceiptPO> getAllSummit();
	public ArrayList<ArrivalReceiptPO> getAllReceipt();
	public ArrayList<ArrivalReceiptPO> showAll();
	public void approve(String id);
	public void flush();
}
