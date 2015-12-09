package edu.nju.express.businesslogic.accountbl.Info;

import java.util.ArrayList;

import edu.nju.express.vo.EmployeeVO;
/**
 * 
 * @author lenovo
 * @version 2015年12月9日22:05:31
 * 用于查看所有的雇员
 */
public interface ManagementInfo {

	

	/**
	 * @author lenovo
	 * @param 
	 * @return 雇员的列表
	 * @version 2015年12月9日22:05:43
	 */
	public ArrayList<EmployeeVO> viewEmployeeList();
}
