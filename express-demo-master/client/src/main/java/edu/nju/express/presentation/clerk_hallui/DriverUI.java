package edu.nju.express.presentation.clerk_hallui;

import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;

import edu.nju.express.presentation.UIController;
import edu.nju.express.presentation.myUI.DateComboBoxPanel;
import edu.nju.express.presentation.myUI.LabelTextField;
import edu.nju.express.presentation.myUI.MyComboBox;
import edu.nju.express.presentation.myUI.MySearchFieldPanel;

public class DriverUI extends JPanel implements MouseListener{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	ImageIcon new0 = new ImageIcon("ui/image/hall/new0.png");
	ImageIcon new1 = new ImageIcon("ui/image/hall/new1.png");
	ImageIcon edit0 = new ImageIcon("ui/image/hall/edit0.png");
	ImageIcon edit1 = new ImageIcon("ui/image/hall/edit1.png");
	ImageIcon trash0 = new ImageIcon("ui/image/hall/trash0.png");
	ImageIcon trash1 = new ImageIcon("ui/image/hall/trash1.png");
	
	int width = 900, height = 600;
	UIController controller;
	JPanel mainpanel;
	JLabel bg;
	JPanel infoPanel, newPanel, errorPanel;
	JButton newBtn, editBtn, trashBtn, searchBtn;
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
		initNewPanel();
		initErrorPanel();
		
		mainpanel.add(newPanel);
		
		
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
		//初始化为新建司机信息
		newBtn = new JButton(new1);
		newBtn.setBounds(729, 81, 30, 30);
		newBtn.setBorderPainted(false);
		newBtn.addActionListener(new ActionListener(){

			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				
			}
			
		});
		newBtn.addMouseListener(this);
		mainpanel.add(newBtn);
		
		editBtn = new JButton(edit0);
		editBtn.setBounds(767, 81, 30, 30);
		editBtn.setBorderPainted(false);
		editBtn.addActionListener(new ActionListener(){

			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				if(mainpanel.getComponentAt(130, 120).equals(newPanel)){
					mainpanel.remove(mainpanel.getComponentAt(130, 120));
					
					mainpanel.validate();
					mainpanel.repaint();
				}
			}
			
		});
		editBtn.addMouseListener(this);
		mainpanel.add(editBtn);
		
		trashBtn = new JButton(trash0);
		trashBtn.setBounds(807, 81, 30, 30);
		trashBtn.setBorderPainted(false);
		trashBtn.addActionListener(new ActionListener(){

			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				
			}
			
		});
		trashBtn.addMouseListener(this);
		mainpanel.add(trashBtn);
		
		searchField = new MySearchFieldPanel(controller);
		searchField.setBounds(480, 76, 200, 40);
		
		mainpanel.add(searchField);
		
	}
	
	public void initInfoPanel(){
		infoPanel = new JPanel();
	}
	
	public void initNewPanel(){
		newPanel = new JPanel();
		newPanel.setLayout(null);
		newPanel.setBounds(128, 117, 729, 452);
		newPanel.setOpaque(false);
		newPanel.setVisible(true);
		
		Font font = new Font("黑体", Font.PLAIN, 18);
		Color color = new Color(44, 62,80);
		
		driverIdField = new LabelTextField("司机编号",9);
		driverIdField.setBounds(110, 20, 300, 45);	
		newPanel.add(driverIdField);
		
		nameField = new LabelTextField("司机姓名",4);
		nameField.setBounds(110, 80, 300, 45);
		newPanel.add(nameField);
		
		genderLabel = new JLabel("性别  ");
		genderLabel.setFont(font);
		genderLabel.setForeground(color);
		genderLabel.setBounds(120, 140, 90, 40);
		newPanel.add(genderLabel);
		
		genderBox = new MyComboBox<String>();
		genderBox.setBounds(200, 140, 100, 30);
		String[] genderlist = {"男", "女", "其他"};
		for(int i=0; i<genderlist.length; i++){
			genderBox.addItem(genderlist[i]);
		}
		genderBox.setSelectedItem(genderlist[0]);
		newPanel.add(genderBox);

		

		birthLabel = new JLabel("出生日期");
		birthLabel.setFont(font);
		birthLabel.setForeground(color);
		birthLabel.setBounds(110, 190, 80, 40);
		newPanel.add(birthLabel);

		birthBoxPanel = new DateComboBoxPanel();
		birthBoxPanel.setBounds(190, 190, 500, 40);
		newPanel.add(birthBoxPanel);

		identityField = new LabelTextField("身份证号",18);
		identityField.setBounds(110, 245, 300, 45);
		newPanel.add(identityField);
		
		cellphoneField = new LabelTextField("手机号   ",11);
		cellphoneField.setBounds(110, 305, 300, 45);
		newPanel.add(cellphoneField);
		
		licenseLimitLabel = new JLabel("行驶证期限");
		licenseLimitLabel.setFont(font);
		licenseLimitLabel.setForeground(color);
		licenseLimitLabel.setBounds(100, 365, 90, 40);
		newPanel.add(licenseLimitLabel);
		
		licenseLimitBoxPanel = new DateComboBoxPanel();
		licenseLimitBoxPanel.setBounds(190, 365, 500, 40);
		newPanel.add(licenseLimitBoxPanel);
		
		addBtn = new JButton(new ImageIcon("ui/image/hall/add0.png"));
		addBtn.setBounds(306, 404, 110, 45);
		addBtn.setOpaque(false);
		addBtn.setBorderPainted(false);
		addBtn.setContentAreaFilled(false);
		newPanel.add(addBtn);
	}
	
	public void initErrorPanel(){
		errorPanel = new JPanel();
		
	}

	@Override
	public void mouseClicked(MouseEvent e) {
		// TODO Auto-generated method stub
		if(e.getSource().equals(newBtn)){
			newBtn.setIcon(new1);
			editBtn.setIcon(edit0);
			trashBtn.setIcon(trash0);
		}
		if(e.getSource().equals(editBtn)){
			newBtn.setIcon(new0);
			editBtn.setIcon(edit1);
			trashBtn.setIcon(trash0);
		}
		if(e.getSource().equals(trashBtn)){
			newBtn.setIcon(new0);
			editBtn.setIcon(edit0);
			trashBtn.setIcon(trash1);
		}
	}

	@Override
	public void mousePressed(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mouseReleased(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mouseEntered(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mouseExited(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}
	
	
}
