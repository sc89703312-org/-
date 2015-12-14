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

import edu.nju.express.blservice.HallReceiptBlService;
import edu.nju.express.blservice.OrderBLService;
import edu.nju.express.po.LoginInfo;
import edu.nju.express.presentation.Location;
import edu.nju.express.presentation.myUI.DateComboBoxPanel;
import edu.nju.express.presentation.myUI.LabelTextField;
import edu.nju.express.presentation.myUI.MyCheckBoxTable;
import edu.nju.express.presentation.myUI.MyComboBox;
import edu.nju.express.presentation.myUI.MyScrollBarUI;
import edu.nju.express.vo.OrderVO;

public class HallTransferUI extends JPanel implements MouseListener{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	HallController controller;
	HallReceiptBlService receipt;
	OrderBLService order;
	JPanel mainpanel;
	JPanel boxpanel;
	
	int width = 900;
	int height = 600;
	
	JLabel orderLabel;
	
	JButton addOrderBtn;
	JButton calFeeBtn;
	MyCheckBoxTable checkTable;
	JButton submitBtn;
	JButton exit;
	JLabel dateLabel, toLabel, addOrderLabel;
	DateComboBoxPanel dateBox;
	MyComboBox<String> toBox;
	LabelTextField carrierIdField,carField, supervisorField,
					guardField,feeField;
	JLabel bg;
	
	static JScrollPane scrollpane = new JScrollPane();
	final MyScrollBarUI ui = new MyScrollBarUI();
	Font font = new Font("黑体", Font.PLAIN, 18);
	Color color = new Color(44, 62,80);
	Color areaColor = new Color(210, 232, 232);

	String hall_id = LoginInfo.getUserID().substring(0, 6);
	
	
	public HallTransferUI(HallController controller){
		this.controller = controller;
		this.receipt = controller.receipt;
		this.order = controller.order;
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
		dateBox.setBounds(120, 70-45, 500, 40);
		panel.add(dateBox);
		
		carrierIdField = new LabelTextField("本营业厅汽运编号",19);
		carrierIdField.setBounds(80,120-45, 400, 45);
		panel.add(carrierIdField);
		
		carField = new LabelTextField("车辆代号", 10);
		carField.setBounds(110, 135, 300, 45);
		panel.add(carField);
		
		toLabel = new JLabel("到达地");
		toLabel.setFont(font);
		toLabel.setForeground(color);
		toLabel.setBounds(130, 135+60, 80, 40);
		panel.add(toLabel);
		
		
		toBox = new MyComboBox<String>();
		//根据所在城市确定到达地
		String cityID = hall_id.substring(0, 3);
		ArrayList<String> toList = new ArrayList<String>();
		
		toList.add(Location.getStationLocation(cityID)+"中转站");
			//同一次登录只要调用一次
			if(Location.station.size() == 0)
				Location.init();
			

			for(int i=0; i<Location.getHallList(hall_id.substring(0, 3)).size(); i++){
				toList.add(Location.getHallList(cityID).get(i));
			}
		
		System.out.println("toList.size()"+ toList.size());
//		toList = {"南京中转站","栖霞区营业厅","浦口区营业厅","鼓楼区营业厅","玄武区营业厅"};
		toBox.removeAllItems();
		for(int i=0; i<toList.size(); i++){
			toBox.addItem(toList.get(i));
		}
		toBox.setSelectedItem(toList.get(0));
		toBox.setBounds(210, 135+60, 220, 30);
		panel.add(toBox);
		
		supervisorField = new LabelTextField("监装员  ",10);
		supervisorField.setBounds(110, 185+45, 300, 45);
		panel.add(supervisorField);
		
		guardField = new LabelTextField("押运员  ",10);
		guardField.setBounds(110, 245+45, 300, 45);
		panel.add(guardField);
		
		addOrderLabel = new JLabel("请在此处勾选出本次装箱所有托运单号");
		addOrderLabel.setFont(font);
		addOrderLabel.setForeground(color);
		addOrderLabel.setBounds(20, 300+45, 400, 40);
		panel.add(addOrderLabel);
		
		
		String[] header = {"全选","订单号"};
		checkTable = new MyCheckBoxTable(header);
		initData();
//		Object[] data1 = { false, "1234567890" };
//		Object[] data2 = { false, "1234567891" };
//		Object[] data3 = { false, "1234567892" };
//		for (int i = 0; i < 10; i++) {
//			checkTable.getTableModel().addRow(data1);
//			checkTable.getTableModel().addRow(data2);
//			checkTable.getTableModel().addRow(data3);
//		}
		
		JScrollPane s = new JScrollPane(checkTable);
		s.setBounds(0, 350+45, 710, 325);
		s.setViewportBorder(new EmptyBorder(0, 0, 0, 0));
		s.setOpaque(false);
		s.getViewport().setOpaque(false);
		s.setColumnHeaderView(checkTable.getTableHeader());
		s.getColumnHeader().setOpaque(false);
		s.setBorder(new EmptyBorder(0, 0, 0, 0));
		s.getVerticalScrollBar().setUI(null);
		panel.add(s);
		
		
		feeField = new LabelTextField("运费  ",10);
		feeField.setBounds(110, 705+45, 300, 45);
		panel.add(feeField);
		
		calFeeBtn = new JButton("生成运费");
		calFeeBtn.setBounds(410, 705+45, 100, 40);
		calFeeBtn.addMouseListener(this);
		calFeeBtn.addActionListener(new ActionListener(){

			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				//...........................................
				feeField.setText("1000");
			}
			
		});
		panel.add(calFeeBtn);
		
		/*
		 * 如果需要在JScrollPane面板中放置多个控件，需要将多个控件放置到JPanel 面板上，然后将JPanel面板
		 * 作为一个整体控件添加到JScrollPane控件上
		 */
		
		scrollpane.setViewportView(panel);
		//感人。。。。layout==null时要加这句
		panel.setPreferredSize(new Dimension(723, 840));
		wrapScrollPane(scrollpane, ui);
		scrollpane.setBounds(130, 120, 720, 400);
		mainpanel.add(scrollpane);
		
		//不需要再加panel了，添加顺序为 mainpanel.add(scrollpane), scrollpane.add(panel)
		
	}
	
	public void initMargin(){
		submitBtn = new JButton("提交");
		submitBtn.setBounds(424, 523, 100, 40);
		submitBtn.addMouseListener(this);
		submitBtn.addActionListener(new ActionListener(){

			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				receipt.subHallTransferReceipt(carrierIdField.getText(), 
						(String)toBox.getSelectedItem(), carField.getText(), 
						supervisorField.getText(), guardField.getText(), 
						getSelectedOrders());
			}
			
		});
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
	
	public void initData(){
		Object[] row = new Object[2];
		int length = (receipt.showCurrentOrder()==null) ? 0 : receipt.showCurrentOrder().size();
		for(int i=0; i<length; i++){
			row[0] = false;
			row[1] = receipt.showCurrentOrder().get(i).getID();
			checkTable.getTableModel().addRow(row);
		}
		
		
	}
	
	public ArrayList<OrderVO> getSelectedOrders(){
		String orderId;
		ArrayList<OrderVO> selectedOrderList = new ArrayList<OrderVO>();

		for (int i = 0; i < checkTable.getRowCount(); i++) {
			if ((boolean) checkTable.getValueAt(i, 0) == true){
				orderId = (String) checkTable.getValueAt(i, 1);
				selectedOrderList.add(order.view(orderId));
			}
		}
		return selectedOrderList;
	}
	
	
	

}
