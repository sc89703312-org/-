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

import edu.nju.express.presentation.MainPanel;
import edu.nju.express.presentation.myUI.DateComboBoxPanel;
import edu.nju.express.presentation.myUI.MyComboBox;
import edu.nju.express.presentation.myUI.MySearchFieldPanel;
import edu.nju.express.presentation.myUI.MyTablePanel;
import edu.nju.express.vo.Paymentvo;

public class PaymentUI extends MainPanel {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private static Image bg = new ImageIcon("ui/image/bg1.png").getImage();
	static Font font = new Font("黑体", Font.PLAIN, 18);
	static Color color = new Color(44, 62,80);

	private MyTablePanel table;
	private DateComboBoxPanel date;
	private MySearchFieldPanel hall;
	private JButton calculate;

	private FinanceController controller;
	private ArrayList<Paymentvo> list;
	private PaymentUI ui;

	public PaymentUI(FinanceController c) {
		this.controller = c;
		ui = this;

		this.add(new FinanceGuide(c));

		showTable();

		JLabel selectDate = new JLabel("          按日期查看：");
		selectDate.setFont(font);
		selectDate.setForeground(color);
		date = new DateComboBoxPanel();
		date.getYearComboBox().addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {

			}

		});
		date.getMonthComboBox().addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {

			}

		});
		date.getDayComboBox().addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {

			}

		});
		
		JLabel selectHall = new JLabel("按营业厅查看：");
		selectHall.setFont(font);
		selectHall.setForeground(color);
		hall = new MySearchFieldPanel(controller);

		JPanel p = new JPanel();
		p.setOpaque(false);
		JPanel p1 = new JPanel();
		p1.setOpaque(false);
		p1.add(selectDate);
		p1.add(date);
		p.add(p1);
		
		JPanel p2 = new JPanel();
		p2.setOpaque(false);
		p2.add(selectHall);
		p2.add(hall);
		p.add(p2);
		p.setBounds(-120, 65, 800, 90);
		p.setLayout(new BoxLayout(p, BoxLayout.Y_AXIS));
		this.add(p);

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
		table.getTable().setPreferredScrollableViewportSize(new Dimension(716, 390));
		table.setBounds(128, 160, 727, 425);;
		
		this.add(table);
	}

	
	private void initData() {
		list = new ArrayList<Paymentvo>();
		for (int i = 0; i < 20; i++)
			list.add(new Paymentvo("", 1+i, "", "", ""));
	}

	@Override
	protected void paintComponent(Graphics g) {
		// TODO Auto-generated method stub
		super.paintComponent(g);
		g.drawImage(bg,0,0,null);
	}
	
}
