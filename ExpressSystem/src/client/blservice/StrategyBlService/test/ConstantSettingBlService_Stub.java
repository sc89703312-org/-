package client.blservice.StrategyBlService.test;

import client.ResultMessage;
import client.blservice.StrategyBlService.ConstantSettingService;

public class ConstantSettingBlService_Stub implements ConstantSettingService{

	@Override
	public ResultMessage setDistance(String id1, String id2, double distance) {
		ResultMessage rm = ResultMessage.VALID;
		if(id1.equals(id2))
			rm = ResultMessage.INVALID;
		else if(id1!="025"||id2!="025")
			rm = ResultMessage.INVALID;
		else if(distance <= 0)
			rm = ResultMessage.INVALID;
		return rm;
	}

	@Override
	public ResultMessage setPrice(double p) {
		ResultMessage rm = ResultMessage.VALID;
		if(p<=0)
			rm = ResultMessage.INVALID;
		return rm;
	}

	@Override
	public ResultMessage setVehicleCost(double van, double railway, double airplane) {
		ResultMessage rm = ResultMessage.VALID;
		if(van<=0||railway<=0||airplane<=0)
			rm = ResultMessage.INVALID;
		return rm;
	}

	@Override
	public ResultMessage setVehicleLoad(int van, int railway, int airplane) {
		ResultMessage rm = ResultMessage.VALID;
		if(van<=0||railway<=0||airplane<=0)
			rm = ResultMessage.INVALID;
		return rm;
	}

}
