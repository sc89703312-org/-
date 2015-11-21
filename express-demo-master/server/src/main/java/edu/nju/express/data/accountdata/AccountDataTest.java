package edu.nju.express.data.accountdata;

import java.util.ArrayList;

import edu.nju.express.common.DefineList;
import edu.nju.express.po.Accountpo;

public class AccountDataTest implements AccountDao {

	
	
	DefineList<Accountpo> accounts;
	
	public AccountDataTest() {
		// TODO Auto-generated constructor stub
	accounts = new DefineList<Accountpo>("account");
	
	}
	
	
	
	@Override
	public void insert(Accountpo po) {
		// TODO Auto-generated method stub
		
		accounts.insert(po);
	}

	@Override
	public Accountpo find(String date) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public ArrayList<Accountpo> getAll() {
		// TODO Auto-generated method stub
		return accounts.getAll();
	}

	@Override
	public void flush() {
		// TODO Auto-generated method stub
		accounts.flush();
	}

}
