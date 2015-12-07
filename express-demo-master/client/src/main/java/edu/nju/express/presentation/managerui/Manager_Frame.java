package edu.nju.express.presentation.managerui;

import javax.swing.JPanel;

import edu.nju.express.presentation.myUI.MyFrame;

public class Manager_Frame extends MyFrame{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public Manager_Frame () {
		JPanel p = new ReceiptApprovalUI(new ManageController(this));
		this.add(p);
		this.setVisible(true);
	}
}
