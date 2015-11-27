package edu.nju.express.presentation.clerk_hallui;

import java.awt.Color;
import java.awt.Font;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.ScrollPaneConstants;
import javax.swing.border.EmptyBorder;

import edu.nju.express.presentation.myUI.MyTextField;

public class HallTransferUI extends JPanel implements MouseListener{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	HallController controller;
	JPanel mainpanel;
	
	int width = 900;
	int height = 600;
	JButton back;
	JButton addOrderBtn;
	JButton calFeeBtn;
	JButton submitBtn;
	JLabel idLabel;
	JLabel dateLabel;
	JLabel carrierIdLabel;
	JLabel fromLabel;
	JLabel toLabel;
	JLabel supervisorLabel;
	JLabel guardLabel;
	JLabel orderLabel;
	JLabel feeLabel;
	JLabel yearLabel, monthLabel, dayLabel;
	MyTextField idField;
	JTextArea orderArea;
	JComboBox<String> yearBox, monthBox, dayBox;
	MyTextField carrierIdField, fromField, toField, supervisorField, guardField;
	MyTextField feeField;
	
	public HallTransferUI(HallController controller){
		this.controller = controller;
		mainpanel = new JPanel();
		mainpanel.setLayout(null);
		mainpanel.setBounds(0, 0, width, height);
//		mainpanel.setBackground(Color.GRAY);
		
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
		idLabel.setForeground(Color.white);
		idLabel.setBounds(20, 20, 100, 30);
		
		idField = new MyTextField(15);
		idField.setBounds(120, 20, 150, 30);
//		idField.setFont(new Font("Microsoft YaHei", Font.PLAIN,15));
//		idField.setBounds(120, 20, 150, 30);
//		idField.setOpaque(false);
		
		//行间隔为10
		dateLabel = new JLabel("装车日期");
		dateLabel.setFont(new Font("Microsoft YaHei", Font.PLAIN,15));
		dateLabel.setForeground(Color.white);
		dateLabel.setBounds(20, 70, 70, 30);
		
		yearLabel = new JLabel("年");
		yearLabel.setFont(new Font("Microsoft YaHei", Font.PLAIN,15));
		yearLabel.setForeground(Color.white);
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
		monthLabel.setForeground(Color.white);
		monthLabel.setBounds(300, 70, 20, 30);
		
		monthBox = new JComboBox<String>();
		monthBox.setFont(new Font("微软雅黑", Font.PLAIN, 15));
		monthBox.setBounds(220, 70, 70, 30);
		for(int i=1; i<=12; i++){
			monthBox.addItem(Integer.toString(i));
		}
		
		dayLabel = new JLabel("日");
		dayLabel.setFont(new Font("Microsoft YaHei", Font.PLAIN,15));
		dayLabel.setForeground(Color.white);
		dayLabel.setBounds(400, 70, 20, 30);
		
		dayBox = new JComboBox<String>();
		dayBox.setFont(new Font("微软雅黑", Font.PLAIN, 15));
		dayBox.setBounds(320, 70, 70, 30);
		for(int i=1; i<=31; i++){
			dayBox.addItem(Integer.toString(i));
		}
		
		carrierIdLabel = new JLabel("本营业厅汽运编号");
		carrierIdLabel.setFont(new Font("Microsoft YaHei", Font.PLAIN,15));
		carrierIdLabel.setForeground(Color.white);
		carrierIdLabel.setBounds(20, 120, 150, 30);
		
		carrierIdField = new MyTextField(19);
//		carrierIdField.setFont(new Font("Microsoft YaHei", Font.PLAIN,15));
		carrierIdField.setBounds(170,120, 200, 30);
		
		fromLabel = new JLabel("出发地");
		fromLabel.setFont(new Font("Microsoft YaHei", Font.PLAIN,15));
		fromLabel.setForeground(Color.white);
		fromLabel.setBounds(20, 170, 100, 30);
		
		fromField = new MyTextField(10);
//		fromField.setFont(new Font("Microsoft YaHei", Font.PLAIN,15));
		fromField.setBounds(120, 170, 120, 30);
		
		toLabel = new JLabel("到达地");
		toLabel.setFont(new Font("Microsoft YaHei", Font.PLAIN,15));
		toLabel.setForeground(Color.white);
		toLabel.setBounds(20, 220, 100, 30);
		
		toField = new MyTextField(10);
//		toField.setFont(new Font("Microsoft YaHei", Font.PLAIN,15));
		toField.setBounds(120, 220, 120, 30);
		
		supervisorLabel = new JLabel("监装员");
		supervisorLabel.setFont(new Font("Microsoft YaHei", Font.PLAIN,15));
		supervisorLabel.setForeground(Color.white);
		supervisorLabel.setBounds(20, 270, 100, 30);
		
		supervisorField = new MyTextField(10);
//		supervisorField.setFont(new Font("Microsoft YaHei", Font.PLAIN,15));
		supervisorField.setBounds(120, 270, 120, 30);
		
		guardLabel = new JLabel("押运员");
		guardLabel.setFont(new Font("Microsoft YaHei", Font.PLAIN,15));
		guardLabel.setForeground(Color.white);
		guardLabel.setBounds(20, 320, 100, 30);
		
		guardField = new MyTextField(10);
//		guardField.setFont(new Font("Microsoft YaHei", Font.PLAIN,15));
		guardField.setBounds(120, 320, 120, 30);
		
		
		
		panel.add(idLabel);
		panel.add(idField);
		panel.add(dateLabel);
		panel.add(yearLabel);
		panel.add(yearBox);
		panel.add(monthLabel);
		panel.add(monthBox);
		panel.add(dayLabel);
		panel.add(dayBox);
		panel.add(carrierIdLabel);
		panel.add(carrierIdField);
		panel.add(fromLabel);
		panel.add(fromField);
		panel.add(toLabel);
		panel.add(toField);
		panel.add(supervisorLabel);
		panel.add(supervisorField);
		panel.add(guardLabel);
		panel.add(guardField);
		panel.setLayout(null);
		panel.setBounds(50, 50, 480, 450);
		panel.setVisible(true);
		panel.setBackground(Color.DARK_GRAY);
		mainpanel.add(panel);
	}
	
