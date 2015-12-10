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



	@Override
	public ArrayList<Balancepo> getCostByDate() {
		// TODO Auto-generated method stub
		
		ArrayList<Balancepo> costList = inList.showAll();
		
		for(int i=0;i<costList.size();i++){
			for(int j=i+1;j<costList.size();j++)
				if(costList.get(i).getDate().compareTo(costList.get(j).getDate())>0){
					Balancepo temp = costList.get(i);
					
					costList.add(i, costList.get(j));
					costList.remove(i+1);
					
					costList.add(j, temp);
					costList.remove(j+1);
				}
					
		}
		
		
		
		
		
		return costList;
	}




}
