package edu.nju.express.presentation.myUI;

import java.awt.BasicStroke;
import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.geom.RoundRectangle2D;

import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;
import javax.swing.border.SoftBevelBorder;

public class MyTextField extends JTextField {

	private static final long serialVersionUID = 1L;

	Font font = new Font("黑体", Font.PLAIN, 18);
	Color color = Color.white;
	int columns = 10;
	MyTextField field;
	static int count = 3;
	Graphics2D g;

	Color bc1 = new Color(137, 193, 232,60);
	Color bc2 = new Color(137, 193, 232,80);
	Color bc3 = new Color(101, 184, 229);

	public MyTextField() {
		initField();
	}

	public MyTextField(int columns) {
		this.columns = columns;
		initField();
	}

	private void initField() {
		field = this;
		this.setOpaque(false);
		this.setBounds(columns, 25, 518, 140);
		this.setFont(font);
		this.setForeground(color);
		this.setBorder(new EmptyBorder(0, 0, 0, 0));

		
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
				field.getParent().repaint();
			}

			@Override
			public void mouseEntered(MouseEvent e) {
				g = (Graphics2D)field.getParent().getGraphics();
				float d = 1.0f;
				int a = 4;
				int x = field.getX();
				int y = field.getY();
				int w = field.getWidth();
				int h = field.getHeight();
				
				g.setStroke(new BasicStroke(d));
				
				g.setColor(bc3);
				g.draw(new RoundRectangle2D.Float(x-d, y-d, w+2*d, h+2*d, a,a));
				g.setColor(bc2);
				g.draw(new RoundRectangle2D.Float(x-2*d, y-2*d, w+4*d, h+4*d, a, a));
				g.setColor(bc1);
				g.draw(new RoundRectangle2D.Float(x-3*d, y-3*d, w+6*d, h+6*d, a, a));
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
