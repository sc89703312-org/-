package edu.nju.express.presentation.myUI;

import java.awt.Color;
import java.awt.Component;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.ArrayList;

import javax.swing.DefaultCellEditor;
import javax.swing.JButton;
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

import edu.nju.express.common.ConcludeTypeById;

public class MyCheckBoxButtonTable extends JTable {

	private static final long serialVersionUID = 1L;
	int ROW_HEIGHT = 32;
	
	Color foreColor = new Color(44, 62,80);
	Color backColor1 = new Color(246,249,249);
	Color backColor2 = new Color(172,229,216);
	Color gridColor = new Color(143,143,143,50);
	Font font = new Font("黑体", Font.PLAIN, 15);
	String selectId;
	String type;

	JTable table;
	static String[] headerStr;

	public MyCheckBoxButtonTable(String[] headerStr) {
		super(new DefaultTableModel(null, headerStr) {
			/**
			 * 
			 */
			private static final long serialVersionUID = 1L;

			@Override
			public Class<?> getColumnClass(int c) {
				if (c == 0)
					return Boolean.class;
				else if( c == 4)
					return JButton.class;
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
		
		JTableButtonRenderer button = new JTableButtonRenderer(table.getDefaultRenderer(JButton.class));
		tcm.getColumn(4).setCellRenderer(button);
		
		
		
		
		this.getColumn("全选").setMaxWidth(25);
		this.getColumn("详情").setMaxWidth(32);

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

	class JTableButtonRenderer implements TableCellRenderer {
		private TableCellRenderer __defaultRenderer;

		public JTableButtonRenderer(TableCellRenderer renderer) {
			__defaultRenderer = renderer;
		}

		public Component getTableCellRendererComponent(JTable table, Object value, boolean isSelected, boolean hasFocus,
				int row, int column) {
			
			
			if (row % 2 == 0)
				setBackground(backColor1);
			else if (row % 2 == 1)
				setBackground(backColor2);
			else{
				setBackground(backColor2);
			}
		
			if (value instanceof Component){
				return (Component) value;
			}
			return __defaultRenderer.getTableCellRendererComponent(table, value, isSelected, hasFocus, row, column);
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
	
	/*class JTableButtonMouseListener implements MouseListener {
		private JTable __table;

		private void __forwardEventToButton(MouseEvent e) {
			TableColumnModel columnModel = __table.getColumnModel();
			int column = columnModel.getColumnIndexAtX(e.getX());
			int row = e.getY() / __table.getRowHeight();
			Object value;
			JButton button;
			MouseEvent buttonEvent;

			if (row >= __table.getRowCount() || row < 0 || column >= __table.getColumnCount() || column < 0)
				return;

			value = __table.getValueAt(row, column);
			

			if (!(value instanceof JButton))
				return;

			button = (JButton) value;

			buttonEvent = (MouseEvent) SwingUtilities.convertMouseEvent(__table, e, button);
			button.dispatchEvent(buttonEvent);
			
		
			
			
			// This is necessary so that when a button is pressed and released
			// it gets rendered properly. Otherwise, the button may still appear
			// pressed down when it has been released.
			__table.repaint();
		}

		public JTableButtonMouseListener(JTable table) {
			__table = table;
		}

		public void mouseClicked(MouseEvent e) {
		//	__forwardEventToButton(e);
			TableColumnModel columnModel = __table.getColumnModel();
			int column = columnModel.getColumnIndexAtX(e.getX());
			int row = e.getY() / __table.getRowHeight();
			selectId = (String)getValueAt(row, 2);
			System.out.println(row+" "+column+" "+getValueAt(row, 2)+" "+getValueAt(row, 1));
			
		}

		public void mouseEntered(MouseEvent e) {
		}

		public void mouseExited(MouseEvent e) {
		}

		public void mousePressed(MouseEvent e) {
		}

		public void mouseReleased(MouseEvent e) {
		}

	}*/

	
}
