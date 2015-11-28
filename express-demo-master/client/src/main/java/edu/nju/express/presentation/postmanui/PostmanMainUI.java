package edu.nju.express.presentation.postmanui;

import java.awt.Dimension;
import java.util.ArrayList;

import edu.nju.express.common.ReceiptState;
import edu.nju.express.presentation.MainPanel;
import edu.nju.express.presentation.myUI.MyTablePanel;
import edu.nju.express.vo.OrderVOforPostmanShow;

public class PostmanMainUI extends MainPanel {
	private static final long serialVersionUID = 1L;

	static int width = 900, height = 600;
	static int y = 50; // 由标题栏高度决定
	static int x = 240; // 由导航栏宽度决定

	MyTablePanel table;

	PostmanController controller;
	ArrayList<OrderVOforPostmanShow> list;

	public PostmanMainUI(PostmanController c) {

		controller = c;
		initData();

		this.setOpaque(false);
		this.setLayout(null);
		this.add(new PostmanGuide(controller));

		String[] header = { "订单编号", "日期", "报价", "预计时间", "包装费", "审批状态" };
		table = new MyTablePanel(header);
		String[] rowData = new String[6];
		OrderVOforPostmanShow vo;
		for (int i = 0; i < list.size(); i++) {
			vo = list.get(i);
			rowData[0] = vo.getId();
			rowData[1] = vo.getDate();
			rowData[2] = vo.getTotalCost() + "";
			rowData[3] = vo.getExpectedTime();
			rowData[4] = vo.getPkgCost() + "";
			rowData[5] = vo.getState().getName();
			table.getTableModel().addRow(rowData);
		}
		table.setRowHeight(30);
		table.getTable().setPreferredScrollableViewportSize(new Dimension(width - x -80, height - y -95));
		table.setBounds(x+30, y+30, width - x-60,height - y-60);
		this.add(table);
	}

	private void initData() {
		list = new ArrayList<OrderVOforPostmanShow>();
		for (int i = 0; i < 50; i++)
			list.add(new OrderVOforPostmanShow("1234567890", "2015/12/01", 20.0, "2015/12/05", 1,
					ReceiptState.APPROVED));
	}

}
