package edu.nju.express.data.stationdata;

import java.util.ArrayList;

import edu.nju.express.common.ResultMessage;
import edu.nju.express.po.ArriveReceiptPO;

public interface ArriveReceiptDao {

	public ResultMessage add(ArriveReceiptPO po);
	public String getNextID(String stationID,String location);
	public ArrayList<ArriveReceiptPO> getAllReceipt(String location);
	public ArrayList<ArriveReceiptPO> getAllReceipt();
	public ArrayList<ArriveReceiptPO> getSummitArrive();
	public ArrayList<ArriveReceiptPO> getApproveArrive(String stationID);
	public ResultMessage approve(String id);
	public void flush();
	public void handle(String id);
	
}
