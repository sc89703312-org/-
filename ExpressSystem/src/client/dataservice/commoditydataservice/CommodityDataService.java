package client.dataservice.commoditydataservice;

import java.rmi.Remote;
import java.rmi.RemoteException;
import java.util.ArrayList;

import client.po.commoditypo.ComInfoPO;
import client.po.commoditypo.EnterReceiptPO;
import client.po.commoditypo.ExitReceiptPO;

public interface CommodityDataService extends Remote{
	
	public ComInfoPO getZone(String comID) throws RemoteException;
	public void addGoods(String comID, EnterReceiptPO po) throws RemoteException;
	public void removeGoods(String comID, ExitReceiptPO po) throws RemoteException;
	public void modifyZone(String comID, int[] space) throws RemoteException;
	
	public void addCommodity(String comID, String location) throws RemoteException;
	public void removeCommodity(String comID) throws RemoteException;
	public ArrayList<ComInfoPO> getCommodity() throws RemoteException;
	
	public void addEnterReceipt(String comID, EnterReceiptPO po) throws RemoteException;
	public ArrayList<EnterReceiptPO> getEnterReceipt(String comID) throws RemoteException;
	public void modifyEnterReceipt(String id, EnterReceiptPO po) throws RemoteException;
	public void approveEnterReceipt(ArrayList<EnterReceiptPO> list) throws RemoteException;
	
	public void addExitReceipt(String comID, ExitReceiptPO po) throws RemoteException;
	public ArrayList<ExitReceiptPO> getExitReceipt(String comID) throws RemoteException;
	public void modifyExitReceipt(String id, ExitReceiptPO po) throws RemoteException;
	public void approveExitReceipt(ArrayList<ExitReceiptPO> list) throws RemoteException;

}
