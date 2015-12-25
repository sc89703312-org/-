package edu.nju.express.presentation.clerk_stationui;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.Image;
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
import edu.nju.express.presentation.MainPanel;
import edu.nju.express.presentation.myUI.ConfirmButton;
import edu.nju.express.presentation.myUI.DateComboBoxPanel;
import edu.nju.express.presentation.myUI.LabelTextField;
import edu.nju.express.presentation.myUI.MyCheckBoxTable;
import edu.nju.express.presentation.myUI.MyComboBox;
import edu.nju.express.presentation.myUI.MyScrollBarUI;
import edu.nju.express.presentation.myUI.WarningDialog;
import edu.nju.express.vo.OrderVO;

public class StationTransportUI extends MainPanel implements MouseListener{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	int width = 900, height = 600;
	StationController controller;
	StationReceiptBlService receipt;
	OrderBLService order;
	JPanel mainpanel,panel,op;
	/*背景图片*/
	Image bg; 
	ConfirmButton submitBtn;
	JLabel dateLabel;
	DateComboBoxPanel dateBox;
	JLabel addOrderLabel,  toLabel;
	MyCheckBoxTable checkTable;
	/*中转单编号*/
	LabelTextField idField;
	boolean idErr;
	MyComboBox<String>  toBox;
	/*车次号、航班号*/
	LabelTextField transportIdField, containerField, supervisorField, 
					feeField;
	JButton calFeeBtn;
	
	String station_id = LoginInfo.getUserID().substring(0, 3);
	//子类在构造方法中要set etype
	Etype etype;
	
	static JScrollPane scroll = new JScrollPane();
	final MyScrollBarUI ui = new MyScrollBarUI();
	Font font = new Font("黑体", Font.PLAIN, 18);
	Color color = new Color(44, 62,80);
	
	public StationTransportUI(StationController c){
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
		
		
		
		toLabel = new JLabel("到达地");
		toLabel.setFont(font);
		toLabel.setForeground(color);
		toLabel.setBounds(130, 200, 80, 40);
		panel.add(toLabel);
		
		toBox = new MyComboBox<String>();
		String[] toList = {"南京中转站","上海中转站","北京中转站","广州中转站"};
		for(int i=0; i<toList.length; i++){
			toBox.addItem(toList[i]);
		}
		toBox.setSelectedItem(toList[0]);
		toBox.setBounds(210, 200, 195, 30);
		panel.add(toBox);
		
		containerField = new LabelTextField("货柜号  ", 15);
		containerField.setBounds(120, 250, 300, 45);
		panel.add(containerField);
		
		supervisorField = new LabelTextField("监装员  ", 10);
		supervisorField.setBounds(120, 310, 300, 45);
		panel.add(supervisorField);
		
		op = new JPanel();
		op.setLayout(null);
		op.setOpaque(false);
		op.setVisible(true);
		op.setBounds(0, 355, 724, 500);
		
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
					for(OrderVO vo: getSelectedOrders()){
						weight += vo.getWeight();
					}
					feeField.setText(calFee(weight) + "");
			}
			
		});
		op.add(calFeeBtn);
		
		panel.add(op);
		
		
		
		
		scroll.setViewportView(panel);
		panel.setPreferredSize(new Dimension(724, 1000));
		wrapScrollPane(scroll, ui);
		scroll.setBounds(129, 120, 720, 400);
		mainpanel.add(scroll);
	}
	
	
	/**
	 * 子类重写这个方法，体现为"车次号" 或"航班号" 
	 * @author guhan
	 */
	public void addTransportIdField(){
		
	}

	public void clearPanel(){
		idField.setText("");
		
		transportIdField.setText("");
		
		dateBox.setToday();
		
		toBox.setSelectedIndex(0);
		
		containerField.setText("");
		
		supervisorField.setText("");
		
		for(int i=0; i<checkTable.getTableModel().getRowCount(); i++){
			checkTable.setValueAt(false, i, 0);
		}
	}

	public void initMargin(){
		
		submitBtn = new ConfirmButton();
		submitBtn.setBounds(424, 523, 100, 40);
		submitBtn.addMouseListener(this);
		submitBtn.addActionListener(new ActionListener(){

			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				if(!isFilled()){
					WarningDialog.show("温馨提示", "请检查填写信息是否齐全");
				}
				else if(!isError()){
					if(!idErr)
						idField.setError();
					WarningDialog.show("数据格式错误","中转单编号为19位");
				}
				else{
					receipt.subTransferReceipt(getSelectedOrders(), (String)toBox.getSelectedItem(), 
							transportIdField.getText(), supervisorField.getText(), etype);
					WarningDialog.show("", "提交成功！");
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
		System.out.println("length of current orders: "+length);
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
		boolean container = (containerField.getText().trim().length()==0) ? false : true;
		boolean supervisor = (supervisorField.getText().trim().length()==0) ? false : true;
		boolean fee = (feeField.getText().trim().length()==0) ? false : true;
		boolean order = (getSelectedOrders().size()==0) ? false : true;
		return id && transportId && container && supervisor && fee && order;
	}
	
	public Double calFee(double weight){
		String thisCity = Location.getStationLocation(station_id);
		String toCity = (String)toBox.getSelectedItem();
		return FeeCalculator.getTransFee(thisCity, toCity, etype, weight);
	}
	
	public boolean isError(){
		idErr = (idField.getText().trim().length()==19) ? true : false;
		return idErr;
	}

}
