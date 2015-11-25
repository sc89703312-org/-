package edu.nju.express.presentation.managerui.salaryui;

import java.awt.Color;
import java.awt.FlowLayout;
import java.awt.Font;

import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

import edu.nju.express.presentation.MainPanel;
import edu.nju.express.presentation.managerui.ManageController;
import edu.nju.express.presentation.managerui.ManageGuide;

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
	JLabel clerkLabel1, clerkLabel2;
	JLabel driverLabel1, driverLabel2;
	JLabel postmanLabel1, postmanLabel2;
	JTextField clerkField;
	JTextField driverField;
	JTextField postmanField;

	public SalaryUI(ManageController c) {
		this.controller = c;
		initData();

		guide = new ManageGuide(controller);
		this.add(guide);

		p = new JPanel();
		this.add(p);
		p.setOpaque(false);
		p.setBounds(guide.getWidth(), y, width - guide.getWidth(), (int) (width * 0.1));
		p.setLayout(new FlowLayout(FlowLayout.CENTER, (int) (0.5 * p.getWidth()), (int) (0.4 * p.getHeight())));

		clerkLabel1 = new JLabel("业务员月薪：");
		clerkField = new JTextField();
		clerkField.setText(clerk + "");
		clerkLabel2 = new JLabel("元/月");
		JPanel temp1 = new JPanel();
		clerkLabel1.setOpaque(false);
		clerkField.setOpaque(false);
		clerkLabel2.setOpaque(false);
		temp1.add(clerkLabel1);
		temp1.add(clerkField);
		temp1.add(clerkLabel2);
		p.add(temp1);
		
		driverLabel1 = new JLabel("司机提成：");
		driverField = new JTextField();
		driverField.setText(driver + "");
		driverLabel2 = new JLabel("元/次");
		JPanel temp2 = new JPanel();
		temp2.add(driverLabel1);
		temp2.add(driverField);
		temp2.add(driverLabel2);
		p.add(temp2);
		
		postmanLabel1 = new JLabel("司机提成：");
		postmanField = new JTextField();
		postmanField.setText(postman + "");
		postmanLabel2 = new JLabel("元/次");
		JPanel temp3 = new JPanel();
		temp3.add(postmanLabel1);
		temp3.add(postmanField);
		temp3.add(postmanLabel2);
		p.add(temp3);
	}

	private void initData() {
		clerk = 2000;
		driver = 50;
		postman = 3;

	}
}
