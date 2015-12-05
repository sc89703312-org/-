package edu.nju.express.data.stationdata;

import java.util.ArrayList;

import edu.nju.express.common.ResultMessage;
import edu.nju.express.po.TransferReceiptPO;

public interface TransferReceiptDao {

	public ResultMessage add(TransferReceiptPO po);
	public String getNextID(String stationID);
	public ArrayList<TransferReceiptPO> getAllReceipt(String stationID);
	public ArrayList<TransferReceiptPO> getAllReceipt();
	public ArrayList<TransferReceiptPO> getSummitTransfer();
	public ArrayList<TransferReceiptPO> getApproveTransfer(String stationID);
	public ResultMessage approve(String id);
	public TransferReceiptPO getTransfer(String id);
	
}
