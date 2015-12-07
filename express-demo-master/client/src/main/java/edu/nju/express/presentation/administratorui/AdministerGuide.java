package edu.nju.express.presentation.administratorui;


import javax.swing.JButton;
import javax.swing.JPanel;


public class AdministerGuide extends JPanel{

	int width=900,height=600;
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	AdministratorController controller;
	
	JButton add;
	JButton delete;
	JButton modify;
	JButton check;
	
	
	public AdministerGuide(AdministratorController controller) {
		this.controller = controller;
		initGuide();
		this.setOpaque(false);
		this.setLayout(null);
		this.setBounds(12, 0, 94, height);
	}
	
	
	void initGuide(){
		check = new JButton();
		check.setActionCommand("CheckTaskUI");
		check.addActionListener(controller);
		check.setBounds(0,44,82,82);
		check.setBorderPainted(false);
		check.setContentAreaFilled(false);
		
		add = new JButton();
		add.setActionCommand("AddBankingUI");
		add.addActionListener(controller);
		add.setBounds(0,144,82,82);
		add.setBorderPainted(false);
		add.setContentAreaFilled(false);
	
		delete = new JButton();
		delete.setActionCommand("DeleteBankingUI");
		delete.addActionListener(controller);
		delete.setBounds(0,244,82,82);
		delete.setBorderPainted(false);
		delete.setContentAreaFilled(false);
		
		modify = new JButton();
		modify.setActionCommand("ModifyUserUI");
		modify.addActionListener(controller);
		modify.setBounds(0,344,82,82);
		modify.setBorderPainted(false);
		modify.setContentAreaFilled(false);
		
		this.add(check);
		this.add(add);
		this.add(delete);
		this.add(modify);
	}
}
