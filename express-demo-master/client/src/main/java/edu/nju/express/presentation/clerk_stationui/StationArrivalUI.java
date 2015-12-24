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

import edu.nju.express.blservice.StationReceiptBlService;
import edu.nju.express.common.GoodsState;
import edu.nju.express.po.LoginInfo;
import edu.nju.express.presentation.Location;
import edu.nju.express.presentation.myUI.ConfirmButton;
import edu.nju.express.presentation.myUI.DateComboBoxPanel;
import edu.nju.express.presentation.myUI.LabelTextField;
import edu.nju.express.presentation.myUI.MyComboBox;
import edu.nju.express.presentation.myUI.MyScrollBarUI;
import edu.nju.express.presentation.myUI.MyTablePanel;
import edu.nju.express.presentation.myUI.WarningDialog;
import edu.nju.express.vo.ArriveReceiptVO;
import edu.nju.express.vo.OrderVO;

public class StationArrivalUI extends JPanel implements MouseListener{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	int width = 900, height = 600;
	StationController controller;
	StationReceiptBlService receipt;
	JPanel mainpanel, panel;
	JLabel bg;
	JButton exit, getOrderBtn;
	ConfirmButton submitBtn;
	LabelTextField idField, getOrderField;
	JLabel dateLabel, fromLabel, arrivalStateLabel;
	DateComboBoxPanel dateBox;
	MyComboBox<String> fromBox;
	MyTablePanel table;
	ArrayList<OrderVO> orderList;
	
	static JScrollPane scroll = new JScrollPane();
	final MyScrollBarUI ui = new MyScrollBarUI();
	Font font = new Font("黑体", Font.PLAIN, 18);
	Color color = new Color(44, 62,80);
	
	
	String cityID = LoginInfo.getUserID().substring(0, 3);
	String location = Location.getStationLocation(cityID);
	
