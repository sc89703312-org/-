package server.main;

import java.net.MalformedURLException;
import java.rmi.Naming;
import java.rmi.RemoteException;
import java.rmi.registry.LocateRegistry;

import server.dataservice.balancedataservice.BalanceDataService_Impl;
import server.dataservice.paymentdataservice.impl.PaymentDataservice_Impl;
import server.dataservice.vehicledataservice.VehicleDataService_Impl;
import client.dataservice.balancedataservice.balancedataservice;
import client.dataservice.paymentdataservice.Paymentdataservice;
import client.dataservice.vehicledataservice.vehicledataservice;


public class RMIHelper {

	
	private static Paymentdataservice paymentdataservice;
	private static vehicledataservice vehicledataservice;
	
	 public static void init() {
	        try {
	            LocateRegistry.createRegistry(1099);

	             paymentdataservice = new PaymentDataservice_Impl();
	            
	             vehicledataservice = new VehicleDataService_Impl();

	            balancedataservice balancedataservice = new BalanceDataService_Impl();
	            
	            
	            Naming.rebind("payment-service",paymentdataservice);

	            Naming.rebind("vehicle-service", vehicledataservice);
	            
	            Naming.rebind("balance-service", balancedataservice);
	        } catch (MalformedURLException e) {
	            e.printStackTrace();
	        } catch (RemoteException e) {
	            e.printStackTrace();
	        }


	    }


	

	 
	 public static void end(){
		 try {
			paymentdataservice.flush();
			vehicledataservice.flushCars();
			vehicledataservice.flushDrivers();
		} catch (RemoteException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	 }

	
	
	

}
