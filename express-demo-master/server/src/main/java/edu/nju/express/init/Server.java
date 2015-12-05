package edu.nju.express.init;

import java.net.InetAddress;
import java.net.UnknownHostException;
import java.util.Scanner;




public class Server {

	
	private InetAddress addr;
	private static String hostAddr;
	private static String hostName;
	
	
	
	
	public static void main(String[] s){
		RMIHelper.init();
		System.out.println("Server creates!");
		
		new Server();
		System.out.println("HostAddress is : "+hostAddr+"\n"+"HostName is : "+hostName);
	


		
		
		
		
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
	
	
	
	public Server() {
		// TODO Auto-generated constructor stub
		
			try {
				addr = InetAddress.getLocalHost();
				hostAddr = addr.getHostAddress();
				hostName = addr.getHostName();
			} catch (UnknownHostException e) {
				e.printStackTrace();
			}
		
	
	
	}
	
}
