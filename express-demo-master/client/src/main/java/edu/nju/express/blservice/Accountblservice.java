package edu.nju.express.blservice;

import edu.nju.express.common.ResultMessage;
import edu.nju.express.vo.Accountvo;


public interface Accountblservice {

	
	public void createAccount();
	public ResultMessage createAccount(Accountvo vo);
	public Accountvo viewAccount(String date);
	public void endAccount();
	
	
}
