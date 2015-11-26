package edu.nju.express.dataimpl;

import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;
import java.util.ArrayList;

import edu.nju.express.common.ResultMessage;
import edu.nju.express.data.userdata.UserMessageDao;
import edu.nju.express.data.userdata.UserMessageFileDao;
import edu.nju.express.dataservice.UserMessageDataService;
import edu.nju.express.po.UserMessagePO;

public class UserMessageDataService_Impl extends UnicastRemoteObject implements UserMessageDataService{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	
	UserMessageDao userMessageDao;
	
	
	public UserMessageDataService_Impl() throws RemoteException {
		super();
		// TODO Auto-generated constructor stub
	
	userMessageDao = new UserMessageFileDao("usermessage");
	
	}

	@Override
	public ResultMessage insert(UserMessagePO po) throws RemoteException {
		// TODO Auto-generated method stub
		return userMessageDao.insert(po);
	}

	@Override
	public ResultMessage delete(String id) throws RemoteException {
		// TODO Auto-generated method stub
		return userMessageDao.delete(id);
	}

	@Override
	public UserMessagePO find(String id) throws RemoteException {
		// TODO Auto-generated method stub
		return userMessageDao.find(id);
	}

	@Override
	public ArrayList<UserMessagePO> getAll() throws RemoteException {
		// TODO Auto-generated method stub
		return userMessageDao.showAll();
	}

	@Override
	public void flush() throws RemoteException {
		// TODO Auto-generated method stub
		userMessageDao.flush();
	}

}
