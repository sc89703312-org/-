package edu.nju.express.presentation.myUI;

import java.awt.Color;
import java.awt.Font;

import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.border.BevelBorder;
import javax.swing.border.EtchedBorder;
import javax.swing.border.SoftBevelBorder;

public class LabelTextField extends JPanel{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	JLabel label;
	JTextField field;
	
	Font font = new Font("微软雅黑", Font.PLAIN, 16);
	Color color = Color.white;
	
	public LabelTextField(String text, int columns) {
		
		this.setOpaque(false);
		
		label = new JLabel(text);
		label.setFont(font);
		label.setForeground(color);
		this.add(label);
		
		
		field = new JTextField(columns);
		field.setSize(columns, 20);
		field.setOpaque(false);
		field.setForeground(color);
		field.setBorder(new SoftBevelBorder(SoftBevelBorder.LOWERED));
		this.add(field);
	}
	
	public String getText(){
		return field.getText();
	}
	
	public void setColumns(int columns){
		field.setColumns(columns);
	}

}
