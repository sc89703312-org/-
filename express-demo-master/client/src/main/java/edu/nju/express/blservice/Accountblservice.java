package edu.nju.express.blservice;

import edu.nju.express.vo.Accountvo;


public interface Accountblservice {

	
	public void createAccount();
	public Accountvo viewAccount(String date);
	public void endAccount();
	
	
}
