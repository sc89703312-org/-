package edu.nju.express.presentation.myUI;

import java.awt.Color;
import java.awt.Component;
import java.awt.Dimension;
import java.awt.Font;

import javax.swing.JTable;
import javax.swing.border.EmptyBorder;
import javax.swing.border.LineBorder;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.JTableHeader;

public class MyTable extends JTable {

	private static final long serialVersionUID = 1L;
	int ROW_HEIGHT = 30;

	Color headerColor = new Color(49, 121, 177);
	Color foreColor = new Color(0, 0, 0);
	Color backColor1 = new Color(255, 255, 255);
	Color backColor2 = new Color(240, 250, 254);
	Font font = new Font("微软雅黑", Font.PLAIN, 15);
	String[] headerStr;
	DefaultTableModel model;
	
	public MyTable(String[] header) {
		super(new DefaultTableModel(null, header));
		
		model = (DefaultTableModel)this.getModel();
		headerStr = header;
		
		initTable();
		
	}

	public DefaultTableModel getTableModel() {
		return model;
	}
	
	@Override
	public boolean isCellEditable(int row, int column) {
		return false;
	}

	private void initTable() {
		JTableHeader header = this.getTableHeader();
		this.setRowHeight(ROW_HEIGHT);
		this.setFont(font);
		
		header.setFont(font);
		
		header.setPreferredSize(new Dimension(header.getWidth(), ROW_HEIGHT));

		this.setCellSelectionEnabled(false);
		this.setOpaque(false);
		this.setShowGrid(false);

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
				else if(row % 2 == 1)
					setBackground(backColor2);
				else
					setBackground(headerColor);
				return super.getTableCellRendererComponent(table, value, isSelected, hasFocus, row, column);
			}
		};
		for (int i = 0; i < headerStr.length; i++) {
			this.getColumn(headerStr[i]).setCellRenderer(dtr);
		}
		header.setDefaultRenderer(dtr);

	}

	@Override
	public void setRowHeight(int h){
		 ROW_HEIGHT = h;
		 super.setRowHeight(ROW_HEIGHT);
		 this.getTableHeader().setPreferredSize(new Dimension(this.getTableHeader().getWidth(), ROW_HEIGHT));

	}
	

}
