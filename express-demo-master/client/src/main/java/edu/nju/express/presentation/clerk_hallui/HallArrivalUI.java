package edu.nju.express.presentation.clerk_hallui;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.util.ArrayList;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;

import edu.nju.express.presentation.myUI.DateComboBoxPanel;
import edu.nju.express.presentation.myUI.MyComboBox;
import edu.nju.express.presentation.myUI.MyTablePanel;
import edu.nju.express.presentation.myUI.MyTextField;
import edu.nju.express.vo.HallTransferReceiptVO;

public class HallArrivalUI extends JPanel implements MouseListener{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	int width = 900;
	int height = 600;
	HallController controller;
	JPanel mainpanel;
	JButton submitBtn, saveOrderBtn, confirmBtn;
	JLabel bg;
	JLabel idLabel, dateLabel, yearLabel, monthLabel, dayLabel, fromLabel;
//	MyComboBox<String> yearBox, monthBox, dayBox;
	DateComboBoxPanel date;
	JLabel transferIdLabel;
	MyTextField idField, fromField;
	MyTextField transferIdField;
	MyTablePanel orderTable;
	ArrayList<String> orderList;
	
	public HallArrivalUI(HallController controller){
		this.controller = controller;
		mainpanel = new JPanel();
		mainpanel.setLayout(null);
		mainpanel.setBounds(0,0,width,height);
		mainpanel.setVisible(true);
		
//		initOrderContainer();
//		initReceiptPanel();
//		initMargin();
		JButton exit = new JButton(new ImageIcon("ui/button/X_darkgray.png"));
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
	
	//生成托运单号
	public void generateData(){
		this.orderList = new ArrayList<String>();
		
		//mock orderList
		for(int i=0; i<30; i++){
			orderList.add("1234567890");
		}
	}
	
	public void initOrderContainer(){
		JPanel panel = new JPanel();
		panel.setLayout(null);
		panel.setVisible(true);
		panel.setBackground(Color.BLACK);
		panel.setBounds(50, 50, 330, 450);
		
		//transferIdLabel
		transferIdLabel = new JLabel("请输入汽运编号：");
		transferIdLabel.setFont(new Font("Microsoft YaHei", Font.PLAIN, 15));
		transferIdLabel.setForeground(Color.white);
		transferIdLabel.setBounds(20, 20, 180, 30);
		panel.add(transferIdLabel);
				
		//transferIdField
		transferIdField = new MyTextField(19);
		transferIdField.setBounds(20, 60, 190, 30);
		panel.add(transferIdField);
		
		//confirmBtn
		confirmBtn = new JButton("确认");
		confirmBtn.setFont(new Font("Microsoft YaHei", Font.PLAIN, 15));
		confirmBtn.setBounds(220, 60, 80, 40);
		panel.add(confirmBtn);
		
		//orderTable
		String[] header = {"托运单号", "货物状态"};
		int[] columnWidth = {140, 140};
		String[] row = new String[2];
		orderTable = new MyTablePanel(header);
		orderTable.setRowHeight(30);
		orderTable.setColumnWidth(columnWidth);
		generateData();
		for(int i=0; i<orderList.size(); i++){
			row[0] = orderList.get(i);
			row[1] = "完整";
//			orderTable.getTable().addMouseListener(this);
			orderTable.getTable().editCellAt(i+1, 2);
			orderTable.getTableModel().addRow(row);
		}
		orderTable.setBounds(20, 120, 290, 290);
		orderTable.getTable().setPreferredScrollableViewportSize(new Dimension(290,290));
		panel.add(orderTable);


		//saveOrderBtn
		saveOrderBtn = new JButton("save");
		saveOrderBtn.setBounds(260, 410, 60, 30);
		panel.add(saveOrderBtn);
		
		mainpanel.add(panel);
	}
	
	public void initReceiptPanel(){
		JPanel panel = new JPanel();
		panel.setLayout(null);
		panel.setVisible(true);
		panel.setBackground(Color.BLACK);
		panel.setBounds(400, 50, 480, 450);
		
		//idLabel
		idLabel = new JLabel("到达单编号");
		idLabel.setFont(new Font("Microsoft YaHei", Font.PLAIN,15));
		idLabel.setForeground(Color.white);
		idLabel.setBounds(20, 20, 100, 30);
		panel.add(idLabel);
		
		//idField
		idField = new MyTextField(15);
		idField.setBounds(120, 20, 150, 30);
		panel.add(idField);
		
		//dateLabel
		dateLabel = new JLabel("装车日期");
		dateLabel.setFont(new Font("Microsoft YaHei", Font.PLAIN,15));
		dateLabel.setForeground(Color.white);
		dateLabel.setBounds(20, 70, 70, 30);
		panel.add(dateLabel);
		
		//comboBox:year, month, day
		date = new DateComboBoxPanel();
		date.setBounds(100, 70, 150, 30);
		panel.add(date);
		
		//fromLabel
		fromLabel = new JLabel("出发地");
		fromLabel.setForeground(Color.white);
		fromLabel.setFont(new Font("Microsoft YaHei", Font.PLAIN, 15));
		fromLabel.setBounds(20, 120, 70, 30);
		panel.add(fromLabel);
		
		//fromField
		fromField = new MyTextField(10);
		fromField.setBounds(120, 120, 150, 30);
		panel.add(fromField);
		
		mainpanel.add(panel);
	}
	
	
	
	public void initMargin(){
		JPanel panel = new JPanel();
		panel.setLayout(null);
		panel.setVisible(true);
		panel.setOpaque(false);
		panel.setBounds(0, 0, width, height);

		
		//submitBtn
		submitBtn = new JButton(new ImageIcon("ui/image/hall/submit0.png"));
		submitBtn.setBounds(50, 510, 90, 30);
		submitBtn.setOpaque(false);
		submitBtn.setBorderPainted(false);
		submitBtn.addMouseListener(this);
		submitBtn.addActionListener(controller);
		panel.add(submitBtn);
		
		mainpanel.add(panel);
	}
	
	//getvo()
	public HallTransferReceiptVO getTransferVO(){
		
		return null;
	}
	
	//returnvo
	
	

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
		if(e.getSource().equals(submitBtn))
			this.submitBtn.setIcon(new ImageIcon("ui/image/hall/submit1.png"));
	}

	@Override
	public void mouseExited(MouseEvent e) {
		// TODO Auto-generated method stub
		if(e.getSource().equals(submitBtn))
			this.submitBtn.setIcon(new ImageIcon("ui/image/hall/submit0.png"));
	}
	
	
}
