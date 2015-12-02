package edu.nju.express.presentation.administratorui;

import java.awt.Dimension;

import javax.swing.JLabel;
import javax.swing.JPanel;

import edu.nju.express.blservice.UserBlService;
import edu.nju.express.presentation.MainPanel;
import edu.nju.express.presentation.myUI.MyTablePanel;

public class CheckTaskUI extends MainPanel {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	static int width = 900, height = 600;
	static int y = 50;		
	static int LABEL_HEIGHT = 6;
	static int ROW_HEIGHT = 30;
	static int x=94;
	static int h=50;
	
	AdministratorController controller;
	UserBlService us;
	JPanel p;
	MyTablePanel table1, table2;
	JLabel label1, label2;



	public CheckTaskUI(AdministratorController c) {
		controller = c;
		this.setLayout(null);
		this.setOpaque(false);
		initGuide();
		initTable();
	}

	private void initTable() {

		String[] header1 = { "ID", "姓名", "职务" };
		table1 = new MyTablePanel(header1);
		table1.setRowHeight(ROW_HEIGHT);
		
		String[] header2 = { "ID" };
		table2 = new MyTablePanel(header2);
		table2.setRowHeight(ROW_HEIGHT);
		
		initData();
		table1.getTable().setPreferredScrollableViewportSize(new Dimension(726, 120));
		table1.setBounds(128, 107, 726, 150);
		table2.getTable().setPreferredScrollableViewportSize(new Dimension(726, 120));
		table2.setBounds(128, 300, 726, 150);
		this.add(table1);
		this.add(table2);
	}

	
	private void initData() {
		String[] rowdata = { "141250030", "dy", "daef" };
		table1.getTableModel().addRow(rowdata);
		table1.getTableModel().addRow(rowdata);
		table1.getTableModel().addRow(rowdata);
		table1.getTableModel().addRow(rowdata);
		table1.getTableModel().addRow(rowdata);
		table1.getTableModel().addRow(rowdata);

		String[] data = { "141250030" };
		table2.getTableModel().addRow(data);
		
	}

	private void initGuide() {
		this.add(new AdministerGuide(controller));
	}
}
