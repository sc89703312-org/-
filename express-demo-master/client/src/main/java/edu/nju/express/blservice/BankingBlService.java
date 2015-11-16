package edu.nju.express.blservice;

import java.util.ArrayList;

import edu.nju.express.common.ResultMessage;
import edu.nju.express.vo.BankingAccountVO;



public interface BankingBlService {
	
	public void addAccount(String name);
	public ResultMessage removeAccount(String name);
	public ResultMessage modifyAccount(String newName, String name);
	public ArrayList<BankingAccountVO> showAccount(String subName);

}
