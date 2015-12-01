package edu.nju.express.presentation.myUI;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;

public class MyTextField extends JPanel {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private static Image img1 = new ImageIcon("ui/bar/field1.png").getImage();
	private static Image img2 = new ImageIcon("ui/bar/field2.png").getImage();
	private static Image img3 = new ImageIcon("ui/bar/field3.png").getImage();

	private static Image imgS1 = new ImageIcon("ui/bar/fieldS1.png").getImage();
	private static Image imgS2 = new ImageIcon("ui/bar/fieldS2.png").getImage();
	private static Image imgS3 = new ImageIcon("ui/bar/fieldS3.png").getImage();

	private JTextField field;
	private MyTextField p;
	private int state = 1;
	private int width;
	private int height = 40;
	private int colomn;

	public MyTextField(int colomn) {
		this.colomn = colomn;

		if(colomn!=0)
			width = 200;
		else	width = 112;
		this.setPreferredSize(new Dimension(width, height));
		this.setOpaque(false);
		this.setLayout(null);
		p = this;

		field = new JTextField();
		field.setBounds(10, 0, (int) (width * 0.8) - 10, height);
		field.setFont(new Font("黑体", Font.PLAIN, 18));
		field.setForeground(new Color(44, 62, 80));
		field.setOpaque(false);
		field.setBorder(new EmptyBorder(0, 0, 0, 0));
		this.add(field);

		field.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseEntered(MouseEvent e) {
				state = 2;
				p.repaint();
			}

			@Override
			public void mouseExited(MouseEvent e) {
				state = 1;
				p.repaint();
			}
		});

	}

	@Override
	protected void paintComponent(Graphics g) {
		super.paintComponent(g);
		if (colomn == 0) {
			switch (state) {
			case 1:
				g.drawImage(imgS1, 0, 0, null);
				break;
			case 2:
				g.drawImage(imgS2, 0, 0, null);
				break;
			case 3:
				g.drawImage(imgS3, 0, 0, null);
				break;
			}
		} else {
			switch (state) {
			case 1:
				g.drawImage(img1, 0, 0, null);
				break;
			case 2:
				g.drawImage(img2, 0, 0, null);
				break;
			case 3:
				g.drawImage(img3, 0, 0, null);
				break;
			}

		}

	}

	public String getText() {
		return field.getText();
	}

	public void setText(String text) {
		field.setText(text);
	}

}
