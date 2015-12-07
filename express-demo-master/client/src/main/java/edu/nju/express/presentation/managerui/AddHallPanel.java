package edu.nju.express.presentation.managerui;


import javax.swing.JButton;
import javax.swing.JPanel;

import edu.nju.express.presentation.MainPanel;
import edu.nju.express.presentation.myUI.CancelButton;
import edu.nju.express.presentation.myUI.ConfirmButton;
import edu.nju.express.presentation.myUI.LabelTextField;
import edu.nju.express.vo.HallVO;
import edu.nju.express.vo.StationVO;

public class AddHallPanel extends MainPanel{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	JButton cancel;
	JButton confirm;
	JPanel p;
	LabelTextField id;
	LabelTextField name;

	private ManageController controller;
	
	public AddHallPanel(ManageController c) {
		this.controller = c;
		initComponents();
		this.add(new ManageGuide(c));
	}

	private void initComponents() {
		
		name = new LabelTextField("营业厅名称",18);
		name.setBounds(294, 170, 400,40);
		this.add(name);

		id = new LabelTextField("营业厅编号",18);
		id.setBounds(294, 230,400,40);
		this.add(id);

		confirm = new ConfirmButton();
		confirm.setBounds(400,537,80,30);
		confirm.setActionCommand("AddHall");
		confirm.addActionListener(controller);
		this.add(confirm);
		
		cancel = new CancelButton();
		this.add(cancel);
		cancel.setActionCommand("OrganizationUI");
		cancel.addActionListener(controller);
	}
	
	public HallVO getTextInput(){
		return new HallVO(id.getText(), name.getText());
	}
}
