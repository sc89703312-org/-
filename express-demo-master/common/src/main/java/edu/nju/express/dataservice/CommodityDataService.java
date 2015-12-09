package edu.nju.express.dataservice;

import java.rmi.Remote;
import java.rmi.RemoteException;
import java.util.ArrayList;

import edu.nju.express.common.ResultMessage;
import edu.nju.express.common.ResultMessageV2;
import edu.nju.express.po.ComGoodsPO;
import edu.nju.express.po.ComInfoPO;
import edu.nju.express.po.ComZonePO;
import edu.nju.express.po.EnterReceiptPO;
import edu.nju.express.po.ExitReceiptPO;

/**
 * 
 * @author ShiroKo
 * @version 2015-12-9 23:28
 * 
 * 仓库模块的数据层接口
 *
 */

public interface CommodityDataService extends Remote{
	
	/** 获得仓库内货物
	 * 
	 * @param comID
	 * @return
	 * @throws RemoteException
	 */
	public ArrayList<ComGoodsPO> getComGoods(String comID) throws RemoteException;
	
	/** 
	 * 
	 * @param comID
	 * @return
	 * @throws RemoteException
	 */
	public String getLocation(String comID) throws RemoteException;
	
	/**
	 * 
	 * @param comID
	 * @return
	 * @throws RemoteException
	 */
	public ComZonePO getZone(String comID) throws RemoteException;
	
	/**
	 * 
	 * @param comID
	 * @param space
	 * @return
	 * @throws RemoteException
	 */
	public ResultMessageV2 modifyZone(String comID, int[] space) throws RemoteException;
	
	/**
	 * 
	 * @param comID
	 * @return
	 * @throws RemoteException
	 */
	public ResultMessageV2 initZone(String comID) throws RemoteException;
	
	/**
	 * 
	 * @param comID
	 * @param po
	 * @throws RemoteException
	 */
	public void addGoods(String comID, EnterReceiptPO po) throws RemoteException;
	
	/**
	 * 
	 * @param comID
	 * @param po
	 * @throws RemoteException
	 */
	public void removeGoods(String comID, ExitReceiptPO po) throws RemoteException;
	
	/**
	 * 
	 * @param comID
	 * @param orderID
	 * @return
	 * @throws RemoteException
	 */
	public ComGoodsPO getGoods(String comID, String orderID) throws RemoteException;
	
	/**
	 * 
	 * @param comID
	 * @param data
	 * @throws RemoteException
	 */
	public void moveGoods(String comID, Object data[][])throws RemoteException;
	

	/**
	 * 
	 * @param comID
	 * @param location
	 * @param totalSpace
	 * @throws RemoteException
	 */
	public void addCommodity(String comID, String location, int totalSpace) throws RemoteException;
	
	/**
	 * 
	 * @param comID
	 * @throws RemoteException
	 */
	public void removeCommodity(String comID) throws RemoteException;
	
	/**
	 * 
	 * @return
	 * @throws RemoteException
	 */
	public ArrayList<ComInfoPO> getCommodity() throws RemoteException;
	
	/**
	 * 
	 * @param po
	 * @throws RemoteException
	 */
	public void addEnterReceipt(EnterReceiptPO po) throws RemoteException;
	
	/**
	 * 
	 * @param comID
	 * @return
	 * @throws RemoteException
	 */
	public String getNextEnterID(String comID) throws RemoteException;
	
	/**
	 * 
	 * @param comID
	 * @return
	 * @throws RemoteException
	 */
	public ArrayList<EnterReceiptPO> getEnterReceipt(String comID) throws RemoteException;
	
	/**
	 * 
	 * @return
	 * @throws RemoteException
	 */
	public ArrayList<EnterReceiptPO> getEnterReceipt() throws RemoteException;
	
	/**
	 * 
	 * @return
	 * @throws RemoteException
	 */
	public ArrayList<EnterReceiptPO> getSummitEnter() throws RemoteException;
	
	/**
	 * 
	 * @param id
	 * @return
	 * @throws RemoteException
	 */
	public ResultMessage approveEnterReceipt(String id) throws RemoteException;
	
	/**
	 * 
	 * @param po
	 * @throws RemoteException
	 */
	public void addExitReceipt(ExitReceiptPO po) throws RemoteException;
	
	/**
	 * 
	 * @param comID
	 * @return
	 * @throws RemoteException
	 */
	public String getNextExitID(String comID) throws RemoteException;
	
	/**
	 * 
	 * @param comID
	 * @return
	 * @throws RemoteException
	 */
	public ArrayList<ExitReceiptPO> getExitReceipt(String comID) throws RemoteException;
	
	/**
	 * 
	 * @return
	 * @throws RemoteException
	 */
	public ArrayList<ExitReceiptPO> getExitReceipt() throws RemoteException;
	
	/**
	 * 
	 * @return
	 * @throws RemoteException
	 */
	public ArrayList<ExitReceiptPO> getSummitExit() throws RemoteException;
	
	/**
	 * 
	 * @param id
	 * @return
	 * @throws RemoteException
	 */
	public ResultMessage approveExitReceipt(String id) throws RemoteException;
	
	
	/**
	 * 
	 * @throws RemoteException
	 */
	public void flush()throws RemoteException;
	
}
