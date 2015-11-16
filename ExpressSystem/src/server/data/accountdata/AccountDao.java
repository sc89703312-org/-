package server.data.accountdata;

import java.util.ArrayList;

import client.po.accountpo.Accountpo;

public interface AccountDao {

	
	public void insert(Accountpo po);
	
	public Accountpo find(String date);
	
	public ArrayList<Accountpo> getAll();
	
	public void flush();
	
	
}
