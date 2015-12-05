package edu.nju.express.presentation.clerk_hallui;

import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

import javax.swing.BoxLayout;
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
	
	JLabel dateLabel;
	DateComboBoxPanel dateBox;
	LabelTextField idField, carrierIdField, fromField, toField, supervisorField,
					guardField,feeField;
	JLabel bg;
	
	static JScrollPane s = new JScrollPane();

	
	public HallTransferUI(HallController controller){
		this.controller = controller;
		mainpanel = new JPanel();
		mainpanel.setLayout(null);
		mainpanel.setBounds(0, 0, width, height);
		mainpanel.setVisible(true);
		mainpanel.setOpaque(false);
		
		
		
		initPanel();
		
		

		
		JButton exit = new JButton(new ImageIcon("ui/button/X_darkgray.png"));
		exit.setBounds(840, 18, 30, 30);
		exit.setOpaque(false);
		exit.setBorderPainted(false);
		exit.setContentAreaFilled(false);
		exit.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				System.exit(0);

			}
		});
		mainpanel.add(exit);
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
		panel.setBounds(128, 117, 723, 1000);
		panel.setVisible(true);
		panel.setOpaque(false);
		
		/*
		 * 如果需要在JScrollPane面板中放置多个控件，需要将多个控件放置到JPanel 面板上，然后将JPanel面板
		 * 作为一个整体控件添加到JScrollPane控件上
		 */
		
		s.setOpaque(false);
		s.setViewportView(panel);
		s.getViewport().setOpaque(false);
		s.getVerticalScrollBar().setOpaque(false);
		
		final MyScrollBarUI ui = new MyScrollBarUI();
		s.getVerticalScrollBar().setUI(ui);
		
		s.getVerticalScrollBar().addMouseListener(new MouseAdapter(){
			@Override
			public void mouseEntered(MouseEvent e) {
				super.mouseEntered(e);
				s.getVerticalScrollBar().repaint();;
			}
			
			@Override
			public void mouseExited(MouseEvent e) {
				// TODO Auto-generated method stub
				super.mouseExited(e);
				s.getVerticalScrollBar().repaint();;
				
			}
		});
		
		s.setBorder(new EmptyBorder(0, 0, 0, 0));
		s.setViewportBorder(new EmptyBorder(0, 0, 0, 0));
		s.setHorizontalScrollBarPolicy(ScrollPaneConstants.HORIZONTAL_SCROLLBAR_NEVER);
		s.setBounds(128, 117, 723, 403);
		mainpanel.add(s);
		
		Font font = new Font("黑体", Font.PLAIN, 18);
		Color color = new Color(44, 62,80);
		
		/**
		 * 装车单编号长度待定
		 */
		idField = new LabelTextField("装车单编号",10);
		idField.setBounds(100, 10, 300, 45);
		panel.add(idField);
		
		dateLabel = new JLabel("装车日期");
		dateLabel.setFont(font);
		dateLabel.setForeground(color);
		dateLabel.setBounds(100, 70, 90, 40);
		panel.add(dateLabel);
		
		dateBox = new DateComboBoxPanel();
		dateBox.setBounds(190, 70, 500, 40);
		panel.add(dateBox);
		
		carrierIdField = new LabelTextField("本营业厅汽运编号",19);
		carrierIdField.setBounds(80,120, 400, 45);
		panel.add(carrierIdField);
		
		fromField = new LabelTextField("出发地  ", 10);
		fromField.setBounds(110, 180, 300, 45);
		panel.add(fromField);
		
		toField = new LabelTextField("到达地  ", 10);
		toField.setBounds(110, 240, 300, 45);
		panel.add(toField);
		
		supervisorField = new LabelTextField("监装员  ",10);
		supervisorField.setBounds(110, 300, 300, 45);
		panel.add(supervisorField);
		
		guardField = new LabelTextField("押运员  ",10);
		guardField.setBounds(110, 360, 300, 45);
		panel.add(guardField);
		
		orderArea = new JTextArea(10,100);
		orderArea.setLineWrap(true);
		orderArea.setWrapStyleWord(true);
		orderArea.setEditable(true);
		orderArea.setFont(font);
		orderArea.setForeground(color);
		JScrollPane qScroller = new JScrollPane(orderArea);
		qScroller.setVerticalScrollBarPolicy(ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS);
		qScroller.setHorizontalScrollBarPolicy(ScrollPaneConstants.HORIZONTAL_SCROLLBAR_NEVER);
		qScroller.setBounds(110, 450, 200, 100);
		panel.add(qScroller);
		
		//不需要再加panel了，添加顺序为 mainpanel.add(scrollpane), scrollpane.add(panel)
//		mainpanel.add(panel);
		
	}
	
	public void initOrderContainer(){
		JPanel panel = new JPanel();
		panel.setLayout(null);
		panel.setBounds(540, 50, 330, 450);
		panel.setVisible(true);
		panel.setBackground(Color.DARK_GRAY);
		
		
		
		addOrderBtn = new JButton("add");
		addOrderBtn.setBounds(230, 300, 50, 30);
		addOrderBtn.setFont(new Font("微软雅黑", Font.PLAIN, 15));
		addOrderBtn.addActionListener(controller);
		
		
		feeField = new LabelTextField("运费",10);
		feeField.setBounds(90, 340, 100, 30);
		
		calFeeBtn = new JButton("生成运费");
		calFeeBtn.setFont(new Font("Microsoft YaHei", Font.PLAIN,15));
		calFeeBtn.setBounds(210, 340, 100, 30);
		calFeeBtn.addActionListener(controller);
			
		
		panel.add(addOrderBtn);
		panel.add(feeField);
		panel.add(calFeeBtn);
		
		mainpanel.add(panel);
	}
	

	

	@Override
	public void mouseClicked(MouseEvent e) {
		// TODO Auto-generated method stub
		
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
