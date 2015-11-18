package edu.nju.express.dataimpl;

import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;
import java.util.ArrayList;

import edu.nju.express.data.userdata.UserDao;
import edu.nju.express.data.userdata.UserFileDao;
import edu.nju.express.dataservice.UserDataService;
import edu.nju.express.po.UserPO;

public class UserDataService_Impl extends UnicastRemoteObject implements UserDataService{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	UserDao userDao;
	
	public UserDataService_Impl() throws RemoteException{
		userDao = new UserFileDao();
	}
	
	@Override
	public int insert(UserPO po) throws RemoteException {
		// TODO Auto-generated method stub
		return userDao.insert(po);
	}

	@Override
	public int delete(String id) throws RemoteException {
		// TODO Auto-generated method stub
		return userDao.delete(id);
	}

	@Override
	public int modify(UserPO po) throws RemoteException {
		// TODO Auto-generated method stub
		return userDao.modify(po);
	}

	@Override
	public UserPO find(String id) throws RemoteException {
		// TODO Auto-generated method stub
		return userDao.find(id);
	}

	@Override
	public ArrayList<UserPO> getAll() throws RemoteException {
		// TODO Auto-generated method stub
		return userDao.getAll();
	}

	@Override
	public void flush() throws RemoteException {
		userDao.flush();
		
	}

}
