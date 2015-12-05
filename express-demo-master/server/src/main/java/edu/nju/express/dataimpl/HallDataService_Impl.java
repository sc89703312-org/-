package edu.nju.express.dataimpl;

import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;
import java.util.ArrayList;

import edu.nju.express.common.ResultMessage;
import edu.nju.express.data.halldata.HallArrivalDao;
import edu.nju.express.data.halldata.HallArrivalFileDao;
import edu.nju.express.data.halldata.HallDao;
import edu.nju.express.data.halldata.HallDeliverDao;
import edu.nju.express.data.halldata.HallDeliverFileDao;
import edu.nju.express.data.halldata.HallFileDao;
import edu.nju.express.data.halldata.HallTransferDao;
import edu.nju.express.data.halldata.HallTransferFileDao;
import edu.nju.express.dataservice.HallDataService;
import edu.nju.express.po.ArrivalReceiptPO;
import edu.nju.express.po.DeliverReceiptPO;
import edu.nju.express.po.HallPo;
import edu.nju.express.po.HallTransferReceiptPO;

public class HallDataService_Impl extends UnicastRemoteObject implements HallDataService{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	HallDao hallDao;
	HallArrivalDao hallArrivalDao;
	HallTransferDao hallTransferDao;
	HallDeliverDao hallDeliverDao;

	public HallDataService_Impl() throws RemoteException {

		super();
		// TODO Auto-generated constructor stub
		hallDao = new HallFileDao("hall");
		hallArrivalDao = new HallArrivalFileDao("hallArrival");
		hallTransferDao = new HallTransferFileDao("hallTransfer");
		hallDeliverDao = new HallDeliverFileDao("hallDeliver");
		
	}

	@Override
	public ResultMessage addHall(HallPo po) throws RemoteException {
		// TODO Auto-generated method stub
		return hallDao.insert(po);
	}

	@Override
	public ResultMessage removeHall(String id) throws RemoteException {
		// TODO Auto-generated method stub
		return hallDao.delete(id);
	}

	@Override
	public ArrayList<HallPo> showHall() throws RemoteException {
		// TODO Auto-generated method stub
		return hallDao.showAll();
	}

	@Override
	public ResultMessage addHallArrival(ArrivalReceiptPO po) throws RemoteException  {
		// TODO Auto-generated method stub
		return this.hallArrivalDao.insert(po);
	}

	@Override
	public ArrivalReceiptPO findHallArrival(String id) throws RemoteException{
		// TODO Auto-generated method stub
		return this.hallArrivalDao.find(id);
	}

	@Override
	public ArrayList<ArrivalReceiptPO> getAllHallArrival()throws RemoteException {
		// TODO Auto-generated method stub
		return this.hallArrivalDao.showAll();
	}

	@Override
	public ResultMessage addHallTransfer(HallTransferReceiptPO po) throws RemoteException{
		// TODO Auto-generated method stub
		return this.hallTransferDao.insert(po);
	}

	@Override
	public HallTransferReceiptPO findHallTransfer(String id) throws RemoteException{
		// TODO Auto-generated method stub
		return this.hallTransferDao.find(id);
	}

	@Override
	public ArrayList<HallTransferReceiptPO> getAllHallTransfer() throws RemoteException{
		// TODO Auto-generated method stub
		return this.hallTransferDao.showAll();
	}

	@Override
	public ResultMessage addHallDeliver(DeliverReceiptPO po)throws RemoteException {
		// TODO Auto-generated method stub
		return this.hallDeliverDao.insert(po);
	}

	@Override
	public DeliverReceiptPO findHallDeliver(String id)throws RemoteException {
		// TODO Auto-generated method stub
		return this.hallDeliverDao.find(id);
	}

	@Override
	public ArrayList<DeliverReceiptPO> getAllHallDeliver() throws RemoteException{
		// TODO Auto-generated method stub
		return this.hallDeliverDao.showAll();
	}

	@Override
	public void flushHalls() throws RemoteException {
		// TODO Auto-generated method stub
		hallDao.flush();
	}

	@Override
	public void flushHallArrival() throws RemoteException {
		// TODO Auto-generated method stub
		hallArrivalDao.flush();
	}

	@Override
	public void flushHallTransfer() throws RemoteException{
		// TODO Auto-generated method stub
		hallTransferDao.flush();
	}

	@Override
	public void flushHallDeliver()throws RemoteException {
		// TODO Auto-generated method stub
		hallDeliverDao.flush();
	}

	@Override
	public String nextArrivalID(String hallID) throws RemoteException {
		// TODO Auto-generated method stub
		return hallArrivalDao.nextID(this.getLocation(hallID), hallID);
	}

	@Override
	public ArrayList<ArrivalReceiptPO> getAllHallArrival(String hallID)
			throws RemoteException {
		// TODO Auto-generated method stub
		return hallArrivalDao.getAll(this.getLocation(hallID));
	}

	@Override
	public void approveHallArrival(String id) throws RemoteException {
		// TODO Auto-generated method stub
		hallArrivalDao.approve(id);
	}

	@Override
	public ArrayList<ArrivalReceiptPO> getApproveArrival()
			throws RemoteException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public ArrayList<ArrivalReceiptPO> getSummitArrival()
			throws RemoteException {
		// TODO Auto-generated method stub
		return hallArrivalDao.getAllSummit();
	}

	@Override
	public String nextHallTransferID(String hallID) throws RemoteException {
		// TODO Auto-generated method stub
		return hallTransferDao.nextID(this.getLocation(hallID), hallID);
	}

	@Override
	public ArrayList<HallTransferReceiptPO> getAllHallTransfer(String hallID)
			throws RemoteException {
		// TODO Auto-generated method stub
		return hallTransferDao.getAll(this.getLocation(hallID));
	}

	@Override
	public void approveHallTransfer(String id) throws RemoteException {
		// TODO Auto-generated method stub
		hallTransferDao.approveTransferReceipt(id);
	}

	@Override
	public ArrayList<HallTransferReceiptPO> getApproveTransfer()
			throws RemoteException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public ArrayList<HallTransferReceiptPO> getSummitTransfer()
			throws RemoteException {
		// TODO Auto-generated method stub
		return hallTransferDao.getAllSummit();
	}

	@Override
	public String nextDeliverID(String hallID) throws RemoteException {
		// TODO Auto-generated method stub
		return hallDeliverDao.nextID(this.getLocation(hallID), hallID);
	}

	@Override
	public ArrayList<DeliverReceiptPO> getAllHallDeliver(String hallID)
			throws RemoteException {
		// TODO Auto-generated method stub
		return hallDeliverDao.getAll(this.getLocation(hallID));
	}

	@Override
	public void approveHallDeliver(String id) throws RemoteException {
		// TODO Auto-generated method stub
		hallDeliverDao.approveDeliverReceipt(id);
	}

	@Override
	public ArrayList<DeliverReceiptPO> getApproveDeliver()
			throws RemoteException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public ArrayList<DeliverReceiptPO> getSummitDeliver()
			throws RemoteException {
		// TODO Auto-generated method stub
		return hallDeliverDao.getAllSummit();
	}

	@Override
	public String getLocation(String id) throws RemoteException {
		// TODO Auto-generated method stub
		return hallDao.getLocation(id);
	}


}
