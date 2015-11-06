package server.main;

import java.util.Scanner;



public class Server {

	public static void main(String[] s){
		RMIHelper.init();
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
