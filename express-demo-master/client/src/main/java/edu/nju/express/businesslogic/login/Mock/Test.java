package edu.nju.express.businesslogic.login.Mock;

import edu.nju.express.businesslogic.login.Login;

public class Test {

	public static void main(String [] s){
		Login login = new Login();
		System.out.println(login.login("admin", "admin"));
	}
}
