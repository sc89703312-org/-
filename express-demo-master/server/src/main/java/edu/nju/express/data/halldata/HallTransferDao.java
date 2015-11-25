package edu.nju.express.data.halldata;

import java.util.ArrayList;

import edu.nju.express.common.ResultMessage;
import edu.nju.express.po.HallTransferReceiptPO;

public interface HallTransferDao {
	public ResultMessage insert(HallTransferReceiptPO po);
	public ResultMessage delete(String id);
	public HallTransferReceiptPO find(String id);
	public ArrayList<HallTransferReceiptPO> getAll();
	public ArrayList<HallTransferReceiptPO> showAll();
	public void approveTransferReceipt(ArrayList<HallTransferReceiptPO> list);
	public void flush();
}
