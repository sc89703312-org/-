package edu.nju.express.businesslogic.accountbl.Info;

import java.util.ArrayList;

import edu.nju.express.vo.HallVO;
import edu.nju.express.vo.StationVO;
/**
 * 
 * @author lenovo
 * @version 2015年12月9日22:06:11
 * 用于查看所有的机构 包括   营业厅和中转中心
 */
public interface OrganizationInfo {


	/**
	 * @author lenovo
	 * @param 
	 * @return  中转中心列表
	 * @version 2015年12月9日22:06:37
	 */
	public ArrayList<StationVO> viewStationList();
	
	
	

	/**
	 * @author lenovo
	 * @param 
	 * @return  营业厅列表
	 * @version 2015年12月9日22:06:52
	 */
	public ArrayList<HallVO> viewHallList();
}
