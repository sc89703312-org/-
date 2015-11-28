package edu.nju.express.presentation.managerui.receiptui;

import java.util.ArrayList;

import javax.swing.JButton;
import javax.swing.JScrollPane;
import javax.swing.border.EmptyBorder;

import edu.nju.express.presentation.MainPanel;
import edu.nju.express.presentation.managerui.ManageController;
import edu.nju.express.presentation.managerui.ManageGuide;
import edu.nju.express.presentation.myUI.MyCheckBoxTable;
import edu.nju.express.vo.ReceiptVOBase;

public class ReceiptApprovalUI extends MainPanel {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	static int width = 900;
	static int height = 600;
	static int x = 240;
	static int y = 50;

	ManageController controller;
	ArrayList<Object[]> list;
	ArrayList<ReceiptVOBase> voList;

	MyCheckBoxTable table;
	JButton jbtApprove;

	public ReceiptApprovalUI(ManageController c) {
		controller = c;

		refreshTable();

		this.add(new ManageGuide(c));

		JScrollPane s = new JScrollPane(table);
		s.setBounds(x + 30, y + 50, width - x - 60, height - y - 120);
		s.setViewportBorder(new EmptyBorder(0, 0, 0, 0));
		s.setOpaque(false);
		s.getViewport().setOpaque(false);
		s.setColumnHeaderView(table.getTableHeader());
		s.getColumnHeader().setOpaque(false);
		s.setBorder(new EmptyBorder(0, 0, 0, 0));
		// s.getVerticalScrollBar().setUI(null);
		this.add(s);

		jbtApprove = new JButton("审批通过");
		jbtApprove.setBounds(x+290, 535, 80, 30);
		jbtApprove.setActionCommand("Approve");
		jbtApprove.addActionListener(controller);
		this.add(jbtApprove);
	}

	private void initData() {
		Object[] data1 = { false, "到达单", "123456", "2015/11/23" };
		Object[] data2 = { false, "到达单", "123000", "2015/11/23" };
		Object[] data3 = { false, "到达单", "123111", "2015/11/23" };
		for (int i = 0; i < 10; i++) {
			table.getTableModel().addRow(data1);
			table.getTableModel().addRow(data2);
			table.getTableModel().addRow(data3);
		}
	}

	private void refreshTable() {
		table = new MyCheckBoxTable();
		initData();
	}

	public ArrayList<String> getIDtoApprove() {
		refreshTable();
		return table.getSelectedID();
	}
}