package edu.nju.express.presentation.myUI;

import java.awt.Color;
import java.awt.Font;

import javax.swing.JComboBox;
import javax.swing.border.EmptyBorder;

public class MyComboBox<E> extends JComboBox<E>{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	
	public MyComboBox() {
		super();
		
	//	this.setOpaque(false);
		this.setBackground(new Color(173,195,192));
		this.setFont(new Font("黑体", Font.PLAIN, 15));
		this.setForeground(Color.white);
		this.setBorder(new EmptyBorder(0,0,0,0));;
	}
}
