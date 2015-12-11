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
		ArrayList<Balancepo> tempList = new ArrayList<>();
		ArrayList<Balancepo> costList = inList.showAll();
		for(Balancepo po:costList)
			tempList.add(po);
		
		for(int i=0;i<tempList.size();i++){
			for(int j=i+1;j<tempList.size();j++)
				if(tempList.get(i).getDate().compareTo(tempList.get(j).getDate())>0){
					Balancepo temp = tempList.get(i);
					
					tempList.add(i, tempList.get(j));
					tempList.remove(i+1);
					
					tempList.add(j, temp);
					tempList.remove(j+1);
				}
					
		}
		
		
		
		
		
		return tempList;
	}




}
