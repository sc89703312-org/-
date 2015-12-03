package edu.nju.express.presentation.clerk_hallui;

import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
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

public class PaymentUI extends JPanel implements MouseListener{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	int width = 900;
	int height = 600;
	HallController controller;
	JPanel mainpanel;
	
	JButton addOrderBtn;
	JButton submitBtn;
	JLabel idLabel;
	JLabel deliverLabel;
	JLabel moneyLabel;
	JLabel dateLabel;
	JLabel yearLabel, monthLabel, dayLabel;
	MyTextField idField, deliverField, moneyField;
	JTextArea orderArea;
	JComboBox<String> yearBox, monthBox, dayBox;
	JLabel bg;
	
	public PaymentUI(HallController controller){
		this.controller = controller;
		mainpanel = new JPanel();
		mainpanel.setLayout(null);
		mainpanel.setBounds(0,0,width,height);
		mainpanel.setBackground(Color.GRAY);
		mainpanel.setVisible(true);
//		initPanel();
//		initOrderContainer();
//		initMargin();
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
		
		bg = new JLabel(new ImageIcon("ui/image/hall/payment.png"));
		bg.setBounds(0, 0, width, height);
		mainpanel.add(bg);
		this.add(mainpanel);
		this.add(new HallGuide(controller));
		this.setLayout(null);
		this.setOpaque(false);
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
		idField.setOpaque(false);
		
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
		
		deliverLabel = new JLabel("收款快递员");
		deliverLabel.setFont(new Font("Microsoft YaHei", Font.PLAIN,15));
		deliverLabel.setForeground(Color.white);
		deliverLabel.setBounds(20, 120, 100, 30);
		
		deliverField = new MyTextField(19);
		deliverField.setBounds(120, 120, 200, 30);
		
		moneyLabel = new JLabel("收款金额");
		moneyLabel.setFont(new Font("Microsoft YaHei", Font.PLAIN,15));
		moneyLabel.setForeground(Color.white);
		moneyLabel.setBounds(20, 170, 100, 30);
		
		moneyField = new MyTextField(10);
		moneyField.setBounds(120, 170, 100, 30);
		
		panel.add(idLabel);
		panel.add(idField);
		panel.add(dateLabel);
		panel.add(yearBox);
		panel.add(yearLabel);
		panel.add(monthLabel);
		panel.add(monthBox);
		panel.add(dayBox);
		panel.add(dayLabel);
		panel.add(deliverLabel);
		panel.add(deliverField);
		panel.add(moneyLabel);
		panel.add(moneyField);
		
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
		orderArea.setForeground(Color.white);
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
		panel.setBackground(Color.DARK_GRAY);
		mainpanel.add(panel);
	}
	
	public void initMargin(){
		JPanel panel = new JPanel();
		
		submitBtn = new JButton(new ImageIcon("ui/image/hall/submit1.png"));
		submitBtn.setBounds(50, 510, 90, 30);
		submitBtn.setOpaque(false);
		submitBtn.setBorderPainted(false);
		submitBtn.addMouseListener(this);
		submitBtn.addActionListener(controller);
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
	}
	
	@Override
	public void mouseExited(MouseEvent e) {
		// TODO Auto-generated method stub
	}
}
