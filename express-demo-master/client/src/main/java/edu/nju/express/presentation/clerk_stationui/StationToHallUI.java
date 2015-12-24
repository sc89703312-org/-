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

import edu.nju.express.blservice.OrderBLService;
import edu.nju.express.blservice.StationReceiptBlService;
import edu.nju.express.common.Etype;
import edu.nju.express.po.LoginInfo;
import edu.nju.express.presentation.FeeCalculator;
import edu.nju.express.presentation.Location;
import edu.nju.express.presentation.myUI.ConfirmButton;
import edu.nju.express.presentation.myUI.DateComboBoxPanel;
import edu.nju.express.presentation.myUI.LabelTextField;
import edu.nju.express.presentation.myUI.MyCheckBoxTable;
import edu.nju.express.presentation.myUI.MyComboBox;
import edu.nju.express.presentation.myUI.MyScrollBarUI;
import edu.nju.express.presentation.myUI.WarningDialog;
import edu.nju.express.vo.OrderVO;

public class StationToHallUI extends JPanel implements MouseListener{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	int width = 900, height = 600;
	StationController controller;
	StationReceiptBlService receipt;
	OrderBLService order;
	JPanel mainpanel, panel, op;
	JLabel bg;
	JButton exit;
	ConfirmButton submitBtn;
	JLabel dateLabel;
	DateComboBoxPanel dateBox;
	JLabel addOrderLabel, toLabel;
	MyCheckBoxTable checkTable;
	/*装车单编号/汽运编号*/
	LabelTextField idField;
	boolean idErr, carErr;
	MyComboBox<String> fromBox, toBox;
	//transortid 是指车辆代号
	LabelTextField transportIdField, supervisorField, guardField, 
					feeField;
	
	JButton calFeeBtn;
	
	static JScrollPane scroll = new JScrollPane();
	final MyScrollBarUI ui = new MyScrollBarUI();
	Font font = new Font("黑体", Font.PLAIN, 18);
	Color color = new Color(44, 62, 80);
	
	String station_id = LoginInfo.getUserID().substring(0, 3);
	
