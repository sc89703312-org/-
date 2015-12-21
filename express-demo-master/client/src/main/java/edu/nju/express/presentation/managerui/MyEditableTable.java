package edu.nju.express.presentation.managerui;

import java.awt.Color;
import java.awt.Component;
import java.awt.Dimension;
import java.awt.Font;
import java.util.ArrayList;

import javax.swing.JLabel;
import javax.swing.JTable;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.DefaultTableModel;

import edu.nju.express.presentation.NumberValidation;

public class MyEditableTable extends JTable {

	private static final long serialVersionUID = 1L;

	private int ROW_HEIGHT = 30;
	private static Color foreColor = new Color(44, 62, 80);
	private static Color foreColor2 = new Color(172, 229, 216);
	private static Font font = new Font("黑体", Font.PLAIN, 18);
	private static String[] header = {"城市1","-","城市2","：","距离","公里"};


	public MyEditableTable() {
		super(new DefaultTableModel(null, header) {

			private static final long serialVersionUID = 1L;

			@Override
			public boolean isCellEditable(int row, int column) {
				if (column == 4)
					return true;
				return false;
			}

		});
		this.setRowHeight(ROW_HEIGHT);
		this.setFont(font);
//		this.setCellSelectionEnabled(false);
		this.setOpaque(false);
		this.setShowGrid(false);
		this.setForeground(foreColor);

		DefaultTableCellRenderer dtr = new DefaultTableCellRenderer() {
			private static final long serialVersionUID = 1L;

			@Override
			public Component getTableCellRendererComponent(JTable table, Object value, boolean isSelected,
					boolean hasFocus, int row, int column) {
				setOpaque(false);
				if (isCellEditable(row, column)) {
					setForeground(foreColor2);
				} else
					setForeground(foreColor);

				return super.getTableCellRendererComponent(table, value, isSelected, hasFocus, row, column);
			}
		};
		dtr.setHorizontalAlignment(JLabel.CENTER);
		for (int i = 0; i < header.length; i++)

		{
			this.getColumn(header[i]).setCellRenderer(dtr);
		}

		DefaultTableCellRenderer dtr1 = new DefaultTableCellRenderer();
		dtr1.setPreferredSize(new Dimension(0, 0));
		this.getTableHeader().setDefaultRenderer(dtr1);

		this.getTableHeader().setVisible(false);

		this.getColumn(header[0]).setMaxWidth(50);
		this.getColumn(header[1]).setMaxWidth(8);
		this.getColumn(header[2]).setMaxWidth(50);
		this.getColumn(header[3]).setMaxWidth(30);
		this.getColumn(header[4]).setMaxWidth(60);
		this.getColumn(header[5]).setMaxWidth(50);

	}

	public ArrayList<String> getInput() {
		ArrayList<String> input = new ArrayList<String>();

		for (int i = 0; i < this.getRowCount(); i++) {
			input.add((String)this.getValueAt(i, 4));
			
			if(!NumberValidation.isPositiveDecimal((String)getValueAt(i, 4)))
				return null;
		}

		return input;
	}
}
