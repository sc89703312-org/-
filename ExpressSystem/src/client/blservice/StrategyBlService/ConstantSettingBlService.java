package client.blservice.StrategyBlService;

import client.ResultMessage;

public interface ConstantSettingBlService{

	//设置各城市距离
	public ResultMessage setDistance(String id1, String id2, double distance);
	
	//设置标准快递单价，经济快递、标准快递、次晨特快价格比为18：23：25
	public ResultMessage setPrice(double p);
	
	//设置不同交通工具运输单价
	public ResultMessage setVehicleCost(double van,double railway,double airplane);
	
	//设置不同交通工具运货量
	public ResultMessage setVehicleLoad(int van, int railway, int airplane);
}
