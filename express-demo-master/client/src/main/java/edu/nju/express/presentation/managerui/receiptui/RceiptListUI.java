package edu.nju.express.presentation.managerui.receiptui;

import java.util.ArrayList;

import javax.swing.JButton;
import javax.swing.JScrollPane;
import javax.swing.border.EmptyBorder;

import edu.nju.express.presentation.MainPanel;
import edu.nju.express.presentation.managerui.ManageController;
import edu.nju.express.presentation.myUI.MyCheckBoxTable;
import edu.nju.express.presentation.myUI.ReturnButton;
import edu.nju.express.vo.ReceiptVOBase;

public class RceiptListUI extends MainPanel {

	private static final long serialVersionUID = 1L;
	int width = 900;
	int height = 600;

	ManageController controller;
	ArrayList<Object[]> list;
	ArrayList<ReceiptVOBase> voList;

	MyCheckBoxTable table;
	JButton jbtApprove;
	JButton jbtReturn;

	public RceiptListUI(ManageController c) {
		controller = c;

		jbtReturn = new ReturnButton();
		jbtReturn.setLocation(10, 60);
		this.add(jbtReturn);
		jbtReturn.addActionListener(controller);
		jbtReturn.setActionCommand("ReceiptUI");

		refreshTable();
		
		JScrollPane s = new JScrollPane(table);
		/*s.setBorder(new EmptyBorder(0, 0, 0, 0));
		s.setOpaque(false);
		s.getViewport().setOpaque(false);*/
		s.setBounds(10, 90 + jbtReturn.getHeight(), width / 2, 400);
		s.setViewportBorder(new EmptyBorder(0, 0, 0, 0));
		s.setOpaque(false);
		s.getViewport().setOpaque(false);
		s.setColumnHeaderView(table.getTableHeader());
		s.getColumnHeader().setOpaque(false);
		s.setBorder(new EmptyBorder(0, 0, 0, 0));
		this.add(s);

		jbtApprove = new JButton("审批通过");
		jbtApprove.setBounds(s.getX() + s.getWidth() / 2 - 50, s.getHeight() + s.getY() + 30, 100, 30);
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
