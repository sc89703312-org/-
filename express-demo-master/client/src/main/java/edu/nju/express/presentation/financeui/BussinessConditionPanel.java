package edu.nju.express.presentation.financeui;

import java.awt.Dimension;
import java.util.ArrayList;

import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import edu.nju.express.common.Item;
import edu.nju.express.presentation.MainPanel;
import edu.nju.express.presentation.myUI.LabelTextField;
import edu.nju.express.presentation.myUI.MyTablePanel;
import edu.nju.express.presentation.myUI.MyTextField;
import edu.nju.express.vo.Balancevo;
import edu.nju.express.vo.Paymentvo;

public class BussinessConditionPanel extends MainPanel {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private static Icon search1 = new ImageIcon("ui/button/searchbutton1.png");
	private static Icon search2 = new ImageIcon("ui/button/searchbutton2.png");

	private JPanel date;
	private MyTextField date1;
	private LabelTextField date2;
	private JButton search;
	private MyTablePanel tableB, tableP;

	private ArrayList<Balancevo> listB;
	private ArrayList<Paymentvo> listP;

	public BussinessConditionPanel(FinanceController controller) {

		this.add(new FinanceGuide(controller));
		
		date = new JPanel();
		date.setOpaque(false);
		date.setBounds(250, 110, 500, 60);
		date1 = new MyTextField(0);
		date2 = new LabelTextField("- ", 0);
		date.add(date1);
		date.add(date2);
		search = new JButton(search1);
		search.setContentAreaFilled(false);
		search.setFocusPainted(false);
		search.setBorder(new EmptyBorder(0, 0, 0, 0));
		search.setRolloverIcon(search2);
		search.addActionListener(controller);
		search.setActionCommand("SearchList");
		date.add(search);
		this.add(date);

		initData();

		initTableB();

		initTableP();
	}

	private void initTableP() {
		String[] header = { "收款日期", "收款金额", "快递员编号", "订单编号" };
		tableP = new MyTablePanel(header);
		Object[] rowdata = new Object[6];
		Balancevo vo;
		for (int i = 0; i < listB.size(); i++) {
			vo = listB.get(i);
			rowdata[0] = vo.getDate();
			rowdata[1] = vo.getMoney();
			rowdata[2] = vo.getName();
			rowdata[3] = vo.getBanking();
			rowdata[4] = vo.getItem().getName();
			rowdata[5] = vo.getRemark();
			tableP.getTableModel().addRow(rowdata);
		}
		tableP.setRowHeight(28);
		tableP.getTable().setPreferredScrollableViewportSize(new Dimension(343, 390));
		tableP.setBounds(128, 165, 335, 405);
		this.add(tableP);
	}

	private void initTableB() {
		String[] header = { "付款日期", "付款金额", "付款人", "付款账号", "条目", "备注" };
		tableB = new MyTablePanel(header);
		Object[] rowdata = new Object[6];
		Balancevo vo;
		for (int i = 0; i < listB.size(); i++) {
			vo = listB.get(i);
			rowdata[0] = vo.getDate();
			rowdata[1] = vo.getMoney();
			rowdata[2] = vo.getName();
			rowdata[3] = vo.getBanking();
			rowdata[4] = vo.getItem().getName();
			rowdata[5] = vo.getRemark();
			tableB.getTableModel().addRow(rowdata);
		}
		tableB.setRowHeight(28);
		tableB.getTable().setPreferredScrollableViewportSize(new Dimension(383, 390));
		tableB.setBounds(471, 165, 383, 405);
		this.add(tableB);
	}

	private void initData() {
		listB = new ArrayList<Balancevo>();
		for (int i = 0; i < 30; i++) {
			listB.add(new Balancevo("2015/11/28", 1000, "Oraisdy", "62220212345689876", Item.RENT, "XXXXXX"));
		}

		listP = new ArrayList<Paymentvo>();
		for (int i = 0; i < 30; i++) {
			listP.add(new Paymentvo("", 0, "", "", ""));
		}
	}

}
