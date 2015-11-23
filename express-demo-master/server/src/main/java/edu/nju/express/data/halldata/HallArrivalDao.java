package edu.nju.express.data.halldata;

import java.util.ArrayList;

import edu.nju.express.po.ArrivalReceiptPO;

public interface HallArrivalDao {
	public void insert(ArrivalReceiptPO po);
	public void delete(String id);
	public ArrivalReceiptPO find (String id);
	public ArrayList<ArrivalReceiptPO> getAll();
	public void approveArrivalReceipt(ArrayList<ArrivalReceiptPO> list);
}
