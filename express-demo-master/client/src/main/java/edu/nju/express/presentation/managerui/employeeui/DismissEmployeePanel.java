package edu.nju.express.presentation.managerui.employeeui;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

import edu.nju.express.presentation.MainPanel;
import edu.nju.express.presentation.managerui.ManageController;
import edu.nju.express.presentation.myUI.ConfirmButton;
import edu.nju.express.presentation.myUI.LabelTextField;
import edu.nju.express.presentation.myUI.ReturnButton;

public class DismissEmployeePanel extends MainPanel {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	ManageController controller;

	int width = 900, height = 600;
	int y = 50;
	LabelTextField id;
	JButton confirm;
	JButton jbtReturn;
	JPanel p;

	public DismissEmployeePanel(ManageController c) {
		controller = c;
		initComponents();
		this.setOpaque(false);
	}

	private void initComponents() {
		
		p = new JPanel();
		p.setLayout(null);
		p.setOpaque(false);
		
		jbtReturn = new ReturnButton();
		jbtReturn.setActionCommand("EmployeeUI");
		jbtReturn.addActionListener(controller);
		p.add(jbtReturn);

		
		id = new LabelTextField("ID ", 15);
		id.setSize(300, 100);
		id.setLocation(width/2-150, 80);
		p.add(id);
		
		confirm = new ConfirmButton();
		confirm.setLocation((width-confirm.getWidth())/2, 140);
		p.add(confirm);
		confirm.addActionListener(controller);
		confirm.setActionCommand("DismissEmployee");
		
		this.add(p);
		p.setBounds(0, y, width, height);
	}

	public String getID() {
		return id.getText();
	}

}
