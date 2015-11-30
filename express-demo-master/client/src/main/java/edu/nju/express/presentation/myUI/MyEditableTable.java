package edu.nju.express.presentation.myUI;

import java.awt.Color;
import java.awt.Component;
import java.awt.Dimension;
import java.awt.Font;

import javax.swing.JLabel;
import javax.swing.JTable;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.DefaultTableModel;

public class MyEditableTable extends JTable{

	private static final long serialVersionUID = 1L;

	int ROW_HEIGHT = 30;
	Color foreColor = Color.white;
	Font font = new Font("黑体", Font.PLAIN, 15);
	
	public MyEditableTable(String[] header, DefaultTableModel model) {
		super(model);
		
		this.setRowHeight(ROW_HEIGHT);
		this.setFont(font);
		this.setCellSelectionEnabled(false);
		this.setOpaque(false);
		this.setShowGrid(false);
		this.setForeground(foreColor);
		
		DefaultTableCellRenderer dtr = new DefaultTableCellRenderer() {
			private static final long serialVersionUID = 1L;

			@Override
			public Component getTableCellRendererComponent(JTable table, Object value, boolean isSelected,
					boolean hasFocus, int row, int column) {
				setOpaque(false);
				return super.getTableCellRendererComponent(table, value, isSelected, hasFocus, row, column);
			}
		};
		dtr.setHorizontalAlignment(JLabel.CENTER);
		for (int i = 0; i < header.length; i++) {
			this.getColumn(header[i]).setCellRenderer(dtr);
		}
		
		DefaultTableCellRenderer dtr1 = new DefaultTableCellRenderer();
		dtr1.setPreferredSize(new Dimension(0,0));
		this.getTableHeader().setDefaultRenderer(dtr1);
		
		this.getTableHeader().setVisible(false);
		
		this.getColumn(header[0]).setMaxWidth(40);
		this.getColumn(header[1]).setMaxWidth(5);
		this.getColumn(header[2]).setMaxWidth(40);
		this.getColumn(header[3]).setMaxWidth(25);
		this.getColumn(header[4]).setMaxWidth(45);
		this.getColumn(header[5]).setMaxWidth(40);
	}
	
	
}
