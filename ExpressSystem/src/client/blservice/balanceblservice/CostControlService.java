package client.blservice.balanceblservice;

import client.ResultMessage;
import client.vo.balancevo.Balancevo;

public interface CostControlService {
	public ResultMessage createCost(Balancevo vo);
	public Balancevo getCost(String id);
	public void endCostControl();
}
