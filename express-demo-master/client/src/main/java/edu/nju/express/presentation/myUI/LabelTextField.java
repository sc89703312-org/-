package edu.nju.express.presentation.myUI;

import java.awt.Color;
import java.awt.Font;

import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

public class LabelTextField extends JPanel {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	JLabel label;
	MyTextField field;

	static Font font = new Font("黑体", Font.PLAIN, 18);
	static Color color = new Color(44, 62, 80);

	public LabelTextField(String text, int columns) {

		this.setOpaque(false);

		label = new JLabel(text);
		label.setFont(font);
		label.setForeground(color);
		this.add(label);

		field = new MyTextField(columns);
		this.add(field);
	}

	public LabelTextField(String text1, int columns, String text2) {

		this.setOpaque(false);

		label = new JLabel(text1);
		label.setFont(font);
		label.setForeground(color);
		this.add(label);

		field = new MyTextField(columns);
		this.add(field);

		JLabel label2 = new JLabel(text2);
		label2.setFont(font);
		label2.setForeground(color);
		this.add(label2);
	}
	
	public JTextField getTextField(){
		return field.getTextField();
	}

	public String getText() {
		return field.getText();
	}

	public void setText(String text) {
		field.setText(text);
	}
	
	public void setError(){
		field.setError();
	}

}
