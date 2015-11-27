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
	MyTextField field;
	
	Font font = new Font("黑体", Font.PLAIN, 16);
	Color color = Color.white;
	
	public LabelTextField(String text, int columns) {
		
		this.setOpaque(false);
		
		label = new JLabel(text);
		label.setFont(font);
		label.setForeground(color);
		this.add(label);
		
		
		field = new MyTextField(columns);
		this.add(field);
	}
	
	public String getText(){
		return field.getText();
	}
	
	public void setColumns(int columns){
		field.setColumns(columns);
	}

}
