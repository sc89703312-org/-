package edu.nju.express.presentation.administratorui;

import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JPanel;

import edu.nju.express.presentation.MainPanel;
import edu.nju.express.presentation.myUI.MyTablePanel;
import edu.nju.express.presentation.myUI.RefreshButton;
import edu.nju.express.vo.UserMessageVO;

public class CheckTaskUI extends MainPanel {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	static int width = 900, height = 600;
	static int y = 50;
	static int LABEL_HEIGHT = 6;
	static int ROW_HEIGHT = 30;
	static int x = 94;
	static int h = 50;
	private final Image bg = new ImageIcon("ui/image/admin/查看任务.png").getImage();

	AdministratorController controller;
	ArrayList<UserMessageVO> list;
	AdministerGuide guide;
	JPanel p;
	MyTablePanel table1, table2;
	JLabel label1, label2;

	public CheckTaskUI(AdministratorController c) {
		controller = c;
		initGuide();
		initTable();
		RefreshButton refresh = new RefreshButton();
		refresh.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				refresh();
			}
		});
		this.add(refresh);
	}

	private void initTable() {

		String[] header1 = { "ID", "姓名", "职务" };
		table1 = new MyTablePanel(header1);
		table1.setRowHeight(ROW_HEIGHT);

		String[] header2 = { "ID" };
		table2 = new MyTablePanel(header2);
		table2.setRowHeight(ROW_HEIGHT);

		initData();
		table1.getTable().setPreferredScrollableViewportSize(new Dimension(715, 120));
		table1.setBounds(128, 107, 726, 160);
		table2.getTable().setPreferredScrollableViewportSize(new Dimension(715, 120));
		table2.setBounds(128, 300, 726, 160);
		this.add(table1);
		this.add(table2);
	}

	private void refresh(){
		int n = table1.getTable().getRowCount();
		for(int i =0 ;i<n;i++){
			table1.getTableModel().removeRow(0);
		}
		n = table2.getTable().getRowCount();
		for(int i =0 ;i<n;i++){
			table2.getTableModel().removeRow(0);
		}
		initData();
		guide.refreshMessage();
	}
	
	private void initData() {
		list = controller.getUserMessageList();
		String[] rowdata;

		for (UserMessageVO vo : list) {

			switch (vo.getOperation()) {
			case add:
				rowdata = new String[3];
				rowdata[0] = vo.getId();
				rowdata[1] = vo.getName();
				rowdata[2] = vo.getRole().getName();
				table1.getTableModel().addRow(rowdata);
				break;
			case delete:
				rowdata = new String[1];
				rowdata[0] = vo.getId();
				table2.getTableModel().addRow(rowdata);
				break;
			}
		}
	}

	private void initGuide() {
		guide = new AdministerGuide(controller);
		this.add(guide);
	}
	
	@Override
	protected void paintComponent(Graphics g) {
		g.drawImage(bg, 0, 0, null);
	}
}
