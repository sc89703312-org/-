package edu.nju.express.presentation.administratorui;


import java.awt.event.ActionEvent;
import java.util.ArrayList;

import javax.swing.JFrame;
import javax.swing.JPanel;

import edu.nju.express.blservice.UserBlService;
import edu.nju.express.businesslogic.DataFactory;
import edu.nju.express.common.ResultMessage;
import edu.nju.express.log.ui.warning.PromptDialog;
import edu.nju.express.presentation.UIController;
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
			
			String id = ((DeleteUserUI)currentPanel).getID() ;
			System.out.println(id);
			ResultMessage message =user.deleteUser(id);
			
			if(message==ResultMessage.INVALID)
				PromptDialog.show("输入无效", "           输入ID不存在");
			else{
				PromptDialog.show("删除成功", "               你真棒");
				frame.getContentPane().removeAll();
				currentPanel = new DeleteUserUI(this);
				frame.add(currentPanel);
				frame.validate();
				frame.repaint();
			}
			
		}else if(e.getActionCommand().equals("AddUser")){
			
			UserVO vo = ((AddUserUI)currentPanel).getTextInput();
			System.out.println(vo.getRole());
			
			
			
			ResultMessage message =user.addUser(vo.getId(), vo.getName(), vo.getRole(), vo.getPassword());
			
			System.out.println(message);
			
			if(message==ResultMessage.INVALID)
				PromptDialog.show("输入无效", "           存在已有ID");
			else{
				PromptDialog.show("添加成功", "               你真棒");
				frame.getContentPane().removeAll();;
				currentPanel = new AddUserUI(this);
				frame.add(currentPanel);
				frame.validate();
				frame.repaint();
			}
			
			
			
		}else if(e.getActionCommand().equals("ModifyUser")){
			
			UserVO vo = ((ModifyUserUI)currentPanel).getTextInput();
			System.out.println(vo.getRole());
			
			ResultMessage message = ResultMessage.INVALID;
			message = user.modifyUser(vo.getId(), vo.getName(), vo.getRole(), vo.getPassword());
			
			if(message == ResultMessage.INVALID)
			  PromptDialog.show("输入无效", "       输入ID不存在");
			else{
				PromptDialog.show("修改成功", "               你真棒");
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
