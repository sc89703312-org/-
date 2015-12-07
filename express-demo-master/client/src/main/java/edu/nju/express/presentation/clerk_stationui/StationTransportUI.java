package edu.nju.express.presentation.clerk_stationui;

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
import javax.swing.ScrollPaneConstants;
import javax.swing.border.EmptyBorder;

import edu.nju.express.presentation.UIController;
import edu.nju.express.presentation.myUI.DateComboBoxPanel;
import edu.nju.express.presentation.myUI.LabelTextField;
import edu.nju.express.presentation.myUI.MyCheckBoxTable;
import edu.nju.express.presentation.myUI.MyComboBox;
import edu.nju.express.presentation.myUI.MyScrollBarUI;

public class StationTransportUI extends JPanel implements MouseListener{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	int width = 900, height = 600;
	UIController controller;
	JPanel mainpanel,panel,op;
	JLabel bg; 
	JButton exit, submitBtn;
	JLabel dateLabel;
	DateComboBoxPanel dateBox;
	JLabel addOrderLabel, fromLabel, toLabel;
	MyCheckBoxTable checkTable;
	LabelTextField idField;
	MyComboBox<String> fromBox, toBox;
	LabelTextField transportIdField, containerField, supervisorField, 
					feeField;
	JButton calFeeBtn;
	
	static JScrollPane scroll = new JScrollPane();
	final MyScrollBarUI ui = new MyScrollBarUI();
	Font font = new Font("黑体", Font.PLAIN, 18);
	Color color = new Color(44, 62,80);
	
	public StationTransportUI(UIController c){
		this.controller = c;
		mainpanel = new JPanel();
		mainpanel.setLayout(null);
		mainpanel.setBounds(0, 0, width, height);
		mainpanel.setOpaque(false);
		mainpanel.setVisible(true);
		
		initMargin();
		initPanel();
		
//		bg = new JLabel(new ImageIcon(imgName));
//		bg.setBounds(0, 0, width, height);
//		mainpanel.add(bg);
		this.add(mainpanel);
		this.add(new StationGuide(controller));
		this.setLayout(null);
		this.setVisible(true);
		this.setOpaque(false);
		this.setBounds(0, 0, width, height);
	}
	
	
	public void initPanel(){
		panel = new JPanel();
		panel.setLayout(null);
		panel.setOpaque(false);
		panel.setVisible(true);
		
		dateLabel = new JLabel("中转日期");
		dateLabel.setFont(font);
		dateLabel.setForeground(color);
		dateLabel.setBounds(110, 10, 90, 40);
		panel.add(dateLabel);
		
		dateBox = new DateComboBoxPanel();
		dateBox.setBounds(120, 10, 500, 45);
		panel.add(dateBox);
		
		idField = new LabelTextField("中转单编号",19);
		idField.setBounds(110, 70, 300, 45);
		panel.add(idField);
		
//		transportIdField = new LabelTextField("航班号  ", 10);
//		transportIdField.setBounds(120, 130, 300, 45);
//		panel.add(transportIdField);
		addTransportIdField();
		
		fromLabel = new JLabel("出发地");
		fromLabel.setFont(font);
		fromLabel.setForeground(color);
		fromLabel.setBounds(130, 190, 80, 40);
		panel.add(fromLabel);
		
		fromBox = new MyComboBox<String>();
		String[] fromList = {"南京","上海","北京","广州"};
		for(int i=0; i<fromList.length; i++){
			fromBox.addItem(fromList[i]);
		}
		fromBox.setSelectedItem(fromList[0]);
		fromBox.setBounds(210, 190, 100, 35);
		panel.add(fromBox);
		
		toLabel = new JLabel("到达地");
		toLabel.setFont(font);
		toLabel.setForeground(color);
		toLabel.setBounds(130, 245, 80, 40);
		panel.add(toLabel);
		
		toBox = new MyComboBox<String>();
		String[] toList = {"南京","上海","北京","广州"};
		for(int i=0; i<toList.length; i++){
			toBox.addItem(toList[i]);
		}
		toBox.setSelectedItem(toList[0]);
		toBox.setBounds(210, 245, 100, 35);
		panel.add(toBox);
		
		containerField = new LabelTextField("货柜号  ", 15);
		containerField.setBounds(120, 295, 300, 45);
		panel.add(containerField);
		
		supervisorField = new LabelTextField("监装员  ", 10);
		supervisorField.setBounds(120, 355, 300, 45);
		panel.add(supervisorField);
		
		op = new JPanel();
		op.setLayout(null);
		op.setOpaque(false);
		op.setVisible(true);
		op.setBounds(0, 400, 724, 500);
		
		addOrderLabel = new JLabel("请在此处勾选出本次装箱所有托运单号");
		addOrderLabel.setFont(font);
		addOrderLabel.setForeground(color);
		addOrderLabel.setBounds(20, 10, 400, 40);
		op.add(addOrderLabel);
		
		
		String[] header = {"全选","订单号"};
		checkTable = new MyCheckBoxTable(header);
		//init data
		Object[] data1 = { false, "1234567890" };
		Object[] data2 = { false, "1234567891" };
		Object[] data3 = { false, "1234567892" };
		for (int i = 0; i < 10; i++) {
			checkTable.getTableModel().addRow(data1);
			checkTable.getTableModel().addRow(data2);
			checkTable.getTableModel().addRow(data3);
		}
		
		JScrollPane s = new JScrollPane(checkTable);
		s.setBounds(0, 60, 710, 325);
		s.setViewportBorder(new EmptyBorder(0, 0, 0, 0));
		s.setOpaque(false);
		s.getViewport().setOpaque(false);
		s.setColumnHeaderView(checkTable.getTableHeader());
		s.getColumnHeader().setOpaque(false);
		s.setBorder(new EmptyBorder(0, 0, 0, 0));
		s.getVerticalScrollBar().setUI(null);
		op.add(s);
		
		
		feeField = new LabelTextField("运费  ", 10);
		feeField.setBounds(120, 400, 300, 45);
		op.add(feeField);
		
		calFeeBtn = new JButton("计算运费");
		calFeeBtn.setBounds(420, 400, 80, 45);
		op.add(calFeeBtn);
		
		panel.add(op);
		
		
		
		
		scroll.setViewportView(panel);
		panel.setPreferredSize(new Dimension(724, 1000));
		wrapScrollPane(scroll, ui);
		scroll.setBounds(129, 120, 720, 400);
		mainpanel.add(scroll);
	}
	
	public void addTransportIdField(){
		
	}
		
	
	
	public void initMargin(){
		exit = new JButton(new ImageIcon("ui/button/X_darkgray.png"));
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
		
		submitBtn = new JButton("提交");
		submitBtn.setBounds(424, 523, 100, 40);
		submitBtn.addMouseListener(this);
		mainpanel.add(submitBtn);
		
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
