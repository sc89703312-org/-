package edu.nju.express.presentation.managerui;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JPanel;

public class ManageController implements ActionListener {

	JPanel currentPanel;
	
	
	
	public ManageController(JPanel currentPanel) {
		super();
		this.currentPanel = currentPanel;
	}



	@Override
	public void actionPerformed(ActionEvent e) {

		if (e.getActionCommand().equals("ReceiptUI")) {

		} else if (e.getActionCommand().equals("EmployeeUI")) {

		} else if (e.getActionCommand().equals("OrganizationUI")) {

		} else if (e.getActionCommand().equals("SalaryUI")) {

		}else if(e.getActionCommand().equals("ConstantUI")){
			
		}
	}

}
