package edu.nju.express.blservice;

import java.util.ArrayList;

import edu.nju.express.common.ResultMessage;
import edu.nju.express.common.Role;
import edu.nju.express.vo.EmployeeVO;

/**
 * 处理总经理人员管理界面的操作
 * @author Dora
 * @version 2015-12-9 21:18:44
 */

public interface ManagementBlService {
	/**
	 * 查看所有人员列表
	 * @author Dora
	 * @return	所有人员vo的集合
	 */
	public ArrayList<EmployeeVO> viewEmployeeList();
	
	/**
	 * 处理增加一个人员的界面请求
	 * @author Dora
	 * @param id
	 * @param name
	 * @param role	人员职务
	 * @return 操作是否有效
	 */
	public ResultMessage addEmployee(String id, 
			String name, Role role);
	
	/**
	 * 处理删除一个人员的界面请求
	 * @author Dora
	 * @param id
	 * @return 操作是否有效
	 */
	public ResultMessage dismissEmployee(String id);
}
