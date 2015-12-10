package edu.nju.express.businesslogic.strategybl.organizationbl.Info;

/**
 * 机构管理模块需要的常量制定模块接口
 * @author Dora
 *
 */
public interface ConstantAddCityInfo {

	/**
	 * 添加一个城市
	 * @author Dora
	 * @param CityID
	 * @param id
	 */
	public void addCity(String CityID,String id);
	
	/**
	 * 删除一个城市
	 * @author Dora
	 * @param CityID
	 */
	public void deleteCity(String CityID);
}
