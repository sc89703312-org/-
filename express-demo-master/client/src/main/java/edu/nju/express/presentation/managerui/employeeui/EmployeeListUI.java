package edu.nju.express.presentation.managerui.employeeui;
import java.awt.Color;
import java.util.ArrayList;

import javax.swing.JPanel;
import javax.swing.table.DefaultTableModel;

import edu.nju.express.common.Role;
import edu.nju.express.presentation.MyTablePanel;
import edu.nju.express.vo.EmployeeVO;

public class EmployeeListUI extends JPanel {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	MyTablePanel table;
	DefaultTableModel model;
	ArrayList<EmployeeVO> list;
	Color headerColor;
	Color lineColor;

	public EmployeeListUI() {
		list = new ArrayList<EmployeeVO>();
		for (int i = 0; i < 20; i++){
			list.add(new EmployeeVO("141250030", "q", Role.ACCOUNTANT));
			list.add(new EmployeeVO("141250030", "dy", Role.ACCOUNTANT));
		}

		initTable();
		
	}

	private void initTable() {
		String[] header = { "ID", "����", "ְ��" };
		table = new MyTablePanel(header);
		
		model = table.getTableModel();
		for (int i = 0; i < list.size(); i++) {
			Object[] row = { list.get(i).getId(), list.get(i).getName(), list.get(i).getRole() };
			model.addRow(row);
		}
		
		this.add(table);

	}


}