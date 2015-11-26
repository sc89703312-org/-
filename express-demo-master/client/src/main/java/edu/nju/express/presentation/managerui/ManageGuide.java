package edu.nju.express.presentation.managerui;


import javax.swing.JButton;
import javax.swing.JPanel;

public class ManageGuide extends JPanel {

	static int width = 900, height = 600;
	static int y = 50;		//由标题栏高度决定
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	ManageController controller;

	JButton receipt;
	JButton employee;
	JButton organization;
	JButton salary;
	JButton constant;

	public ManageGuide(ManageController controller) {
		this.controller = controller;
		initGuide();
		this.setLayout(null);
		this.setOpaque(false);
		this.setBounds(0, y, 240, height-y);
	}

	void initGuide() {
		
		receipt = new JButton("单据管理");
		receipt.setBounds(60,30,120,40);
		receipt.setActionCommand("ReceiptUI");
		receipt.addActionListener(controller);
		
		employee = new JButton("人员管理");
		employee.setBounds(60,100,120,40);
		employee.setActionCommand("EmployeeUI");
		employee.addActionListener(controller);
		
		organization = new JButton("机构管理");
		organization.setBounds(60,170,120,40);
		organization.setActionCommand("organizationUI");
		organization.addActionListener(controller);
		
		salary = new JButton("薪水制定");
		salary.setBounds(60,240,120,40);
		salary.setActionCommand("SalaryUI");
		salary.addActionListener(controller);
		
		constant = new JButton("常量制定");
		constant.setBounds(60,310,120,40);
		constant.setActionCommand("ConstantUI");
		constant.addActionListener(controller);
		
		this.add(receipt);
		this.add(employee);
		this.add(organization);
		this.add(salary);
		this.add(constant);

	}
}
