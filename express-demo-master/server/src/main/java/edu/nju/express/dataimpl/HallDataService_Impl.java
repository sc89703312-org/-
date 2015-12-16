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

	/**
	 * @author guhan
	 * (non-Javadoc)
	 * @see edu.nju.express.dataservice.HallDataService#addHall(edu.nju.express.po.HallPo)
	 */
	@Override
	public ResultMessage addHall(HallPo po) throws RemoteException {
		// TODO Auto-generated method stub
		return hallDao.insert(po);
	}

	/**
	 * @author guhan
	 * (non-Javadoc)
	 * @see edu.nju.express.dataservice.HallDataService#removeHall(java.lang.String)
	 */
	@Override
	public ResultMessage removeHall(String id) throws RemoteException {
		// TODO Auto-generated method stub
		return hallDao.delete(id);
	}

	/**
	 * @author guhan
	 * (non-Javadoc)
	 * @see edu.nju.express.dataservice.HallDataService#showHall()
	 */
	@Override
	public ArrayList<HallPo> showHall() throws RemoteException {
		// TODO Auto-generated method stub
		return hallDao.showAll();
	}

	/**
	 * @author guhan
	 * (non-Javadoc)
	 * @see edu.nju.express.dataservice.HallDataService#addHallArrival(edu.nju.express.po.ArrivalReceiptPO)
	 */
	@Override
	public ResultMessage addHallArrival(ArrivalReceiptPO po) throws RemoteException  {
		// TODO Auto-generated method stub
		return this.hallArrivalDao.insert(po);
	}

	/**
	 * @author guhan
	 * (non-Javadoc)
	 * @see edu.nju.express.dataservice.HallDataService#findHallArrival(java.lang.String)
	 */
	@Override
	public ArrivalReceiptPO findHallArrival(String id) throws RemoteException{
		// TODO Auto-generated method stub
		return this.hallArrivalDao.find(id);
	}

	/**
	 * @author guhan
	 * (non-Javadoc)
	 * @see edu.nju.express.dataservice.HallDataService#getAllHallArrival()
	 */
	@Override
	public ArrayList<ArrivalReceiptPO> getAllHallArrival()throws RemoteException {
		// TODO Auto-generated method stub
		return this.hallArrivalDao.showAll();
	}

	/**
	 * @author guhan
	 * (non-Javadoc)
	 * @see edu.nju.express.dataservice.HallDataService#addHallTransfer(edu.nju.express.po.HallTransferReceiptPO)
	 */
	@Override
	public ResultMessage addHallTransfer(HallTransferReceiptPO po) throws RemoteException{
		// TODO Auto-generated method stub
		return this.hallTransferDao.insert(po);
	}

	/**
	 * @author guhan
	 * (non-Javadoc)
	 * @see edu.nju.express.dataservice.HallDataService#findHallTransfer(java.lang.String)
	 */
	@Override
	public HallTransferReceiptPO findHallTransfer(String id) throws RemoteException{
		// TODO Auto-generated method stub
		return this.hallTransferDao.find(id);
	}

	/**
	 * @author guhan
	 * (non-Javadoc)
	 * @see edu.nju.express.dataservice.HallDataService#getAllHallTransfer()
	 */
	@Override
	public ArrayList<HallTransferReceiptPO> getAllHallTransfer() throws RemoteException{
		// TODO Auto-generated method stub
		return this.hallTransferDao.showAll();
	}

	/**
	 * @author guhan
	 * (non-Javadoc)
	 * @see edu.nju.express.dataservice.HallDataService#addHallDeliver(edu.nju.express.po.DeliverReceiptPO)
	 */
	@Override
	public ResultMessage addHallDeliver(DeliverReceiptPO po)throws RemoteException {
		// TODO Auto-generated method stub
		return this.hallDeliverDao.insert(po);
	}

	/**
	 * @author guhan
	 * (non-Javadoc)
	 * @see edu.nju.express.dataservice.HallDataService#findHallDeliver(java.lang.String)
	 */
	@Override
	public DeliverReceiptPO findHallDeliver(String id)throws RemoteException {
		// TODO Auto-generated method stub
		return this.hallDeliverDao.find(id);
	}

	/**
	 * @author guhan
	 * (non-Javadoc)
	 * @see edu.nju.express.dataservice.HallDataService#getAllHallDeliver()
	 */
	@Override
	public ArrayList<DeliverReceiptPO> getAllHallDeliver() throws RemoteException{
		// TODO Auto-generated method stub
		return this.hallDeliverDao.showAll();
	}

	/**
	 * @author guhan
	 * (non-Javadoc)
	 * @see edu.nju.express.dataservice.HallDataService#flushHalls()
	 */
	@Override
	public void flushHalls() throws RemoteException {
		// TODO Auto-generated method stub
		hallDao.flush();
	}

	/**
	 * @author guhan
	 * (non-Javadoc)
	 * @see edu.nju.express.dataservice.HallDataService#flushHallArrival()
	 */
	@Override
	public void flushHallArrival() throws RemoteException {
		// TODO Auto-generated method stub
		hallArrivalDao.flush();
	}

	/**
	 * @author guhan
	 * (non-Javadoc)
	 * @see edu.nju.express.dataservice.HallDataService#flushHallTransfer()
	 */
	@Override
	public void flushHallTransfer() throws RemoteException{
		// TODO Auto-generated method stub
		hallTransferDao.flush();
	}

	/**
	 * @author guhan
	 * (non-Javadoc)
	 * @see edu.nju.express.dataservice.HallDataService#flushHallDeliver()
	 */
	@Override
	public void flushHallDeliver()throws RemoteException {
		// TODO Auto-generated method stub
		hallDeliverDao.flush();
	}

	/**
	 * @author guhan
	 * (non-Javadoc)
	 * @see edu.nju.express.dataservice.HallDataService#nextArrivalID(java.lang.String)
	 */
	@Override
	public String nextArrivalID(String hallID) throws RemoteException {
		// TODO Auto-generated method stub
		return hallArrivalDao.nextID(this.getLocation(hallID), hallID);
	}

	/**
	 * @author guhan
	 * (non-Javadoc)
	 * @see edu.nju.express.dataservice.HallDataService#getAllHallArrival(java.lang.String)
	 */
	@Override
	public ArrayList<ArrivalReceiptPO> getAllHallArrival(String hallID)
			throws RemoteException {
		// TODO Auto-generated method stub
		return hallArrivalDao.getAll(this.getLocation(hallID));
	}

	/**
	 * @author guhan
	 * (non-Javadoc)
	 * @see edu.nju.express.dataservice.HallDataService#approveHallArrival(java.lang.String)
	 */
	@Override
	public void approveHallArrival(String id) throws RemoteException {
		// TODO Auto-generated method stub
		hallArrivalDao.approve(id);
	}

	/**
	 * @author guhan
	 * (non-Javadoc)
	 * @see edu.nju.express.dataservice.HallDataService#getApproveArrival()
	 */
	@Override
	public ArrayList<ArrivalReceiptPO> getApproveArrival()
			throws RemoteException {
		// TODO Auto-generated method stub
		return null;
	}

	/**
	 * @author guhan
	 * (non-Javadoc)
	 * @see edu.nju.express.dataservice.HallDataService#getSummitArrival()
	 */
	@Override
	public ArrayList<ArrivalReceiptPO> getSummitArrival()
			throws RemoteException {
		// TODO Auto-generated method stub
		return hallArrivalDao.getAllSummit();
	}

	/**
	 * @author guhan
	 * (non-Javadoc)
	 * @see edu.nju.express.dataservice.HallDataService#nextHallTransferID(java.lang.String)
	 */
	@Override
	public String nextHallTransferID(String hallID) throws RemoteException {
		// TODO Auto-generated method stub
		return hallTransferDao.nextID(this.getLocation(hallID), hallID);
	}

	/**
	 * @author guhan
	 * (non-Javadoc)
	 * @see edu.nju.express.dataservice.HallDataService#getAllHallTransfer(java.lang.String)
	 */
	@Override
	public ArrayList<HallTransferReceiptPO> getAllHallTransfer(String hallID)
			throws RemoteException {
		// TODO Auto-generated method stub
		return hallTransferDao.getAll(this.getLocation(hallID));
	}

	/**
	 * @author guhan
	 * (non-Javadoc)
	 * @see edu.nju.express.dataservice.HallDataService#approveHallTransfer(java.lang.String)
	 */
	@Override
	public void approveHallTransfer(String id) throws RemoteException {
		// TODO Auto-generated method stub
		hallTransferDao.approveTransferReceipt(id);
	}

	/**
	 * @author guhan
	 * (non-Javadoc)
	 * @see edu.nju.express.dataservice.HallDataService#getApproveTransfer()
	 */
	@Override
	public ArrayList<HallTransferReceiptPO> getApproveTransfer()
			throws RemoteException {
		// TODO Auto-generated method stub
		return null;
	}

	/**
	 * @author guhan
	 * (non-Javadoc)
	 * @see edu.nju.express.dataservice.HallDataService#getSummitTransfer()
	 */
	@Override
	public ArrayList<HallTransferReceiptPO> getSummitTransfer()
			throws RemoteException {
		// TODO Auto-generated method stub
		return hallTransferDao.getAllSummit();
	}

	/**
	 * @author guhan
	 * (non-Javadoc)
	 * @see edu.nju.express.dataservice.HallDataService#nextDeliverID(java.lang.String)
	 */
	@Override
	public String nextDeliverID(String hallID) throws RemoteException {
		// TODO Auto-generated method stub
		return hallDeliverDao.nextID(this.getLocation(hallID), hallID);
	}

	/**
	 * @author guhan
	 * (non-Javadoc)
	 * @see edu.nju.express.dataservice.HallDataService#getAllHallDeliver(java.lang.String)
	 */
	@Override
	public ArrayList<DeliverReceiptPO> getAllHallDeliver(String hallID)
			throws RemoteException {
		// TODO Auto-generated method stub
		return hallDeliverDao.getAll(this.getLocation(hallID));
	}

	/**
	 * @author guhan
	 * (non-Javadoc)
	 * @see edu.nju.express.dataservice.HallDataService#approveHallDeliver(java.lang.String)
	 */
	@Override
	public void approveHallDeliver(String id) throws RemoteException {
		// TODO Auto-generated method stub
		hallDeliverDao.approveDeliverReceipt(id);
	}

	/**
	 * @author guhan
	 * (non-Javadoc)
	 * @see edu.nju.express.dataservice.HallDataService#getApproveDeliver()
	 */
	@Override
	public ArrayList<DeliverReceiptPO> getApproveDeliver()
			throws RemoteException {
		// TODO Auto-generated method stub
		return null;
	}

	/**
	 * @author guhan
	 * (non-Javadoc)
	 * @see edu.nju.express.dataservice.HallDataService#getSummitDeliver()
	 */
	@Override
	public ArrayList<DeliverReceiptPO> getSummitDeliver()
			throws RemoteException {
		// TODO Auto-generated method stub
		return hallDeliverDao.getAllSummit();
	}

	/**
	 * @author guhan
	 * (non-Javadoc)
	 * @see edu.nju.express.dataservice.HallDataService#getLocation(java.lang.String)
	 */
	@Override
	public String getLocation(String id) throws RemoteException {
		// TODO Auto-generated method stub
		System.out.println(hallDao.getLocation(id));
		return hallDao.getLocation(id);
	}


}
