package edu.nju.express.presentation.administratorui;
import java.awt.FlowLayout;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

import edu.nju.express.presentation.MainPanel;
import edu.nju.express.presentation.myUI.ConfirmButton;
import edu.nju.express.presentation.myUI.MyTextField;

public class DeleteUserUI extends MainPanel{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	int width=900,height=600;
	int y = 50;		//由标题栏高度决定
	MyTextField id;
	JButton confirm;
	AdministratorController controller;
	JPanel p ;
	
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

		
		id = new MyTextField("ID ", 15);
		id.setSize(300, 100);
		id.setLocation(180, 60);
		p.add(id);
		
		confirm = new ConfirmButton();
		confirm.setLocation(confirm.getX(), 120);
		p.add(confirm);
		confirm.addActionListener(controller);
		confirm.setActionCommand("DeleteUser");
		
		this.add(p);
		p.setBounds((int)(width*0.2), y, (int)(width*0.8), height);
	}

	public String getID(){
		return id.getText();
	}

	

	
	
}
