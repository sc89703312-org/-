package edu.nju.express.businesslogic.paymentbl.Info;

import java.util.ArrayList;

import edu.nju.express.vo.BankingAccountVO;

public interface BankingInfo {

	public void modify(int pay,String account) ;
	
	public ArrayList<BankingAccountVO> getAllAccounts();
	
	public int getMoney(String account);
}
