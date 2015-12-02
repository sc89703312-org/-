package edu.nju.express.presentation.managerui;

import javax.swing.JPanel;

import edu.nju.express.presentation.MainPanel;
import edu.nju.express.presentation.myUI.CancelButton;
import edu.nju.express.presentation.myUI.ConfirmButton;
import edu.nju.express.presentation.myUI.LabelTextField;

public class DismissEmployeePanel extends MainPanel {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	ManageController controller;

	int width = 900, height = 600;
	int y = 50;
	LabelTextField id;
	ConfirmButton confirm;
	CancelButton cancel;
	JPanel p;

	public DismissEmployeePanel(ManageController c) {
		controller = c;
		initComponents();
		this.add(new ManageGuide(c));
	}

	private void initComponents() {
		
		id = new LabelTextField("ID    ",15);
		id.setBounds(200+94, 220,400,40);
		this.add(id);
		
		confirm = new ConfirmButton();
		this.add(confirm);
		confirm.addActionListener(controller);
		confirm.setActionCommand("DismissEmployee");
		
		cancel = new CancelButton();
		this.add(cancel);
		cancel.addActionListener(controller);
		cancel.setActionCommand("EmployeeUI");
		
	}

	public String getID() {
		return id.getText();
	}

}
