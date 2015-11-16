package edu.nju.express.data.accountdata;

import java.util.ArrayList;

import edu.nju.express.po.Accountpo;



public interface AccountDao {

	
	public void insert(Accountpo po);
	
	public Accountpo find(String date);
	
	public ArrayList<Accountpo> getAll();
	
	public void flush();
	
	
}
