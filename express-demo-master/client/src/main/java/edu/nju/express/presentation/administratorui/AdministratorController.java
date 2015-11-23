package edu.nju.express.presentation.administratorui;


import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JFrame;
import javax.swing.JPanel;

public class AdministratorController implements ActionListener{

	JPanel currentPanel;
	JFrame frame;
	public AdministratorController( JFrame f) {
		currentPanel = (JPanel)f.getContentPane();
		frame = f;
	}
	@Override
	public void actionPerformed(ActionEvent e) {
		System.out.println(e.getActionCommand());
		
		if(e.getActionCommand().equals("DeleteUser")){
			System.out.println(((DeleteUserUI)currentPanel).getID() );
		}else if(e.getActionCommand().equals("AddUser")){
			System.out.println(((AddUserUI)currentPanel).getTextInput().getRole());
		}else if(e.getActionCommand().equals("ModifyUser")){
			System.out.println(((ModifyUserUI)currentPanel).getTextInput().getRole());
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

}