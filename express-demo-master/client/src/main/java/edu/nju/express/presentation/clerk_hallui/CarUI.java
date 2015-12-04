package edu.nju.express.presentation.clerk_hallui;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;

import edu.nju.express.presentation.UIController;
import edu.nju.express.presentation.myUI.LabelTextField;
import edu.nju.express.presentation.myUI.MySearchFieldPanel;

public class CarUI extends JPanel{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	int width = 900, height = 600;
	UIController controller;
	JPanel mainpanel;
	JLabel bg;
	JButton newBtn, editBtn, trashBtn;
	JPanel infoPanel, editPanel;
	JButton saveBtn, addBtn;
	MySearchFieldPanel searchField;
	LabelTextField idField, numberField;
	
	public 	CarUI(UIController controller){
		this.controller = controller;
		mainpanel = new JPanel();
		mainpanel.setLayout(null);
		mainpanel.setBounds(0, 0, width, height);
		mainpanel.setVisible(true);
		mainpanel.setOpaque(false);
		
		initButton();
		initEditPanel();
		initInfoPanel();
		
		mainpanel.add(editPanel);
		
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
		
		
		bg = new JLabel(new ImageIcon("ui/image/hall/car.png"));
		bg.setBounds(0, 0, width, height);
		mainpanel.add(bg);
		
		
		this.add(mainpanel);
		this.add(new HallGuide(controller));
		this.setLayout(null);
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
		
		searchField = new MySearchFieldPanel(controller);
		searchField.setBounds(480, 76, 200, 40);
		mainpanel.add(searchField);
	}

	public void initInfoPanel(){

	}

	public void initEditPanel(){
		editPanel = new JPanel();
		editPanel.setLayout(null);
		editPanel.setBounds(128, 117, 729, 452);
		editPanel.setOpaque(false);
		editPanel.setVisible(true);
		
		idField = new LabelTextField("车辆代号",9 );
		idField.setBounds(110, 80, 300, 45);
		editPanel.add(idField);
		
		numberField = new LabelTextField("车牌号  ",7);
		numberField.setBounds(110, 160, 300, 45);
		editPanel.add(numberField);
		
		addBtn = new JButton(new ImageIcon("ui/image/hall/add0.png"));
		addBtn.setBounds(306, 404, 110, 45);
		addBtn.setOpaque(false);
		addBtn.setBorderPainted(false);
		addBtn.setContentAreaFilled(false);
		editPanel.add(addBtn);

	}
}
