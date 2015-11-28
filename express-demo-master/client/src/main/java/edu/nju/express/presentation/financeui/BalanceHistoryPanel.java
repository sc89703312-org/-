package edu.nju.express.presentation.financeui;

import java.awt.Dimension;
import java.util.ArrayList;

import edu.nju.express.common.Item;
import edu.nju.express.presentation.MainPanel;
import edu.nju.express.presentation.myUI.MyTablePanel;
import edu.nju.express.presentation.myUI.ReturnButton;
import edu.nju.express.vo.Balancevo;

public class BalanceHistoryPanel extends MainPanel {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private static int width = 900, height = 600;
	private static int x = 240, y = 50;
	private static int h = 75;
	
	private FinanceController controller;
	
	private ReturnButton jbtRe;
	private MyTablePanel table;
	
	private ArrayList<Balancevo> list;

	BalanceHistoryPanel(FinanceController c) {
		controller = c;
		
		jbtRe = new ReturnButton();
		jbtRe.setLocation(20, 70);
		jbtRe.setActionCommand("BalanceUI");
		jbtRe.addActionListener(controller);
		this.add(jbtRe);
		
		initTable();
	}

	private void initTable() {
		initData();
		String[] header = {"付款日期","付款金额","付款人","付款账号","条目","备注"};
		table  = new MyTablePanel(header);
		Object[] rowdata = new Object[6];
		Balancevo vo;
		for(int i = 0;i<list.size();i++){
			vo=list.get(i);
			rowdata[0]=vo.getDate();
			rowdata[1]=vo.getMoney();
			rowdata[2]=vo.getName();
			rowdata[3]=vo.getBanking();
			rowdata[4]=vo.getItem().getName();
			rowdata[5]=vo.getRemark();
			table.getTableModel().addRow(rowdata);
		}
		table.setRowHeight(35);
		int[]  cwidth = {100,80,80,250,80,150};
		table.setColumnWidth(cwidth);
		table.getTable().setPreferredScrollableViewportSize(new Dimension(740,450));
		table.setBounds(80, 120,740,450);
		this.add(table);
	}

	private void initData() {
		list = new ArrayList<Balancevo>();
		for(int i =0;i<30;i++){
			list.add(new Balancevo("2015/11/28", 1000, "Oraisdy", "62220212345689876", Item.RENT, "XXXXXX"));
		}
	}
}
