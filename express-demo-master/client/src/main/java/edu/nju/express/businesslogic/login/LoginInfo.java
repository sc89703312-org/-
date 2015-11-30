package edu.nju.express.businesslogic.login;

public class LoginInfo {

	
	private static String id;
	private static String userName;
	
	
	public static void setID(String ID){
		id = ID;
	}
	
	
	public static void setUserName(String name){
		userName = name;
	}
	
	
	public static String getID(){
		return id;
	}
	
	
	public static String getUserName(){
		return userName;
	}
}
