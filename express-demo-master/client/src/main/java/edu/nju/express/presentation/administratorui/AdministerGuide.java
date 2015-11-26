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
		check = new JButton("查看任务");
		check.setActionCommand("CheckTaskUI");
		check.addActionListener(controller);
		check.setBounds(60, 30,120,40);
		
		add = new JButton("增加账号");
		add.setActionCommand("AddUserUI");
		add.addActionListener(controller);
		add.setBounds(60, 100,120,40);
	
		delete = new JButton("删除账号");
		delete.setActionCommand("DeleteUserUI");
		delete.addActionListener(controller);
		delete.setBounds(60, 170,120,40);
		
		modify = new JButton("修改账号");
		modify.setActionCommand("ModifyUserUI");
		modify.addActionListener(controller);
		modify.setBounds(60, 240,120,40);
		
		this.add(check);
		this.add(add);
		this.add(delete);
		this.add(modify);
	}
}
