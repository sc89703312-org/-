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

import edu.nju.express.blservice.HallReceiptBlService;
import edu.nju.express.blservice.OrderBLService;
import edu.nju.express.presentation.MainPanel;
import edu.nju.express.presentation.myUI.ConfirmButton;
import edu.nju.express.presentation.myUI.DateComboBoxPanel;
import edu.nju.express.presentation.myUI.LabelTextField;
import edu.nju.express.presentation.myUI.MyCheckBoxTable;
import edu.nju.express.presentation.myUI.MyScrollBarUI;
import edu.nju.express.presentation.myUI.WarningDialog;
import edu.nju.express.vo.OrderVO;

public class HallDeliverUI extends MainPanel implements MouseListener{

	/**
	 * 
	 */
	
	private static final long serialVersionUID = 1L;
	int width = 900;
	int height = 600;
	HallController controller;
	HallReceiptBlService receipt;
	OrderBLService order;
	JPanel mainpanel;
	JLabel addOrderLabel;
	MyCheckBoxTable checkTable;
	JLabel dateLabel;
	DateComboBoxPanel dateBox;
	LabelTextField  deliverIdField;
	boolean deliverErr;
	Image bg = (new ImageIcon("ui/image/hall/deliver.png")).getImage();
	ConfirmButton submitBtn;
		
	JScrollPane scrollpane = new JScrollPane();
	final MyScrollBarUI ui = new MyScrollBarUI();
	Font font = new Font("黑体", Font.PLAIN, 18);
	Color color = new Color(44, 62,80);
	Color areaColor = new Color(210, 232, 232);
	
	public HallDeliverUI(HallController controller){
		this.controller = controller;
		this.receipt = controller.receipt;
		this.order = controller.order;
		mainpanel = new JPanel();
		mainpanel.setBounds(0, 0, width, height);
		mainpanel.setLayout(null);
		mainpanel.setVisible(true);
		mainpanel.setOpaque(false);
		
		initPanel();
		initMargin();
		
		
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
//		idField = new LabelTextField("派件单编号",15);
//		idField.setBounds(120, 20, 300, 45);
//		panel.add(idField);

		dateLabel = new JLabel("派件日期");
		dateLabel.setFont(font);
		dateLabel.setForeground(color);
		dateLabel.setBounds(105, 80-45, 80, 45);
		panel.add(dateLabel);
		
		dateBox = new DateComboBoxPanel();
		dateBox.setBounds(110, 80-45, 500, 40);
		panel.add(dateBox);
		
		//即快递员
		deliverIdField = new LabelTextField("派送员  ",19);
		deliverIdField.setBounds(120, 135-45, 300, 45);
		panel.add(deliverIdField);
		
		addOrderLabel = new JLabel("请在此处勾选出本次装箱所有托运单号");
		addOrderLabel.setFont(font);
		addOrderLabel.setForeground(color);
		addOrderLabel.setBounds(20, 190, 400, 40);
		panel.add(addOrderLabel);
		
		
		String[] header = {"全选","订单号"};
		checkTable = new MyCheckBoxTable(header);
		initData();
		
		JScrollPane s = new JScrollPane(checkTable);
		s.setBounds(0, 240, 710, 325);
		s.setViewportBorder(new EmptyBorder(0, 0, 0, 0));
		s.setOpaque(false);
		s.getViewport().setOpaque(false);
		s.setColumnHeaderView(checkTable.getTableHeader());
		s.getColumnHeader().setOpaque(false);
		s.setBorder(new EmptyBorder(0, 0, 0, 0));
		s.getVerticalScrollBar().setUI(null);
		panel.add(s);
		
		
		scrollpane.setViewportView(panel);
		panel.setPreferredSize(new Dimension(723, 700));
		wrapScrollPane(scrollpane, ui);
		scrollpane.setBounds(130, 120, 720, 400);
		mainpanel.add(scrollpane);
	}
	
	public void clearPanel(){
		dateBox.setToday();
		
		deliverIdField.setText("");
		
		//checkTable
		for(int i = 0; i < checkTable.getRowCount(); i ++){
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
				}
				else if(!isError()){
					deliverIdField.setError();
					WarningDialog.show("数据格式错误", "派件员编号应该为8位数");
				}
				else{
					submit(deliverIdField.getText(), getSelectedOrders());
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
	}

	@Override
	public void mouseExited(MouseEvent e) {
		// TODO Auto-generated method stub
		
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
	
	public void submit(String id, ArrayList<OrderVO> orderlist){
		receipt.subDeliverReceipt(id, orderlist);;
	}
	
	public boolean isFilled(){
		boolean deliverId = (deliverIdField.getText().length()==0)?false: true;
		boolean order = (getSelectedOrders().size()==0)?false:true;
		return deliverId && order;
	}
	
	public boolean isError(){
		deliverErr = (deliverIdField.getText().trim().length()==8) ? true : false;
		return deliverErr;
	}

	@Override
	protected void paintComponent(Graphics g) {
		g.drawImage(bg, 0, 0, null);
	}
}
