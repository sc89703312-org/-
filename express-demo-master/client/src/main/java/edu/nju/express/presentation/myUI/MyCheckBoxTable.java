package edu.nju.express.presentation.myUI;

import java.awt.Color;
import java.awt.Component;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.ArrayList;

import javax.swing.DefaultCellEditor;
import javax.swing.JCheckBox;
import javax.swing.JLabel;
import javax.swing.JTable;
import javax.swing.border.EmptyBorder;
import javax.swing.border.LineBorder;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.JTableHeader;
import javax.swing.table.TableCellRenderer;
import javax.swing.table.TableColumnModel;

public class MyCheckBoxTable extends JTable {

	private static final long serialVersionUID = 1L;
	int ROW_HEIGHT = 30;
	
	Color foreColor = new Color(44, 62,80);
	Color backColor1 = new Color(246,249,249);
	Color backColor2 = new Color(172,229,216);
	Color gridColor = new Color(143,143,143,50);
	Font font = new Font("黑体", Font.PLAIN, 15);

	JTable table;
	static String[] headerStr;

	public MyCheckBoxTable(String[] headerStr) {
		super(new DefaultTableModel(null, headerStr) {
			/**
			 * 
			 */
			private static final long serialVersionUID = 1L;

			@Override
			public Class<?> getColumnClass(int c) {
				if (c == 0)
					return Boolean.class;
				else
					return String.class;
			}
		});
		this.headerStr = headerStr;
		table = this;

		JTableHeader header = this.getTableHeader();
		this.setRowHeight(ROW_HEIGHT);
		this.setFont(font);
		table.setGridColor(gridColor);

		header.setFont(font);
		header.setBorder(new LineBorder(gridColor, 1));
		header.setBorder(new EmptyBorder(0, 0, 0, 0));
		header.setPreferredSize(new Dimension(header.getWidth(), ROW_HEIGHT));

		this.setCellSelectionEnabled(false);
		this.setOpaque(false);
	//	this.setShowGrid(false);

		// 设置表格颜色
		DefaultTableCellRenderer dtr = new DefaultTableCellRenderer() {
			private static final long serialVersionUID = 1L;

			@Override
			public Component getTableCellRendererComponent(JTable table, Object value, boolean isSelected,
					boolean hasFocus, int row, int column) {
				if (row % 2 == 0)
					setBackground(backColor1);
				else if (row % 2 == 1)
					setBackground(backColor2);
				else
					setBackground(backColor2);
				
				setForeground(foreColor);
				return super.getTableCellRendererComponent(table, value, isSelected, hasFocus, row, column);
			}
		};
		for (int i = 0; i < headerStr.length; i++) {
			this.getColumn(headerStr[i]).setCellRenderer(dtr);
		}
		dtr.setHorizontalAlignment(JLabel.CENTER);
		header.setDefaultRenderer(dtr);

		
		TableColumnModel tcm = this.getColumnModel();
		tcm.getColumn(0).setCellEditor(new DefaultCellEditor(new JCheckBox()));

		final MyTableCellRenderer check = new MyTableCellRenderer();
		tcm.getColumn(0).setCellRenderer(check);
		tcm.getColumn(0).setHeaderRenderer(check);
		this.getColumn("全选").setMaxWidth(25);

		// 全选功能
		this.getTableHeader().addMouseListener(new MouseAdapter() {

			@Override
			public void mouseClicked(MouseEvent e) {
				int column = columnModel.getColumnIndexAtX(e.getX());
				if(column != 0 )
					return;
				boolean b = !check.isSelected();
				check.setSelected(b);
				for (int i = 0; i < table.getRowCount(); i++) {
					table.getModel().setValueAt(b, i, 0);
				}
			}
		});
	}

	@Override
	public boolean isCellEditable(int row, int column) {
		if (column == 0)
			return true;
		return false;
	}

	private class MyTableCellRenderer extends JCheckBox implements TableCellRenderer {
		private static final long serialVersionUID = 1L;

		public Component getTableCellRendererComponent(JTable table, Object value, boolean isSelected, boolean hasFocus,
				int row, int column) {
			
			if (row % 2 == 0)
				setBackground(backColor1);
			else if (row % 2 == 1)
				setBackground(backColor2);
			else{
				setBackground(backColor2);
			}
			if(row!=-1)
				setSelected(value != null&& (Boolean) value);
			return this;
		}
	}

	public ArrayList<String> getSelectedID() {
		ArrayList<String> l = new ArrayList<String>();
		ArrayList<Integer> temp = new ArrayList<Integer>();
		for (int i = 0; i < table.getRowCount(); i++) {
			if ((boolean) table.getValueAt(i, 0) == true){
				l.add((String) table.getValueAt(i, 2));
				temp.add(i);
			}
		}
		int gap = 0;
		for(int i: temp)
			this.getTableModel().removeRow(i-gap++);
		return l;
	}

	public DefaultTableModel getTableModel() {
		return (DefaultTableModel) this.getModel();
	}
}
