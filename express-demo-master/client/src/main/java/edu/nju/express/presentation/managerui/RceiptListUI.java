package edu.nju.express.presentation.managerui;


import javax.swing.JButton;

import edu.nju.express.presentation.MainPanel;
import edu.nju.express.presentation.myUI.ReturnButton;

public class RceiptListUI extends MainPanel {

	private static final long serialVersionUID = 1L;
	int width = 900;
	int height = 600;
	ManageController controller;

	JButton jbtReturn;

	public RceiptListUI(ManageController c) {
		controller = c;

		jbtReturn = new ReturnButton();
		jbtReturn.setLocation(10, 60);
		this.add(jbtReturn);
		jbtReturn.addActionListener(controller);
		jbtReturn.setActionCommand("ReceiptUI");

	}
}
