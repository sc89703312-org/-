package edu.nju.express.blservice;

import java.util.ArrayList;

import edu.nju.express.common.ResultMessage;
import edu.nju.express.common.Role;
import edu.nju.express.vo.UserMessageVO;

/**
 * 处理管理员界面请求
 * @author Dora
 * @version 2015-12-9 21:23:24
 */

public interface UserBlService {
	
	/**
	 * 处理管理员界面添加一个人员的请求
	 * @author Dora
	 * @param id
	 * @param name
	 * @param role
	 * @param password
	 * @return 操作是否有效
	 */
	public ResultMessage addUser(String id, 
			String name, Role role, String password);
	
	/**
	 * 处理删除一个账号的界面请求
	 * @author Dora
	 * @param id
	 * @return 操作是否有效
	 */
	public ResultMessage deleteUser(String id);
	
	/**
	 * 处理修改账号信息的请求
	 * @author Dora
	 * @param id
	 * @param name
	 * @param role
	 * @param password
	 * @return	操作是否有效
	 */
	public ResultMessage modifyUser(String id, 
			String name, Role role, String password);
	
	/**
	 * 处理查看任务的界面请求
	 * @author Dora
	 * @return	所有人员变更申请vo的集合
	 */
	public ArrayList<UserMessageVO> viewTask();
}
