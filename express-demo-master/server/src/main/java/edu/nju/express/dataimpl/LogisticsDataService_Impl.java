package edu.nju.express.dataimpl;

import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;
import java.util.ArrayList;

import edu.nju.express.common.ResultMessage;
import edu.nju.express.data.logisticsdata.LogisticsDao;
import edu.nju.express.data.logisticsdata.LogisticsFileDao;
import edu.nju.express.dataservice.LogisticsDataService;
import edu.nju.express.po.LogisticsPO;



public class LogisticsDataService_Impl extends UnicastRemoteObject implements LogisticsDataService{

	

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	/**
	 * 
	 */
	LogisticsDao logisticsDao;
	public LogisticsDataService_Impl() throws RemoteException {
		super();
		// TODO Auto-generated constructor stub
		logisticsDao = new LogisticsFileDao("logistics");
	}

	@Override
	public ResultMessage insert(LogisticsPO po) throws RemoteException {
		// TODO Auto-generated method stub
		return logisticsDao.insert(po);
	}

	@Override
	public ResultMessage update(LogisticsPO po) throws RemoteException {
		// TODO Auto-generated method stub
		return logisticsDao.update(po);
	}

	@Override
	public LogisticsPO find(String id) throws RemoteException {
		// TODO Auto-generated method stub
		return logisticsDao.find(id);
	}

	@Override
	public ArrayList<LogisticsPO> getAll()throws RemoteException {
		// TODO Auto-generated method stub
		return logisticsDao.showAll();
	}

	@Override
	public void flush() {
		// TODO Auto-generated method stub
		logisticsDao.flush();
	}

	

	

}
