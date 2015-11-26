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
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.JTableHeader;
import javax.swing.table.TableCellRenderer;
import javax.swing.table.TableColumnModel;

public class MyCheckBoxTable extends JTable {

	private static final long serialVersionUID = 1L;
	int ROW_HEIGHT = 30;
	Color headerColor = new Color(49, 121, 177);
	Color foreColor = new Color(0, 0, 0);
	Color backColor1 = new Color(255, 255, 255);
	Color backColor2 = new Color(240, 250, 254);
	Font font = new Font("微软雅黑", Font.PLAIN, 15);

	JTable table;
	static String[] headerStr = { "全选", "单据种类", "单据编号", "提交时间" };

	public MyCheckBoxTable() {
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
		table = this;

		JTableHeader header = this.getTableHeader();
		this.setRowHeight(ROW_HEIGHT);
		this.setFont(font);

		header.setFont(font);
		header.setBorder(new EmptyBorder(0, 0, 0, 0));
		header.setPreferredSize(new Dimension(header.getWidth(), ROW_HEIGHT));

		this.setCellSelectionEnabled(false);
		this.setOpaque(false);
		this.setShowGrid(false);

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
					setBackground(headerColor);
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
			public void mouseExited(MouseEvent e) {
				// TODO Auto-generated method stub

			}

			@Override
			public void mouseEntered(MouseEvent e) {
				// TODO Auto-generated method stub

			}

			@Override
			public void mouseClicked(MouseEvent e) {
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
			else
				setBackground(headerColor);

			if (row != -1)
				setSelected(value != null && (Boolean) value);

			return this;
		}
	}

	public ArrayList<String> getSelectedID() {
		ArrayList<String> l = new ArrayList<String>();
		for (int i = 0; i < table.getRowCount(); i++) {
			if ((boolean) table.getValueAt(i, 0) == true) {
				System.out.println(table.getValueAt(i, 2));
				l.add((String) table.getValueAt(i, 2));
			}
		}
		return l;
	}

	public DefaultTableModel getTableModel() {
		return (DefaultTableModel) this.getModel();
	}
}
