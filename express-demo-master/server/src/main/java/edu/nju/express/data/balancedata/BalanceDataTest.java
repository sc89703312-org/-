package edu.nju.express.data.balancedata;

import java.util.ArrayList;

import edu.nju.express.common.CommonData;
import edu.nju.express.common.ReceiptState;
import edu.nju.express.common.ResultMessage;
import edu.nju.express.po.Balancepo;

public class BalanceDataTest extends CommonData<Balancepo> implements BalanceDao{

	
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public BalanceDataTest(String path) {
		super(path);
		// TODO Auto-generated constructor stub
	}
	
	

	@Override
	public ArrayList<Balancepo> findByDate(String date) {
		// TODO Auto-generated method stub
		
		ArrayList<Balancepo> balances = inList.showAll();
		ArrayList<Balancepo> temp = new ArrayList<Balancepo>();
		
		
		for(int i=0;i<balances.size();i++){
			if(balances.get(i).getDate().equals(date))
				temp.add(balances.get(i));
		}
		
		return temp;
	}

	@Override
	public ResultMessage update(Balancepo po, String id) {
		// TODO Auto-generated method stub
		return update(id, po);
	}



	@Override
	public ArrayList<Balancepo> viewAllCostSubmitted() {
		// TODO Auto-generated method stub
		ArrayList<Balancepo> balances = inList.showAll();
		ArrayList<Balancepo> temp = new ArrayList<Balancepo>();
		
		
		for(int i=0;i<balances.size();i++){
			if(balances.get(i).getState()==ReceiptState.SUBMITTED)
				temp.add(balances.get(i));
		}
		
		return temp;
	}



	@Override
	public Balancepo findById(String id) {
		// TODO Auto-generated method stub
		return find(id);
	}




}
