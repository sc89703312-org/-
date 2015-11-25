package edu.nju.express.data.halldata;

import java.util.ArrayList;

import edu.nju.express.common.ResultMessage;
import edu.nju.express.po.DeliverReceiptPO;

public interface HallDeliverDao {

	public ResultMessage insert(DeliverReceiptPO po);
	public ResultMessage delete(String id);
	public DeliverReceiptPO find(String id);
	public ArrayList<DeliverReceiptPO> getAll();
	public ArrayList<DeliverReceiptPO> showAll();
	public void approveDeliverReceipt(ArrayList<DeliverReceiptPO> list);
	public void flush();
}
