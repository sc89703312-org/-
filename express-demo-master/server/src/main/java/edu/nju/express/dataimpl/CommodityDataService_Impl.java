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
		ComInfoPO po = comInfoDao.find(comID);
		return po.getComGoodsList();
	}

	@Override
	public String getLocation(String comID) throws RemoteException {
		// TODO Auto-generated method stub
		ComInfoPO po = comInfoDao.find(comID);
		return po.getLocation();
	}

	@Override
	public ComZonePO getZone(String comID) throws RemoteException {
		// TODO Auto-generated method stub
		ComInfoPO po = comInfoDao.find(comID);
		return po.getZone();
	}

	@Override
	public ResultMessageV2 modifyZone(String comID, int[] space)
			throws RemoteException {
		// TODO Auto-generated method stub
		
		ComInfoPO com = comInfoDao.find(comID);
		ComZonePO po = com.getZone();
		boolean[] planeSpace = po.getIsEmptyPlane();
		boolean[] trainSpace = po.getIsEmptyTrain();
		boolean[] carSpace = po.getIsEmptyCar();
		boolean[] temSpace = po.getIsEmptyTem();
		for(int i=planeSpace.length;i<space[0];i++)
			if(planeSpace[i]==false)
				return ResultMessageV2.ERROR;
		for(int i=trainSpace.length;i<space[1];i++)
			if(trainSpace[i]==false)
				return ResultMessageV2.ERROR;
		for(int i=carSpace.length;i<space[2];i++)
			if(carSpace[i]==false)
				return ResultMessageV2.ERROR;
		for(int i=temSpace.length;i<space[3];i++)
			if(temSpace[i]==false)
				return ResultMessageV2.ERROR;
		
		boolean[] newPlane = new boolean[space[0]];
		boolean[] newTrain = new boolean[space[1]];
		boolean[] newCar = new boolean[space[2]];
		boolean[] newTem = new boolean[space[3]];
		
		for(int i=0;i<space[0];i++)
			newPlane[i] = planeSpace[i];
		for(int i=0;i<space[0];i++)
			newTrain[i] = trainSpace[i];
		for(int i=0;i<space[0];i++)
			newCar[i] = carSpace[i];
		for(int i=0;i<space[0];i++)
			newTem[i] = temSpace[i];
		
		po.setIsEmptyPlane(newPlane);
		po.setIsEmptyTrain(newTrain);
		po.setIsEmptyCar(newCar);
		po.setIsEmptyTem(newTem);
		
		comInfoDao.modify(comID, com);
		
		return ResultMessageV2.SUCCESS;
	}

	@Override
	public ResultMessageV2 initZone(String comID) throws RemoteException {
		// TODO Auto-generated method stub
		
		ComZonePO po = comInfoDao.find(comID).getZone();
		
		return modifyZone(comID,po.getSpace());
	}

	@Override
	public void addGoods(String comID, EnterReceiptPO po)
			throws RemoteException {
		// TODO Auto-generated method stub
		comInfoDao.addGoods(comID, po.getGoods());
	}

	@Override
	public void removeGoods(String comID, ExitReceiptPO po)
			throws RemoteException {
		// TODO Auto-generated method stub
		comInfoDao.removeGoods(comID, po.getGoods());
	}

	@Override
	public ComGoodsPO getGoods(String comID, String orderID)
			throws RemoteException {
		// TODO Auto-generated method stub
		ArrayList<ComGoodsPO> list = comInfoDao.find(comID).getComGoodsList();
		for(int i=0;i<list.size();i++)
			if(list.get(i).getId().equals(orderID))
				return list.get(i);
		return null;
	}

	@Override
	public void moveGoods(String comID, Object[][] data) {
		// TODO Auto-generated method stub
		ComInfoPO po = comInfoDao.find(comID);
		ComZonePO zone = po.getZone();
		ArrayList<ComGoodsPO> goods = po.getComGoodsList();
		
		 int shelfPerLine = zone.getShelfPerLine();
		 int cellPerShelf = zone.getCellPerShelf();
		 
		 boolean isEmptyPlane[] = zone.getIsEmptyPlane();
		 boolean isEmptyTrain[] = zone.getIsEmptyTrain();
		 boolean isEmptyCar[] = zone.getIsEmptyCar();
		 boolean isEmptyTem[] = zone.getIsEmptyTem();
			
		 for(int i=0;i<isEmptyPlane.length;i++)
				isEmptyPlane[i] = true;
		 for(int i=0;i<isEmptyTrain.length;i++)
				isEmptyTrain[i] = true;
		 for(int i=0;i<isEmptyCar.length;i++)
				isEmptyCar[i] = true;
		 for(int i=0;i<isEmptyTem.length;i++)
				isEmptyTem[i] = true;
		
		for(int i=0;i<data.length;i++){
			int index = (Integer.parseInt((String) data[i][2])-1)*shelfPerLine*cellPerShelf+(Integer.parseInt((String) data[i][3])-1)*cellPerShelf+(Integer.parseInt((String) data[i][4])-1);
			goods.get(i).setLine(Integer.parseInt((String) data[i][2]));
			goods.get(i).setShelf(Integer.parseInt((String) data[i][3]));
			goods.get(i).setCell(Integer.parseInt((String) data[i][4]));
			String type = (String) data[i][1];
			if(type.equals("航运区"))
				isEmptyPlane[index] = false;
			if(type.equals("铁运区"))
				isEmptyTrain[index] = false;
			if(type.equals("汽运区"))
				isEmptyCar[index] = false;
			if(type.equals("机动区"))
				isEmptyTem[index] = false;
		}
		
		zone.setIsEmptyPlane(isEmptyPlane);
		zone.setIsEmptyTrain(isEmptyTrain);
		zone.setIsEmptyCar(isEmptyCar);
		zone.setIsEmptyTem(isEmptyTem);
		
		comInfoDao.modify(comID, po);
		
	}

	@Override
	public void addCommodity(String comID, String location, int totalSpace)
			throws RemoteException {
		// TODO Auto-generated method stub
		
		ComInfoPO po = new ComInfoPO(comID,location,totalSpace);
		comInfoDao.add(po);
		
	}

	@Override
	public void removeCommodity(String comID) throws RemoteException {
		// TODO Auto-generated method stub
		
		comInfoDao.remove(comID);
		
	}

	@Override
	public ArrayList<ComInfoPO> getCommodity() throws RemoteException {
		// TODO Auto-generated method stub
		return comInfoDao.getAll();
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
		
		return enterDao.nextID(comID);
	}

	@Override
	public ArrayList<EnterReceiptPO> getEnterReceipt(String comID)
			throws RemoteException {
		// TODO Auto-generated method stub
		
		return enterDao.showAllReceipt(comID);
	}

	@Override
	public ArrayList<EnterReceiptPO> getEnterReceipt() throws RemoteException {
		// TODO Auto-generated method stub
		
		return enterDao.showAllReceipt();
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
		
		return exitDao.nextID(comID);
	}

	@Override
	public ArrayList<ExitReceiptPO> getExitReceipt(String comID)
			throws RemoteException {
		// TODO Auto-generated method stub
		
		return exitDao.showAllReceipt(comID);
	}

	@Override
	public ArrayList<ExitReceiptPO> getExitReceipt() throws RemoteException {
		// TODO Auto-generated method stub
		
		return exitDao.showAllReceipt();
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
	
	@Override
	public void flush(){
		comInfoDao.flush();
		enterDao.flush();
		exitDao.flush();
	}

}
