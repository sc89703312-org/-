package edu.nju.express.presentation.managerui;

import edu.nju.express.presentation.MainPanel;
import edu.nju.express.presentation.myUI.ConfirmButton;
import edu.nju.express.presentation.myUI.LabelTextField;
import edu.nju.express.vo.SalaryVO;

public class SalaryUI extends MainPanel {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	private ManageController controller;
	private double clerk, driver, postman;

	private ManageGuide guide;
	private ConfirmButton confirm;
	
	private LabelTextField clerkField;
	private LabelTextField driverField;
	private LabelTextField postmanField;

	public SalaryUI(ManageController c) {
		this.controller = c;
		initData();

		guide = new ManageGuide(controller);
		this.add(guide);
		
		clerkField = new LabelTextField("业务员月薪：",-1,"元/月");
		clerkField.setText(clerk + "");
		clerkField.setBounds(200+94, 170, 400, 40);
		this.add(clerkField);
		
		driverField = new LabelTextField("司机提成：  ",-1,"元/次");
		driverField.setText(driver + "");
		driverField.setBounds(200+94, 250, 400, 40);
		this.add(driverField);
		
		postmanField = new LabelTextField("司机提成：  ",-1,"元/次");
		postmanField.setText(postman + "");
		postmanField.setBounds(200+94, 330, 400, 40);
		this.add(postmanField);
		
		confirm = new ConfirmButton();
		this.add(confirm);
		confirm.setActionCommand("SetSalary");
		confirm.addActionListener(controller);
	}

	private void initData() {
		SalaryVO vo =controller.getSalaryData();
		clerk = vo.getClerkSalary();
		driver = vo.getDriverWage();
		postman = vo.getPostmanWage();

	}
	
	public String[] getText(){
		String[] text = new String[3];
		text[0] = clerkField.getText();
		text[1] = driverField.getText();
		text[2] = postmanField.getText();
		return text;
	}
	
	
}
