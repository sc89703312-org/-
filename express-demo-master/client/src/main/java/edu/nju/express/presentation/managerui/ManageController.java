package edu.nju.express.presentation.managerui;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JFrame;
import javax.swing.JPanel;

import edu.nju.express.presentation.administratorui.CheckTaskUI;
import edu.nju.express.presentation.managerui.employeeui.AddEmployeePanel;
import edu.nju.express.presentation.managerui.employeeui.DismissEmployeePanel;
import edu.nju.express.presentation.managerui.employeeui.EmployeeListUI;
import edu.nju.express.presentation.managerui.receiptui.RceiptListUI;

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

		} else if (e.getActionCommand().equals("SalaryUI")) {

		}else if(e.getActionCommand().equals("ConstantUI")){
			
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
		}else if(e.getActionCommand().equals("Approve")){
			((RceiptListUI)currentPanel).getIDtoApprove();
		}
	}

}
