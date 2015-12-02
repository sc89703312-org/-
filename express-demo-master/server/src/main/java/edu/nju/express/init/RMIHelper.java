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
	private static orderdataservice orderdataservice;
	private static HallDataService hallDataService;
	private static UserDataService userDataService;
	private static UserMessageDataService userMessageDataService;
	private static SalaryDataService salaryDataService;
	private static ConstantDataService constantDataService;
	private static LogRecordDataService logRecordDataService;
	
	
	 public static void init() {
	        try {
	            LocateRegistry.createRegistry(1099);

	             paymentdataservice = new PaymentDataservice_Impl();
	            
	             vehicledataservice = new VehicleDataService_Impl();

	             balancedataservice = new BalanceDataService_Impl();
	            
	             bankingDataService = new BankingDataService_Impl();
	            
	             accountdataservice = new AccountDataService_Impl();
	             
	             orderdataservice = new OrderDataService_Impl();
	             
	             hallDataService = new HallDataService_Impl();
	             
	             userDataService = new UserDataService_Impl();
	             	             
	             userMessageDataService = new UserMessageDataService_Impl();
	             
	             salaryDataService = new SalaryDataService_Impl();
	             
	             constantDataService =new ConstantDataService_Impl();
	             
	             logRecordDataService = new LogRecordDataService_Impl();
	             
	            Naming.rebind("payment-service",paymentdataservice);

	            Naming.rebind("vehicle-service", vehicledataservice);
	            
	            Naming.rebind("balance-service", balancedataservice);
	            
	            Naming.rebind("banking_service", bankingDataService);
	        
	            Naming.rebind("account-service", accountdataservice);
	        
	            Naming.rebind("order-service", orderdataservice);
	            
	            Naming.rebind("hall-service", hallDataService);
	            	            
	            Naming.rebind("user-service", userDataService);
	            
	            Naming.rebind("usermessage-service", userMessageDataService);
	            
	            Naming.rebind("salary-service", salaryDataService);
	        
	            Naming.rebind("constant-service", constantDataService);
	            
	            Naming.rebind("log-service", logRecordDataService);
	            
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
			hallDataService.flushHalls();
			hallDataService.flushHallArrival();
			hallDataService.flushHallDeliver();
			hallDataService.flushHallTransfer();
			orderdataservice.flush();
			userDataService.flush();
			userMessageDataService.flush();
			salaryDataService.flush();
			constantDataService.flush();
			logRecordDataService.flush();
		    bankingDataService.flush();
		} catch (RemoteException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	 }

	
	
	

}
