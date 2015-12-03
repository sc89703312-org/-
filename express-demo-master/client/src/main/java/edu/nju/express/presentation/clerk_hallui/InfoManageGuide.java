package edu.nju.express.presentation.clerk_hallui;

import javax.swing.JButton;
import javax.swing.JPanel;

public class InfoManageGuide extends JPanel{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	HallController controller;
	JPanel iconColumn;
	JButton newBtn, editBtn, deleteBtn;
	
	public InfoManageGuide(HallController controller){
		this.controller = controller;
		iconColumn = new JPanel();
		iconColumn.setLayout(null);
		iconColumn.setVisible(true);
		iconColumn.setBounds( 650, 50, 200, 50);
		init();
		this.setLayout(null);
		this.setVisible(true);
		this.add(iconColumn);
		this.setBounds( 650, 50, 200, 50);
	}
	
	public void init(){
		JPanel panel = new JPanel();
		panel.setLayout(null);
		panel.setBounds(650, 50, 200, 50);
		panel.setVisible(true);
		panel.setOpaque(false);
		
		//newBtn
		newBtn = new JButton("new");
		newBtn.setBounds( 0, 0, 50, 50);
		panel.add(newBtn);
		
		//editBtn
		editBtn = new JButton("edit");
		editBtn.setBounds(60, 0, 50, 50);
		panel.add(editBtn);
		
		//deleteBtn
		deleteBtn = new JButton("delete");
		deleteBtn.setBounds(120, 0, 50, 50);
		panel.add(deleteBtn);
		
		this.iconColumn.add(panel);
		
	}

}
