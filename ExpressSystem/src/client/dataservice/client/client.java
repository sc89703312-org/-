package client.dataservice.client;

import java.awt.List;
import java.rmi.RemoteException;
import java.util.ArrayList;

import client.po.carpo.Carpo;
import client.po.paymentpo.Paymentpo;
import client.presentation.payment.PaymentPanel;
import client.presentation.payment.paymentui;
import client.vo.paymentvo.Paymentvo;

public class client {

	public static void main(String[] s){
		RMIHelper.init();
		System.out.println("Client creates!");
		
		
		
//  	try {
//			RMIHelper.getPaymentDataService().insert(new Paymentpo("2015/9/12",
//				                                                      20, "025000000",
//				                                                      "0000000001", "sc89703312"));
//		
//		ArrayList<Paymentpo> temp = RMIHelper.getPaymentDataService().getAll();
//		for(int i=0;i<temp.size();i++){
//		System.out.println(new Paymentvo(temp.get(i).getDate(),temp.get(i).getPay(),
//					              temp.get(i).getCourier_id(),temp.get(i).getOrder_id(),
//			              temp.get(i).getBankaccount()).toString());
			
//					System.out.println();
//		}
			
//			RMIHelper.getVehicleDataService().insertCar(new Carpo(02500020, "motor-1",
//					                                                 "Su-A 8908", "base-1", 
//					                                                 "2016/1/1", 1));
//		
//			
//			
	
		
		
//		
//		} catch (RemoteException e) {
//			// TODO Auto-generated catch block
//		e.printStackTrace();
//		}
	paymentui ui = new paymentui();
	
	}
}
