package edu.nju.express.presentation.managerui;

import java.awt.Dimension;
import java.util.ArrayList;

import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JPanel;
import javax.swing.table.DefaultTableModel;

import edu.nju.express.common.Role;
import edu.nju.express.presentation.MainPanel;
import edu.nju.express.presentation.myUI.MyTablePanel;
import edu.nju.express.vo.EmployeeVO;

public class EmployeeListUI extends MainPanel {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private static Icon add1 = new ImageIcon("ui/button/addemployee1.png");
	private static Icon add2 = new ImageIcon("ui/button/addemployee2.png");
	private static Icon delete1 = new ImageIcon("ui/button/deleteemployee1.png");
	private static Icon delete2 = new ImageIcon("ui/button/deleteemployee2.png");

	ManageController controller;

	ArrayList<EmployeeVO> list;

	MyTablePanel table;
	DefaultTableModel model;
	JPanel buttons;
	JButton jbtAdd;
	JButton jbtDelete;

	private static int TABLE_ROW_HEIGHT = 30;

	public EmployeeListUI(ManageController c) {

		controller = c;
		initGuide();
		initdata();
		initButtons();
		initTable();
		
		this.setOpaque(false);

	}

	private void initButtons() {
		jbtAdd = new JButton(add1);
		jbtAdd.setRolloverIcon(add2);
		jbtAdd.setContentAreaFilled(false);
		jbtAdd.setBorderPainted(false);
		jbtAdd.setBounds(370,537,80,30);
		jbtAdd.setActionCommand("AddEmployeeUI");
		jbtAdd.addActionListener(controller);

		jbtDelete = new JButton(delete1);
		jbtDelete.setRolloverIcon(delete2);
		jbtDelete.setContentAreaFilled(false);
		jbtDelete.setBorderPainted(false);
		jbtDelete.setBounds(530,537,80,30);
		jbtDelete.setActionCommand("DismissEmployeeUI");
		jbtDelete.addActionListener(controller);

		this.add(jbtAdd);
		this.add(jbtDelete);
	}

	private void initGuide() {
		this.add(new ManageGuide(controller));
	}

	private void initdata() {
		list = new ArrayList<EmployeeVO>();
		for (int i = 0; i < 20; i++) {
			list.add(new EmployeeVO("141250030", "q", Role.ACCOUNTANT));
			list.add(new EmployeeVO("141250030", "dy", Role.ACCOUNTANT));
		}
	}

	private void initTable() {
		String[] header = { "ID", "姓名", "职务" };
		table = new MyTablePanel(header);
		table.setRowHeight(TABLE_ROW_HEIGHT);
		table.getTable().setPreferredScrollableViewportSize(new Dimension(715,390));
		table.setBounds(128,107,726,425);

		model = table.getTableModel();
		for (int i = 0; i < list.size(); i++) {
			Object[] row = { list.get(i).getId(), list.get(i).getName(), list.get(i).getRole().getName() };
			model.addRow(row);
		}

		this.add(table);

	}

}