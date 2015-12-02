package edu.nju.express.dataimpl;

import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;
import java.util.ArrayList;

import edu.nju.express.common.ResultMessage;
import edu.nju.express.common.ResultMessageV2;
import edu.nju.express.data.commoditydata.ComInfoDao;
import edu.nju.express.data.commoditydata.EnterReceiptDao;
import edu.nju.express.data.commoditydata.ExitReceiptDao;
import edu.nju.express.dataservice.CommodityDataService;
import edu.nju.express.po.ComGoodsPO;
import edu.nju.express.po.ComInfoPO;
import edu.nju.express.po.ComZonePO;
import edu.nju.express.po.EnterReceiptPO;
import edu.nju.express.po.ExitReceiptPO;

public class CommodityDataService_Impl extends UnicastRemoteObject implements CommodityDataService{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 5960764122860351292L;
	
	EnterReceiptDao enterDao;
	ExitReceiptDao exitDao;
	ComInfoDao comInfoDao;

	public CommodityDataService_Impl() throws RemoteException{
		
	}

	@Override
	public ArrayList<ComGoodsPO> getComGoods(String comID)
			throws RemoteException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public String getLocation(String comID) throws RemoteException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public ComZonePO getZone(String comID) throws RemoteException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public ResultMessageV2 modifyZone(String comID, int[] space)
			throws RemoteException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public ResultMessageV2 initZone(String comID) throws RemoteException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void addGoods(String comID, EnterReceiptPO po)
			throws RemoteException {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void removeGoods(String comID, ExitReceiptPO po)
			throws RemoteException {
		// TODO Auto-generated method stub
		
	}

	@Override
	public ComGoodsPO getGoods(String comID, String orderID)
			throws RemoteException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void moveGoods(String comID, Object[][] data) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void addCommodity(String comID, String location)
			throws RemoteException {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void removeCommodity(String comID) throws RemoteException {
		// TODO Auto-generated method stub
		
	}

	@Override
	public ArrayList<ComInfoPO> getCommodity() throws RemoteException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void addEnterReceipt(EnterReceiptPO po)
			throws RemoteException {
		// TODO Auto-generated method stub
		
		enterDao.add(po);
		
	}

	@Override
	public String getNextEnterID(String comID) throws RemoteException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public ArrayList<EnterReceiptPO> getEnterReceipt(String comID)
			throws RemoteException {
		// TODO Auto-generated method stub
		
		return enterDao.showAll(comID);
	}

	@Override
	public ArrayList<EnterReceiptPO> getEnterReceipt() throws RemoteException {
		// TODO Auto-generated method stub
		
		return enterDao.showAll();
	}

	@Override
	public ArrayList<EnterReceiptPO> getSummitEnter() throws RemoteException {
		// TODO Auto-generated method stub
		
		return enterDao.showAllSummit();
	}

	@Override
	public ResultMessage approveEnterReceipt(String id) throws RemoteException {
		// TODO Auto-generated method stub
		
		return enterDao.approve(id);
	}

	@Override
	public void addExitReceipt(ExitReceiptPO po)
			throws RemoteException {
		// TODO Auto-generated method stub
		
		exitDao.add(po);
		
	}

	@Override
	public String getNextExitID(String comID) throws RemoteException {
		// TODO Auto-generated method stub
		
		return null;
	}

	@Override
	public ArrayList<ExitReceiptPO> getExitReceipt(String comID)
			throws RemoteException {
		// TODO Auto-generated method stub
		
		return exitDao.showAll(comID);
	}

	@Override
	public ArrayList<ExitReceiptPO> getExitReceipt() throws RemoteException {
		// TODO Auto-generated method stub
		
		return exitDao.showAll();
	}

	@Override
	public ArrayList<ExitReceiptPO> getSummitExit() throws RemoteException {
		// TODO Auto-generated method stub
		
		return exitDao.showAllSummit();
	}

	@Override
	public ResultMessage approveExitReceipt(String id) throws RemoteException {
		// TODO Auto-generated method stub
		
		return exitDao.approve(id);
	}

}
