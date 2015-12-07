package edu.nju.express.presentation.administratorui;


import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JPanel;


public class AdministerGuide extends JPanel{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private int width=900,height=600;
	private static Icon check1=new ImageIcon("ui/icon/查看任务1.png");
	private static Icon check2=new ImageIcon("ui/icon/查看任务2.png");
	private static Icon add1=new ImageIcon("ui/icon/增加人员1.png");
	private static Icon add2=new ImageIcon("ui/icon/增加人员2.png");
	private static Icon delete1=new ImageIcon("ui/icon/删除人员1.png");
	private static Icon delete2=new ImageIcon("ui/icon/删除人员2.png");
	private static Icon modify1=new ImageIcon("ui/icon/修改人员1.png");
	private static Icon modify2=new ImageIcon("ui/icon/修改人员2.png");
	
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
		this.setBounds(12, 0, 94, height);
	}
	
	
	void initGuide(){
		check = new JButton(check1);
		check.setRolloverIcon(check2);
		check.setFocusPainted(false);
		check.setContentAreaFilled(false);
		check.setActionCommand("CheckTaskUI");
		check.addActionListener(controller);
		check.setBounds(0,44,82,82);
		check.setBorderPainted(false);
		check.setContentAreaFilled(false);
		
		add = new JButton(add1);
		add.setRolloverIcon(add2);
		add.setFocusPainted(false);
		add.setContentAreaFilled(false);
		add.setActionCommand("AddUserUI");
		add.addActionListener(controller);
		add.setBounds(0,144,82,82);
		add.setBorderPainted(false);
		add.setContentAreaFilled(false);
	
		delete = new JButton(delete1);
		delete.setRolloverIcon(delete2);
		delete.setFocusPainted(false);
		delete.setContentAreaFilled(false);
		delete.setActionCommand("DeleteUserUI");
		delete.addActionListener(controller);
		delete.setBounds(0,244,82,82);
		delete.setBorderPainted(false);
		delete.setContentAreaFilled(false);
		
		modify = new JButton(modify1);
		modify.setRolloverIcon(modify2);
		modify.setFocusPainted(false);
		modify.setContentAreaFilled(false);
		modify.setActionCommand("ModifyUserUI");
		modify.addActionListener(controller);
		modify.setBounds(0,344,82,82);
		modify.setBorderPainted(false);
		modify.setContentAreaFilled(false);
		
		this.add(check);
		this.add(add);
		this.add(delete);
		this.add(modify);
	}
}
