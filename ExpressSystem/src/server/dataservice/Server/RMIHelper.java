package server.dataservice.Server;

import java.net.MalformedURLException;
import java.rmi.Naming;
import java.rmi.RemoteException;
import java.rmi.registry.LocateRegistry;

import server.dataservice.paymentdataservice.impl.PaymentDataservice_Impl;
import server.dataservice.vehicledataservice.VehicleDataService_Impl;
import client.dataservice.paymentdataservice.Paymentdataservice;
import client.dataservice.vehicledataservice.vehicledataservice;


public class RMIHelper {

	 public static void init() {
	        try {
	            LocateRegistry.createRegistry(1099);

	            Paymentdataservice paymentdataservice = new PaymentDataservice_Impl();
	            
	            vehicledataservice vehicledataservice = new VehicleDataService_Impl();

	            Naming.rebind("payment-service",paymentdataservice);

	            Naming.rebind("vehicle-service", vehicledataservice);
	            
	            
	        } catch (MalformedURLException e) {
	            e.printStackTrace();
	        } catch (RemoteException e) {
	            e.printStackTrace();
	        }


	    }


	


	
	
	

}
