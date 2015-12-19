package edu.nju.express.blservice;

import java.util.ArrayList;

import edu.nju.express.common.ResultMessage;
import edu.nju.express.vo.Drivervo;

/**
 * 
 * @author lenovo
 * @version 2015年12月9日21:45:58
 * 
 * 
 * 用于营业厅业务员对该营业厅的司机进行增删改查等操作
 */

public interface Vehicleblservice {


	/**
	 * @author lenovo
	 * @param   DriverVO  
	 * @return  ResultMessage  新增司机是否合法
	 * @version 2015年12月9日21:47:24
	 */
	public ResultMessage addDriver(Drivervo vo);
	
	

	/**
	 * @author lenovo
	 * @param  String id    司机的ID
	 * @return  ResultMessage  删除司机是否合法
	 * @version 2015年12月9日21:52:02
	 */
	public ResultMessage deleteDriver(String id);
	
	
	

	/**
	 * @author lenovo
	 * @param  司机的ID 和  界面打包好的DriverVO
	 * @return  修改司机信息是否合法
	 * @version 2015年12月9日21:52:37
	 */
	public ResultMessage modifyDriver(String id,Drivervo vo);
	
	
	

	/**
	 * @author lenovo
	 * @param  String id    司机ID
	 * @return  DriverVO  将司机信息打包好返回给界面层
	 * @version  2015年12月9日21:53:46
	 */
	public Drivervo viewDriver(String id);
	
	/**
	 * @author guhan
	 * @return ArrayList<Drivervo> 得到所有司机信息返回给界面层
	 * 
	 */
	public ArrayList<Drivervo> getAll();

	/**
	 * @author lenovo
	 * @param 
	 * @return 
	 * @version  2015年12月9日21:53:52
	 */
	public void endVehicle();
	
	
}
