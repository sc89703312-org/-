package edu.nju.express.init;

import java.net.InetAddress;
import java.net.UnknownHostException;
import java.util.Scanner;

import edu.nju.express.ui.frame.ServerFrame;




public class Server {

	

	
	
	
	
	public static void main(String[] s){
		RMIHelper.init();
		System.out.println("Server creates!");
		
	    new ServerFrame();
		
	

	    

		
		
		
		
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
