package client.main;

import java.awt.List;
import java.rmi.RemoteException;
import java.util.ArrayList;

import client.businesslogic.vehiclebl.CarControl;
import client.businesslogic.vehiclebl.Vehiclebl;
import client.po.carpo.Carpo;
import client.po.driverpo.Driverpo;
import client.po.paymentpo.Paymentpo;
import client.presentation.payment.PaymentPanel;
import client.presentation.payment.paymentui;
import client.vo.carvo.Carvo;
import client.vo.drivervo.Drivervo;
import client.vo.paymentvo.Paymentvo;

public class client {

	public static void main(String[] s){
		RMIHelper.init();
		System.out.println("Client creates!");
		

		
		
//		try {
//			RMIHelper.getVehicleDataService().insertDri(new Driverpo(025000001, "XiaoLiu",
//															 "1996/1/3", "321283",
//															 "89703312", "025000",
//															 true, "2016/1/2"));
//		} catch (RemoteException e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		}
		
		
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
//	paymentui ui = new paymentui();
	
//		
//		try {
//			RMIHelper.getVehicleDataService().findCar(02500020);
			
//			RMIHelper.getVehicleDataService().deleteCar(RMIHelper.getVehicleDataService().findCar(02500021));
			
//		RMIHelper.getVehicleDataService().insertCar(new Carpo(02500022, "motor-1",
//            "Su-A 0523", "base-1", 
//            "2016/1/3", 1));
			
//			RMIHelper.getVehicleDataService().findCar(02500021);
//		} catch (RemoteException e) {
//			// TODO Auto-generated catch block
//			System.out.println("error");
//			e.printStackTrace();
//		}
		
	}
}
