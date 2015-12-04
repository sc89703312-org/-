package edu.nju.express.presentation.clerk_hallui;

import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;

import edu.nju.express.presentation.UIController;
import edu.nju.express.presentation.myUI.DateComboBoxPanel;
import edu.nju.express.presentation.myUI.LabelTextField;
import edu.nju.express.presentation.myUI.MyComboBox;
import edu.nju.express.presentation.myUI.MySearchFieldPanel;

public class DriverUI extends JPanel{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	int width = 900, height = 600;
	UIController controller;
	JPanel mainpanel;
	JLabel bg;
	JPanel infoPanel, editPanel;
	JButton newBtn, editBtn, trashBtn;
	JLabel  genderLabel, birthLabel, licenseLimitLabel;
	LabelTextField driverIdField, nameField, identityField, cellphoneField;
	MyComboBox<String> genderBox;
	DateComboBoxPanel birthBoxPanel, licenseLimitBoxPanel;
	JButton saveBtn, addBtn;
	MySearchFieldPanel searchField;
	
	public DriverUI(UIController controller){
		this.controller = controller;
		
		mainpanel = new JPanel();
		mainpanel.setLayout(null);
		mainpanel.setBounds(0, 0, width, height);
		mainpanel.setVisible(true);
		mainpanel.setOpaque(false);
		initButton();
		initInfoPanel();
		initEditPanel();
		
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
		
		Font font = new Font("黑体", Font.PLAIN, 18);
		Color color = new Color(44, 62,80);
		
		driverIdField = new LabelTextField("司机编号",9);
		driverIdField.setBounds(110, 20, 300, 45);			
		editPanel.add(driverIdField);
		
		nameField = new LabelTextField("司机姓名",4);
		nameField.setBounds(110, 80, 300, 45);
		editPanel.add(nameField);
		
		genderLabel = new JLabel("性别  ");
		genderLabel.setFont(font);
		genderLabel.setForeground(color);
		genderLabel.setBounds(120, 140, 90, 40);
		editPanel.add(genderLabel);
		
		genderBox = new MyComboBox<String>();
		genderBox.setBounds(200, 140, 100, 30);
		String[] genderlist = {"男", "女", "其他"};
		for(int i=0; i<genderlist.length; i++){
			genderBox.addItem(genderlist[i]);
		}
		genderBox.setSelectedItem(genderlist[0]);
		editPanel.add(genderBox);

		

		birthLabel = new JLabel("出生日期");
		birthLabel.setFont(font);
		birthLabel.setForeground(color);
		birthLabel.setBounds(110, 190, 80, 40);
		editPanel.add(birthLabel);

		birthBoxPanel = new DateComboBoxPanel();
		birthBoxPanel.setBounds(190, 190, 500, 40);
		editPanel.add(birthBoxPanel);

		identityField = new LabelTextField("身份证号",18);
		identityField.setBounds(110, 245, 300, 45);
		editPanel.add(identityField);
		
		cellphoneField = new LabelTextField("手机号   ",11);
		cellphoneField.setBounds(110, 305, 300, 45);
		editPanel.add(cellphoneField);
		
		licenseLimitLabel = new JLabel("行驶证期限");
		licenseLimitLabel.setFont(font);
		licenseLimitLabel.setForeground(color);
		licenseLimitLabel.setBounds(100, 365, 90, 40);
		editPanel.add(licenseLimitLabel);
		
		licenseLimitBoxPanel = new DateComboBoxPanel();
		licenseLimitBoxPanel.setBounds(190, 365, 500, 40);
		editPanel.add(licenseLimitBoxPanel);
		
		addBtn = new JButton(new ImageIcon("ui/image/hall/add0.png"));
		addBtn.setBounds(306, 404, 110, 45);
		addBtn.setOpaque(false);
		addBtn.setBorderPainted(false);
		addBtn.setContentAreaFilled(false);
		editPanel.add(addBtn);
	}
	
	
}
