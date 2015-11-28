package edu.nju.express.businesslogic.userbl;

import java.rmi.RemoteException;
import java.util.ArrayList;

import edu.nju.express.dataservice.UserMessageDataService;
import edu.nju.express.init.RMIHelper;
import edu.nju.express.po.UserMessagePO;
import edu.nju.express.vo.UserMessageVO;



public class TaskList {

	UserMessageDataService userMessageData;

	public TaskList() {
		userMessageData = RMIHelper.getUserMessageDataService();
	}
	
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
	
	
	
	UserMessageVO convertToVO(UserMessagePO po) {

		return new UserMessageVO(po.getOperation(), po.getId(), po.getName(), po.getRole());
	}
	
}
