package edu.nju.express.presentation.myUI;

import java.awt.BasicStroke;
import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics2D;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.geom.RoundRectangle2D;

import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;

public class MyTextField extends JTextField {

	private static final long serialVersionUID = 1L;

	private static Font font = new Font("黑体", Font.PLAIN, 16);
	int columns = 10;
	MyTextField field;
	Graphics2D g;

	private static float d = 1.0f;
	private static int a = 4;
	int x, y, w, h;
	private static Color back1 = new Color(173,195,192);
	private static Color back2 = new Color(240,240,240);
	private static Color fore1 = Color.white;
	private static Color fore2 = new Color(50,50,50);
	Color bc1[] = { new Color(165,165,165),new Color(217,217,217,75),new Color(242,242,242)};
	//蓝色系
	private static Color bc2[] = { new Color(137, 193, 232, 60), new Color(137, 193, 232, 80), new Color(101, 184, 229) };
	//红色系
	Color bc3[] = {new Color(255,86,86, 60), new Color(255,86,86, 80), new Color(255,86,86)};
	
	public MyTextField(int columns) {
		super(columns);
		this.columns = columns;
		
		field = this;
		this.setFont(font);
		this.setBounds(500, 90, 100, 25);
		this.setForeground(fore1);
		this.setBackground(back1);
//		this.setHorizontalAlignment(JLabel.CENTER);
		this.setBorder(new EmptyBorder(0,0,0,0));
		
		
		
		this.addMouseListener(new MouseAdapter() {

			@Override
			public void mouseExited(MouseEvent e) {
				field.getParent().repaint();
				field.setBackground(back1);
				field.setForeground(fore1);
				field.setBorder(new EmptyBorder(0,0,0,0));
			}

			@Override
			public void mouseEntered(MouseEvent e) {
				field.setBackground(back2);
				field.setForeground(fore2);
				
				x = field.getX();
				y = field.getY();
				w = field.getWidth();
				h = field.getHeight();
				g = (Graphics2D)field.getParent().getGraphics();
				
				
				g.setStroke(new BasicStroke(d));
				
				g.setColor(bc2[2]);
				g.draw(new RoundRectangle2D.Float(x-d, y-d, w+d, h+d, a,a));
				g.draw(new RoundRectangle2D.Float(x, y, w, h, a,a));
				g.draw(new RoundRectangle2D.Float(x-d, y-d, w+2*d, h+2*d, a,a));
				g.setColor(bc2[1]);
				g.draw(new RoundRectangle2D.Float(x-2*d, y-2*d, w+4*d, h+4*d, a, a));
				g.setColor(bc2[0]);
				g.draw(new RoundRectangle2D.Float(x-3*d, y-3*d, w+6*d, h+6*d, a, a));
				
			
			}

			@Override
			public void mouseClicked(MouseEvent e) {
			}
		});

	}

	public String getText() {
		return this.getText();
	}

	public void setErrorField(){
		
	}
	
	
}

