package edu.nju.express.dataservice;

import java.rmi.Remote;
import java.rmi.RemoteException;
import java.util.ArrayList;

public interface ConstantDataService extends Remote{

	public void flush() throws RemoteException;
	
	public void setPrice(double price) throws RemoteException;
	
	public double getPrice() throws RemoteException;
	
	public void setVehicleCost(double van, double railway, double airplane)throws RemoteException;
	
	public double[] getVehicleCost()throws RemoteException;
	
	public void setVehicleLoad(int van, int railway, int airplane) throws RemoteException;
	
	public int[] getVehicleLoad() throws RemoteException;
	
	public ArrayList<String> getCityList() throws RemoteException;
	
	public ArrayList<String> getCityDistance() throws RemoteException;
	
}
