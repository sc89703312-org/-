package edu.nju.express.presentation.administratorui;


import java.awt.event.ActionEvent;
import java.util.ArrayList;

import javax.swing.JFrame;
import javax.swing.JPanel;

import edu.nju.express.blservice.UserBlService;
import edu.nju.express.businesslogic.DataFactory;
import edu.nju.express.common.ResultMessage;
import edu.nju.express.presentation.UIController;
import edu.nju.express.presentation.myUI.WarningDialog;
import edu.nju.express.vo.UserMessageVO;
import edu.nju.express.vo.UserVO;

public class AdministratorController implements UIController{

	private JPanel currentPanel;
	private JFrame frame;
	private UserBlService user;
	public AdministratorController( Administor_Frame f) {
		currentPanel = (JPanel)f.getContentPane();
		frame = f;
		user = DataFactory.createUserBlInstance();
	}
	@Override
	public void actionPerformed(ActionEvent e) {
		System.out.println(e.getActionCommand());
		
		if(e.getActionCommand().equals("DeleteUser")){
			if(((DeleteUserUI)currentPanel).getID()==null)
				return ;
			String id = ((DeleteUserUI)currentPanel).getID() ;
			System.out.println(id);
			ResultMessage message =user.deleteUser(id);
			
			if(message==ResultMessage.INVALID)
				WarningDialog.show("输入无效", "该人员编号不存在");
			else{
				WarningDialog.show("操作成功", "该人员已成功被删除");
				frame.getContentPane().removeAll();
				currentPanel = new DeleteUserUI(this);
				frame.add(currentPanel);
				frame.validate();
				frame.repaint();
			}
			
		}else if(e.getActionCommand().equals("AddUser")){
			
			if(((AddUserUI)currentPanel).getTextInput()==null)
				return ;
			
			UserVO vo = ((AddUserUI)currentPanel).getTextInput();
			System.out.println(vo.getRole());
			
			
			
			ResultMessage message =user.addUser(vo.getId(), vo.getName(), vo.getRole(), vo.getPassword());
			
			System.out.println(message);
			
			if(message==ResultMessage.INVALID)
				WarningDialog.show("输入无效", "该人员编号已存在");
			else{
				WarningDialog.show("操作成功", "该人员已成功被增加");
				frame.getContentPane().removeAll();;
				currentPanel = new AddUserUI(this);
				frame.add(currentPanel);
				frame.validate();
				frame.repaint();
			}
			
			
			
		}else if(e.getActionCommand().equals("ModifyUser")){
			if(((ModifyUserUI)currentPanel).getTextInput()==null)
				return ;
			UserVO vo = ((ModifyUserUI)currentPanel).getTextInput();
			System.out.println(vo.getRole());
			
			ResultMessage message = ResultMessage.INVALID;
			message = user.modifyUser(vo.getId(), vo.getName(), vo.getRole(), vo.getPassword());
			
			if(message == ResultMessage.INVALID)
			  WarningDialog.show("输入无效", "该人员编号不存在");
			else{
				WarningDialog.show("操作成功", "账号信息已成功修改");
				frame.getContentPane().removeAll();
				currentPanel = new ModifyUserUI(this);
				frame.add(currentPanel);
				frame.validate();
				frame.repaint();
			}
				
			
		}else if(e.getActionCommand().equals("CheckTaskUI")){
			
			frame.getContentPane().removeAll();;
			currentPanel = new CheckTaskUI(this);
			frame.add(currentPanel);
			frame.validate();
			frame.repaint();
			
		}else if(e.getActionCommand().equals("AddUserUI")){
			
			frame.getContentPane().removeAll();;
			currentPanel = new AddUserUI(this);
			frame.add(currentPanel);
			frame.validate();
			frame.repaint();
			
		}else if(e.getActionCommand().equals("DeleteUserUI")){
			
			frame.getContentPane().removeAll();
			currentPanel = new DeleteUserUI(this);
			frame.add(currentPanel);
			frame.validate();
			frame.repaint();
			
		}else if(e.getActionCommand().equals("ModifyUserUI")){
			
			frame.getContentPane().removeAll();
			currentPanel = new ModifyUserUI(this);
			frame.add(currentPanel);
			frame.validate();
			frame.repaint();
			
		}
		
	}
	
	ArrayList<UserMessageVO> getUserMessageList(){
		return user.viewTask();
	}

	public int getMessages(){
		return user.viewTask().size();
	}
}
