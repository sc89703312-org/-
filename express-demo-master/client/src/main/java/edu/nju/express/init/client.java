package edu.nju.express.init;


import java.rmi.RemoteException;

import edu.nju.express.presentation.Location;
import edu.nju.express.presentation.loginui.LoginUI;
import edu.nju.express.presentation.myUI.WarningDialog;

import static edu.nju.express.init.RMIHelper.checkService;



public class client {
	
	static LoginUI ui ;

	public static void main(String[] s){
		
		
		try {
			RMIHelper.init();
		} catch (Exception e) {
			// TODO: handle exception
		}
		
		System.out.println("Client creates!");
		

        ui = new LoginUI();
		Location.init();
	
		new Thread(new Runnable() {
			
			@Override
			public void run() {
				// TODO Auto-generated method stub
				
				while(true)
				{
				
				
    			try {
					checkService.check();
				} catch (RemoteException e) {
					// TODO Auto-generated catch block
					System.out.println("网断了少年！");
					WarningDialog.showConnectionError();
					checkNet();
					}
				}
				
			}
		}).start();
		

		try {
			Thread.sleep(2000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	
	
	
	public static void checkNet()
	{
	
				
		while (true) {

			
			try {
			
				RMIHelper.init();
				checkService.check();
				WarningDialog.showSucessConnect();
				System.out.println("网好了");

				break;
			} catch (RemoteException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
			
		try {
			Thread.sleep(2000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	
	}
	
	
	
	
	
}