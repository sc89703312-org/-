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
import javax.swing.JTextArea;
import javax.swing.ScrollPaneConstants;
import javax.swing.border.EmptyBorder;

import edu.nju.express.blservice.HallReceiptBlService;
import edu.nju.express.blservice.OrderBLService;
import edu.nju.express.common.ResultMessage;
import edu.nju.express.log.ui.warning.PromptDialog;
import edu.nju.express.presentation.myUI.DateComboBoxPanel;
import edu.nju.express.presentation.myUI.LabelTextField;
import edu.nju.express.presentation.myUI.MyCheckBoxTable;
import edu.nju.express.presentation.myUI.MyScrollBarUI;
import edu.nju.express.vo.ArrivalReceiptVO;
import edu.nju.express.vo.DeliverReceiptVO;
import edu.nju.express.vo.OrderVO;

public class HallDeliverUI extends JPanel implements MouseListener{

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
	JLabel bg;
	JButton exit, submitBtn;
		
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
		
		
		bg = new JLabel(new ImageIcon("ui/image/hall/deliver.png"));
		bg.setBounds(0, 0, width, height);
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
//		idField = new LabelTextField("派件单编号",15);
//		idField.setBounds(120, 20, 300, 45);
//		panel.add(idField);

		dateLabel = new JLabel("装车日期");
		dateLabel.setFont(font);
		dateLabel.setForeground(color);
		dateLabel.setBounds(90, 80-45, 80, 45);
		panel.add(dateLabel);
		
		dateBox = new DateComboBoxPanel();
		dateBox.setBounds(120, 80-45, 500, 40);
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
		submitBtn = new JButton("提交");
		submitBtn.setBounds(424, 523, 100, 40);
		submitBtn.addMouseListener(this);
		submitBtn.addActionListener(new ActionListener(){

			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				if(!isFilled()){
					PromptDialog.show("提交内容不能为空", "请检查填写是否齐全");
				}
				else{
					submit(deliverIdField.getText(), getSelectedOrders());
				}
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
		boolean deliverId = (deliverIdField.getText()==null)?false: true;
		boolean order = (getSelectedOrders().isEmpty())?false:true;
		return deliverId && order;
	}

}
