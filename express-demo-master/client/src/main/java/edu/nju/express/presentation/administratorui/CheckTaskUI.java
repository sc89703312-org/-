package edu.nju.express.presentation.administratorui;

import java.awt.Font;

import javax.swing.BoxLayout;
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

	int width = 900, height = 600;
	int y = 50;		//由标题栏高度决定

	AdministratorController controller;
	UserBlService us;
	JPanel p;
	MyTablePanel table1, table2;
	JLabel label1, label2;

	int LABEL_HEIGHT = 6;
	int ROW_HEIGHT = 20;
	Font FONT = new Font("微软雅黑",Font.PLAIN,15);

	public CheckTaskUI(AdministratorController c) {
		controller = c;
		this.setLayout(null);
		this.setOpaque(false);
		initGuide();
		initTable();
	}

	private void initTable() {
		p = new JPanel();
		p.setOpaque(false);
		p.setBounds((int) (width * 0.2), y, (int) (width * 0.8), height);
		p.setLayout(new BoxLayout(p, BoxLayout.Y_AXIS));
		
		this.add(p);

		String[] header1 = { "ID", "姓名", "职务" };
		table1 = new MyTablePanel(header1);
		table1.setRowHeight(ROW_HEIGHT);
		
		String[] header2 = { "ID" };
		table2 = new MyTablePanel(header2);
		table2.setRowHeight(ROW_HEIGHT);
		
		initData();

		p.add(table1);
		p.add(table2);
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
