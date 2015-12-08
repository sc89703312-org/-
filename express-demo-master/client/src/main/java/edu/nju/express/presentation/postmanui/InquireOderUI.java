package edu.nju.express.presentation.postmanui;

import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Image;
import java.util.ArrayList;

import javax.swing.ImageIcon;

import edu.nju.express.presentation.MainPanel;
import edu.nju.express.presentation.myUI.MySearchFieldPanel;
import edu.nju.express.presentation.myUI.MyTablePanel;
import edu.nju.express.vo.OrderVO;

public class InquireOderUI extends MainPanel {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private static final Image bg = new ImageIcon("ui/image/bg1.png").getImage();
	MyTablePanel table;
	MySearchFieldPanel search;

	PostmanController controller;
	ArrayList<OrderVO> list;

	public InquireOderUI(PostmanController c) {

		controller = c;
		initData();

		this.add(new PostmanGuide(c));

		search = new MySearchFieldPanel(c);
		search.setBounds(380, 68, 400, 40);
		search.setActionCommand("SearchOrder");
		this.add(search);

		String[] header = { "订单编号", "报价", "预计时间", "包装费", "到达状态" };
		table = new MyTablePanel(header);
		String[] rowData = new String[5];
		OrderVO vo;
		for (int i = 0; i < list.size(); i++) {
			vo = list.get(i);
			rowData[0] = vo.getID();
			rowData[1] = vo.getTotalCost() + "";
			rowData[2] = vo.getExpectedTime();
			rowData[3] = vo.getPkgCost() + "";
			rowData[4] = vo.getState().toString();
			table.getTableModel().addRow(rowData);
		}
		table.setRowHeight(30);
		table.getTable().setPreferredScrollableViewportSize(new Dimension(715, 390));
		table.setBounds(128, 112, 727, 422);
		this.add(table);
	}

	private void initData() {
		list = controller.getOrderList();
	}

	public String getOrder() {
		return search.getText();
	}

	public void addRow(OrderVO vo) {
		int n = table.getTable().getRowCount();
		for (int i = 0; i < n; i++)
			table.getTableModel().removeRow(0);
		String[] rowData = new String[5];
		rowData[0] = vo.getID();
		rowData[1] = vo.getTotalCost() + "";
		rowData[2] = vo.getExpectedTime();
		rowData[3] = vo.getPkgCost() + "";
		rowData[4] = vo.getState().toString();
		table.getTableModel().addRow(rowData);

	}
	
	@Override
	protected void paintComponent(Graphics g) {
		// TODO Auto-generated method stub
		super.paintComponent(g);
		g.drawImage(bg,0, 0, null);
	}
}
