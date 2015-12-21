package edu.nju.express.presentation.managerui;

import java.awt.Graphics;
import java.awt.Image;

import javax.swing.ImageIcon;
import javax.swing.JPanel;

import edu.nju.express.presentation.MainPanel;
import edu.nju.express.presentation.myUI.CancelButton;
import edu.nju.express.presentation.myUI.ConfirmButton;
import edu.nju.express.presentation.myUI.LabelTextField;

public class DismissEmployeePanel extends MainPanel {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private static Image bg = new ImageIcon("ui/image/manager/删除人员.png").getImage();
	

	ManageController controller;

	int width = 900, height = 600;
	int y = 50;
	LabelTextField id;
	ConfirmButton confirm;
	CancelButton cancel;
	JPanel p;

	public DismissEmployeePanel(ManageController c) {
		controller = c;
		initComponents();
		ManageGuide guide = new ManageGuide(c);
		guide.employee.setIcon(null);
		this.add(guide);
	}

	private void initComponents() {
		
		id = new LabelTextField("ID    ",15);
		id.setBounds(200+94, 220,400,40);
		this.add(id);
		
		confirm = new ConfirmButton();
		this.add(confirm);
		confirm.setBounds(400,537,80,30);
		confirm.addActionListener(controller);
		confirm.setActionCommand("DismissEmployee");
		
		cancel = new CancelButton();
		this.add(cancel);
		cancel.addActionListener(controller);
		cancel.setActionCommand("EmployeeUI");
		
	}

	public String getID() {
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
