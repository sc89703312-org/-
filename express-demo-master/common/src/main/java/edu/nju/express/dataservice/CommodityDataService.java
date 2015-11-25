package edu.nju.express.dataservice;

import java.rmi.Remote;
import java.rmi.RemoteException;
import java.util.ArrayList;

import edu.nju.express.po.ComGoodsPO;
import edu.nju.express.po.ComInfoPO;
import edu.nju.express.po.ComZonePO;
import edu.nju.express.po.EnterReceiptPO;
import edu.nju.express.po.ExitReceiptPO;



public interface CommodityDataService extends Remote{
	
	public ComInfoPO getCom(String comID) throws RemoteException;
	public String getLocation(String comID) throws RemoteException;
	public ComZonePO getZone(String comID) throws RemoteException;
	public void addGoods(String comID, EnterReceiptPO po) throws RemoteException;
	public void removeGoods(String comID, ExitReceiptPO po) throws RemoteException;
	public ComGoodsPO getGoods(String comID, String orderID) throws RemoteException;
	public void modifyZone(String comID, int[] space) throws RemoteException;
	
	public void addCommodity(String comID, String location) throws RemoteException;
	public void removeCommodity(String comID) throws RemoteException;
	public ArrayList<ComInfoPO> getCommodity() throws RemoteException;
	public void moveGoods(String comID, Object data[][]);
	
	public void addEnterReceipt(String comID, EnterReceiptPO po) throws RemoteException;
	public String getNextEnterID(String comID) throws RemoteException;
	public ArrayList<EnterReceiptPO> getEnterReceipt(String comID) throws RemoteException;
	public void modifyEnterReceipt(String id, EnterReceiptPO po) throws RemoteException;
	public void approveEnterReceipt(ArrayList<EnterReceiptPO> list) throws RemoteException;
	
	public void addExitReceipt(String comID, ExitReceiptPO po) throws RemoteException;
	public String getNextExitID(String comID) throws RemoteException;
	public ArrayList<ExitReceiptPO> getExitReceipt(String comID) throws RemoteException;
	public void modifyExitReceipt(String id, ExitReceiptPO po) throws RemoteException;
	public void approveExitReceipt(ArrayList<ExitReceiptPO> list) throws RemoteException;

}
