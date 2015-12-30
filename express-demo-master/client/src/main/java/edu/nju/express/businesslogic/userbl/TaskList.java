package edu.nju.express.businesslogic.userbl;

import java.rmi.RemoteException;
import java.util.ArrayList;

import edu.nju.express.dataservice.UserMessageDataService;
import edu.nju.express.init.RMIHelper;
import edu.nju.express.po.UserMessagePO;
import edu.nju.express.vo.UserMessageVO;
import static edu.nju.express.init.RMIHelper.userMessageDataService;
/**
 * 查看管理员任务列表
 * @author Dora
 * @version 2015-12-9 23:11:23
 */

public class TaskList {

	public TaskList() {
	}
	
	/**
	 * 获得人员变动任务vo的列表
	 * @author Dora
	 * @return
	 */
	public ArrayList<UserMessageVO> viewTask() {
		ArrayList<UserMessagePO> listPo = null;
		
		try {
			listPo = userMessageDataService.getAll();
		} catch (RemoteException e) {
			e.printStackTrace();
		}
		
		ArrayList<UserMessageVO> listVo = new ArrayList<UserMessageVO>();

		for (int i = 0; i < listPo.size(); i++) {
			listVo.add(convertToVO(listPo.get(i)));
		}
		return listVo;
	}
	
	
	/*
	 * 将人员变动操作的持久化对象转化为vo
	 */
	UserMessageVO convertToVO(UserMessagePO po) {

		return new UserMessageVO(po.getOperation(), po.getId(), po.getName(), po.getRole());
	}
	
}
