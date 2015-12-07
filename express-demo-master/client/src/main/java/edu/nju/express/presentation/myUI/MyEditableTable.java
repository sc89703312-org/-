package edu.nju.express.presentation.myUI;

import java.awt.Color;
import java.awt.Component;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.event.FocusAdapter;
import java.awt.event.FocusEvent;
import java.util.ArrayList;

import javax.swing.JLabel;
import javax.swing.JTable;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.DefaultTableModel;

public class MyEditableTable extends JTable {

	private static final long serialVersionUID = 1L;

	private int ROW_HEIGHT = 30;
	private static Color foreColor = new Color(44, 62, 80);
	private static Color foreColor2 = new Color(172, 229, 216);
	private static Font font = new Font("黑体", Font.PLAIN, 18);
	private static ArrayList<Integer> editedRows = new ArrayList<Integer>();

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
				if (isCellEditable(row, column)) {
					final int i = row;
					setForeground(foreColor2);
					addFocusListener(new FocusAdapter() {
						@Override
						public void focusGained(FocusEvent e) {
							// TODO Auto-generated method stub
							super.focusGained(e);
							editedRows.add(i);
						}
						
					});
				} else
					setForeground(foreColor);

				return super.getTableCellRendererComponent(table, value, isSelected, hasFocus, row, column);
			}
		};
		dtr.setHorizontalAlignment(JLabel.CENTER);
		for (int i = 0; i < header.length; i++) {
			this.getColumn(header[i]).setCellRenderer(dtr);
		}

		DefaultTableCellRenderer dtr1 = new DefaultTableCellRenderer();
		dtr1.setPreferredSize(new Dimension(0, 0));
		this.getTableHeader().setDefaultRenderer(dtr1);

		this.getTableHeader().setVisible(false);

		this.getColumn(header[0]).setMaxWidth(80);
		this.getColumn(header[1]).setMaxWidth(10);
		this.getColumn(header[2]).setMaxWidth(80);
		this.getColumn(header[3]).setMaxWidth(50);
		this.getColumn(header[4]).setMaxWidth(90);
		this.getColumn(header[5]).setMaxWidth(80);
	}

	public ArrayList<Integer> getEditedRows(){
		return editedRows;
	}
}
