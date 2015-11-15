package client.businesslogic.balancebl;

import java.util.ArrayList;

import client.businesslogic.balancebl.CreateCost.CostControlbl;
import client.vo.balancevo.Balancevo;

public class CostList {

	
	
	ArrayList<Balancevo>  tempLists = new ArrayList<Balancevo>();
	CostControlbl controlbl;
	
	
	public CostList(CostControlbl controlbl) {
		// TODO Auto-generated constructor stub
	
	
	this.controlbl = controlbl;
	getAll();
	
	}


	private void getAll() {
		// TODO Auto-generated method stub
		tempLists = controlbl.viewAllCost();
	}
	
	
	
	public ArrayList<Balancevo> getList(){
		return tempLists;
	}
	
	
	
	
	public ArrayList<Balancevo> getListByDate(String start,String end){
		
		
		 ArrayList<Balancevo> tempList = new ArrayList<Balancevo>();
			
			
			
			System.out.println("The length of costlist is: "+tempList.size());
			
			
			for(int i=0;i<tempLists.size();i++){
				
				String date =tempLists.get(i).getDate();
				
				
				if(date.compareTo(end)<=0&&date.compareTo(start)>=0){
					
					System.out.println("The date of: "+date +" is valid");
					
					tempList.add(tempLists.get(i));
				}
			}
			
			
			
			
			return tempList;
	}
}
