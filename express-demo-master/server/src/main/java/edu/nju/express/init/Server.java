package edu.nju.express.init;


import java.net.MalformedURLException;
import java.rmi.Naming;
import java.rmi.RemoteException;
import java.rmi.registry.LocateRegistry;
import java.util.Scanner;

import edu.nju.express.config.RMIConfig;
import edu.nju.express.dataimpl.LoginInfoDataService_Impl;
import edu.nju.express.dataservice.LoginInfoDataService;
import edu.nju.express.ui.frame.ServerFrame;




public class Server {

	private static LoginInfoDataService loginInfoDataService;

	
	
	
	
	public static void main(String[] s){
		
		
		new ServerFrame();
		
		
//		new RMIHelper().start();
		System.out.println("Server creates!");
		
		
		
	    
		
	
		
		new Thread(new Runnable() {
			
			@Override
			public void run() {
				// TODO Auto-generated method stub
				
				Scanner scanner=new Scanner(System.in);
				
				while(true){
					String temp = scanner.next();
					
					if(temp.equals("#")){
						System.out.println("End the Server and update all data");
						RMIHelper.end();
						System.exit(0);
					}else {
						System.out.println("Not end char");
					}
				}
			}
		}).start();
		
	}
	
	
	
	
	
}
