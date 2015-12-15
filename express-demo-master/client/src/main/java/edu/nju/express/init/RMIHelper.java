package edu.nju.express.init;

import java.net.MalformedURLException;
import java.rmi.Naming;
import java.rmi.NotBoundException;
import java.rmi.RemoteException;

import edu.nju.express.config.RMIConfig;
import edu.nju.express.dataservice.*;




public class RMIHelper {
	
	
	
	
	
	
    private static final String IP = RMIConfig.HOST;//Can be read from config file
   
    
    private static Paymentdataservice paymentDataservice;
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
    private static StationDataService stationDataService;
    private static LoginInfoDataService loginInfoDataService;
    private static CommodityDataService commodityDataService;
    
    public static void init() {
        try {
//        	
//        	
//            paymentDataservice = (Paymentdataservice) Naming.lookup("rmi://" + IP + "/payment-service");
//            vehicledataservice = (vehicledataservice) Naming.lookup("rmi://" + IP + "/vehicle-service");
//            balancedataservice = (balancedataservice) Naming.lookup("rmi://" + IP + "/balance-service");
//            bankingDataService = (BankingDataService) Naming.lookup("rmi://" + IP + "/banking_service");
//            accountdataservice = (accountdataservice) Naming.lookup("rmi://" + IP + "/account-service");
//            orderdataservice = (orderdataservice) Naming.lookup("rmi://" + IP + "/order-service");
//            hallDataService = (HallDataService) Naming.lookup("rmi://" + IP + "/hall-service");
//            userDataService = (UserDataService) Naming.lookup("rmi://" + IP + "/user-service");
//            userMessageDataService = (UserMessageDataService) Naming.lookup("rmi://" + IP + "/usermessage-service");
               salaryDataService = (SalaryDataService) Naming.lookup("rmi://" + IP + "/salary-service");
               constantDataService = (ConstantDataService) Naming.lookup("rmi://" + IP + "/constant-service");
               logRecordDataService = (LogRecordDataService)Naming.lookup("rmi://" + IP + "/log-service");
//            stationDataService = (StationDataService)Naming.lookup("rmi://" + IP + "/station-service");
//            loginInfoDataService = (LoginInfoDataService)Naming.lookup("rmi://" + IP + "/login-info")  ;
//            commodityDataService = (CommodityDataService)Naming.lookup("rmi://" + IP + "/commodity-service");
//      
        } catch (MalformedURLException e) {
            e.printStackTrace();
        } catch (RemoteException e) {
            e.printStackTrace();
        } catch (NotBoundException e) {
            e.printStackTrace();
        }
    }

//    public static Paymentdataservice getPaymentDataService() {
//        return paymentDataservice;
//    }
//    public static vehicledataservice getVehicleDataService() {
//        return vehicledataservice;
//    }
//    public static balancedataservice getBalanceDataService() {
//        return balancedataservice;
//    }
//    public static BankingDataService getBankingDataService(){
//    	return bankingDataService;
//    }
//    public static accountdataservice getAccountdataservice(){
//    	return accountdataservice;
//    }
//    public static orderdataservice getOrderdataservice(){
//    	return orderdataservice;
//    }
//    public static HallDataService getHallDataService(){
//    	return hallDataService;
//    }
//    public static CommodityDataService getCommodityDataService(){
//    	return commodityDataService;
//    }
//    public static UserDataService getUserDataService(){
//    	return userDataService;
//    }
//    public static UserMessageDataService getUserMessageDataService(){
//    	return userMessageDataService;
//    }
    public static SalaryDataService getSalaryDataService(){
    	return salaryDataService;
    }
    public static ConstantDataService getConstantDataService(){
    	return constantDataService;
    }
    public static LogRecordDataService getLogRecordDataService(){
    	return logRecordDataService;
    }
//    public static StationDataService getStationDataService(){
//    	return stationDataService;
//    }
//    public static LoginInfoDataService getLoginInfoDataService(){
//    	return loginInfoDataService;
//    }
}