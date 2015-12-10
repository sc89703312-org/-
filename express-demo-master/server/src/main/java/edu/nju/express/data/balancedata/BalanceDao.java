package edu.nju.express.data.balancedata;


import java.util.ArrayList;

import edu.nju.express.common.ResultMessage;
import edu.nju.express.po.Balancepo;




public interface BalanceDao {

    public ResultMessage insert(Balancepo po) ;
	
	public ArrayList<Balancepo> findByDate(String date) ;
	
	public ResultMessage delete(String id) ;
	
	public ResultMessage update(Balancepo po,String id);
	
	public ArrayList<Balancepo> getAll() ;
	
	public ArrayList<Balancepo> showAll();
	
    public ArrayList<Balancepo> viewAllCostSubmitted();
	
    public Balancepo findById(String id);
	
	public void flush();
	
	public ArrayList<Balancepo> getCostByDate();
}
