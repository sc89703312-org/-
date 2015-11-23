package edu.nju.express.presentation;

import java.awt.Color;
import java.awt.Component;
import java.awt.Dimension;
import java.awt.Font;

import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.JTableHeader;

public class MyTablePanel extends JPanel {

	private static final long serialVersionUID = 1L;
	int ROW_HEIGHT = 40;
	int WIDTH = 600;
	int HEIGHT = 400;
	Color headerColor = new Color(49, 121, 177);
	Color foreColor = new Color(0, 0, 0);
	Color backColor1 = new Color(255, 255, 255);
	Color backColor2 = new Color(240, 250, 254);
	Font font = new Font("微软雅黑", Font.PLAIN, 15);
	String[] headerStr;
	JTable table; 
	DefaultTableModel model;
	
	public MyTablePanel(String[] header) {
		model = new DefaultTableModel(null, header);
		
		table = new JTable(model){
			private static final long serialVersionUID = 1L;

			@Override
			public boolean isCellEditable(int row, int column) {
				return false;
			}
		};
		
		headerStr = header;
		
		initTable();
		
		JScrollPane s = new JScrollPane(table);
		s.setOpaque(false);
		s.setViewportBorder(new EmptyBorder(0, 0, 0, 0));
		s.getViewport().setOpaque(false);
		s.setColumnHeaderView(table.getTableHeader());
		s.getColumnHeader().setOpaque(false);
		s.setBorder(new EmptyBorder(0, 0, 0, 0));
		this.add(s);
		this.setOpaque(false);
	}

	public DefaultTableModel getTableModel() {
		return model;
	}

	private void initTable() {
		JTableHeader header = table.getTableHeader();
		table.setRowHeight(ROW_HEIGHT);
		table.setFont(font);
		header.setFont(font);
		header.setPreferredSize(new Dimension(header.getWidth(), ROW_HEIGHT));
		table.setPreferredScrollableViewportSize(new Dimension(WIDTH, HEIGHT));

		table.setCellSelectionEnabled(false);
		table.setBorder(null);
		table.setOpaque(false);

		// 设置表格颜色
		setForeground(foreColor);
		header.setBackground(headerColor);
		DefaultTableCellRenderer dtr = new DefaultTableCellRenderer() {
			private static final long serialVersionUID = 1L;

			@Override
			public Component getTableCellRendererComponent(JTable table, Object value, boolean isSelected,
					boolean hasFocus, int row, int column) {
				if (row % 2 == 0)
					setBackground(backColor1);
				else
					setBackground(backColor2);
				return super.getTableCellRendererComponent(table, value, isSelected, hasFocus, row, column);
			}
		};
		for (int i = 0; i < headerStr.length; i++) {
			table.getColumn(headerStr[i]).setCellRenderer(dtr);
		}
	}

	public void setRowHeight(int h){
		this.ROW_HEIGHT = h;
		table.setRowHeight(ROW_HEIGHT);
		JTableHeader header= table.getTableHeader();
		header.setPreferredSize(new Dimension(header.getWidth(), ROW_HEIGHT));
	}

}
