package edu.nju.express.init;

import java.net.MalformedURLException;
import java.rmi.Naming;
import java.rmi.Remote;
import java.rmi.RemoteException;
import java.rmi.registry.LocateRegistry;
import java.rmi.server.UnicastRemoteObject;

import edu.nju.express.config.RMIConfig;
import edu.nju.express.dataimpl.*;
import edu.nju.express.dataservice.*;
import edu.nju.express.ui.frame.ServerFrame;




public class RMIHelper extends Thread{

	
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
	private static StationDataService stationDataService;
	private static ConstantDataService constantDataService;
	private static LogRecordDataService logRecordDataService;
	private static LoginInfoDataService loginInfoDataService;
	private static CommodityDataService commodityDataService;
	static Remote registry;
	
	public static boolean  isStarted = false;
	
	
		           

		@Override
		public void run(){
			
	
	
	        try {

	          registry =   LocateRegistry.createRegistry(Integer.parseInt(RMIConfig.PORT));
	            
	             loginInfoDataService = new LoginInfoDataService_Impl();
	             
	             

	             
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
	             
	             stationDataService = new StationDataService_Impl();
	             

	             
	             commodityDataService = new CommodityDataService_Impl();
	             
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
	            
	            Naming.rebind("station-service", stationDataService);
	            
	            Naming.rebind("login-info", loginInfoDataService);
	            
	            Naming.rebind("commodity-service", commodityDataService);
	            
	        } catch (MalformedURLException e) {
	            e.printStackTrace();
	        } catch (RemoteException e) {
	            e.printStackTrace();
	        }


	    
	}
	

	

	 
	 public static void end(){
		 
		 
		 isStarted = false;
		 
		 
		 
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
		    stationDataService.flush();
		    loginInfoDataService.flush();
		    commodityDataService.flush();
		    UnicastRemoteObject.unexportObject(registry, true);
		} catch (RemoteException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	 }

	
	
	

}
