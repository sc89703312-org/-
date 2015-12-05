package edu.nju.express.data.halldata;

import java.util.ArrayList;

import edu.nju.express.common.ResultMessage;
import edu.nju.express.po.DeliverReceiptPO;

public interface HallDeliverDao {

	public ResultMessage insert(DeliverReceiptPO po);
	public ResultMessage delete(String id);
	public String nextID(String location,String hallID);
	public DeliverReceiptPO find(String id);
	public ArrayList<DeliverReceiptPO> getAllReceipt();
	public ArrayList<DeliverReceiptPO> getAll(String location);
	public ArrayList<DeliverReceiptPO> getAllSummit();
	public ArrayList<DeliverReceiptPO> showAll();
	public void approveDeliverReceipt(String id);
	public void flush();
}
