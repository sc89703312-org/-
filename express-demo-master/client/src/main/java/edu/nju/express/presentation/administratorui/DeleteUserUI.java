package edu.nju.express.presentation.administratorui;
import java.awt.FlowLayout;
import java.awt.Font;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

import edu.nju.express.presentation.MainPanel;
import edu.nju.express.presentation.myUI.ConfirmButton;
import edu.nju.express.presentation.myUI.LabelTextField;

public class DeleteUserUI extends MainPanel{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private static int width=900,height=600;
	private static int y = 50;		//由标题栏高度决定
	private static int x =240;
	
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
		p = new JPanel();
		p.setLayout(null);
		p.setOpaque(false);

		
		id = new LabelTextField(" ID  ", 15);
		id.setBounds(200, 90,200,28);
		p.add(id);
		
		confirm = new ConfirmButton();
		p.add(confirm);
		confirm.setLocation(270, 200);
		confirm.addActionListener(controller);
		confirm.setActionCommand("DeleteUser");
		
		this.add(p);
		p.setBounds(x, y, width-x, height-y);
	}

	public String getID(){
		return id.getText();
	}

	

	
	
}
