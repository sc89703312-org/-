package edu.nju.express.data.halldata;

import java.util.ArrayList;

import edu.nju.express.common.ResultMessage;
import edu.nju.express.po.HallTransferReceiptPO;

public interface HallTransferDao {
	public ResultMessage insert(HallTransferReceiptPO po);
	public ResultMessage delete(String id);
	public String nextID(String location,String hallID);
	public HallTransferReceiptPO find(String id);
	public ArrayList<HallTransferReceiptPO> getAllReceipt();
	public ArrayList<HallTransferReceiptPO> getAll(String location);
	public ArrayList<HallTransferReceiptPO> getAllSummit();
	public ArrayList<HallTransferReceiptPO> showAll();
	public void approveTransferReceipt(String id);
	public HallTransferReceiptPO getHallTransfer(String id);
	public void flush();
}
