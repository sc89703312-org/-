package edu.nju.express.presentation.managerui;


import java.awt.Graphics;
import java.awt.Image;

import javax.swing.ImageIcon;

import edu.nju.express.presentation.MainPanel;
import edu.nju.express.presentation.myUI.CancelButton;
import edu.nju.express.presentation.myUI.ConfirmButton;
import edu.nju.express.presentation.myUI.LabelTextField;

public class DeleteStationPanel extends MainPanel{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private static Image bg = new ImageIcon("ui/image/manager/删除中转中心.png").getImage();
	
	
	ConfirmButton confirm;
	CancelButton cancel;
	LabelTextField id;

	private ManageController controller;
	
	public DeleteStationPanel(ManageController c) {
		this.controller = c;
		initComponents();
		ManageGuide guide = new ManageGuide(c);
		guide.organization.setIcon(null);
		this.add(guide);
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
		if(id.getText().equals("")){
			id.setError();
			return null;
		}
		
		return id.getText();
	}
	
	@Override
	protected void paintComponent(Graphics g) {
		g.drawImage(bg, 0, 0, null);
	}
}
