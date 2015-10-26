package client.main;

import java.net.MalformedURLException;
import java.rmi.Naming;
import java.rmi.NotBoundException;
import java.rmi.RemoteException;

import client.dataservice.paymentdataservice.Paymentdataservice;
import client.dataservice.vehicledataservice.vehicledataservice;



public class RMIHelper {
    private static final String IP = "127.0.0.1";//Can be read from config file
    private static Paymentdataservice paymentDataservice;
    private static vehicledataservice vehicledataservice;
    public static void init() {
        try {
            paymentDataservice =  (Paymentdataservice) Naming.lookup("rmi://" + IP + "/payment-service");
            vehicledataservice = (vehicledataservice) Naming.lookup("rmi://" + IP + "/vehicle-service");
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
}