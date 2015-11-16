package client.dataservice.stationdataservice;

import java.rmi.Remote;
import java.rmi.RemoteException;
import java.util.ArrayList;

import client.ResultMessage;
import client.po.stationpo.ArriveReceiptPO;
import client.po.stationpo.StationPO;
import client.po.stationpo.TransferReceiptPO;

public interface StationDataService extends Remote{

	public ResultMessage addStation(String id, String location) throws RemoteException;
	public ResultMessage removeStation(String id) throws RemoteException;
	public ArrayList<StationPO> showStation() throws RemoteException;
	
	public void addArriveReceipt(ArriveReceiptPO po, String stationID) throws RemoteException;
	public ArrayList<ArriveReceiptPO> getArriveReceipt() throws RemoteException;
	public ResultMessage approveArriveReceipt(String id) throws RemoteException;
	public void modifyArriveReceipt(String id, ArriveReceiptPO po) throws RemoteException;
	
	public void addTransferReceipt(TransferReceiptPO po, String stationID) throws RemoteException;
	public ArrayList<TransferReceiptPO> getTransferReceipt() throws RemoteException;
	public ResultMessage approveTransferReceipt(String id) throws RemoteException;
	public void modifyTransferReceipt(String id, TransferReceiptPO po) throws RemoteException;
	
	
}
