package edu.nju.express.presentation.managerui;


import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.RenderingHints;

import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JPanel;

public class ManageGuide extends JPanel {

	private static int width = 900, height = 600;
	private static Icon receipt1 = new ImageIcon("ui/icon/单据审批1.png");
	private static Icon receipt2 = new ImageIcon("ui/icon/单据审批2.png");
	private static Icon employ1 = new ImageIcon("ui/icon/人员管理1.png");
	private static Icon employ2 = new ImageIcon("ui/icon/人员管理2.png");
	private static Icon org1 = new ImageIcon("ui/icon/机构管理1.png");
	private static Icon org2 = new ImageIcon("ui/icon/机构管理2.png");
	private static Icon salary1 = new ImageIcon("ui/icon/工资制定1.png");
	private static Icon salary2 = new ImageIcon("ui/icon/工资制定2.png");
	private static Icon cons1 = new ImageIcon("ui/icon/常量制定1.png");
	private static Icon cons2 = new ImageIcon("ui/icon/常量制定2.png");
	private static Font font = new Font("黑体",Font.BOLD,14);
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
		
		receipt = new JButton(receipt1);
		receipt.setRolloverIcon(receipt2);
		receipt.setBorderPainted(false);
		receipt.setContentAreaFilled(false);
		receipt.setBounds(1,44,82,82);
		receipt.setActionCommand("ReceiptUI");
		receipt.addActionListener(controller);
		
		employee = new JButton(employ1);
		employee.setRolloverIcon(employ2);
		employee.setBounds(1,144,82,82);
		employee.setBorderPainted(false);
		employee.setContentAreaFilled(false);
		employee.setActionCommand("EmployeeUI");
		employee.addActionListener(controller);
		
		organization = new JButton(org1);
		organization.setRolloverIcon(org2);
		organization.setContentAreaFilled(false);
		organization.setBorderPainted(false);
		organization.setBounds(0,244,82,82);
		organization.setActionCommand("OrganizationUI");
		organization.addActionListener(controller);
		
		salary = new JButton(salary1);
		salary.setRolloverIcon(salary2);
		salary.setContentAreaFilled(false);
		salary.setBorderPainted(false);
		salary.setBounds(0,344,82,82);
		salary.setActionCommand("SalaryUI");
		salary.addActionListener(controller);
		
		constant = new JButton(cons1);
		constant.setRolloverIcon(cons2);
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
	
	public void refreshMessage(){
		repaint();
	}
	
	@Override
	protected void paintComponent(Graphics g) {
		super.paintComponent(g);
		int message = controller.getMessages();
		if(message != 0 ){
			Graphics2D g2d = (Graphics2D)g;
			g2d.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
			g2d.setColor(new Color(240,173,78));
			g2d.fillOval(79-12, 50, 24,24);
			g2d.setFont(font);
			g2d.setColor(new Color(246,249,249));
			int width = g2d.getFontMetrics().stringWidth(message+"");
			g2d.drawString(message+"", 79 - width/2, 66);
		}
	}
}
