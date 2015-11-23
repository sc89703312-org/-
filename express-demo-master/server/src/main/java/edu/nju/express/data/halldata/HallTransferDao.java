package edu.nju.express.data.halldata;

import java.util.ArrayList;

import edu.nju.express.po.HallTransferReceiptPO;

public interface HallTransferDao {
	public void insert(HallTransferReceiptPO po);
	public void delete(String id);
	public HallTransferReceiptPO find(String id);
	public ArrayList<HallTransferReceiptPO> getAll();
	public void approveTransferReceipt(ArrayList<HallTransferReceiptPO> list);
}
