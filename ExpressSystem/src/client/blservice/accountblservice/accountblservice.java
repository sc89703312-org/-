package client.blservice.accountblservice;

import client.ResultMessage;
import client.vo.accountvo.Accountvo;


public interface Accountblservice {

	
	public void createAccount();
	public ResultMessage createAccount(Accountvo vo);
	public Accountvo viewAccount(String date);
	public void endAccount();
	
	
}
