package edu.nju.express.net;

import java.rmi.Remote;
import java.rmi.RemoteException;

public interface CheckService extends Remote {

	public void check() throws RemoteException;
}
