package edu.nju.express.presentation.administratorui;

import java.awt.FlowLayout;

import javax.swing.JButton;
import javax.swing.JPanel;


public class AdministerGuide extends JPanel{

	int width=900,height=600;
	int y = 50;		//由标题栏高度决定
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	AdministratorController controller;
	
	JButton add;
	JButton delete;
	JButton modify;
	JButton check;
	
	
	public AdministerGuide(AdministratorController controller) {
		this.controller = controller;
		initGuide();
		this.setOpaque(false);
		this.setLayout(null);
		this.setBounds(0, y, (int)(width*0.2), (int)(height));
	}
	
	
	void initGuide(){
		JPanel buttons = new JPanel();
		buttons.setOpaque(false);
		((FlowLayout)buttons.getLayout()).setVgap(y/2);
		buttons.setBounds(0, 0, (int)(width*0.2), (int)(height));
		check = new JButton("查看任务");
		check.setActionCommand("CheckTaskUI");
		check.addActionListener(controller);
		add = new JButton("增加账号");
		add.setActionCommand("AddUserUI");
		add.addActionListener(controller);
		delete = new JButton("删除账号");
		delete.setActionCommand("DeleteUserUI");
		delete.addActionListener(controller);
		modify = new JButton("修改账号");
		modify.setActionCommand("ModifyUserUI");
		modify.addActionListener(controller);
		buttons.add(check);
		buttons.add(add);
		buttons.add(delete);
		buttons.add(modify);
		add(buttons);
	}
}
