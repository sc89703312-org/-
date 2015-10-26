package client.dataservice.stationdataservice;

import java.rmi.Remote;
import java.rmi.RemoteException;
import java.util.ArrayList;

import client.po.stationpo.ArriveReceiptPO;
import client.po.stationpo.StationPO;
import client.po.stationpo.TransferReceiptPO;

public interface StationDataService extends Remote{

	public void addStation(String id, String location) throws RemoteException;
	public void removeStation(String id) throws RemoteException;
	public ArrayList<StationPO> showStation() throws RemoteException;
	
	public void addArriveReceipt(ArriveReceiptPO po, String stationID) throws RemoteException;
	public ArrayList<ArriveReceiptPO> getArriveReceipt(String stationID) throws RemoteException;
	public void approveArriveReceipt(ArrayList<ArriveReceiptPO> list) throws RemoteException;
	public void modifyArriveReceipt(String id, ArriveReceiptPO po) throws RemoteException;
	
	public void addTransferReceipt(TransferReceiptPO po, String stationID) throws RemoteException;
	public ArrayList<TransferReceiptPO> getTransferReceipt(String stationID) throws RemoteException;
	public void approveTransferReceiptPO(ArrayList<TransferReceiptPO> list) throws RemoteException;
	public void modifyTransferReceiptPO(String id, TransferReceiptPO po) throws RemoteException;
	
	
}
