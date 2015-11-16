package edu.nju.express.init;

import java.net.MalformedURLException;
import java.rmi.Naming;
import java.rmi.RemoteException;
import java.rmi.registry.LocateRegistry;

import edu.nju.express.dataimpl.*;
import edu.nju.express.dataservice.*;




public class RMIHelper {

	
	private static Paymentdataservice paymentdataservice;
	private static vehicledataservice vehicledataservice;
	private static balancedataservice balancedataservice;
	private static BankingDataService bankingDataService;
	private static accountdataservice accountdataservice;
	
	 public static void init() {
	        try {
	            LocateRegistry.createRegistry(1099);

	             paymentdataservice = new PaymentDataservice_Impl();
	            
	             vehicledataservice = new VehicleDataService_Impl();

	             balancedataservice = new BalanceDataService_Impl();
	            
	             bankingDataService = new BankingDataService_Impl();
	            
	             accountdataservice = new AccountDataService_Impl();
	             
	            Naming.rebind("payment-service",paymentdataservice);

	            Naming.rebind("vehicle-service", vehicledataservice);
	            
	            Naming.rebind("balance-service", balancedataservice);
	            
//	            Naming.rebind("banking_service", bankingDataService);
	        
	            Naming.rebind("account-service", accountdataservice);
	        
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
			balancedataservice.flush();
			accountdataservice.flush();
		} catch (RemoteException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	 }

	
	
	

}
