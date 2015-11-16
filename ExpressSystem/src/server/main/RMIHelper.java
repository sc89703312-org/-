package server.main;

import java.net.MalformedURLException;
import java.rmi.Naming;
import java.rmi.RemoteException;
import java.rmi.registry.LocateRegistry;

import server.dataservice.accountdataservice.AccountDataService_Impl;
import server.dataservice.balancedataservice.BalanceDataService_Impl;
import server.dataservice.bankingdataservice.BankingDataService_Impl;
import server.dataservice.paymentdataservice.impl.PaymentDataservice_Impl;
import server.dataservice.vehicledataservice.VehicleDataService_Impl;
import client.dataservice.accountdataservice.accountdataservice;
import client.dataservice.balancedataservice.balancedataservice;
import client.dataservice.bankingdataservice.BankingDataService;
import client.dataservice.paymentdataservice.Paymentdataservice;
import client.dataservice.vehicledataservice.vehicledataservice;


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
