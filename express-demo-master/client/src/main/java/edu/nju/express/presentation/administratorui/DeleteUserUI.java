package edu.nju.express.presentation.administratorui;

import javax.swing.JButton;
import javax.swing.JPanel;

import edu.nju.express.presentation.MainPanel;
import edu.nju.express.presentation.myUI.ConfirmButton;
import edu.nju.express.presentation.myUI.LabelTextField;

public class DeleteUserUI extends MainPanel{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	AdministratorController controller;

	LabelTextField id;
	JButton confirm;
	JPanel p;
	
	public DeleteUserUI(AdministratorController c) {
		controller = c;
		this.setLayout(null);
		this.add(new AdministerGuide(controller));
		initComponents();
		this.setOpaque(false);
	}
	
	private void initComponents() {
		
		id = new LabelTextField("ID     ", 15);
		id.setBounds(294, 200,400,40);
		this.add(id);
		
		confirm = new ConfirmButton();
		this.add(confirm);
		confirm.addActionListener(controller);
		confirm.setActionCommand("DeleteUser");
		
		
	}

	public String getID(){
		return id.getText();
	}

	

	
	
}
