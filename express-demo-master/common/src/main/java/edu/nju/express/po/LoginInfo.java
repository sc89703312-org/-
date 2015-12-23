package edu.nju.express.po;

import java.io.Serializable;
import java.net.InetAddress;
import java.net.UnknownHostException;
import java.rmi.server.RemoteServer;
import java.rmi.server.ServerNotActiveException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class LoginInfo implements Serializable{

	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	
	/** 登陆ID */
	private  String id;
	/** 用户名称*/
	private  static String userName;
	/** 用户ID*/
	private  static String userID;
	/** 登陆名称*/
	private  String name;
	/** 登陆时间 */
	private  String loginTime;
	/** 登陆IP地址*/
	private  String clientIP;
	
	private static String passWord;
	
	private  InetAddress addr;
	private  String hostAddr;

	
	
	
	public LoginInfo(String id,String userName) {
		// TODO Auto-generated constructor stub

		this.id = id;
        this.name = userName;
		setTime();
		
		hostAddr = getClientIP();
	}
	
	
	public static void setUserName(String name){
		LoginInfo.userName = name;
	}
	
	public static void setUserID(String ID){
		LoginInfo.userID = ID;
	}
	
	public static void setUserPassword(String password){
		LoginInfo.passWord = password;
	}
	
	public static String getUserPassword(){
		return passWord;
	}
	
	
	public static String getUserName(){
		return userName;
	}
	
	public static String getUserID(){
		return userID;
	}
	public String getID(){
		return id;
	}
	public String getName(){
		return name;
	}
	
	public String getTime(){
		return loginTime;
	}
	
	public void setTime(){
		
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		loginTime = sdf.format(new Date()).split(" ")[1];
	}
	
	
	
	
	public  void setClientIP(){
		clientIP =getClientIP();
	}
	
	
	private  String getClientIP() {
	
		try {
			addr = InetAddress.getLocalHost();
			hostAddr = addr.getHostAddress();
		
		} catch (UnknownHostException e) {
			e.printStackTrace();
		}
		
		return hostAddr;
	}
	
	
	public String getAddress(){
		return hostAddr;
	}
	
	public  String getInfo(){
		return "["+loginTime+"]"+" "+name+" "+id+" "+getAddress();
	}
}
