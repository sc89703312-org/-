package edu.nju.express.presentation.myUI;

import java.awt.Component;

import javax.swing.JTable;
import javax.swing.table.TableCellRenderer;

public class MyComboBoxRenderer extends MyComboBox<String> implements TableCellRenderer{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	public MyComboBoxRenderer(){
		super();
		addItem("完整");
		addItem("损坏");
		addItem("丢失");
	}

	@Override
	public Component getTableCellRendererComponent(JTable table, Object value,
			boolean isSelected, boolean hasFocus, int row, int column) {
		// TODO Auto-generated method stub
		if(isSelected){
			setForeground(table.getForeground());
			super.setBackground(table.getBackground());
		}else{
			setForeground(table.getForeground());
			setBackground(table.getBackground());
		}
//		boolean isMale = ((Boolean)value).booleanValue();
//		setSelectedIndex(isMale? 0 : 1);
		int index = ((Integer)value).intValue();
		setSelectedIndex(index);
		return this;
	}


	

}
