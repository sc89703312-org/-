package edu.nju.express.presentation.clerk_hallui;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.Graphics;
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
import javax.swing.table.DefaultTableModel;

import edu.nju.express.blservice.HallReceiptBlService;
import edu.nju.express.common.GoodsState;
import edu.nju.express.po.LoginInfo;
import edu.nju.express.presentation.Location;
import edu.nju.express.presentation.MainPanel;
import edu.nju.express.presentation.myUI.ConfirmButton;
import edu.nju.express.presentation.myUI.DateComboBoxPanel;
import edu.nju.express.presentation.myUI.LabelTextField;
import edu.nju.express.presentation.myUI.MyComboBox;
import edu.nju.express.presentation.myUI.MyScrollBarUI;
import edu.nju.express.presentation.myUI.MyTablePanel;
import edu.nju.express.presentation.myUI.WarningDialog;
import edu.nju.express.vo.ArrivalReceiptVO;
import edu.nju.express.vo.OrderVO;

public class HallArrivalUI extends MainPanel implements MouseListener{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	int width = 900;
	int height = 600;
	HallController controller;
	HallReceiptBlService  receipt;
	JPanel mainpanel, panel;
	JButton  confirmBtn;
	ConfirmButton submitBtn;
	Image bg = (new ImageIcon("ui/image/hall/arrival.png")).getImage();
	JLabel dateLabel, fromLabel;
	DateComboBoxPanel dateBox;
	MyComboBox<String> fromBox;
	LabelTextField transferIdField;
	MyTablePanel table;
	ArrayList<OrderVO> orderList;
	
	static JScrollPane s = new JScrollPane();
	final MyScrollBarUI ui = new MyScrollBarUI();
	Font font = new Font("黑体", Font.PLAIN, 18);
	Color color = new Color(44, 62,80);
	
	String hall_id = LoginInfo.getUserID().substring(0, 6);
	
