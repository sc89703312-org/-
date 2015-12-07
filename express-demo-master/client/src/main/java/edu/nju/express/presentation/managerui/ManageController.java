package edu.nju.express.presentation.managerui;

import java.awt.event.ActionEvent;
import java.util.ArrayList;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;

import edu.nju.express.blservice.ConstantSettingBlService;
import edu.nju.express.blservice.ManagementBlService;
import edu.nju.express.blservice.OrganizationBlService;
import edu.nju.express.blservice.ReceiptBlService;
import edu.nju.express.blservice.SalarySettingBlService;
import edu.nju.express.businesslogic.DataFactory;
import edu.nju.express.presentation.UIController;
import edu.nju.express.vo.EmployeeVO;
import edu.nju.express.vo.UserMessageVO;

public class ManageController implements UIController {

	private JPanel currentPanel;
	private JFrame frame;
	private ManagementBlService manage;
	private OrganizationBlService org;
	private ConstantSettingBlService constant;
	private ReceiptBlService receipt;
	private SalarySettingBlService salary;
	
	public ManageController(JFrame f) {
		this.frame = f;
		manage = DataFactory.createManagementBlInstance();
		org = DataFactory.createOrganizationBl();
		receipt = DataFactory.createReceiptBlInstance();
		salary = DataFactory.createSalarySettingBlInstance();
		constant = DataFactory.createConstantSettingBLInstance();
	}



	@Override
	public void actionPerformed(ActionEvent e) {
		System.out.println(e.getActionCommand());
		
		if (e.getActionCommand().equals("ReceiptUI")) {
			
			frame.getContentPane().removeAll();;
			currentPanel = new ReceiptApprovalUI(this);
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
			
			currentPanel = (JPanel)(((JButton)e.getSource()).getParent());
			for(String id:((ReceiptApprovalUI)currentPanel).getIDtoApprove()){
				System.out.println(id);
			}
		}else if(e.getActionCommand().equals("GetSalary")){
			
			((SalaryUI)currentPanel).getText();
			
		}else if(e.getActionCommand().equals("ModifyConstant")){
			
		}else if(e.getActionCommand().equals("AddEmployee")){
			
			UserMessageVO vo= ((AddEmployeePanel)currentPanel).getTextInput();
			manage.addEmployee(vo.getId(), vo.getName(), vo.getRole());
			
		}else if(e.getActionCommand().equals("DismissEmployee")){
			
			String id= ((DismissEmployeePanel)currentPanel).getID();
			manage.dismissEmployee(id);
			
		}
		
	}

	ArrayList<EmployeeVO> getEmployeeList(){
		return manage.viewEmployeeList();
	}
}
