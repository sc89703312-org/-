package edu.nju.express.data.bankingdata;

import java.util.ArrayList;

import edu.nju.express.common.ResultMessage;
import edu.nju.express.po.BankingAccountPO;


public interface BankingDao {

    public void add(BankingAccountPO po);
    public ResultMessage remove(String name);
    public ArrayList<BankingAccountPO> getAll();
    public ResultMessage modify(String newname, String name);
    public void income(String name, int num);
    public void expend(String name, int num);
    public ArrayList<BankingAccountPO> showAll();
    public void flush();
    public ResultMessage insert(BankingAccountPO po);
	
}
