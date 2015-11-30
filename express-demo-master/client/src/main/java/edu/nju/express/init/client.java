package edu.nju.express.init;

import edu.nju.express.presentation.loginui.LoginUI;






public class client {

	public static void main(String[] s){
		RMIHelper.init();
		System.out.println("Client creates!");
		
	
		new LoginUI();
		
		
	}
}