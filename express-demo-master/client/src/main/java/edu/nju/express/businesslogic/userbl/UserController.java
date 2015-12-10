package edu.nju.express.businesslogic.userbl;

import java.util.ArrayList;

import edu.nju.express.blservice.UserBlService;
import edu.nju.express.businesslogic.DataFactory;
import edu.nju.express.common.ResultMessage;
import edu.nju.express.common.Role;
import edu.nju.express.vo.UserMessageVO;



public class UserController implements UserBlService{

	UserBlService user;
	
	/**
	 * @param user
	 */
	public UserController() {
		this.user = DataFactory.createUserBlInstance();
	}

	@Override
	public ResultMessage addUser(String id, String name, Role role, String password) {
		return user.addUser(id, name, role, password);
	}

	@Override
	public ResultMessage deleteUser(String id) {
		return user.deleteUser(id);
	}

	@Override
	public ResultMessage modifyUser(String id, String name, Role role, String password) {
		return user.modifyUser(id, name, role, password);
	}

	@Override
	public ArrayList<UserMessageVO> viewTask() {
		// TODO Auto-generated method stub
		return user.viewTask();
	}

}