	public HallArrivalUI(HallController controller){
		this.controller = controller;
		this.receipt = controller.receipt;
		mainpanel = new JPanel();
		mainpanel.setLayout(null);
		mainpanel.setBounds(0,0,width,height);
		mainpanel.setVisible(true);
		mainpanel.setOpaque(false);
		
		initPanel();
		initScrollPane();
		initMargin();
		
		
		
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
		confirmBtn = new JButton();
		confirmBtn.setFont(new Font("Microsoft YaHei", Font.PLAIN, 15));
		confirmBtn.setBounds(530, 20, 80, 40);
		confirmBtn.setIcon(new ImageIcon("ui/image/hall/confirm0.png"));
		confirmBtn.setBorderPainted(false);
		confirmBtn.setContentAreaFilled(false);
		confirmBtn.addMouseListener(this);
		confirmBtn.addActionListener(new ActionListener(){

			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				if(!isFilled()){
					WarningDialog.show("温馨提示", "装车单编号不能为空");
				}
				else if(searchTransfer()==null){
					WarningDialog.show("T ^ T", "对不起，没找到您要的装车单");
				}
				else{
					//set panel with return value of createArrival
					generateData();
				}
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


		
		//dateLabel
		dateLabel = new JLabel("到达日期");
		dateLabel.setFont(font);
		dateLabel.setForeground(color);
		dateLabel.setBounds(110, 495, 90, 40);
		panel.add(dateLabel);
		
		//comboBox:year, month, day
		dateBox = new DateComboBoxPanel();
		dateBox.setBounds(115, 495, 500, 40);
		panel.add(dateBox);
		
		//fromLabel, fromBox
		fromLabel = new JLabel("出发地");
		fromLabel.setFont(font);
		fromLabel.setForeground(color);
		fromLabel.setBounds(130, 550, 80, 40);
		panel.add(fromLabel);
		
		fromBox = new MyComboBox<String>();
		String cityID = hall_id.substring(0, 3);
		ArrayList<String> fromList = new ArrayList<String>();
		
		fromList.add(Location.getStationLocation(cityID)+"中转站");
		for(int i=0; i<Location.getHallList(hall_id.substring(0, 3)).size(); i++){
			fromList.add(Location.getHallList(cityID).get(i));
		}
//		fromList = {"南京中转站","栖霞区营业厅","浦口区营业厅","鼓楼区营业厅","玄武区营业厅"};
		fromBox.removeAllItems();
		for(int i=0; i<fromList.size(); i++){
			fromBox.addItem(fromList.get(i));
		}
		fromBox.setSelectedItem(fromList.get(0));
		fromBox.setBounds(210, 550, 220, 30);
		panel.add(fromBox);
		
	}
	
	public void clearPanel(){
		transferIdField.setText("");
		
		dateBox.setToday();
		
		fromBox.setSelectedIndex(0);
		
		for(int i=table.getTableModel().getRowCount()-1; i>0; i++){
			table.getTableModel().removeRow(i);
		}
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
		submitBtn = new ConfirmButton();
		submitBtn.setBounds(424, 523, 100, 40);
		submitBtn.addMouseListener(this);
		submitBtn.addActionListener(new ActionListener(){

			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				if(!isFilled()){
					WarningDialog.show("提交内容不能为空", "请检查填写是否齐全");
				}else{
					for(int i=0; i<orderList.size(); i++){
						orderList.get(i).setGoodState(convert((String)table.getTable().getValueAt(i, 1)));
					}
					receipt.subArrivalReceipt(new ArrivalReceiptVO(transferIdField.getText(),
							dateBox.getDate(), (String)fromBox.getSelectedItem(),
							Location.getHallLocation(hall_id), orderList));
					WarningDialog.show("", "提交成功！");
					clearPanel();
				}
			}

		});
		mainpanel.add(submitBtn);
		
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
		if(e.getSource().equals(confirmBtn)){
			confirmBtn.setIcon(new ImageIcon("ui/image/hall/confirm1.png"));
		}
	}

	@Override
	public void mouseExited(MouseEvent e) {
		// TODO Auto-generated method stub
		if(e.getSource().equals(confirmBtn)){
			confirmBtn.setIcon(new ImageIcon("ui/image/hall/confirm0.png"));
		}
	}
	
	public ArrivalReceiptVO searchTransfer(){
		String searchId = "HallTransferReceipt"+transferIdField.getText();
		return receipt.createArrivalReceipt(searchId);
	}
	

	//生成托运单号
	public void generateData(){
		;
		orderList = new ArrayList<OrderVO>();
//		System.out.println(transferId);
		
		String dateStr = searchTransfer().getDate();
		String[] date = dateStr.split("/");
		dateBox.getYearComboBox().setSelectedItem(date[0]);
		dateBox.getMonthComboBox().setSelectedItem(date[1]);
		dateBox.getDayComboBox().setSelectedItem(date[2]);
		
		String from = searchTransfer().getFrom();
		
		
		fromBox.addItem(from);
		fromBox.setSelectedItem(from);
		
		//先清空table
		int tablelen = table.getTableModel().getRowCount();
		for(int i = tablelen-1; i>=0; i --){
			table.getTableModel().removeRow(i);
		}
		
		int length = searchTransfer().getOrderList().size();
		for(int i=0; i<length; i++){
			orderList.add(searchTransfer().getOrderList().get(i));
		}
		
		String[] row = new String[2];
		for(int i=0; i<length; i++){
			row[0] = orderList.get(i).getID();
			row[1] = "完整";
			table.getTableModel().addRow(row);
		}
		
	}
	
	public GoodsState convert(String goodState){
		switch(goodState){
		case "完整": return GoodsState.COMPLETE;
		case "损坏": return GoodsState.DAMAGED;
		default: return GoodsState.LOST;
		}
		
	}
	
	public boolean isFilled(){
		boolean transferId = (transferIdField.getText().trim().length()==0)?false:true;
		
		return transferId;
	}
	
	@Override
	protected void paintComponent(Graphics g) {
		g.drawImage(bg, 0, 0, null);
	}
}
