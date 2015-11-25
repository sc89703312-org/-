package edu.nju.express.presentation.myUI;

import java.awt.Color;
import java.awt.Font;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

import javax.swing.JTextField;
import javax.swing.border.SoftBevelBorder;

public class MyTextField extends JTextField {

	private static final long serialVersionUID = 1L;

	Font font = new Font("微软雅黑", Font.PLAIN, 16);
	Color color = Color.white;
	int columns = 10;

	public MyTextField() {
		initField();
	}
	
	public MyTextField(int columns) {
		this.columns = columns;
		initField();
	}

	private void initField() {
		this.setOpaque(false);
		this.setSize(columns, 20);
		this.setFont(font);
		this.setForeground(color);
		this.setBorder(new SoftBevelBorder(SoftBevelBorder.LOWERED));

		this.addMouseListener(new MouseListener() {

			@Override
			public void mouseReleased(MouseEvent e) {
				// TODO Auto-generated method stub

			}

			@Override
			public void mousePressed(MouseEvent e) {
				// TODO Auto-generated method stub

			}

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
				// TODO Auto-generated method stub

			}
		});

	}

	public String getText() {
		return this.getText();
	}
}
