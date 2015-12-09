package edu.nju.express.businesslogic.strategybl.managementbl.Info;

import java.util.ArrayList;

import edu.nju.express.common.ResultMessage;
import edu.nju.express.common.Role;
import edu.nju.express.common.StaffChange;
import edu.nju.express.vo.EmployeeVO;

/**
 * 人员管理模块需要的账号管理模块的接口
 * @author Dora
 * @version 2015-12-9 23:25:12
 */
public interface UserCreateMessageInfo {

	/**
	 * 创建一条人员管理任务
	 * @author Dora
	 * @param change
	 * @param id
	 * @param name
	 * @param role
	 * @return
	 */
	public ResultMessage createUserMessage(StaffChange change,String id, String name, Role role);

	/**
	 * 查看人员列表
	 * @author Dora
	 * @return
	 */
	public ArrayList<EmployeeVO> viewEmployeeList();
}
