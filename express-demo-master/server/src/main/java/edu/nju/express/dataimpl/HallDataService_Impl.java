package edu.nju.express.dataimpl;

import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;
import java.util.ArrayList;

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

	protected HallDataService_Impl() throws RemoteException {
		super();
		// TODO Auto-generated constructor stub
		hallDao = new HallFileDao("hall");
		hallArrivalDao = new HallArrivalFileDao("hallArrival");
		hallTransferDao = new HallTransferFileDao("hallTransfer");
		hallDeliverDao = new HallDeliverFileDao("hallDeliver");
		
	}

	@Override
	public void addHall(HallPo po) throws RemoteException {
		// TODO Auto-generated method stub
		hallDao.insert(po);
	}

	@Override
	public void removeHall(String id) throws RemoteException {
		// TODO Auto-generated method stub
		hallDao.delete(id);
	}

	@Override
	public ArrayList<HallPo> showHall() throws RemoteException {
		// TODO Auto-generated method stub
		return hallDao.getAll();
	}

	@Override
	public void addHallArrival(ArrivalReceiptPO po) {
		// TODO Auto-generated method stub
		this.hallArrivalDao.insert(po);
	}

	@Override
	public void removeHallArrival(String id) {
		// TODO Auto-generated method stub
		this.hallArrivalDao.delete(id);
	}

	@Override
	public ArrivalReceiptPO findHallArrival(String id) {
		// TODO Auto-generated method stub
		return this.hallArrivalDao.find(id);
	}

	@Override
	public ArrayList<ArrivalReceiptPO> getAllHallArrival() {
		// TODO Auto-generated method stub
		return this.hallArrivalDao.getAll();
	}

	@Override
	public void approveHallArrival(ArrayList<ArrivalReceiptPO> list) {
		// TODO Auto-generated method stub
		this.hallArrivalDao.approveArrivalReceipt(list);
	}

	@Override
	public void addHallTransfer(HallTransferReceiptPO po) {
		// TODO Auto-generated method stub
		this.hallTransferDao.insert(po);
	}

	@Override
	public void removeHallTransfer(String id) {
		// TODO Auto-generated method stub
		this.hallTransferDao.delete(id);
	}

	@Override
	public HallTransferReceiptPO findHallTransfer(String id) {
		// TODO Auto-generated method stub
		return this.hallTransferDao.find(id);
	}

	@Override
	public ArrayList<HallTransferReceiptPO> getAllHallTransfer() {
		// TODO Auto-generated method stub
		return this.hallTransferDao.getAll();
	}

	@Override
	public void approveHallTransfer(ArrayList<HallTransferReceiptPO> list) {
		// TODO Auto-generated method stub
		this.hallTransferDao.approveTransferReceipt(list);;
	}

	@Override
	public void addHallDeliver(DeliverReceiptPO po) {
		// TODO Auto-generated method stub
		this.hallDeliverDao.insert(po);
	}

	@Override
	public void removeHallDeliver(String id) {
		// TODO Auto-generated method stub
		this.hallDeliverDao.delete(id);
	}

	@Override
	public DeliverReceiptPO findHallDeliver(String id) {
		// TODO Auto-generated method stub
		return this.hallDeliverDao.find(id);
	}

	@Override
	public ArrayList<DeliverReceiptPO> getAllHallDeliver() {
		// TODO Auto-generated method stub
		return this.hallDeliverDao.getAll();
	}

	@Override
	public void approveHallDeliver(ArrayList<DeliverReceiptPO> list) {
		// TODO Auto-generated method stub
		this.hallDeliverDao.approveDeliverReceipt(list);
	}

}
