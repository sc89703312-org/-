package client.blservice.StrategyBlService;

import client.ResultMessage;

public interface ConstantSettingBlService{

	//���ø����о���
	public ResultMessage setDistance(String id1, String id2, double distance);
	
	//���ñ�׼��ݵ��ۣ����ÿ�ݡ���׼��ݡ��γ��ؿ�۸��Ϊ18��23��25
	public ResultMessage setPrice(double p);
	
	//���ò�ͬ��ͨ�������䵥��
	public ResultMessage setVehicleCost(double van,double railway,double airplane);
	
	//���ò�ͬ��ͨ�����˻���
	public ResultMessage setVehicleLoad(int van, int railway, int airplane);
}
