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
	public ResultMessage removeHallArrival(String id)throws RemoteException {
		// TODO Auto-generated method stub
		return this.hallArrivalDao.delete(id);
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
	public void approveHallArrival(ArrayList<ArrivalReceiptPO> list) throws RemoteException{
		// TODO Auto-generated method stub
		this.hallArrivalDao.approveArrivalReceipt(list);
	}

	@Override
	public ResultMessage addHallTransfer(HallTransferReceiptPO po) throws RemoteException{
		// TODO Auto-generated method stub
		return this.hallTransferDao.insert(po);
	}

	@Override
	public ResultMessage removeHallTransfer(String id) throws RemoteException{
		// TODO Auto-generated method stub
		return this.hallTransferDao.delete(id);
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
	public void approveHallTransfer(ArrayList<HallTransferReceiptPO> list) throws RemoteException{
		// TODO Auto-generated method stub
		this.hallTransferDao.approveTransferReceipt(list);;
	}

	@Override
	public ResultMessage addHallDeliver(DeliverReceiptPO po)throws RemoteException {
		// TODO Auto-generated method stub
		return this.hallDeliverDao.insert(po);
	}

	@Override
	public ResultMessage removeHallDeliver(String id)throws RemoteException {
		// TODO Auto-generated method stub
		return this.hallDeliverDao.delete(id);
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
	public void approveHallDeliver(ArrayList<DeliverReceiptPO> list)throws RemoteException {
		// TODO Auto-generated method stub
		this.hallDeliverDao.approveDeliverReceipt(list);
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

}
