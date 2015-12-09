package edu.nju.express.dataservice;

import java.rmi.Remote;
import java.rmi.RemoteException;
import java.util.ArrayList;

import edu.nju.express.common.ResultMessage;
import edu.nju.express.po.ArriveReceiptPO;
import edu.nju.express.po.StationPO;
import edu.nju.express.po.TransferReceiptPO;

/**
 * 
 * @author ShiroKo
 * @version 2015-12-9 23:34
 * 
 * 中转中心模块的数据层接口
 *
 */

public interface StationDataService extends Remote{

	/**
	 * 
	 * @param id
	 * @return
	 * @throws RemoteException
	 */
	public String getLocation(String id) throws RemoteException;
	
	/**
	 * 
	 * @param id
	 * @param location
	 * @return
	 * @throws RemoteException
	 */
	public ResultMessage addStation(String id, String location) throws RemoteException;
	
	/**
	 * 
	 * @param id
	 * @return
	 * @throws RemoteException
	 */
	public ResultMessage removeStation(String id) throws RemoteException;
	
	/**
	 * 
	 * @return
	 * @throws RemoteException
	 */
	public ArrayList<StationPO> showStation() throws RemoteException;
	
	/**
	 * 
	 * @param po
	 * @throws RemoteException
	 */
	public void addArriveReceipt(ArriveReceiptPO po) throws RemoteException;
	
	/**
	 * 
	 * @param stationID
	 * @return
	 * @throws RemoteException
	 */
	public String nextArriveID(String stationID) throws RemoteException;
	
	/**
	 * 
	 * @param stationID
	 * @return
	 * @throws RemoteException
	 */
	public ArrayList<ArriveReceiptPO> getArriveReceipt(String stationID) throws RemoteException;
	
	/**
	 * 
	 * @return
	 * @throws RemoteException
	 */
	public ArrayList<ArriveReceiptPO> getArriveReceipt() throws RemoteException;
	
	/**
	 * 
	 * @param id
	 * @return
	 * @throws RemoteException
	 */
	public ResultMessage approveArriveReceipt(String id) throws RemoteException;
	
	/**
	 * 
	 * @param comID
	 * @return
	 * @throws RemoteException
	 */
	public ArrayList<ArriveReceiptPO> getApproveArrive(String comID) throws RemoteException;
	
	/**
	 * 
	 * @return
	 * @throws RemoteException
	 */
	public ArrayList<ArriveReceiptPO> getSummitArrive() throws RemoteException;
	//public void modifyArriveReceipt(String id, ArriveReceiptPO po) throws RemoteException;
	
	/**
	 * 
	 * @param po
	 * @throws RemoteException
	 */
	public void addTransferReceipt(TransferReceiptPO po) throws RemoteException;
	
	/**
	 * 
	 * @param stationID
	 * @return
	 * @throws RemoteException
	 */
	public String nextTransferID(String stationID) throws RemoteException;
	
	/**
	 * 
	 * @param stationID
	 * @return
	 * @throws RemoteException
	 */
	public ArrayList<TransferReceiptPO> getTransferReceipt(String stationID) throws RemoteException;
	
	/**
	 * 
	 * @return
	 * @throws RemoteException
	 */
	public ArrayList<TransferReceiptPO> getTransferReceipt() throws RemoteException;
	
	/**
	 * 
	 * @param id
	 * @return
	 * @throws RemoteException
	 */
	public ResultMessage approveTransferReceipt(String id) throws RemoteException;
	
	/**
	 * 
	 * @param comID
	 * @return
	 * @throws RemoteException
	 */
	public ArrayList<TransferReceiptPO> getApproveTransfer(String comID) throws RemoteException;
	
	/**
	 * 
	 * @return
	 * @throws RemoteException
	 */
	public ArrayList<TransferReceiptPO> getSummitTransfer() throws RemoteException;
	//public void modifyTransferReceipt(String id, TransferReceiptPO po) throws RemoteException;
	
	/**
	 * 
	 * @param id
	 * @return
	 * @throws RemoteException
	 */
	public TransferReceiptPO getTransfer(String id) throws RemoteException;
	
	/**
	 * 
	 * @param id
	 * @throws RemoteException
	 */
	public void handleTransfer(String id) throws RemoteException;
	
	/**
	 * 
	 * @param id
	 * @throws RemoteException
	 */
	public void handleArrive(String id) throws RemoteException;
	
	/**
	 * 
	 * @throws RemoteException
	 */
	public void flush()throws RemoteException;

	
	
}
