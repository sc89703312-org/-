package edu.nju.express.dataimpl;

import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;
import java.util.ArrayList;

import edu.nju.express.common.ResultMessage;
import edu.nju.express.data.stationdata.ArriveFileDao;
import edu.nju.express.data.stationdata.ArriveReceiptDao;
import edu.nju.express.data.stationdata.StationDao;
import edu.nju.express.data.stationdata.StationFileDao;
import edu.nju.express.data.stationdata.TransferFileDao;
import edu.nju.express.data.stationdata.TransferReceiptDao;
import edu.nju.express.dataservice.StationDataService;
import edu.nju.express.po.ArriveReceiptPO;
import edu.nju.express.po.StationPO;
import edu.nju.express.po.TransferReceiptPO;

public class StationDataService_Impl extends UnicastRemoteObject implements StationDataService{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	StationDao stationDao;
	ArriveReceiptDao arriveDao;
	TransferReceiptDao transferDao;

	public StationDataService_Impl() throws RemoteException {
		super();
		// TODO Auto-generated constructor stub
		stationDao = new StationFileDao("station");
		arriveDao = new ArriveFileDao("arrivereceipt");
		transferDao = new TransferFileDao("transferreceipt");
	}

	@Override
	public String getLocation(String id) throws RemoteException {
		// TODO Auto-generated method stub
		return stationDao.getLocation(id);
	}

	@Override
	public ResultMessage addStation(String id, String location)
			throws RemoteException {
		// TODO Auto-generated method stub
		return stationDao.add(new StationPO(id,location));
	}

	@Override
	public ResultMessage removeStation(String id) throws RemoteException {
		// TODO Auto-generated method stub
		return stationDao.remove(id);
	}

	@Override
	public ArrayList<StationPO> showStation() throws RemoteException {
		// TODO Auto-generated method stub
		return stationDao.showAllStation();
	}

	@Override
	public void addArriveReceipt(ArriveReceiptPO po) throws RemoteException {
		// TODO Auto-generated method stub
		arriveDao.add(po);
	}

	@Override
	public String nextArriveID(String stationID) throws RemoteException {
		// TODO Auto-generated method stub
		return arriveDao.getNextID(stationID,this.getLocation(stationID));
	}

	@Override
	public ArrayList<ArriveReceiptPO> getArriveReceipt(String stationID)
			throws RemoteException {
		// TODO Auto-generated method stub
		String location = this.getLocation(stationID);
		return arriveDao.getAllReceipt(location);
	}

	@Override
	public ArrayList<ArriveReceiptPO> getArriveReceipt() throws RemoteException {
		// TODO Auto-generated method stub
		return arriveDao.getAllReceipt();
	}

	@Override
	public ResultMessage approveArriveReceipt(String id) throws RemoteException {
		// TODO Auto-generated method stub
		return arriveDao.approve(id);
	}

	@Override
	public ArrayList<ArriveReceiptPO> getApproveArrive(String comID)
			throws RemoteException {
		// TODO Auto-generated method stub
		return arriveDao.getApproveArrive(comID);
	}

	@Override
	public ArrayList<ArriveReceiptPO> getSummitArrive() throws RemoteException {
		// TODO Auto-generated method stub
		return arriveDao.getSummitArrive();
	}

	@Override
	public void addTransferReceipt(TransferReceiptPO po) throws RemoteException {
		// TODO Auto-generated method stub
		transferDao.add(po);
	}

	@Override
	public String nextTransferID(String stationID) throws RemoteException {
		// TODO Auto-generated method stub
		return transferDao.getNextID(stationID,this.getLocation(stationID));
	}

	@Override
	public ArrayList<TransferReceiptPO> getTransferReceipt(String stationID)
			throws RemoteException {
		// TODO Auto-generated method stub
		return transferDao.getAllReceipt(stationID);
	}

	@Override
	public ArrayList<TransferReceiptPO> getTransferReceipt()
			throws RemoteException {
		// TODO Auto-generated method stub
		return transferDao.getAllReceipt();
	}

	@Override
	public ResultMessage approveTransferReceipt(String id)
			throws RemoteException {
		// TODO Auto-generated method stub
		return transferDao.approve(id);
	}

	@Override
	public ArrayList<TransferReceiptPO> getApproveTransfer(String comID)
			throws RemoteException {
		// TODO Auto-generated method stub
		return transferDao.getApproveTransfer(comID);
	}

	@Override
	public ArrayList<TransferReceiptPO> getSummitTransfer()
			throws RemoteException {
		// TODO Auto-generated method stub
		return transferDao.getSummitTransfer();
	}

	@Override
	public TransferReceiptPO getTransfer(String id) throws RemoteException {
		// TODO Auto-generated method stub
		return transferDao.getTransfer(id);
	}
	
	@Override
	public void handleArrive(String id)throws RemoteException{
		arriveDao.handle(id);
	}
	
	@Override
	public void handleTransfer(String id)throws RemoteException{
		transferDao.handle(id);
	}

	@Override
	public void flush() throws RemoteException{
		// TODO Auto-generated method stub
		stationDao.flush();
		arriveDao.flush();
		transferDao.flush();
	}

}
