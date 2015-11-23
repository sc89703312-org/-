package edu.nju.express.presentation.UserUI;

import javax.swing.JButton;
import javax.swing.JPanel;

public class AdministerGuide extends JPanel{

	int width=900,height=600;
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	UserController controller;
	
	JButton add;
	JButton delete;
	JButton modify;
	JButton check;
	
	
	public AdministerGuide(UserController controller) {
		this.controller = controller;
		initGuide();
		this.setLayout(null);
		this.setBounds(0, 0, (int)(width*0.2), (int)(height));
	}
	
	
	void initGuide(){
		JPanel buttons = new JPanel();
		buttons.setOpaque(false);
		buttons.setBounds(0, 0, (int)(width*0.2), (int)(height));
		check = new JButton("查看人员");
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