	public StationToHallUI(StationController c){
		this.controller = c;
		this.receipt = c.receipt;
		this.order = c.order;
		mainpanel = new JPanel();
		mainpanel.setLayout(null);
		mainpanel.setBounds(0, 0, width, height);
		mainpanel.setOpaque(false);
		mainpanel.setVisible(true);
		
		initMargin();
		initPanel();
		
		bg = new JLabel(new ImageIcon("ui/image/station/toHall.png"));
		bg.setBounds(0, 0, width, height);
		mainpanel.add(bg);
		this.add(mainpanel);
		this.add(new StationGuide(controller));
		this.setLayout(null);
		this.setVisible(true);
		this.setOpaque(false);
		this.setBounds(0, 0, width, height);
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
				else if(!isError()){
					if(!idErr)
						idField.setError();
					if(!carErr)
						transportIdField.setError();
					WarningDialog.show("数据格式错误", "汽运编号为19位"+"\n"+"车辆代号为10位");
				}
				else{
					receipt.subTransferReceipt(getSelectedOrders(), (String)toBox.getSelectedItem(),
							transportIdField.getText(), supervisorField.getText(), Etype.STANDARD);
					WarningDialog.show("", "提交成功！");
					clearPanel();
					
				}
			}

		});
		mainpanel.add(submitBtn);
		
	}
	
	public void initPanel(){
		panel = new JPanel();
		panel.setLayout(null);
		panel.setOpaque(false);
		panel.setVisible(true);
		
		dateLabel = new JLabel("中转日期");
		dateLabel.setFont(font);
		dateLabel.setForeground(color);
		dateLabel.setBounds(110, 10, 80, 40);
		panel.add(dateLabel);
		
		dateBox = new DateComboBoxPanel();
		dateBox.setBounds(120, 10, 500, 45);
		panel.add(dateBox);
		
		idField = new LabelTextField("汽运编号",19);
		idField.setBounds(110, 70, 300, 45);
		panel.add(idField);
		
		transportIdField = new LabelTextField("车辆代号", 10);
		transportIdField.setBounds(110, 130, 300, 45);
		panel.add(transportIdField);
		
		toLabel = new JLabel("到达地");
		toLabel.setFont(font);
		toLabel.setForeground(color);
		toLabel.setBounds(130, 190, 80, 40);
		panel.add(toLabel);
		
		//根据station属性确定是哪个城市的营业厅
		if(Location.station.size() == 0)
			Location.init();
		ArrayList<String> toList = new ArrayList<String>(Location.getHallList(station_id));
		
		
		toBox = new MyComboBox<String>();
		for(int i=0; i<toList.size(); i++){
			toBox.addItem(toList.get(i));
		}
		toBox.setSelectedItem(toList.get(0));
		toBox.setBounds(210, 190, 210, 30);
		panel.add(toBox);
		
		supervisorField = new LabelTextField("监装员  ", 10);
		supervisorField.setBounds(120, 240, 300, 45);
		panel.add(supervisorField);
		
		guardField = new LabelTextField("押运员  ", 10);
		guardField.setBounds(120, 300, 300, 45);
		panel.add(guardField);
		
		op = new JPanel();
		op.setLayout(null);
		op.setOpaque(false);
		op.setVisible(true);
		op.setBounds(0, 360, 724, 500);
		
		addOrderLabel = new JLabel("请在此处勾选出本次装箱所有托运单号");
		addOrderLabel.setFont(font);
		addOrderLabel.setForeground(color);
		addOrderLabel.setBounds(20, 10, 400, 40);
		op.add(addOrderLabel);
		
		
		String[] header = {"全选","订单号"};
		checkTable = new MyCheckBoxTable(header);
		initData();
		
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
		
		calFeeBtn = new JButton();
		calFeeBtn.setBounds(420, 410, 90, 30);
		calFeeBtn.setBorderPainted(false);
		calFeeBtn.setContentAreaFilled(false);
		calFeeBtn.setIcon(new ImageIcon("ui/image/hall/calFee0.png"));
		calFeeBtn.addMouseListener(this);
		calFeeBtn.addActionListener(new ActionListener(){

			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				double weight = 0;
//				System.out.println("selected orders : "+getSelectedOrders().size());
				for(int i = 0; i < getSelectedOrders().size(); i ++){
					System.out.println(getSelectedOrders().get(i).getWeight());
					weight += getSelectedOrders().get(i).getWeight();
				}
				feeField.setText(calFee(weight) + "");
			}
			
		});
		op.add(calFeeBtn);
		
		panel.add(op);
		
		
		scroll.setViewportView(panel);
		panel.setPreferredSize(new Dimension(724, 900));
		wrapScrollPane(scroll, ui);
		scroll.setBounds(129, 120, 720, 400);
		mainpanel.add(scroll);
		
	}

	public void clearPanel(){
		idField.setText("");

		transportIdField.setText("");

		dateBox.setToday();

		toBox.setSelectedIndex(0);

		guardField.setText("");

		supervisorField.setText("");

		for(int i=0; i<checkTable.getTableModel().getRowCount(); i++){
			checkTable.setValueAt(false, i, 0);
		}
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
		if(e.getSource().equals(calFeeBtn)){
			calFeeBtn.setIcon(new ImageIcon("ui/image/hall/calFee1.png"));
		}
	}

	@Override
	public void mouseExited(MouseEvent e) {
		// TODO Auto-generated method stub
		if(e.getSource().equals(calFeeBtn)){
			calFeeBtn.setIcon(new ImageIcon("ui/image/hall/calFee0.png"));
		}
	}
	
	public void initData(){
		Object[] row = new Object[2];
		int length = receipt.showCurrentOrder().size();
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
	
	public boolean isFilled(){
		boolean id = (idField.getText().trim().length()==0) ? false : true;
		boolean transportId = (transportIdField.getText().trim().length()==0) ? false : true;
		boolean supervisor = (supervisorField.getText().trim().length()==0) ? false : true;
		boolean guard = (guardField.getText().trim().length()==0) ? false : true;
		boolean order = (getSelectedOrders().size()==0) ? false : true;
		return id && transportId && supervisor && guard;
		
	}
	
	public boolean isError(){
		idErr = (idField.getText().trim().length()==19) ? true : false;
		carErr = (transportIdField.getText().trim().length()==10) ? true : false;
		return idErr && carErr;
	}
	
	//计算运费的方法    
	public double calFee(double weight){
		return FeeCalculator.getTransFee(Etype.STANDARD, weight);
		
	}

}
