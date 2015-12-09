package edu.nju.express.dataimpl;

import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;
import java.util.ArrayList;

import edu.nju.express.data.constant.ConstantDao;
import edu.nju.express.data.constant.ConstantFileDao;
import edu.nju.express.dataservice.ConstantDataService;

public class ConstantDataService_Impl extends UnicastRemoteObject implements ConstantDataService{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	
	ConstantDao constantDao;
	
	
	
	
	
	public ConstantDataService_Impl() throws RemoteException {
		super();
		// TODO Auto-generated constructor stub
	
	constantDao = new ConstantFileDao("constant");
	
	
	}

	@Override
	public void flush() throws RemoteException {
		// TODO Auto-generated method stub
		constantDao.flush();
	}

	@Override
	public void setPrice(double price) throws RemoteException {
		// TODO Auto-generated method stub
		constantDao.setPrice(price);
	}

	@Override
	public double getPrice() throws RemoteException {
		// TODO Auto-generated method stub
		return constantDao.getPrice();
	}

	@Override
	public void setVehicleCost(double van, double railway, double airplane)
			throws RemoteException {
		// TODO Auto-generated method stub
		constantDao.setVehicleCost(van, railway, airplane);
	}

	@Override
	public double[] getVehicleCost() throws RemoteException {
		// TODO Auto-generated method stub
		return constantDao.getVehicleCost();
	}

	@Override
	public void setVehicleLoad(int van, int railway, int airplane)
			throws RemoteException {
		// TODO Auto-generated method stub
		constantDao.setVehicleLoad(van, railway, airplane);
	}

	@Override
	public int[] getVehicleLoad() throws RemoteException {
		// TODO Auto-generated method stub
		return constantDao.getVehicleLoad();
	}

	@Override
	public ArrayList<String> getCityList() throws RemoteException {
		// TODO Auto-generated method stub
		return constantDao.getCityList();
	}

	@Override
	public ArrayList<String> getCityDistance() throws RemoteException {
		// TODO Auto-generated method stub
		return constantDao.getCityDistance();
	}

	@Override
	public void addCity(String CityID,String id) throws RemoteException {
		// TODO Auto-generated method stub
		constantDao.addCity(CityID, id);
	}

	@Override
	public void setCityDistance(String CityID1, String CityID2, double distance)
			throws RemoteException {
		// TODO Auto-generated method stub
		constantDao.setCityDistance(CityID1, CityID2, distance);
	}

	@Override
	public void deleteCity(String CityID) throws RemoteException {
		// TODO Auto-generated method stub
		constantDao.deleteCity(CityID);
	}

}
