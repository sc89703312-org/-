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

		this.getColumn(header[0]).setMaxWidth(50);
		this.getColumn(header[1]).setMaxWidth(8);
		this.getColumn(header[2]).setMaxWidth(50);
		this.getColumn(header[3]).setMaxWidth(30);
		this.getColumn(header[4]).setMaxWidth(60);
		this.getColumn(header[5]).setMaxWidth(50);
	}

	public ArrayList<String> getEditedRows(){
		ArrayList<String> edited = new ArrayList<String>();
		for(int i = 0;i<this.getRowCount();i++){
			edited.add((String)(this.getValueAt(i, 4)));
//			System.out.println((String)(this.getValueAt(i, 4)));
		}
		
		return edited;
	}
}
