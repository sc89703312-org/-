package edu.nju.express.po;

import java.io.Serializable;


public class Driverpo implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	int id;
	String name;
	String birthdate;
	String certificate;
	String phone;
	String hall_id;
	boolean sex;
	String ddl;
	
	
	public Driverpo(int id,String n,String b,String c,String p,String h,boolean s,String d) {
		// TODO Auto-generated constructor stub
      
		this.id  = id;
		name = n;
		birthdate = b;
		certificate = c;
		phone = p;
		hall_id = h;
		sex = s;
		ddl = d;
	
	
	}

	
	public int getId(){
		return id;
	}
	
	public String getName(){
		return name;
	}
	
	public String getBirthDate(){
		return birthdate;
	}
	
	public String getCertificate(){
		return certificate;
	}
	
	public String getPhone(){
		return phone;
	}
	
	
	public String getHallId(){
		return hall_id;
	}
	
	
	public boolean getSex(){
		return sex;
	}
	
	public String getDdl(){
		return ddl;
	}
}
