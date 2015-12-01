package edu.nju.express.presentation.myUI;

import java.awt.Color;
import java.awt.Component;
import java.awt.Dimension;
import java.awt.Font;

import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.ScrollPaneConstants;
import javax.swing.border.EmptyBorder;
import javax.swing.border.LineBorder;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.JTableHeader;
import javax.swing.table.TableColumn;
import javax.swing.table.TableColumnModel;

public class MyTablePanel extends JPanel {

	private static final long serialVersionUID = 1L;
	int ROW_HEIGHT = 35;
//	Color headerColor = new Color(49, 121, 177);
	Color foreColor = new Color(44, 62,80);
	Color backColor1 = new Color(246,249,249);
	Color backColor2 = new Color(172,229,216);
	Color gridColor = new Color(143,143,143,50);
	Font font = new Font("黑体", Font.PLAIN, 15);
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
		s.setViewportBorder(new EmptyBorder(0, 0, 0, 0));
		s.setOpaque(false);
		s.getViewport().setOpaque(false);
//		s.setColumnHeaderView(table.getTableHeader());
//		s.getColumnHeader().setOpaque(false);
		s.setBorder(new EmptyBorder(0, 0, 0, 0));
		s.getVerticalScrollBar().setOpaque(false);
		s.getVerticalScrollBar().setUI(null);
		s.setHorizontalScrollBarPolicy(ScrollPaneConstants.HORIZONTAL_SCROLLBAR_NEVER );;
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

		table.setCellSelectionEnabled(false);
		table.setOpaque(false);
//		table.setShowGrid(false);
//		table.setShowVerticalLines(false);
		table.setGridColor(gridColor);

		// 设置表格颜色
		setForeground(foreColor);
		header.setForeground(foreColor);
//		header.setBackground(headerColor);
		header.setBorder(new LineBorder(gridColor, 1));
		
		DefaultTableCellRenderer dtr = new DefaultTableCellRenderer() {
			private static final long serialVersionUID = 1L;

			@Override
			public Component getTableCellRendererComponent(JTable table, Object value, boolean isSelected,
					boolean hasFocus, int row, int column) {
				if (row % 2 == 0){
					setBackground(backColor1);
				}
				else if(row % 2 == 1){
					setBackground(backColor2);
				}
				else
					setBackground(backColor2);
				setForeground(foreColor);

			
				return super.getTableCellRendererComponent(table, value, isSelected, hasFocus, row, column);
			}
		};
		dtr.setHorizontalAlignment(JLabel.CENTER);
		for (int i = 0; i < headerStr.length; i++) {
			table.getColumn(headerStr[i]).setCellRenderer(dtr);
		}
		header.setDefaultRenderer(dtr);

	}

	public void setRowHeight(int h){
		this.ROW_HEIGHT = h;
		table.setRowHeight(ROW_HEIGHT);
		JTableHeader header= table.getTableHeader();
		header.setPreferredSize(new Dimension(header.getWidth(), ROW_HEIGHT));
	}

	public JTable getTable(){
		return table;
	}
	
	public void setColumnWidth(int[] columnWidth){
		TableColumnModel columnModel = table.getColumnModel();
        for (int i = 0; i < columnModel.getColumnCount(); i++) {
        	// 以数组元素设置列的宽度
            columnModel.getColumn(i).setMinWidth(columnWidth[i]);
        }
	}
}
