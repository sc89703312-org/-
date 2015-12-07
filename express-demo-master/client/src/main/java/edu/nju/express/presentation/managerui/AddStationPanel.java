package edu.nju.express.presentation.managerui;


import javax.swing.JButton;

import edu.nju.express.presentation.MainPanel;
import edu.nju.express.presentation.myUI.CancelButton;
import edu.nju.express.presentation.myUI.ConfirmButton;
import edu.nju.express.presentation.myUI.LabelTextField;
import edu.nju.express.vo.StationVO;

public class AddStationPanel extends MainPanel{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	
	JButton cancel;
	JButton confirm;
	LabelTextField id;
	LabelTextField name;

	private ManageController controller;
	
	public AddStationPanel(ManageController c) {
		this.controller = c;
		initComponents();
		this.add(new ManageGuide(c));
	}

	private void initComponents() {

		name = new LabelTextField("中转中心名称",18);
		name.setBounds(294,170,400,40);
		this.add(name);

		id = new LabelTextField("中转中心编号",18);
		id.setBounds(294,230,400,40);
		this.add(id);

		confirm = new ConfirmButton();
		confirm.setBounds(400,537,80,30);
		this.add(confirm);
		confirm.addActionListener(controller);
		confirm.setActionCommand("AddStation");
		
		cancel = new CancelButton();
		this.add(cancel);
		cancel.setActionCommand("OrganizationUI");
		cancel.addActionListener(controller);
	}
	
	public StationVO getTextInput(){
		return new StationVO(id.getText(), name.getText());
	}
}
