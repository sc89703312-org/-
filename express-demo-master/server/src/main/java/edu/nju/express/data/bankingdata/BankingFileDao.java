package edu.nju.express.data.bankingdata;

import edu.nju.express.common.CommonData;
import edu.nju.express.common.ResultMessage;
import edu.nju.express.po.BankingAccountPO;

public class BankingFileDao extends CommonData<BankingAccountPO> implements BankingDao{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public BankingFileDao(String path) {
		super(path);
		// TODO Auto-generated constructor stub
	}

	@Override
	public void add(BankingAccountPO po) {
		// TODO Auto-generated method stub
		insert(po);
	}

	@Override
	public ResultMessage remove(String name) {
		// TODO Auto-generated method stub
		return delete(name);
	}

	@Override
	public ResultMessage modify(String newname, String name) {
		// TODO Auto-generated method stub
		BankingAccountPO po = this.find(name);
		ResultMessage result = delete(name);
		
		if(result==ResultMessage.VALID)
			po.changeName(newname);
		
		insert(po);
		
		return result;
	}

	@Override
	public void income(String name, int num) {
		// TODO Auto-generated method stub
		BankingAccountPO po = find(name);
		po.addMoney(num);
		update(name,po);
	}

	@Override
	public void expend(String name, int num) {
		// TODO Auto-generated method stub
		BankingAccountPO po = find(name);
		po.minusMoney(num);
		update(name,po);
	}

}
