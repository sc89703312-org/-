package edu.nju.express.presentation.clerk_hallui;

import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JButton;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.ScrollPaneConstants;

import java.awt.Color;
import java.awt.Font;
import java.awt.Image;
import java.awt.Insets;

public class HallHome extends JPanel{
	private static final long serialVersionUID = 1L;
	
	HallController controller;
	JPanel guidePanel;
	JPanel mainPanel;

	int width = 900;
	int height = 600;
	
	JButton addTransfer;
	JButton addArrival;
	JButton addDeliver;
	JButton addPayment;
	JButton driver;
	JButton car;
	JButton back;
	JLabel greeting;
	JTextArea recentReceipt;
	
	public HallHome(HallController controller) {
		this.controller = controller;
		this.guidePanel = new JPanel();
		guidePanel.setLayout(null);
		guidePanel.setBounds(0, 0, width/5, height);
		guidePanel.setBackground(Color.LIGHT_GRAY);
		initButtons();
		guidePanel.setVisible(true);
		
		this.mainPanel = new JPanel();
		mainPanel.setLayout(null);
		mainPanel.setBounds(width/5, 0, 4*width/5, height);
		mainPanel.setBackground(Color.DARK_GRAY);
		initMain();
		mainPanel.setVisible(true);
		
		this.add(guidePanel);
		this.add(mainPanel);
		this.setLayout(null);			//!!!!!!!!!!!!!!!!!!!!!!!
		this.setVisible(true);
		
	}

	public void initButtons(){
		JPanel panel = new JPanel();
		
		
		panel.setOpaque(false);
		panel.setLayout(null);
		panel.setBounds(0, 0, width/5, height);
		
		
		
		addTransfer = new JButton("装车单");
		addTransfer.setFont(new Font("Microsoft YaHei", Font.PLAIN, 13));
		addTransfer.setBounds((width/5)/6, 60, 4*(width/5)/6, height/15);
		addTransfer.addActionListener(controller);
		addTransfer.setActionCommand("addTransfer");
		
		addArrival = new JButton("到达单");
		addArrival.setFont(new Font("Microsoft YaHei", Font.PLAIN,13));
		addArrival.setBounds((width/5)/6, 60+(height/15+15), 4*(width/5)/6, height/15);
		addArrival.addActionListener(controller);
		addArrival.setActionCommand("addArrival");
		
		addDeliver = new JButton("派件单");
		addDeliver.setFont(new Font("Microsoft YaHei", Font.PLAIN,13));
		addDeliver.setBounds((width/5)/6, 60+2*(height/15+15), 4*(width/5)/6, height/15);
		addDeliver.addActionListener(controller);
		addDeliver.setActionCommand("addDeliver");
		
		addPayment = new JButton("收款单");
		addPayment.setFont(new Font("Microsoft YaHei", Font.PLAIN,13));
		addPayment.setBounds((width/5)/6, 60+3*(height/15+15), 4*(width/5)/6, height/15);
		addPayment.addActionListener(controller);
		addPayment.setActionCommand("addPayment");
		
		driver = new JButton("司机信息");
		driver.setFont(new Font("Microsoft YaHei", Font.PLAIN,13));
		driver.setBounds((width/5)/6, 60+4*(height/15+15), 4*(width/5)/6, height/15);
		driver.addActionListener(controller);
		driver.setActionCommand("manageDriver");
		
		car = new JButton("车辆信息");
		car.setFont(new Font("Microsoft YaHei", Font.PLAIN,13));
		car.setBounds((width/5)/6, 60+5*(height/15+15), 4*(width/5)/6, height/15);
		car.addActionListener(controller);
		car.setActionCommand("manageCar");
	
		back = new JButton(new ImageIcon("ui/image/hall/backToLastPage.png"));
		back.setBounds(30, 15, 30, 30);
//		Image img = icon.getImage().getScaledInstance(back.getWidth(), back.getHeight(),icon.getImage().SCALE_DEFAULT );
//		icon = new ImageIcon(img);
		
		back.setOpaque(false);  
//        back.setContentAreaFilled(false);  
//        back.setMargin(new Insets(0, 0, 0, 0));  
//        back.setFocusPainted(false);  
        back.setBorderPainted(false);  
//        back.setBorder(null);  
		back.addActionListener(controller);
		
		panel.add(addTransfer);
		panel.add(addArrival);
		panel.add(addDeliver);
		panel.add(addPayment);
		panel.add(driver);
		panel.add(car);
		panel.add(back);
		panel.setVisible(true);
		
		
		
		guidePanel.add(panel);
		
	}
	
	public void initMain(){
		JPanel panel = new JPanel();
		panel.setOpaque(false);
		panel.setLayout(null);
		panel.setBounds(0, 0, 4*width/5, height);
		
		greeting = new JLabel("Hello, clerk XXX");
		greeting.setForeground(Color.BLACK);
		greeting.setFont(new Font("Microsoft YaHei", Font.PLAIN, 15));
		greeting.setBounds(400,0,120,40);
		greeting.setOpaque(false);
		
		recentReceipt = new JTextArea(15,20);
		recentReceipt.setText("装车单XXXX: 未审批");
		recentReceipt.setLineWrap(true);
		recentReceipt.setWrapStyleWord(true);
		recentReceipt.setEditable(false);
		JScrollPane qScroller = new JScrollPane(recentReceipt);
		qScroller.setVerticalScrollBarPolicy(ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS);
		qScroller.setHorizontalScrollBarPolicy(ScrollPaneConstants.HORIZONTAL_SCROLLBAR_NEVER);
		qScroller.setBounds(70, 120, 520, 400);
		
		panel.add(greeting);
		panel.add(qScroller);
		panel.setVisible(true);
		
		mainPanel.add(panel);
	}
	
	
}
