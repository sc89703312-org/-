package server.dataservice.paymentdataservice.Server;

import java.net.MalformedURLException;
import java.rmi.Naming;
import java.rmi.RemoteException;
import java.rmi.registry.LocateRegistry;

import server.dataservice.paymentdataservice.impl.PaymentDataservice_Impl;
import client.dataservice.paymentdataservice.Paymentdataservice;


public class RMIHelper {

	 public static void init() {
	        try {
	            LocateRegistry.createRegistry(1099);

	            Paymentdataservice paymentdataservice = new PaymentDataservice_Impl();

	            Naming.rebind("payment-service",paymentdataservice);

	        } catch (MalformedURLException e) {
	            e.printStackTrace();
	        } catch (RemoteException e) {
	            e.printStackTrace();
	        }


	    }


	


	
	
	

}
