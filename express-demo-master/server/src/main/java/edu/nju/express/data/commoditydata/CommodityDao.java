package edu.nju.express.data.commoditydata;

import java.util.ArrayList;

import edu.nju.express.po.ComInfoPO;
import edu.nju.express.po.EnterReceiptPO;
import edu.nju.express.po.ExitReceiptPO;



public interface CommodityDao {

	public ComInfoPO getZone(String comID);
	public void addGoods(String comID, EnterReceiptPO po);
	public void removeGoods(String comID, ExitReceiptPO po);
	public void modifyZone(String comID, int[] space);
	
	public void addCommodity(String comID, String location);
	public void removeCommodity(String comID);
	public ArrayList<ComInfoPO> getCommodity();
	
	public void addEnterReceipt(String comID, EnterReceiptPO po);
	public ArrayList<EnterReceiptPO> getEnterReceipt(String comID);
	public void modifyEnterReceipt(String id, EnterReceiptPO po);
	public void approveEnterReceipt(ArrayList<EnterReceiptPO> list);
	
	public void addExitReceipt(String comID, ExitReceiptPO po);
	public ArrayList<ExitReceiptPO> getExitReceipt(String comID);
	public void modifyExitReceipt(String id, ExitReceiptPO po);
	public void approveExitReceipt(ArrayList<ExitReceiptPO> list);
	
}
