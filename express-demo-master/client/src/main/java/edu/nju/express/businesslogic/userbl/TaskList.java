package edu.nju.express.businesslogic.userbl;

import java.net.MalformedURLException;
import java.rmi.Naming;
import java.rmi.NotBoundException;
import java.rmi.RemoteException;
import java.util.ArrayList;

import edu.nju.express.config.RMIConfig;
import edu.nju.express.dataservice.UserMessageDataService;
import edu.nju.express.init.RMIHelper;
import edu.nju.express.po.UserMessagePO;
import edu.nju.express.vo.UserMessageVO;

/**
 * 查看管理员任务列表
 * @author Dora
 * @version 2015-12-9 23:11:23
 */

public class TaskList {

	UserMessageDataService userMessageData;

	public TaskList() {
		try {
			userMessageData = (UserMessageDataService) Naming.lookup("rmi://" + RMIConfig.HOST + "/usermessage-service");
		} catch (MalformedURLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (RemoteException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (NotBoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	/**
	 * 获得人员变动任务vo的列表
	 * @author Dora
	 * @return
	 */
	public ArrayList<UserMessageVO> viewTask() {
		ArrayList<UserMessagePO> listPo = null;
		
		try {
			listPo = userMessageData.getAll();
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
