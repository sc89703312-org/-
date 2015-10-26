package client.blservice.balanceblservice;

import java.util.ArrayList;

import client.ResultMessage;
import client.vo.balancevo.Balancevo;

public interface CostControlService {
	public ResultMessage createCost(Balancevo vo);
	public Balancevo getCost(String id);
	public void endCostControl();
	public ArrayList<Balancevo> viewAllCost();
}
