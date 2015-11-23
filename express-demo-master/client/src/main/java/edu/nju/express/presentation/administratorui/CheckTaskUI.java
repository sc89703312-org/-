package edu.nju.express.presentation.administratorui;

import java.awt.Dimension;
import java.awt.Font;

import javax.swing.BoxLayout;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.border.EmptyBorder;
import javax.swing.border.TitledBorder;

import edu.nju.express.blservice.UserBlService;
import edu.nju.express.presentation.MainPanel;
import edu.nju.express.presentation.myUI.MyTable;

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
	MyTable table1, table2;
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
		table1 = new MyTable(header1);
		table1.setRowHeight(ROW_HEIGHT);
		JScrollPane s1 = new JScrollPane(table1);
		s1.setBorder(new TitledBorder(new EmptyBorder(getInsets()), "需要新增的账号:", 
				TitledBorder.DEFAULT_JUSTIFICATION,
				TitledBorder.DEFAULT_POSITION, FONT));
		s1.setPreferredSize(new Dimension(s1.getWidth(),4*ROW_HEIGHT));
		s1.setOpaque(false);
		s1.getViewport().setOpaque(false);
		
		String[] header2 = { "ID" };
		table2 = new MyTable(header2);
		table2.setRowHeight(ROW_HEIGHT);
		JScrollPane s2 = new JScrollPane(table2);
		s2.setBorder(new TitledBorder(new EmptyBorder(getInsets()), "需要删除的账号:", 
				TitledBorder.DEFAULT_JUSTIFICATION,
				TitledBorder.DEFAULT_POSITION, FONT));
		s2.setOpaque(false);
		s2.getViewport().setOpaque(false);
		
		initData();

		p.add(s1);
		p.add(s2);
	}

	
	private void initData() {
		String[] rowdata = { "141250030", "dy", "daef" };
		table1.getTableModel().addRow(rowdata);

		String[] data = { "141250030" };
		table2.getTableModel().addRow(data);
	}

	private void initGuide() {
		this.add(new AdministerGuide(controller));
	}
}
