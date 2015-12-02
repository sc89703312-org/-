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
		this.setBounds(12, 0, 94, height);
	}

	void initGuide() {
		
		receipt = new JButton();
		receipt.setBorderPainted(false);
		receipt.setContentAreaFilled(false);
		receipt.setBounds(0,44,82,82);
		receipt.setActionCommand("ReceiptUI");
		receipt.addActionListener(controller);
		
		employee = new JButton();
		employee.setBounds(0,144,82,82);
		employee.setBorderPainted(false);
		employee.setContentAreaFilled(false);
		employee.setActionCommand("EmployeeUI");
		employee.addActionListener(controller);
		
		organization = new JButton();
		organization.setContentAreaFilled(false);
		organization.setBorderPainted(false);
		organization.setBounds(0,244,82,82);
		organization.setActionCommand("OrganizationUI");
		organization.addActionListener(controller);
		
		salary = new JButton();
		salary.setContentAreaFilled(false);
		salary.setBorderPainted(false);
		salary.setBounds(0,344,82,82);
		salary.setActionCommand("SalaryUI");
		salary.addActionListener(controller);
		
		constant = new JButton();
		constant.setBounds(0,444,82,82);
		constant.setContentAreaFilled(false);
		constant.setBorderPainted(false);
		constant.setActionCommand("ConstantUI");
		constant.addActionListener(controller);
		
		this.add(receipt);
		this.add(employee);
		this.add(organization);
		this.add(salary);
		this.add(constant);

	}
}
