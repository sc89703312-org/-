package edu.nju.express.presentation.myUI;

import java.awt.Color;
import java.awt.Font;

import javax.swing.JComboBox;
import javax.swing.border.EmptyBorder;
import javax.swing.plaf.basic.BasicComboBoxUI;
import javax.swing.plaf.basic.BasicComboPopup;
import javax.swing.plaf.basic.ComboPopup;

public class MyComboBox<E> extends JComboBox<E>{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	
	public MyComboBox() {
		super();
		
	//	this.setOpaque(false);
		this.setBackground(new Color(246,249,249));
		this.setFont(new Font("黑体", Font.PLAIN, 17));
		this.setForeground(new Color(44, 62,80));
		this.setBorder(new EmptyBorder(0,0,0,0));;
	//	this.setUI( new MyComboBoxUI() );
	
	}
	
	private class MyComboBoxUI extends BasicComboBoxUI{
		
		MyComboBoxUI(){
			super();
		}
		
		@Override
		protected ComboPopup createPopup() {
			return new MyComboPopup(comboBox);
		}
	}
	
	private class MyComboPopup extends BasicComboPopup{
		
		/**
		 * 
		 */
		private static final long serialVersionUID = 1L;

		public MyComboPopup(JComboBox combo) {
			super(combo);
			scroller.getVerticalScrollBar().setUI(null);
			scroller.getVerticalScrollBar().setBorder(new EmptyBorder(0, 0, 0, 0));
		}
		
	}
}
