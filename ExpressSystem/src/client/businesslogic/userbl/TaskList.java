package client.businesslogic.userbl;

import java.rmi.RemoteException;
import java.util.ArrayList;

import client.dataservice.userdataservice.UserMessageDataService;
import client.po.userpo.UserMessagePO;
import client.vo.UserMessageVO;

public class TaskList {

	UserMessageDataService userMessageData;

	public TaskList() {
		
		this.userMessageData = new MockUserMessageData();
		
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