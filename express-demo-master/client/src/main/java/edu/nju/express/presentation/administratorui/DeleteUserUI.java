package edu.nju.express.presentation.administratorui;

import java.awt.Graphics;
import java.awt.Image;

import javax.swing.ImageIcon;
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
	private final Image bg = new ImageIcon("ui/image/admin/删除人员.png").getImage();

	
	AdministratorController controller;

	LabelTextField id;
	JButton confirm;
	JPanel p;
	
	public DeleteUserUI(AdministratorController c) {
		controller = c;
		this.setLayout(null);
		AdministerGuide guide = new AdministerGuide(controller);
		this.add(guide);
		guide.delete.setIcon(null);
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

	
	@Override
	protected void paintComponent(Graphics g) {
		g.drawImage(bg, 0, 0, null);
	}
	
	
}
