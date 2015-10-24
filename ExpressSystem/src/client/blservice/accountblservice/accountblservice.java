package client.blservice.accountblservice;

import client.ResultMessage;
import client.vo.accountvo.Accountvo;


public interface Accountblservice {

	
	
	public ResultMessage createAccount(Accountvo vo);
	public Accountvo viewAccount(String date);
	public void endAccount();
	
	
}