	public void initOrderContainer(){
		JPanel panel = new JPanel();
		
		orderArea = new JTextArea(10,100);
		orderArea.setLineWrap(true);
		orderArea.setWrapStyleWord(true);
		orderArea.setEditable(true);
		orderArea.setBackground(Color.DARK_GRAY);
		orderArea.setForeground(Color.WHITE);
		JScrollPane qScroller = new JScrollPane(orderArea);
		qScroller.setVerticalScrollBarPolicy(ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS);
		qScroller.setHorizontalScrollBarPolicy(ScrollPaneConstants.HORIZONTAL_SCROLLBAR_NEVER);
		qScroller.setBounds(30, 30, 250, 250);
		
		addOrderBtn = new JButton("add");
		addOrderBtn.setBounds(230, 300, 50, 30);
		addOrderBtn.setFont(new Font("微软雅黑", Font.PLAIN, 15));
		addOrderBtn.addActionListener(controller);
		
		feeLabel = new JLabel("运费");
		feeLabel.setFont(new Font("Microsoft YaHei", Font.PLAIN,15));
		feeLabel.setForeground(Color.white);
		feeLabel.setBounds(30, 340, 60, 30);
		
		feeField = new MyTextField(10);
//		feeField.setFont(new Font("Microsoft YaHei", Font.PLAIN,15));
		feeField.setBounds(90, 340, 100, 30);
		
		calFeeBtn = new JButton("生成运费");
		calFeeBtn.setFont(new Font("Microsoft YaHei", Font.PLAIN,15));
		calFeeBtn.setBounds(210, 340, 100, 30);
		calFeeBtn.addActionListener(controller);
			
		
		panel.add(qScroller);
		panel.add(addOrderBtn);
		panel.add(feeLabel);
		panel.add(feeField);
		panel.add(calFeeBtn);
		panel.setLayout(null);
		panel.setBounds(540, 50, 330, 450);
		panel.setVisible(true);
		panel.setBackground(Color.DARK_GRAY);
		mainpanel.add(panel);
	}
	
	public void initMargin(){
		JPanel panel = new JPanel();
		
		back = new JButton(new ImageIcon("ui/image/hall/back1.png"));
		back.setBounds(30, 15, 30, 30);
		back.setOpaque(false);
		back.setBorderPainted(false);
		back.addActionListener(controller);
		back.addMouseListener(this);
		back.setActionCommand("backHome");
		
		submitBtn = new JButton("submit");
		submitBtn.setFont(new Font("Microsoft YaHei", Font.PLAIN,15));
		submitBtn.setBounds(50, 510, 90, 30);
		submitBtn.addActionListener(controller);
		
		panel.add(back);
		panel.add(submitBtn);
		
		panel.setLayout(null);
		panel.setOpaque(false);
		panel.setBounds(0, 0, width, height);
		panel.setVisible(true);
		mainpanel.add(panel);
	}

	

	@Override
	public void mouseClicked(MouseEvent e) {
		// TODO Auto-generated method stub
		
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
		if(e.getSource().equals(back))
			this.back.setIcon(new ImageIcon("ui/image/hall/back2.png"));
		
	}

	@Override
	public void mouseExited(MouseEvent e) {
		// TODO Auto-generated method stub
		if(e.getSource().equals(back))
			this.back.setIcon(new ImageIcon("ui/image/hall/back1.png"));
	}
	

}
