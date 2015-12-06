package edu.nju.express.presentation.managerui;

import java.util.ArrayList;

import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JScrollPane;
import javax.swing.border.EmptyBorder;

import edu.nju.express.presentation.MainPanel;
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
	private static Icon img1 = new ImageIcon("ui/button/approve1.png");
	private static Icon img2 = new ImageIcon("ui/button/approve2.png");
	
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
		s.setBounds(128,112,727,420);
		s.setViewportBorder(new EmptyBorder(0, 0, 0, 0));
		s.setOpaque(false);
		s.getViewport().setOpaque(false);
		s.setColumnHeaderView(table.getTableHeader());
		s.getColumnHeader().setOpaque(false);
		s.setBorder(new EmptyBorder(0, 0, 0, 0));
		s.getVerticalScrollBar().setUI(null);
		this.add(s);

		jbtApprove = new JButton(img1);
		jbtApprove.setRolloverIcon(img2);
		jbtApprove.setContentAreaFilled(false);
		jbtApprove.setBorderPainted(false);
		jbtApprove.setBounds(450,537,80,30);
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
		String[] header= { "全选", "单据种类", "单据编号", "提交时间" };
		table = new MyCheckBoxTable(header);
		initData();
	}

	public ArrayList<String> getIDtoApprove() {
		refreshTable();
		return table.getSelectedID();
	}
}