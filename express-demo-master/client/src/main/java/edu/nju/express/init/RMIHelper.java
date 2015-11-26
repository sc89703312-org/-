package edu.nju.express.init;

import java.net.MalformedURLException;
import java.rmi.Naming;
import java.rmi.NotBoundException;
import java.rmi.RemoteException;

import edu.nju.express.blservice.Balanceblservice;
import edu.nju.express.dataservice.*;




public class RMIHelper {
    private static final String IP = "127.0.0.1";//Can be read from config file
   
    
    private static Paymentdataservice paymentDataservice;
    private static vehicledataservice vehicledataservice;
    private static balancedataservice balancedataservice;
    private static BankingDataService bankingDataService;
    private static accountdataservice accountdataservice;
    private static orderdataservice orderdataservice;
    private static HallDataService hallDataService;
    private static LogisticsDataService logisticsDataService;
    private static UserDataService userDataService;
    private static UserMessageDataService userMessageDataService;
    
    public static void init() {
        try {
        	
        	
            paymentDataservice = (Paymentdataservice) Naming.lookup("rmi://" + IP + "/payment-service");
            vehicledataservice = (vehicledataservice) Naming.lookup("rmi://" + IP + "/vehicle-service");
            balancedataservice = (balancedataservice) Naming.lookup("rmi://" + IP + "/balance-service");
//          bankingDataService = (BankingDataService) Naming.lookup("rmi://" + IP + "/banking-service");
            accountdataservice = (accountdataservice) Naming.lookup("rmi://" + IP + "/account-service");
            orderdataservice = (orderdataservice) Naming.lookup("rmi://" + IP + "/order-service");
            hallDataService = (HallDataService) Naming.lookup("rmi://" + IP + "/hall-service");
            logisticsDataService = (LogisticsDataService) Naming.lookup("rmi://" + IP + "/logistics-service");
            userDataService = (UserDataService) Naming.lookup("rmi://" + IP + "/user-service");
            userMessageDataService = (UserMessageDataService) Naming.lookup("rmi://" + IP + "/usermessage-service");
            
            
        } catch (MalformedURLException e) {
            e.printStackTrace();
        } catch (RemoteException e) {
            e.printStackTrace();
        } catch (NotBoundException e) {
            e.printStackTrace();
        }
    }

    public static Paymentdataservice getPaymentDataService() {
        return paymentDataservice;
    }
    public static vehicledataservice getVehicleDataService() {
        return vehicledataservice;
    }
    public static balancedataservice getBalanceDataService() {
        return balancedataservice;
    }
    public static BankingDataService getBankingDataService(){
    	return bankingDataService;
    }
    public static accountdataservice getAccountdataservice(){
    	return accountdataservice;
    }
    public static orderdataservice getOrderdataservice(){
    	return orderdataservice;
    }
    public static HallDataService getHallDataService(){
    	return hallDataService;
    }
    public static LogisticsDataService getLogisticsDataService(){
    	return logisticsDataService;
    }
    public static UserDataService getUserDataService(){
    	return userDataService;
    }
    public static UserMessageDataService getUserMessageDataService(){
    	return userMessageDataService;
    }
}