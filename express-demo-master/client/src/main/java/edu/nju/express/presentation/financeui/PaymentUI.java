package edu.nju.express.presentation.financeui;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;

import edu.nju.express.presentation.MainPanel;
import edu.nju.express.presentation.myUI.MyComboBox;
import edu.nju.express.presentation.myUI.MyTablePanel;
import edu.nju.express.vo.Paymentvo;

public class PaymentUI extends MainPanel {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private static int width = 900, height = 600;
	private static int x = 240, y = 50;
	private static int h = 75;

	private MyTablePanel table;
	private MyComboBox<String> style;
	private JButton calculate;

	private FinanceController controller;
	private ArrayList<Paymentvo> list;
	private PaymentUI ui;

	public PaymentUI(FinanceController c) {
		this.controller = c;
		ui = this;
		
		this.add(new FinanceGuide(c));
		
		showTablebyDate();

		JLabel sort = new JLabel("选择排序方式：");
		sort.setFont(new Font("黑体", Font.PLAIN, 15));
		sort.setForeground(Color.white);
		style = new MyComboBox<String>();
		style.addItem("日期");
		style.addItem("营业厅");
		style.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				System.out.println((String) style.getSelectedItem());
				switch ((String) style.getSelectedItem()) {
				case "日期":
					ui.remove(table);
					showTablebyDate();
					ui.validate();
					ui.repaint();
					break;
				case "营业厅":
					ui.remove(table);
					showTablebyHall();
					ui.validate();
					ui.repaint();
					break;
				}

			}

		});

		JPanel p = new JPanel();
		p.setOpaque(false);
		p.add(sort);
		p.add(style);
		p.setBounds(x, y + 30, 220, 30);
		this.add(p);

	}

	private void showTablebyDate() {
		initDatabyDate();
		String[] header = { "收款日期", "收款金额", "快递员编号", "订单编号" };
		table = new MyTablePanel(header);
		Object[] rowdata = new Object[4];

		for (int i = 0; i < list.size(); i++) {
			Paymentvo vo = list.get(i);
			rowdata[0] = vo.getDate();
			rowdata[1] = vo.getPay();
			rowdata[2] = vo.getCourier_id();
			rowdata[3] = vo.getOrder_id();
			table.getTableModel().addRow(rowdata);
		}
		table.setRowHeight(30);
		table.getTable().setPreferredScrollableViewportSize(new Dimension(width - x -80, height - y - h-70));
		table.setBounds(x + 30, y + h, width - x - 60, 400);
		this.add(table);
	}

	private void showTablebyHall() {
		initDatabyHall();
		String[] header = { "营业厅编号", "收款金额", "快递员编号", "收款日期" };
		table = new MyTablePanel(header);
		Object[] rowdata = new Object[4];

		for (int i = 0; i < list.size(); i++) {
			Paymentvo vo = list.get(i);
			table.getTableModel().addRow(rowdata);
		}
		this.add(table);
		table.setRowHeight(30);
		table.getTable().setPreferredScrollableViewportSize(new Dimension(width - x -80, height - y - h-70));
		table.setBounds(x + 30, y + h, width - x - 60, 400);
	}

	private void initDatabyDate() {
		list = new ArrayList<Paymentvo>();
		for (int i = 0; i < 20; i++)
			list.add(new Paymentvo("", 0, "", "", ""));
	}

	private void initDatabyHall() {
		list = new ArrayList<Paymentvo>();
		for (int i = 0; i < 20; i++)
			list.add(new Paymentvo("", 0, "", "", ""));
	}
}
