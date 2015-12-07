package edu.nju.express.presentation.clerk_hallui;

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
import edu.nju.express.vo.HallTransferReceiptVO;

public class HallArrivalUI extends JPanel implements MouseListener{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	int width = 900;
	int height = 600;
	UIController controller;
	JPanel mainpanel, panel;
	JButton exit, submitBtn, saveOrderBtn, confirmBtn;
	JLabel bg;
	JLabel dateLabel, fromLabel;
	DateComboBoxPanel dateBox;
	MyComboBox<String> fromBox;
	LabelTextField transferIdField;
	MyTablePanel table;
	ArrayList<String> orderList;
	
	static JScrollPane s = new JScrollPane();
	final MyScrollBarUI ui = new MyScrollBarUI();
	Font font = new Font("黑体", Font.PLAIN, 18);
	Color color = new Color(44, 62,80);
	
	public HallArrivalUI(UIController controller){
		this.controller = controller;
		mainpanel = new JPanel();
		mainpanel.setLayout(null);
		mainpanel.setBounds(0,0,width,height);
		mainpanel.setVisible(true);
		mainpanel.setOpaque(false);
		
		initPanel();
		initScrollPane();
		initMargin();
		
		
		bg = new JLabel();
		bg.setBounds(0, 0, width, height);
		bg.setIcon(new ImageIcon("ui/image/hall/arrival.png"));
		mainpanel.add(bg);
		
		this.add(mainpanel);
		this.add(new HallGuide(controller));
		this.setLayout(null);
		this.setOpaque(false);
		this.setVisible(true);
	}
	
	
	
	public void initPanel(){
		panel = new JPanel();
		panel.setLayout(null);
		panel.setVisible(true);
		panel.setOpaque(false);
		
				
		//transferIdField
		transferIdField = new LabelTextField("请输入装车单编号 ",19);
		transferIdField.setBounds(20, 10, 500, 45);
		panel.add(transferIdField);
		
		//confirmBtn
		confirmBtn = new JButton("确认");
		confirmBtn.setFont(new Font("Microsoft YaHei", Font.PLAIN, 15));
		confirmBtn.setBounds(530, 15, 80, 40);
		confirmBtn.addActionListener(new ActionListener(){

			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				generateData();
			}
			
		});
		panel.add(confirmBtn);
		
		//orderTable
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
		table.setBounds(5, 80, 700, 350);
		table.getTable().setPreferredScrollableViewportSize(new Dimension(690,350));
		panel.add(table);


		//saveOrderBtn
		saveOrderBtn = new JButton("save");
		saveOrderBtn.setBounds(600, 440, 80, 40);
		panel.add(saveOrderBtn);
		
		
//		//idField
//		idField = new LabelTextField("到达单编号",15);
//		idField.setBounds(110, 430, 300, 45);
//		panel.add(idField);
//		
		
		//dateLabel
		dateLabel = new JLabel("到达日期");
		dateLabel.setFont(font);
		dateLabel.setForeground(color);
		dateLabel.setBounds(100, 495, 90, 40);
		panel.add(dateLabel);
		
		//comboBox:year, month, day
		dateBox = new DateComboBoxPanel();
		dateBox.setBounds(120, 495, 500, 40);
		panel.add(dateBox);
		
		//fromLabel, fromBox
		fromLabel = new JLabel("出发地");
		fromLabel.setFont(font);
		fromLabel.setForeground(color);
		fromLabel.setBounds(130, 550, 80, 40);
		panel.add(fromLabel);
		
		fromBox = new MyComboBox<String>();
		String[] fromList = {"南京","上海","北京","广州"};
		for(int i=0; i<fromList.length; i++){
			fromBox.addItem(fromList[i]);
		}
		fromBox.setSelectedItem(fromList[0]);
		fromBox.setBounds(210, 550, 100, 35);
		panel.add(fromBox);
		
	}
	
	
	
	public void initScrollPane(){
		s.setViewportView(panel);
		panel.setPreferredSize(new Dimension(723, 620));
		s.setBounds(130, 120, 720, 400);
		mainpanel.add(s);
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
	
	
	
	
	//getvo()
	public HallTransferReceiptVO getTransferVO(){

		return null;
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
