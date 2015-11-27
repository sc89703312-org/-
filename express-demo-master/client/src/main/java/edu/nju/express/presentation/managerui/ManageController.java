package edu.nju.express.presentation.managerui;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JFrame;
import javax.swing.JPanel;

import edu.nju.express.presentation.managerui.constantui.ConstantUI;
import edu.nju.express.presentation.managerui.employeeui.AddEmployeePanel;
import edu.nju.express.presentation.managerui.employeeui.DismissEmployeePanel;
import edu.nju.express.presentation.managerui.employeeui.EmployeeListUI;
import edu.nju.express.presentation.managerui.organizationui.AddHallPanel;
import edu.nju.express.presentation.managerui.organizationui.AddStationPanel;
import edu.nju.express.presentation.managerui.organizationui.DeleteHallPanel;
import edu.nju.express.presentation.managerui.organizationui.DeleteStationPanel;
import edu.nju.express.presentation.managerui.organizationui.OrganizationUI;
import edu.nju.express.presentation.managerui.receiptui.RceiptListUI;
import edu.nju.express.presentation.managerui.salaryui.SalaryUI;

public class ManageController implements ActionListener {

	JPanel currentPanel;
	JFrame frame;
	
	
	public ManageController(JFrame f) {
		this.frame = f;
	}



	@Override
	public void actionPerformed(ActionEvent e) {

		if (e.getActionCommand().equals("ReceiptUI")) {
			frame.getContentPane().removeAll();;
			currentPanel = new RceiptListUI(this);
			frame.add(currentPanel);
			frame.validate();
			frame.repaint();
		} else if (e.getActionCommand().equals("EmployeeUI")) {
			frame.getContentPane().removeAll();;
			currentPanel = new EmployeeListUI(this);
			frame.add(currentPanel);
			frame.validate();
			frame.repaint();
		} else if (e.getActionCommand().equals("OrganizationUI")) {
			frame.getContentPane().removeAll();;
			currentPanel = new OrganizationUI(this);
			frame.add(currentPanel);
			frame.validate();
			frame.repaint();
		} else if (e.getActionCommand().equals("SalaryUI")) {
			frame.getContentPane().removeAll();;
			currentPanel = new SalaryUI(this);
			frame.add(currentPanel);
			frame.validate();
			frame.repaint();
		}else if(e.getActionCommand().equals("ConstantUI")){
			frame.getContentPane().removeAll();;
			currentPanel = new ConstantUI(this);
			frame.add(currentPanel);
			frame.validate();
			frame.repaint();
		}else if(e.getActionCommand().equals("AddEmployeeUI")){
			frame.getContentPane().removeAll();;
			currentPanel = new AddEmployeePanel(this);
			frame.add(currentPanel);
			frame.validate();
			frame.repaint();
		}else if(e.getActionCommand().equals("DismissEmployeeUI")){
			frame.getContentPane().removeAll();;
			currentPanel = new DismissEmployeePanel(this);
			frame.add(currentPanel);
			frame.validate();
			frame.repaint();
		}else if(e.getActionCommand().equals("AddStationUI")){
			frame.getContentPane().removeAll();;
			currentPanel = new AddStationPanel(this);
			frame.add(currentPanel);
			frame.validate();
			frame.repaint();
		}else if(e.getActionCommand().equals("DeleteStationUI")){
			frame.getContentPane().removeAll();;
			currentPanel = new DeleteStationPanel(this);
			frame.add(currentPanel);
			frame.validate();
			frame.repaint();
		}else if(e.getActionCommand().equals("AddHallUI")){
			frame.getContentPane().removeAll();;
			currentPanel = new AddHallPanel(this);
			frame.add(currentPanel);
			frame.validate();
			frame.repaint();
		}else if(e.getActionCommand().equals("DeleteHallUI")){
			frame.getContentPane().removeAll();;
			currentPanel = new DeleteHallPanel(this);
			frame.add(currentPanel);
			frame.validate();
			frame.repaint();
		}else if(e.getActionCommand().equals("Approve")){
			((RceiptListUI)currentPanel).getIDtoApprove();
		}else if(e.getActionCommand().equals("GetSalary")){
			((SalaryUI)currentPanel).getText();
		}
	}

}
