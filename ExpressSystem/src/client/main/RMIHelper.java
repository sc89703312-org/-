package client.main;

import java.net.MalformedURLException;
import java.rmi.Naming;
import java.rmi.NotBoundException;
import java.rmi.RemoteException;

import client.dataservice.accountdataservice.accountdataservice;
import client.dataservice.balancedataservice.balancedataservice;
import client.dataservice.bankingdataservice.BankingDataService;
import client.dataservice.paymentdataservice.Paymentdataservice;
import client.dataservice.vehicledataservice.vehicledataservice;



public class RMIHelper {
    private static final String IP = "127.0.0.1";//Can be read from config file
   
    
    private static Paymentdataservice paymentDataservice;
    private static vehicledataservice vehicledataservice;
    private static balancedataservice balancedataservice;
    private static BankingDataService bankingDataService;
    private static accountdataservice accountdataservice;
    
    
    
    
    public static void init() {
        try {
        	
        	
            paymentDataservice = (Paymentdataservice) Naming.lookup("rmi://" + IP + "/payment-service");
            vehicledataservice = (vehicledataservice) Naming.lookup("rmi://" + IP + "/vehicle-service");
            balancedataservice = (balancedataservice) Naming.lookup("rmi://" + IP + "/balance-service");
//          bankingDataService = (BankingDataService) Naming.lookup("rmi://" + IP + "/banking-service");
            accountdataservice = (accountdataservice) Naming.lookup("rmi://" + IP + "/account-service");
        
        
        
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
}