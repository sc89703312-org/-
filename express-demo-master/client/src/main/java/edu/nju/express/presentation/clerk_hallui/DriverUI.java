package edu.nju.express.presentation.clerk_hallui;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class DriverUI extends JPanel{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	int width = 900, height = 600;
	HallController controller;
	JPanel mainpanel;
	JLabel bg;
	JPanel infoPanel, editPanel, searchPanel;
	JButton newBtn, editBtn, trashBtn;
	
	
	public DriverUI(HallController controller){
		this.controller = controller;
		
		mainpanel = new JPanel();
		mainpanel.setLayout(null);
		mainpanel.setBounds(0, 0, width, height);
		mainpanel.setVisible(true);
		initButton();
		JButton exit = new JButton(new ImageIcon("ui/button/X_darkgray.png"));
		exit.setBounds(840, 18, 30, 30);
		exit.setOpaque(false);
		exit.setBorderPainted(false);
		exit.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				System.exit(0);

			}
		});
		mainpanel.add(exit);
		bg = new JLabel(new ImageIcon("ui/image/hall/driver.png"));
		bg.setBounds(0, 0, width, height);
		mainpanel.add(bg);
		
		this.add(mainpanel);
		this.add(new HallGuide(controller));
		this.setLayout(null);
		this.setBounds(0, 0, width, height);
		this.setOpaque(false);
		this.setVisible(true);
	}
	
	public void initButton(){
		newBtn = new JButton(new ImageIcon("ui/image/hall/new0.png"));
		newBtn.setBounds(729, 81, 30, 30);
		newBtn.setBorderPainted(false);
		mainpanel.add(newBtn);
		
		editBtn = new JButton(new ImageIcon("ui/image/hall/edit0.png"));
		editBtn.setBounds(767, 81, 30, 30);
		editBtn.setBorderPainted(false);
		mainpanel.add(editBtn);
		
		trashBtn = new JButton(new ImageIcon("ui/image/hall/trash0.png"));
		trashBtn.setBounds(807, 81, 30, 30);
		trashBtn.setBorderPainted(false);
		mainpanel.add(trashBtn);
		
	}
	
	public void initInfoPanel(){
		
	}
	
	public void initEditPanel(){
		
	}
	
	public void initSearchPanel(){
		
	}
}
