package edu.nju.express.presentation.financeui;

import java.awt.Dimension;
import java.util.ArrayList;

import javax.swing.ImageIcon;

import edu.nju.express.blservice.CostControlService;
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
	
	
	private MyTablePanel table;
	private FinanceController controller;
	private CostControlService costControlBL;
	private ArrayList<Balancevo> list;
	
	

	BalanceHistoryPanel(FinanceController c) {
		this.controller = c;
		
		FinanceGuide guide =new FinanceGuide(controller);
		guide.balance.setIcon(null);
		this.add(guide);
		this.bg = new ImageIcon("ui/image/finance/历史单据.png").getImage();
		
		costControlBL = controller.cost;
		ReturnButton jbtReturn = new ReturnButton();
		jbtReturn.addActionListener(controller);
		jbtReturn.setActionCommand("BalanceUI");
		this.add(jbtReturn);
		
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
		table.setRowHeight(30);
		int[]  cwidth = {150,100,100,100,100,176};
		table.setColumnWidth(cwidth);
		table.getTable().setPreferredScrollableViewportSize(new Dimension(726,390));
		table.setBounds(123, 106, 737, 426);
		this.add(table);
		
		
	}

	private void initData() {
		list = costControlBL.viewCostByDate();
	}
}