	public StationArrivalUI(StationController c){
		this.controller = c;
		this.receipt = c.receipt;
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
		
//		stationIdField = new LabelTextField("中转中心编号",4);
//		stationIdField.setBounds(60, 10, 400, 45);
//		panel.add(stationIdField);
		
		dateLabel = new JLabel("到达日期");
		dateLabel.setFont(font);
		dateLabel.setForeground(color);
		dateLabel.setBounds(100, 70-45, 80, 40);
		panel.add(dateLabel);
		
		dateBox = new DateComboBoxPanel();
		dateBox.setBounds(110, 70-45, 500, 40);
		panel.add(dateBox);
		
		idField = new LabelTextField("到达单编号", 19);
		idField.setBounds(100, 125-45, 300, 45);
		panel.add(idField);
		
		fromLabel = new JLabel("出发地");
		fromLabel.setFont(font);
		fromLabel.setForeground(color);
		fromLabel.setBounds(100, 185-45, 70, 40);
		panel.add(fromLabel);
		
		fromBox = new MyComboBox<String>();
		ArrayList<String> fromList = new ArrayList<String>();
		fromList.add("南京中转站");
		fromList.add("北京中转站");
		fromList.add("上海中转站");
		fromList.add("广州中转站");
		if(Location.station.size() == 0)
			Location.init();
		
		System.out.println("location:"+cityID);
		for(int i=0; i<Location.getHallList(cityID).size(); i++){
			fromList.add(Location.getHallList(cityID).get(i));
		}
//		String[] fromList = {"栖霞区营业厅","鼓楼区营业厅","玄武区营业厅","浦口区营业厅"};
		for(int i=0; i<fromList.size(); i++){
			fromBox.addItem(fromList.get(i));
		}
		fromBox.setSelectedItem(fromList.get(0));
		fromBox.setBounds(170, 185-45, 200, 30);
		panel.add(fromBox);
		
		
		getOrderField = new LabelTextField("获取到达订单", 19);
		getOrderField.setBounds(90, 235-45, 350, 45);
		panel.add(getOrderField);
		
		getOrderBtn = new JButton();
		getOrderBtn.setBounds(440, 240-45, 80, 40);
		getOrderBtn.setIcon(new ImageIcon("ui/image/hall/confirm0.png"));
		getOrderBtn.setBorderPainted(false);
		getOrderBtn.setContentAreaFilled(false);
		getOrderBtn.addMouseListener(this);
		getOrderBtn.addActionListener(new ActionListener(){

			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				if(getOrderField.getText().length()==0){
					WarningDialog.show("温馨提示", "输入内容不能为空");
				}
				else if(searchOrder()==null){
					WarningDialog.show("T ^ T", "您输入的中转单编号不存在");
				}
				else{
					generateData();
				}
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
		table.setBounds(5, 300-45, 700, 350);
		table.getTable().setPreferredScrollableViewportSize(new Dimension(690,350));
		panel.add(table);
		
		
		scroll.setViewportView(panel);
		panel.setPreferredSize(new Dimension(724, 800));
		wrapScrollPane(scroll, ui);
		scroll.setBounds(129, 120, 720, 400);
		mainpanel.add(scroll);
	}
	
	public void clearPanel(){
		
		idField.setText("");
		
		getOrderField.setText("");
		
		dateBox.setToday();
		
		fromBox.setSelectedIndex(0);
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
		
		submitBtn = new ConfirmButton();
		submitBtn.setBounds(424, 523, 100, 40);
		submitBtn.addMouseListener(this);
		submitBtn.addActionListener(new ActionListener(){

			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				if(!isFilled()){
					WarningDialog.show("温馨提示", "请检查填写项是否齐全");
				}
				else{
					for(int i=0; i<orderList.size(); i++){
						orderList.get(i).setGoodState(convert((String)table.getTable().getValueAt(i, 1)));
					}
					submit(new ArriveReceiptVO(idField.getText(), dateBox.getDate(), 
							(String)fromBox.getSelectedItem(), location, orderList));
					clearPanel();
				}
			}

		});
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
		if(e.getSource().equals(getOrderBtn)){
			getOrderBtn.setIcon(new ImageIcon("ui/image/hall/confirm1.png"));
		}
	}

	@Override
	public void mouseExited(MouseEvent e) {
		// TODO Auto-generated method stub
		if(e.getSource().equals(getOrderBtn)){
			getOrderBtn.setIcon(new ImageIcon("ui/image/hall/confirm0.png"));
		}
	}
	
	
	public ArriveReceiptVO searchOrder(){
		
		String sign = (getOrderField.getText().length() == 10)?"HallTransferReceipt":"TransferReceipt";
		String searchId = sign + getOrderField.getText();
		return receipt.creatArriveReceipt(searchId);
	}

	//set panel
	public void generateData(){
		//dateBox
		String date = searchOrder().getDate();
		String[] dateSplit = date.split("/");
		dateBox.getYearComboBox().setSelectedItem(dateSplit[0]);
		dateBox.getMonthComboBox().setSelectedItem(dateSplit[1]);
		dateBox.getDayComboBox().setSelectedItem(dateSplit[2]);
		
		//fromBox
		fromBox.setSelectedItem(searchOrder().getFrom());

		//先清空table
		int tablelen = table.getTableModel().getRowCount();
		for(int i = tablelen-1; i>=0; i --){
			table.getTableModel().removeRow(i);
		}

		orderList = new ArrayList<OrderVO>();
		int length = searchOrder().getList().size();
		for(int i=0; i<length; i++){
			orderList.add(searchOrder().getList().get(i));
		}
		Object[] row = new Object[2];
		for(int i=0; i<length; i++){
			row[0] = orderList.get(i).getID();
			row[1] = "完整";
		}
		table.getTableModel().addRow(row);

	}
	
	public void submit(ArriveReceiptVO vo){
		receipt.subArriveReceipt(vo);
	}
	
	public GoodsState convert(String goodState){
		switch(goodState){
		case "完整": return GoodsState.COMPLETE;
		case "损坏": return GoodsState.DAMAGED;
		default: return GoodsState.LOST;
		}
		
	}
	
	public boolean isFilled(){
		boolean id = (idField.getText().trim().length()==0) ? false : true;
		
		return id;
	}

}
