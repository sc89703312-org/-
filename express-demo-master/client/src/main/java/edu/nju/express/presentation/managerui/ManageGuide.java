package edu.nju.express.presentation.managerui;

import javax.swing.JButton;
import javax.swing.JPanel;

public class ManageGuide extends JPanel {

	int width = 900, height = 600;
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
		this.setBounds(0, 0, (int) (width * 0.2), (int) (height));
	}

	void initGuide() {
		JPanel buttons = new JPanel();
		buttons.setOpaque(false);
		buttons.setBounds(0, 0, (int) (width * 0.2), (int) (height));
		
		receipt = new JButton("单据管理");
		receipt.setActionCommand("ReceiptUI");
		receipt.addActionListener(controller);
		
		employee = new JButton("人员管理");
		employee.setActionCommand("EmployeeUI");
		employee.addActionListener(controller);
		
		organization = new JButton("机构管理");
		organization.setActionCommand("organizationUI");
		organization.addActionListener(controller);
		
		salary = new JButton("薪水制定");
		salary.setActionCommand("SalaryUI");
		salary.addActionListener(controller);
		
		constant = new JButton("常量制定");
		constant.setActionCommand("ConstantUI");
		constant.addActionListener(controller);
		
		add(buttons);
	}
}
