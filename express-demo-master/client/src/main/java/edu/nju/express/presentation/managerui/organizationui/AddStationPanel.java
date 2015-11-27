package edu.nju.express.presentation.managerui.organizationui;

import java.awt.Color;
import java.awt.Font;

import javax.swing.JButton;
import javax.swing.JPanel;

import edu.nju.express.presentation.MainPanel;
import edu.nju.express.presentation.managerui.ManageController;
import edu.nju.express.presentation.myUI.ConfirmButton;
import edu.nju.express.presentation.myUI.LabelTextField;
import edu.nju.express.presentation.myUI.ReturnButton;
import edu.nju.express.vo.StationVO;

public class AddStationPanel extends MainPanel{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	static Font font = new Font("黑体", Font.PLAIN, 16);
	static Color color = Color.white;
	static int width = 900, height = 600;
	static int y = 50; // 由标题栏高度决定
	static int x=240;
	static int h=200;
	
	JButton jbtReturn;
	JButton confirm;
	JPanel p;
	LabelTextField id;
	LabelTextField name;

	private ManageController controller;
	
	public AddStationPanel(ManageController c) {
		this.controller = c;
		initComponents();
	}

	private void initComponents() {
		p = new JPanel();
		this.add(p);
		p.setLayout(null);
		p.setOpaque(false);
		p.setBounds(0, y,  width, height);

		jbtReturn = new ReturnButton();
		jbtReturn.setActionCommand("OrganizationUI");
		jbtReturn.addActionListener(controller);
		p.add(jbtReturn);

		
		name = new LabelTextField("中转中心名称",18);
		name.setBounds((width-350)/2, 130, 350,40);
		p.add(name);

		id = new LabelTextField("中转中心编号",18);
		id.setBounds((width-350)/2, 80,350,40);
		p.add(id);

		confirm = new ConfirmButton();
		confirm.setLocation((width-confirm.getWidth())/2, 220);
		confirm.setActionCommand("AddStation");
		confirm.addActionListener(controller);
		p.add(confirm);
	}
	
	public StationVO getTextInput(){
		return new StationVO(id.getText(), name.getText());
	}
}
