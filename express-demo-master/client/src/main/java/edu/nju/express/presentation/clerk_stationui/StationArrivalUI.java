package edu.nju.express.presentation.clerk_stationui;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.util.ArrayList;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.ScrollPaneConstants;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableModel;

import edu.nju.express.presentation.UIController;
import edu.nju.express.presentation.myUI.DateComboBoxPanel;
import edu.nju.express.presentation.myUI.LabelTextField;
import edu.nju.express.presentation.myUI.MyComboBox;
import edu.nju.express.presentation.myUI.MyScrollBarUI;
import edu.nju.express.presentation.myUI.MyTablePanel;

public class StationArrivalUI extends JPanel implements MouseListener{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	int width = 900, height = 600;
	UIController controller;
	JPanel mainpanel, panel;
	JLabel bg;
	JButton exit, submitBtn, getOrderBtn;
	LabelTextField stationIdField, idField, getOrderField;
	JLabel dateLabel, fromLabel, arrivalStateLabel;
	DateComboBoxPanel dateBox;
	MyComboBox<String> fromBox;
	MyTablePanel table;
	ArrayList<String> orderList;
	
	static JScrollPane scroll = new JScrollPane();
	final MyScrollBarUI ui = new MyScrollBarUI();
	Font font = new Font("黑体", Font.PLAIN, 18);
	Color color = new Color(44, 62,80);
	
	
	public StationArrivalUI(UIController c){
		this.controller = c;
		mainpanel = new JPanel();
		mainpanel.setLayout(null);
		mainpanel.setBounds(0, 0, width, height);
		mainpanel.setOpaque(false);
		mainpanel.setVisible(true);
		
		initMargin();
		initPanel();
		
		bg = new JLabel(new ImageIcon("ui/image/station/station_arrival.png"));
		bg.setBounds(0, 0, width, height);
		mainpanel.add(bg);
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
		panel.setVisible(true);
		panel.setOpaque(false);
		
		stationIdField = new LabelTextField("中转中心编号",4);
		stationIdField.setBounds(60, 10, 400, 45);
		panel.add(stationIdField);
		
		dateLabel = new JLabel("到达日期");
		dateLabel.setFont(font);
		dateLabel.setForeground(color);
		dateLabel.setBounds(100, 70, 80, 40);
		panel.add(dateLabel);
		
		dateBox = new DateComboBoxPanel();
		dateBox.setBounds(110, 70, 500, 40);
		panel.add(dateBox);
		
		idField = new LabelTextField("中转单编号", 19);
		idField.setBounds(100, 125, 300, 45);
		panel.add(idField);
		
		fromLabel = new JLabel("出发地");
		fromLabel.setFont(font);
		fromLabel.setForeground(color);
		fromLabel.setBounds(100, 185, 70, 40);
		panel.add(fromLabel);
		
		fromBox = new MyComboBox<String>();
		String[] fromList = {"栖霞区营业厅","鼓楼区营业厅","玄武区营业厅","浦口区营业厅"};
		for(int i=0; i<fromList.length; i++){
			fromBox.addItem(fromList[i]);
		}
		fromBox.setSelectedItem(fromList[0]);
		fromBox.setBounds(170, 185, 200, 30);
		panel.add(fromBox);
		
		
		getOrderField = new LabelTextField("获取到达订单", 19);
		getOrderField.setBounds(90, 235, 350, 45);
		panel.add(getOrderField);
		
		getOrderBtn = new JButton("获取");
		getOrderBtn.setBounds(440, 240, 60, 35);
		getOrderBtn.addActionListener(new ActionListener(){

			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				generateData();
			}
		
		});
		panel.add(getOrderBtn);
		
		String[] header = {"托运单号","货物到达状态"};
		DefaultTableModel model = new DefaultTableModel(null,header){
			/**
			 * 
			 */
			private static final long serialVersionUID = 1L;

			@Override
			public boolean isCellEditable(int row, int column) {
				if(column==1){
					return true;
				}
				return false;
			}
		};
		table = new MyTablePanel(model,header);
		table.setBounds(5, 300, 700, 350);
		table.getTable().setPreferredScrollableViewportSize(new Dimension(690,350));
		panel.add(table);
		
		
		scroll.setViewportView(panel);
		panel.setPreferredSize(new Dimension(724, 800));
		wrapScrollPane(scroll, ui);
		scroll.setBounds(129, 120, 720, 400);
		mainpanel.add(scroll);
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
	
	//生成托运单号
		public void generateData(){
			this.orderList = new ArrayList<String>();
			String[] row = new String[2];
			//mock orderList
			for(int i=0; i<30; i++){
				orderList.add("1234567890");
			}
			for(int i=0; i<orderList.size(); i++){
				row[0] = orderList.get(i);
				row[1] = "完整";
				table.getTableModel().addRow(row);
			}

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
