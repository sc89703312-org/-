package edu.nju.express.presentation.managerui;

import java.awt.Color;
import java.awt.Font;

import javax.swing.JButton;
import javax.swing.JPanel;

import edu.nju.express.presentation.MainPanel;
import edu.nju.express.presentation.myUI.ConfirmButton;
import edu.nju.express.presentation.myUI.LabelTextField;
import edu.nju.express.presentation.myUI.ReturnButton;

public class DeleteHallPanel extends MainPanel{

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

	private ManageController controller;
	
	public DeleteHallPanel(ManageController c) {
		this.controller = c;
		initComponents();
	}

	private void initComponents() {
		
		p = new JPanel();
		p.setLayout(null);
		p.setOpaque(false);
		
		jbtReturn = new ReturnButton();
		jbtReturn.setActionCommand("OrganizationUI");
		jbtReturn.addActionListener(controller);
		p.add(jbtReturn);

		
		id = new LabelTextField("ID   ", 15);
		id.setSize(350, 40);
		id.setLocation((width-350)/2, 90);
		p.add(id);
		
		confirm = new ConfirmButton();
		confirm.setLocation((width-confirm.getWidth())/2, 180);
		p.add(confirm);
		confirm.addActionListener(controller);
		confirm.setActionCommand("DeleteStation");
		
		this.add(p);
		p.setBounds(0, y, width, height);
	}
	
	public String getID(){
		return id.getText();
	}
}
