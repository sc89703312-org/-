package edu.nju.express.presentation.managerui.salaryui;

import java.awt.Color;
import java.awt.FlowLayout;
import java.awt.Font;

import javax.swing.JLabel;
import javax.swing.JPanel;

import edu.nju.express.presentation.MainPanel;
import edu.nju.express.presentation.managerui.ManageController;
import edu.nju.express.presentation.managerui.ManageGuide;
import edu.nju.express.presentation.myUI.ConfirmButton;
import edu.nju.express.presentation.myUI.MyTextField;

public class SalaryUI extends MainPanel {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	static Font font = new Font("微软雅黑", Font.PLAIN, 16);
	static Color color = Color.white;
	static int width = 900, height = 600;
	static int y = 50; // 由标题栏高度决定

	ManageController controller;
	int clerk, driver, postman;

	JPanel p;
	ManageGuide guide;
	ConfirmButton confirm;
	
	JLabel clerkLabel1, clerkLabel2;
	JLabel driverLabel1, driverLabel2;
	JLabel postmanLabel1, postmanLabel2;
	MyTextField clerkField;
	MyTextField driverField;
	MyTextField postmanField;

	public SalaryUI(ManageController c) {
		this.controller = c;
		initData();

		guide = new ManageGuide(controller);
		this.add(guide);
		
		p = new JPanel();
		this.add(p);
		p.setOpaque(false);
		p.setBounds(guide.getWidth(), y, width - guide.getWidth(), height - y);
		p.setLayout(new FlowLayout(FlowLayout.CENTER, (int) (0.5 * p.getWidth()), 60));

		clerkLabel1 = new JLabel("业务员月薪：");
		clerkField = new MyTextField(6);
		clerkField.setText(clerk + "");
		clerkLabel2 = new JLabel("元/月");
		JPanel temp1 = new JPanel();
		clerkLabel1.setOpaque(false);
		clerkField.setOpaque(false);
		clerkLabel2.setOpaque(false);
		temp1.setOpaque(false);
		temp1.add(clerkLabel1);
		temp1.add(clerkField);
		temp1.add(clerkLabel2);
		p.add(temp1);
		
		driverLabel1 = new JLabel("司机提成：");
		driverField = new MyTextField(6);
		driverField.setText(driver + "");
		driverLabel2 = new JLabel("元/次");
		JPanel temp2 = new JPanel();
		driverLabel1.setOpaque(false);
		driverField.setOpaque(false);
		driverLabel2.setOpaque(false);
		temp2.setOpaque(false);
		temp2.add(driverLabel1);
		temp2.add(driverField);
		temp2.add(driverLabel2);
		p.add(temp2);
		
		postmanLabel1 = new JLabel("司机提成：");
		postmanField = new MyTextField(6);
		postmanField.setText(postman + "");
		postmanLabel2 = new JLabel("元/次");
		JPanel temp3 = new JPanel();
		postmanLabel1.setOpaque(false);
		postmanField.setOpaque(false);
		postmanLabel2.setOpaque(false);
		temp3.setOpaque(false);
		temp3.add(postmanLabel1);
		temp3.add(postmanField);
		temp3.add(postmanLabel2);
		p.add(temp3);
		
		confirm = new ConfirmButton();
		confirm.setLocation(guide.getWidth()+p.getWidth()/2-confirm.getWidth()/2, 380);
		this.add(confirm);
		confirm.setActionCommand("GetSalary");
		confirm.addActionListener(controller);
	}

	private void initData() {
		clerk = 2000;
		driver = 50;
		postman = 3;

	}
	
	public String[] getText(){
		String[] text = new String[3];
		text[0] = clerkField.getText();
		text[1] = driverField.getText();
		text[2] = postmanField.getText();
		return text;
	}
	
	
}
