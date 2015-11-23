package edu.nju.express.data.halldata;

import java.util.ArrayList;

import edu.nju.express.po.DeliverReceiptPO;

public interface HallDeliverDao {

	public void insert(DeliverReceiptPO po);
	public void delete(String id);
	public DeliverReceiptPO find(String id);
	public ArrayList<DeliverReceiptPO> getAll();
	public void approveDeliverReceipt(ArrayList<DeliverReceiptPO> list);
}
