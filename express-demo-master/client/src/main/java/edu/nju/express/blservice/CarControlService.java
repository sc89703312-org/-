package edu.nju.express.blservice;

import java.util.ArrayList;

import edu.nju.express.common.ResultMessage;
import edu.nju.express.vo.Carvo;

/**
 * @author lenovo
 *  
 *  
 * @version 2015年12月9日21:00:26
 * 
 * 
 * 用于营业厅业务员进行车辆管理
 * 
 * 可以对车辆进行增删改查等操作
 * 
 */
public interface CarControlService {

	
	/**
	 * @author lenovo
	 * @return ResultMessage 表示新增车辆是否合法
	 * @param  CarVO 从界面层打包过来的Value Object
	 * @version 2015年12月9日21:01:05
	 * 
	 * 
	 */
	public ResultMessage addCar(Carvo vo);
	
	
	
	/**
	 * @author lenovo
	 * @return ResultMessage 表示删除车辆是否合法
	 * @param  String id    车辆的编号
	 * @version 2015年12月9日21:01:58
	 * 
	 * 
	 */
	public ResultMessage deleteCar(String id);
	
	
	
	
	/**
	 * @author lenovo
	 * @return ResultMessage 表示修改车辆是否合法
	 * @param  String id    车辆的编号      CarVO 从界面层打包过来的Value Object
	 * @version 2015年12月9日21:03:04
	 * 
	 * 
	 */
	public ResultMessage modifyCar(String id,Carvo vo);
	
	
	
	
	/**
	 * @author lenovo
	 * @return CarVO  用于显示在界面层打包好的VO
	 * @param  String id    车辆的编号
	 * @version 2015年12月9日21:03:37
	 * 
	 * 
	 */
	public Carvo viewCar(String id);
	
	
	
	/**
	 * @author lenovo
	 * @return 
	 * @param  
	 * @version 2015年12月9日21:03:59
	 * 
	 * 
	 */
	public void endCar();
	
	public ArrayList<Carvo> getAll();
	
}
