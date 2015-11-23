package edu.nju.express.presentation.managerui.employeeui;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.FlowLayout;
import java.util.ArrayList;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.table.DefaultTableModel;

import edu.nju.express.common.Role;
import edu.nju.express.presentation.MyTablePanel;
import edu.nju.express.presentation.managerui.ManageController;
import edu.nju.express.presentation.managerui.ManageGuide;
import edu.nju.express.vo.EmployeeVO;

public class EmployeeListUI extends JPanel {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	ManageController controller;

	ArrayList<EmployeeVO> list;

	MyTablePanel table;
	DefaultTableModel model;
	ManageGuide guide;
	JPanel buttons;
	JButton jbtAdd;
	JButton jbtDelete;

	int width = 900, height = 600;
	int TABLE_ROW_HEIGHT = 30;

	public EmployeeListUI(ManageController c) {

		controller = c;
		this.setLayout(null);
		initGuide();
		initdata();
		initButtons();
		initTable();

	}

	private void initButtons() {
		buttons = new JPanel();
		buttons.setBounds(guide.getWidth(), 0, width - guide.getWidth(), (int) (width * 0.1));
		buttons.setLayout(new FlowLayout(FlowLayout.CENTER,
				(int)(0.15*buttons.getWidth()),(int)(0.4*buttons.getHeight())));

		jbtAdd = new JButton("新增员工");
		jbtAdd.setActionCommand("AddEmployee");
		jbtAdd.addActionListener(controller);

		jbtDelete = new JButton("删除员工");
		jbtDelete.setActionCommand("DismissEmployee");
		jbtDelete.addActionListener(controller);

		buttons.add(jbtAdd);
		buttons.add(jbtDelete);
		
		this.add(buttons);
		buttons.setOpaque(false);
	}

	private void initGuide() {
		guide = new ManageGuide(controller);
		this.add(guide);
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
		table.setBounds(guide.getWidth(), (int) (buttons.getHeight()), (int) (width - guide.getWidth()),
				(int) (height - buttons.getHeight()));

		model = table.getTableModel();
		for (int i = 0; i < list.size(); i++) {
			Object[] row = { list.get(i).getId(), list.get(i).getName(), list.get(i).getRole().getName() };
			model.addRow(row);
		}

		this.add(table);

	}

}