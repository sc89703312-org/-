package client.blservice.bankingBlService;

import java.util.ArrayList;

import client.ResultMessage;
import client.vo.bankingvo.BankingAccountVO;

public interface BankingBlService {
	
	public void addAccount(String name);
	public ResultMessage removeAccount(String name);
	public ResultMessage modifyAccount(String newName, String name);
	public ArrayList<BankingAccountVO> showAccount(String subName);

}
