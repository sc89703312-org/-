package edu.nju.express.businesslogic.accountbl.Info;

import java.util.ArrayList;

import edu.nju.express.vo.Carvo;
/**
 * 
 * @author lenovo
 * @version 2015年12月9日22:01:54
 * 
 * 依赖CarController获得所有CarVO
 */
public interface CarControlInfo {


	/**
	 * @author lenovo
	 * @param 
	 * @return CarVO的列表
	 * @version 2015年12月9日22:03:56
	 */
	public ArrayList<Carvo> getAll();
}
