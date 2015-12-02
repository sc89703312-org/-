package edu.nju.express.presentation.managerui;


import edu.nju.express.presentation.MainPanel;
import edu.nju.express.presentation.myUI.CancelButton;
import edu.nju.express.presentation.myUI.ConfirmButton;
import edu.nju.express.presentation.myUI.LabelTextField;

public class DeleteHallPanel extends MainPanel{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	ConfirmButton confirm;
	CancelButton cancel;
	LabelTextField id;

	private ManageController controller;
	
	public DeleteHallPanel(ManageController c) {
		this.controller = c;
		initComponents();
		this.add(new ManageGuide(c));
	}

	private void initComponents() {
		
		confirm = new ConfirmButton();
		this.add(confirm);
		confirm.addActionListener(controller);
		confirm.setActionCommand("DeleteHall");
		
		cancel = new CancelButton();
		this.add(cancel);
		cancel.setActionCommand("OrganizationUI");
		cancel.addActionListener(controller);

		
		id = new LabelTextField("ID   ", 15);
		id.setBounds(200+94, 220, 400,40);
		this.add(id);
		
	}
	
	public String getID(){
		return id.getText();
	}
}
