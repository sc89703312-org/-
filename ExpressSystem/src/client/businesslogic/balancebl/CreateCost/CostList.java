package client.businesslogic.balancebl.CreateCost;

import java.util.ArrayList;

import client.vo.balancevo.Balancevo;

public class CostList {

	
	
	ArrayList<Balancevo>  tempList = new ArrayList<Balancevo>();
	CostControlbl controlbl;
	
	
	public CostList(CostControlbl controlbl) {
		// TODO Auto-generated constructor stub
	
	
	this.controlbl = controlbl;
	getAll();
	
	}


	private void getAll() {
		// TODO Auto-generated method stub
		tempList = controlbl.viewAllCost();
	}
	
	
	
	public ArrayList<Balancevo> getList(){
		return tempList;
	}
}
