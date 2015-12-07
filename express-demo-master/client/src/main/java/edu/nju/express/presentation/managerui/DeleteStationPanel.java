package edu.nju.express.presentation.managerui;


import edu.nju.express.presentation.MainPanel;
import edu.nju.express.presentation.myUI.CancelButton;
import edu.nju.express.presentation.myUI.ConfirmButton;
import edu.nju.express.presentation.myUI.LabelTextField;

public class DeleteStationPanel extends MainPanel{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	ConfirmButton confirm;
	CancelButton cancel;
	LabelTextField id;

	private ManageController controller;
	
	public DeleteStationPanel(ManageController c) {
		this.controller = c;
		initComponents();
		this.add(new ManageGuide(c));
	}

	private void initComponents() {
		
		id = new LabelTextField("ID   ", 15);
		id.setBounds(200+94,220,400,40);
		this.add(id);
		
		confirm = new ConfirmButton();
		confirm.setBounds(400,537,80,30);
		this.add(confirm);
		confirm.addActionListener(controller);
		confirm.setActionCommand("DeleteStation");
		
		cancel = new CancelButton();
		this.add(cancel);
		cancel.setActionCommand("OrganizationUI");
		cancel.addActionListener(controller);
	}
	
	public String getID(){
		return id.getText();
	}
}
