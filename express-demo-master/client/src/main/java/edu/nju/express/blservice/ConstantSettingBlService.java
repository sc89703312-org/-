package edu.nju.express.blservice;

import edu.nju.express.common.ResultMessage;
import edu.nju.express.vo.ConstantVO;

/**
 * 处理总经理界面请求
 * @author Dora
 * @version 2015-12-9 21:22:26
 */

public interface ConstantSettingBlService{

	/**
	 * 处理设置距离的请求
	 * @author Dora
	 * @param id1
	 * @param id2
	 * @param distance
	 * @return 操作是否有效
	 */
	public ResultMessage setDistance(String id1, String id2, double distance);
	
	/**
	 * 处理设置价格的请求
	 * @author Dora
	 * @param p
	 * @return 操作是否有效
	 */
	public ResultMessage setPrice(double p);

	/**
	 * 处理设置交通成本的界面请求
	 * @author Dora
	 * @param van
	 * @param railway
	 * @param airplane
	 * @return 操作是否有效
	 */
	public ResultMessage setVehicleCost(double van,double railway,double airplane);

	/**
	 * 处理设置交通载量的界面请求
	 * @author Dora
	 * @param van
	 * @param railway
	 * @param airplane
	 * @return 操作是否有效
	 */
	public ResultMessage setVehicleLoad(int van, int railway, int airplane);

	/**
	 * 处理获得常量信息的请求
	 * @author Dora
	 * @return 所有常量的vo
	 */
	public ConstantVO getConstant();

}
