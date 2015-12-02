package edu.nju.express.dataimpl;

import java.rmi.RemoteException;
import java.util.ArrayList;

import edu.nju.express.common.ResultMessage;
import edu.nju.express.dataservice.StationDataService;
import edu.nju.express.po.ArriveReceiptPO;
import edu.nju.express.po.StationPO;
import edu.nju.express.po.TransferReceiptPO;

public class StationDataService_Impl implements StationDataService{

	@Override
	public String getLocation(String id) throws RemoteException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public ResultMessage addStation(String id, String location)
			throws RemoteException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public ResultMessage removeStation(String id) throws RemoteException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public ArrayList<StationPO> showStation() throws RemoteException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void addArriveReceipt(ArriveReceiptPO po) throws RemoteException {
		// TODO Auto-generated method stub
		
	}

	@Override
	public String nextArriveID(String stationID) throws RemoteException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public ArrayList<ArriveReceiptPO> getArriveReceipt(String stationID)
			throws RemoteException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public ArrayList<ArriveReceiptPO> getArriveReceipt() throws RemoteException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public ResultMessage approveArriveReceipt(String id) throws RemoteException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public ArrayList<ArriveReceiptPO> getApproveArrive(String comID)
			throws RemoteException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public ArrayList<ArriveReceiptPO> getSummitArrive() throws RemoteException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void addTransferReceipt(TransferReceiptPO po) throws RemoteException {
		// TODO Auto-generated method stub
		
	}

	@Override
	public String nextTransferID(String stationID) throws RemoteException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public ArrayList<TransferReceiptPO> getTransferReceipt(String stationID)
			throws RemoteException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public ArrayList<TransferReceiptPO> getTransferReceipt()
			throws RemoteException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public ResultMessage approveTransferReceipt(String id)
			throws RemoteException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public ArrayList<TransferReceiptPO> getApproveTransfer(String comID)
			throws RemoteException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public ArrayList<TransferReceiptPO> getSummitTransfer()
			throws RemoteException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public TransferReceiptPO getTransfer(String id) throws RemoteException {
		// TODO Auto-generated method stub
		return null;
	}

}
