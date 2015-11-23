package edu.nju.express.presentation.UserUI;


import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;

public class UserController implements ActionListener{

	JPanel currentPanel;
	JFrame frame;
	public UserController( JFrame f) {
		currentPanel = (JPanel)f.getContentPane();
		frame = f;
	}
	@Override
	public void actionPerformed(ActionEvent e) {
		System.out.println(e.getActionCommand());
		
		if(e.getActionCommand().equals("DeleteUser")){
			System.out.println(((DeleteUserPanel)currentPanel).getID() );
		}else if(e.getActionCommand().equals("AddUser")){
			System.out.println(((AddUserPanel)currentPanel).getTextInput().getRole());
		}else if(e.getActionCommand().equals("CheckTaskUI")){
		}else if(e.getActionCommand().equals("AddUserUI")){
			frame.getContentPane().removeAll();;
			currentPanel = new AddUserPanel(this);
			frame.add(currentPanel);
			frame.validate();
			frame.repaint();
		}else if(e.getActionCommand().equals("DeleteUserUI")){
			frame.getContentPane().removeAll();
			currentPanel = new DeleteUserPanel(this);
			frame.add(currentPanel);
			frame.validate();
			frame.repaint();
		}else if(e.getActionCommand().equals("ModifyUserUI")){
		}
		
		System.out.println(currentPanel);
	}

}
