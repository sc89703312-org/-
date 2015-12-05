package edu.nju.express.presentation.clerk_hallui;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.ScrollPaneConstants;
import javax.swing.border.EmptyBorder;

import edu.nju.express.presentation.myUI.DateComboBoxPanel;
import edu.nju.express.presentation.myUI.LabelTextField;
import edu.nju.express.presentation.myUI.MyScrollBarUI;

public class HallTransferUI extends JPanel implements MouseListener{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	HallController controller;
	JPanel mainpanel;
	JPanel boxpanel;
	
	int width = 900;
	int height = 600;
	
	JLabel orderLabel;
	JTextArea orderArea;
	JButton addOrderBtn;
	JButton calFeeBtn;
	
	JButton submitBtn;
	JButton exit;
	JLabel dateLabel, addOrderLabel;
	DateComboBoxPanel dateBox;
	LabelTextField carrierIdField, fromField, toField, supervisorField,
					guardField,feeField;
	JLabel bg;
	
	static JScrollPane s = new JScrollPane();
	final MyScrollBarUI ui = new MyScrollBarUI();
	Font font = new Font("黑体", Font.PLAIN, 18);
	Color color = new Color(44, 62,80);
	Color areaColor = new Color(210, 232, 232);

	
	public HallTransferUI(HallController controller){
		this.controller = controller;
		mainpanel = new JPanel();
		mainpanel.setLayout(null);
		mainpanel.setBounds(0, 0, width, height);
		mainpanel.setVisible(true);
		mainpanel.setOpaque(false);
		
		initMargin();
		initPanel();
		
		
		bg = new JLabel();
		bg.setBounds(0, 0, width, height);
		bg.setIcon(new ImageIcon("ui/image/hall/transfer.png"));
		mainpanel.add(bg);
		 
		
		this.add(mainpanel);
		this.add(new HallGuide(controller));
		this.setLayout(null);
		this.setOpaque(false);
		this.setVisible(true);
	}
	
	public void initPanel(){
		JPanel panel = new JPanel();
		panel.setLayout(null);
		panel.setVisible(true);
		panel.setOpaque(false);
		
		/*
		 * height -= 45
		 */
		
		dateLabel = new JLabel("装车日期");
		dateLabel.setFont(font);
		dateLabel.setForeground(color);
		dateLabel.setBounds(100, 70-45, 90, 40);
		panel.add(dateLabel);
		
		dateBox = new DateComboBoxPanel();
		dateBox.setBounds(190, 70-45, 500, 40);
		panel.add(dateBox);
		
		carrierIdField = new LabelTextField("本营业厅汽运编号",19);
		carrierIdField.setBounds(80,120-45, 400, 45);
		panel.add(carrierIdField);
		
		fromField = new LabelTextField("出发地  ", 10);
		fromField.setBounds(110, 180-45, 300, 45);
		panel.add(fromField);
		
		toField = new LabelTextField("到达地  ", 10);
		toField.setBounds(110, 240-45, 300, 45);
		panel.add(toField);
		
		supervisorField = new LabelTextField("监装员  ",10);
		supervisorField.setBounds(110, 300-45, 300, 45);
		panel.add(supervisorField);
		
		guardField = new LabelTextField("押运员  ",10);
		guardField.setBounds(110, 360-45, 300, 45);
		panel.add(guardField);
		
		addOrderLabel = new JLabel("请在此处添加本次托运单号:");
		addOrderLabel.setFont(font);
		addOrderLabel.setForeground(color);
		addOrderLabel.setBounds(110, 375, 300, 40);
		panel.add(addOrderLabel);
		
		orderArea = new JTextArea(10,1);
		orderArea.setLineWrap(true);
		orderArea.setWrapStyleWord(true);
		orderArea.setEditable(true);
		orderArea.setFont(font);
		orderArea.setBackground(areaColor);
		final JScrollPane orderpane = new JScrollPane();
		
		orderpane.setViewportView(orderArea);
		final MyScrollBarUI ui2 = new MyScrollBarUI();
		wrapScrollPane(orderpane, ui2);
		orderpane.setBounds(110, 450, 400, 100);
		panel.add(orderpane);
		
		addOrderBtn = new JButton("add");
		addOrderBtn.setBounds(460, 560, 50, 30);
		//点击addOrderBtn之后， 读取TextArea里的内容，并检测订单号位数，有错(!=10)给提示
		addOrderBtn.addMouseListener(this);
		panel.add(addOrderBtn);
		
		feeField = new LabelTextField("运费  ",10);
		feeField.setBounds(110, 600, 300, 45);
		panel.add(feeField);
		
		calFeeBtn = new JButton("生成运费");
		calFeeBtn.setBounds(410, 600, 100, 40);
		calFeeBtn.addMouseListener(this);
		panel.add(calFeeBtn);
		
		/*
		 * 如果需要在JScrollPane面板中放置多个控件，需要将多个控件放置到JPanel 面板上，然后将JPanel面板
		 * 作为一个整体控件添加到JScrollPane控件上
		 */
		
		s.setViewportView(panel);
		//感人。。。。layout==null时要加这句
		panel.setPreferredSize(new Dimension(723, 700));
		wrapScrollPane(s, ui);
		s.setBounds(130, 120, 720, 400);
		mainpanel.add(s);
		
		//不需要再加panel了，添加顺序为 mainpanel.add(scrollpane), scrollpane.add(panel)
		
	}
	
	public void initMargin(){
		submitBtn = new JButton("提交");
		submitBtn.setBounds(424, 523, 100, 40);
		submitBtn.addMouseListener(this);
		mainpanel.add(submitBtn);
		
		exit = new JButton(new ImageIcon("ui/button/X_darkgray.png"));
		exit.setBounds(840, 18, 30, 30);
		exit.setOpaque(false);
		exit.setBorderPainted(false);
		exit.setContentAreaFilled(false);
		exit.addMouseListener(this);
		exit.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				System.exit(0);

			}
		});
		mainpanel.add(exit);
	}
	
	
	public void wrapScrollPane(final JScrollPane s, final MyScrollBarUI ui){
		s.setOpaque(false);
		s.getViewport().setOpaque(false);
		s.getVerticalScrollBar().setUI(ui);
		s.getVerticalScrollBar().addMouseListener(new MouseAdapter(){
			@Override
			public void mouseEntered(MouseEvent e) {
				super.mouseEntered(e);
				s.getVerticalScrollBar().repaint();
			}
			
			@Override
			public void mouseExited(MouseEvent e) {
				// TODO Auto-generated method stub
				super.mouseExited(e);
				s.getVerticalScrollBar().repaint();
				
			}
		});
		
		s.setBorder(new EmptyBorder(0, 0, 0, 0));
		s.setViewportBorder(new EmptyBorder(0, 0, 0, 0));
		s.setVerticalScrollBarPolicy(ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS);
		s.setHorizontalScrollBarPolicy(ScrollPaneConstants.HORIZONTAL_SCROLLBAR_NEVER);
	}

	

	@Override
	public void mouseClicked(MouseEvent e) {
		// TODO Auto-generated method stub
		if(e.getSource().equals(addOrderBtn)){
			
			//读取TextArea里的内容，并检测订单号位数，有错(!=10)给提示
			
		}
	}

	@Override
	public void mousePressed(MouseEvent e) {
		// TODO Auto-generated method stub
		if(e.getSource().equals(submitBtn)){
			System.out.println("Submit successfully!");
		}
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
