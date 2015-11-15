package client.businesslogic.strategybl.constantsettingbl;

import client.ResultMessage;
import client.blservice.StrategyBlService.ConstantSettingBlService;
import client.po.BasicValues;

public class ConstantSettingBl implements ConstantSettingBlService {

	@Override
	public ResultMessage setDistance(String id1, String id2, double distance) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public ResultMessage setPrice(double p) {
		if (p <= 0)
			return ResultMessage.INVALID;
		BasicValues.price = p;
		return ResultMessage.VALID;
	}

	@Override
	public ResultMessage setVehicleCost(double van, double railway, double airplane) {
		if (van <= 0 || railway <= 0 || airplane <= 0)
			return ResultMessage.INVALID;
		BasicValues.vanCost = van;
		BasicValues.railwayCost = railway;
		BasicValues.airplaneCost = airplane;
		return ResultMessage.VALID;
	}

	@Override
	public ResultMessage setVehicleLoad(int van, int railway, int airplane) {
		if (van <= 0 || railway <= 0 || airplane <= 0)
			return ResultMessage.INVALID;
		
		BasicValues.airplaneLoad = airplane;
		BasicValues.vanLoad = van;
		BasicValues.railwayLoad = railway;
		return ResultMessage.VALID;
	}

}
