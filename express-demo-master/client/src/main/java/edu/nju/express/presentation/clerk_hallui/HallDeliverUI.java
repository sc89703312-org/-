package edu.nju.express.presentation.clerk_hallui;

import java.awt.Color;
import java.awt.Font;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.ScrollPaneConstants;
import javax.swing.border.EmptyBorder;

public class HallDeliverUI extends JPanel{

	/**
	 * 
	 */
	
	private static final long serialVersionUID = 1L;
	int width = 900;
	int height = 600;
	HallController controller;
	JPanel mainpanel;
	
	JButton back;
	JButton addOrderBtn;
	JButton submitBtn;
	JLabel idLabel;
	JLabel dateLabel;
	JLabel deliverIdLabel;
	JLabel yearLabel, monthLabel, dayLabel;
	JTextField idField, deliverIdField;
	JTextArea orderArea;
	JComboBox<String> yearBox, monthBox, dayBox;
	
	
	public HallDeliverUI(HallController controller){
		this.controller = controller;
		mainpanel = new JPanel();
		mainpanel.setBounds(0, 0, width, height);
		mainpanel.setLayout(null);
		mainpanel.setBackground(Color.DARK_GRAY);
		mainpanel.setVisible(true);
		initPanel();
		initOrderContainer();
		initMargin();
		this.add(mainpanel);
		this.setLayout(null);
		this.setVisible(true);
		
	}
	
	public void initPanel(){
		JPanel panel = new JPanel();
		
		idLabel = new JLabel("装车单编号");
		idLabel.setFont(new Font("Microsoft YaHei", Font.PLAIN,15));
		idLabel.setBounds(20, 20, 100, 30);
		
		idField = new JTextField("",15);
		idField.setFont(new Font("Microsoft YaHei", Font.PLAIN,15));
		idField.setBounds(120, 20, 150, 30);
		idField.setOpaque(false);
		
		//行间隔为10
		dateLabel = new JLabel("装车日期");
		dateLabel.setFont(new Font("Microsoft YaHei", Font.PLAIN,15));
		dateLabel.setBounds(20, 70, 70, 30);
		
		yearLabel = new JLabel("年");
		yearLabel.setFont(new Font("Microsoft YaHei", Font.PLAIN,15));
		yearLabel.setBounds(200, 70, 20, 30);
		
		yearBox = new JComboBox<String>();
		yearBox.setOpaque(false);
		yearBox.setFont(new Font("微软雅黑", Font.PLAIN, 15));
		yearBox.setBorder(new EmptyBorder(0,0,0,0));
		for(int i=2015; i<2100; i++){
			yearBox.addItem(Integer.toString(i));
		}
		yearBox.setBounds(90, 70, 100, 30);
		
		monthLabel = new JLabel("月");
		monthLabel.setFont(new Font("Microsoft YaHei", Font.PLAIN,15));
		monthLabel.setBounds(300, 70, 20, 30);
		
		monthBox = new JComboBox<String>();
		monthBox.setFont(new Font("微软雅黑", Font.PLAIN, 15));
		monthBox.setBounds(220, 70, 70, 30);
		for(int i=1; i<=12; i++){
			monthBox.addItem(Integer.toString(i));
		}
		
		dayLabel = new JLabel("日");
		dayLabel.setFont(new Font("Microsoft YaHei", Font.PLAIN,15));
		dayLabel.setBounds(400, 70, 20, 30);
		
		dayBox = new JComboBox<String>();
		dayBox.setFont(new Font("微软雅黑", Font.PLAIN, 15));
		dayBox.setBounds(320, 70, 70, 30);
		for(int i=1; i<=31; i++){
			dayBox.addItem(Integer.toString(i));
		}
		
		deliverIdLabel = new JLabel("派送员");
		deliverIdLabel.setFont(new Font("Microsoft YaHei", Font.PLAIN,15));
		deliverIdLabel.setBounds(20, 120, 70, 30);
		
		deliverIdField = new JTextField("",19);
		deliverIdField.setFont(new Font("Microsoft YaHei", Font.PLAIN,15));
		deliverIdField.setBounds(90, 120, 200, 30);
		
		panel.add(idLabel);
		panel.add(idField);
		panel.add(dateLabel);
		panel.add(yearLabel);
		panel.add(yearBox);
		panel.add(monthLabel);
		panel.add(monthBox);
		panel.add(dateLabel);
		panel.add(dayBox);
		panel.add(deliverIdLabel);
		panel.add(deliverIdField);
		
		panel.setLayout(null);
		panel.setBounds(50, 50, 480, 450);
		panel.setVisible(true);
		mainpanel.add(panel);
	}
	
	public void initOrderContainer(){
		JPanel panel = new JPanel();
		
		orderArea = new JTextArea(10,100);
		orderArea.setLineWrap(true);
		orderArea.setWrapStyleWord(true);
		orderArea.setEditable(true);
		JScrollPane qScroller = new JScrollPane(orderArea);
		qScroller.setVerticalScrollBarPolicy(ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS);
		qScroller.setHorizontalScrollBarPolicy(ScrollPaneConstants.HORIZONTAL_SCROLLBAR_NEVER);
		qScroller.setBounds(30, 30, 250, 250);
		
		addOrderBtn = new JButton("add");
		addOrderBtn.setBounds(230, 300, 50, 30);
		addOrderBtn.setFont(new Font("微软雅黑", Font.PLAIN, 15));
		addOrderBtn.addActionListener(controller);
		
		panel.add(qScroller);
		panel.add(addOrderBtn);
		
		panel.setLayout(null);
		panel.setBounds(540, 50, 330, 450);
		panel.setVisible(true);
		mainpanel.add(panel);
	}
	
	public void initMargin(){
		JPanel panel = new JPanel();
		
		back = new JButton(new ImageIcon("ui/image/hall/backToLastPage.png"));
		back.setBounds(30, 15, 30, 30);
		back.setOpaque(false);
		back.setBorderPainted(false);
		back.addActionListener(controller);
		back.setActionCommand("backHome");
		
		submitBtn = new JButton("submit");
		submitBtn.setBounds(50, 510, 60, 20);
		submitBtn.setFont(new Font("微软雅黑", Font.PLAIN, 15));
		submitBtn.addActionListener(controller);
		
		panel.add(back);
		panel.add(submitBtn);
		
		panel.setLayout(null);
		panel.setOpaque(false);
		panel.setBounds(0, 0, width, height);
		panel.setVisible(true);
		mainpanel.add(panel);
	}

}
