package edu.nju.express.businesslogic.strategybl.managementbl;

import java.util.ArrayList;

import edu.nju.express.blservice.ManagementBlService;
import edu.nju.express.businesslogic.accountbl.Info.ManagementInfo;
import edu.nju.express.businesslogic.strategybl.managementbl.Info.UserCreateMessageInfo;
import edu.nju.express.businesslogic.userbl.UserBl;
import edu.nju.express.common.ResultMessage;
import edu.nju.express.common.Role;
import edu.nju.express.common.StaffChange;
import edu.nju.express.log.LogController;
import edu.nju.express.po.LogMessage;
import edu.nju.express.po.LoginInfo;
import edu.nju.express.vo.EmployeeVO;


/**
 * 人员管理模块功能实现
 * @author Dora
 * @version 2015-12-9 23:26:55
 */
public class ManagementBl implements ManagementBlService,ManagementInfo{

	UserCreateMessageInfo userBL;
	
	public ManagementBl(UserCreateMessageInfo userBL) {
		this.userBL = userBL;
	}
	

	/**
	 * 增加一个人员增加任务
	 * @see UserBl;
	 */
	@Override
	public ResultMessage addEmployee(String id, String name, Role role) {
		
		LogController.insertLog(new LogMessage("增加雇员", LoginInfo.getUserName()));
		
		return userBL.createUserMessage(StaffChange.add, id, name, role);
	}

	/**
	 * 增加一个人员删除任务
	 * @see UserBl;
	 */
	@Override
	public ResultMessage dismissEmployee(String id) {
		
		LogController.insertLog(new LogMessage("解雇雇员", LoginInfo.getUserName()));
		
		
		return userBL.createUserMessage(StaffChange.delete, id, null, null);
	}



	/**
	 * 查看人员列表
	 * @see UserBl;
	 */
	@Override
	public ArrayList<EmployeeVO> viewEmployeeList() {
		return userBL.viewEmployeeList();
	}


	

}
