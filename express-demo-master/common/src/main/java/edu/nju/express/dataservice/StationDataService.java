package edu.nju.express.dataservice;

import java.rmi.Remote;
import java.rmi.RemoteException;
import java.util.ArrayList;

import edu.nju.express.common.ResultMessage;
import edu.nju.express.po.ArriveReceiptPO;
import edu.nju.express.po.StationPO;
import edu.nju.express.po.TransferReceiptPO;



public interface StationDataService extends Remote{

	public String getLocation(String id) throws RemoteException;
	
	public ResultMessage addStation(String id, String location) throws RemoteException;
	public ResultMessage removeStation(String id) throws RemoteException;
	public ArrayList<StationPO> showStation() throws RemoteException;
	
	
	public void addArriveReceipt(ArriveReceiptPO po) throws RemoteException;
	public String nextArriveID(String stationID) throws RemoteException;
	public ArrayList<ArriveReceiptPO> getArriveReceipt(String stationID) throws RemoteException;
	public ArrayList<ArriveReceiptPO> getArriveReceipt() throws RemoteException;
	public ResultMessage approveArriveReceipt(String id) throws RemoteException;
	public ArrayList<ArriveReceiptPO> getApproveArrive() throws RemoteException;
	public ArrayList<ArriveReceiptPO> getSummitArrive() throws RemoteException;
	//public void modifyArriveReceipt(String id, ArriveReceiptPO po) throws RemoteException;
	
	
	public void addTransferReceipt(TransferReceiptPO po) throws RemoteException;
	public String nextTransferID(String stationID) throws RemoteException;
	public ArrayList<TransferReceiptPO> getTransferReceipt(String stationID) throws RemoteException;
	public ArrayList<TransferReceiptPO> getTransferReceipt() throws RemoteException;
	public ResultMessage approveTransferReceipt(String id) throws RemoteException;
	public ArrayList<TransferReceiptPO> getApproveTransfer() throws RemoteException;
	public ArrayList<TransferReceiptPO> getSummitTransfer() throws RemoteException;
	//public void modifyTransferReceipt(String id, TransferReceiptPO po) throws RemoteException;
	
	public TransferReceiptPO getTransfer(String id) throws RemoteException;
	
}
