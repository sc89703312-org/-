package edu.nju.express.presentation.myUI;

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

import edu.nju.express.presentation.UIController;

public class MySearchFieldPanel extends JPanel{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private static Image img1= new ImageIcon("ui/bar/searchbar/search1.png").getImage();
	private static Image img2= new ImageIcon("ui/bar/searchbar/search2.png").getImage();
	private static Image img3= new ImageIcon("ui/bar/searchbar/search3.png").getImage();
	
	private JTextField field;
	private JButton button;
	private MySearchFieldPanel p;
	private int state = 1;
	private int width = 200;
	private int height = 40;

	public MySearchFieldPanel(UIController c) {
		
		this.setPreferredSize(new Dimension(width, height));
		this.setOpaque(false);
		this.setLayout(null);
		p = this;
		
		field = new JTextField();
		field.setBounds(10, 0, (int)(width*0.8)-10, height);
		field.setFont(new Font("黑体", Font.PLAIN, 18));
	//	field.setForeground(new Color(165, 165, 165));
		field.setOpaque(false);
		field.setBorder(new EmptyBorder(0, 0, 0, 0));
		this.add(field);
		
		button = new JButton();
		button.setBounds((int)(width*0.8), (int)(height*0.2), (int)(width*0.15), (int)(height*0.6));
		button.setBorderPainted(false);
		button.setContentAreaFilled(false);
		button.setOpaque(false);
		this.add(button);
		
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
		
		button.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseEntered(MouseEvent e) {
				state = 3;
				p.repaint();
			}
			
			@Override
			public void mouseExited(MouseEvent e) {
				state = 2;
				p.repaint();
			}
			
		});
		
		button.addActionListener(c);
	}
	
	@Override
	protected void paintComponent(Graphics g) {
		super.paintComponent(g);
		switch(state){
		case 1:	g.drawImage(img1, 0, 0, null);break;
		case 2: g.drawImage(img2, 0, 0, null);break;
		case 3:	g.drawImage(img3, 0, 0, null);break;
		}
	}
	
	public void setActionCommand(String actionCommand){
		button.setActionCommand(actionCommand);
	}
}
