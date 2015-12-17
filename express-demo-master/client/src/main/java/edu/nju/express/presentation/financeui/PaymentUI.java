package edu.nju.express.presentation.financeui;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

import javax.swing.BoxLayout;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;

import edu.nju.express.blservice.ViewPaymentService;
import edu.nju.express.presentation.MainPanel;
import edu.nju.express.presentation.myUI.DateComboBoxPanel;
import edu.nju.express.presentation.myUI.MyButton;
import edu.nju.express.presentation.myUI.MyComboBox;
import edu.nju.express.presentation.myUI.MySearchFieldPanel;
import edu.nju.express.presentation.myUI.MyTablePanel;
import edu.nju.express.vo.Paymentvo;

public class PaymentUI extends MainPanel implements ActionListener{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	static Font font = new Font("黑体", Font.PLAIN, 18);
	static Color color = new Color(44, 62,80);

	private MyTablePanel table;
	private DateComboBoxPanel date;
	private MySearchFieldPanel hall;
	private JButton calculate;
	private MyButton hallButton;
    private ViewPaymentService viewBL;
	private FinanceController controller;
	private ArrayList<Paymentvo> list;
	private PaymentUI ui;

	public PaymentUI(FinanceController c) {
		this.controller = c;
		viewBL = c.view;
		ui = this;

		FinanceGuide guide =new FinanceGuide(controller);
		guide.payment.setIcon(null);
		this.add(guide);
		this.bg = new ImageIcon("ui/image/finance/结算管理.png").getImage();

		showTable();

		JLabel selectDate = new JLabel("          按日期查看：");
		selectDate.setFont(font);
		selectDate.setForeground(color);
		date = new DateComboBoxPanel();
		date.getYearComboBox().addActionListener(this);
		date.getMonthComboBox().addActionListener(this);
		date.getDayComboBox().addActionListener(this);
		
//		
//		hallButton = new MyButton(404, 115, 35, 35);
//		hallButton.setVisible(true);
//		hallButton.setOpaque(false);
//		hallButton.addActionListener(this);
//		this.add(hallButton);
		
		
		JLabel selectHall = new JLabel("按营业厅查看：");
		selectHall.setFont(font);
		selectHall.setForeground(color);
		hall = new MySearchFieldPanel(controller);
		hall.setBounds(251,120,200, 33);
		hall.button.addActionListener(this);
		this.add(hall);

		
		
		
		JPanel p1 = new JPanel();
		p1.setOpaque(false);
		p1.add(selectDate);
		p1.add(date);
		
		JPanel p2 = new JPanel();
		p2.setOpaque(false);
		p2.add(selectHall);
		p2.add(hall);
		
		p1.setBounds(-40,78,650,45);
		p2.setBounds(34,130,500,45);
		this.add(p1);
		this.add(p2);

	}

	private void showTable() {
		initData();
		String[] header = { "收款日期", "收款金额", "快递员编号", "订单编号" };
		table = new MyTablePanel(header);

		Object[] rowdata = new Object[4];
		double sum = 0;
		for (int i = 0; i < list.size(); i++) {
			Paymentvo vo = list.get(i);
			rowdata[0] = vo.getDate();
			rowdata[1] = vo.getPay();
			sum += (double) rowdata[1];
			rowdata[2] = vo.getCourier_id();
			rowdata[3] = vo.getOrder_id();
			table.getTableModel().addRow(rowdata);
		}
		Object[] last = {"总计",sum,"",""};
		table.getTableModel().addRow(last);
		table.setRowHeight(30);
		table.getTable().setPreferredScrollableViewportSize(new Dimension(716, 370));
		table.setBounds(128, 180, 727, 405);;
		
		this.add(table);
	}

	
	private void initData() {
		list = viewBL.getAll();
		
	}

	
	
	
	public void clearTable(){
		
		
		for(int i=0;i<=list.size();i++)
			table.getTableModel().removeRow(0);
		
	}
	
	
	@Override
	public void actionPerformed(ActionEvent e) {
		


		clearTable();

		
		
		if(e.getSource()!=hall.button){
		list = viewBL.viewByDate(date.getDate());
		}else {
			list = viewBL.viewByHall(hall.getText());
		}
		
		Object[] rowdata = new Object[4];
		double sum = 0;
		for (int i = 0; i < list.size(); i++) {
			Paymentvo vo = list.get(i);
			rowdata[0] = vo.getDate();
			rowdata[1] = vo.getPay();
			sum += (double) rowdata[1];
			rowdata[2] = vo.getCourier_id();
			rowdata[3] = vo.getOrder_id();
			table.getTableModel().addRow(rowdata);
		}
		Object[] last = {"总计",sum,"",""};
		table.getTableModel().addRow(last);
	
	}
	
	
	
	
}
