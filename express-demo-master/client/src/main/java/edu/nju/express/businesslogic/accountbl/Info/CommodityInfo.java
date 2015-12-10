package edu.nju.express.businesslogic.accountbl.Info;

import java.util.ArrayList;
/**
 * @author lenovo
 * @version 2015年12月9日22:04:34
 * 用于获取所有的库存的接口
 */

import edu.nju.express.vo.ComGoodsVO;

public interface CommodityInfo {

	
	

	/**
	 * @author lenovo
	 * @param 
	 * @return 库存的列表
	 * @version 2015年12月9日22:04:55
	 */
	public ArrayList<ComGoodsVO> showAllCityInventory();
}
