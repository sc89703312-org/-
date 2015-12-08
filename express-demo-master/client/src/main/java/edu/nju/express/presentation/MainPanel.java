package edu.nju.express.presentation;

import java.awt.Graphics;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class MainPanel extends JPanel {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	int WIDTH = 900;
	int HEIGHT = 600;
	int BAR_HEIGHT = 50;
	Image logo;
	protected Image bg = new ImageIcon("ui/image/bg.png").getImage();
	Icon quitIcon1 = new ImageIcon("ui/button/X_darkGray.png");
	Icon quitIcon2 = new ImageIcon("ui/button/X_green.png");
	
	JButton quit;
	JButton signOut;
	JLabel welcome;
	String userInfo;

	public MainPanel() {
		this.setLayout(null);
		this.setOpaque(false);

		// init logo
		JLabel label = new JLabel("此处应有logo");
		label.setBounds(0, 0, 80, BAR_HEIGHT);
		label.setOpaque(false);
//		this.add(label);

		// init buttons
		quit = new JButton(quitIcon1);
		quit.setRolloverIcon(quitIcon2);
		quit.setContentAreaFilled(false);
		quit.setBorderPainted(false);
		quit.setBounds(WIDTH - 60, 20, 30, 30);
		quit.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				System.exit(0);

			}
		});
		this.add(quit);

		welcome = new JLabel("Welcome!" + userInfo);
		welcome.setBounds((int) (WIDTH * 0.6), 0, 150, BAR_HEIGHT);
		welcome.setOpaque(false);
	//	this.add(welcome);

		signOut = new JButton("退出登录");
		signOut.setOpaque(false);
		signOut.setBounds((int) (WIDTH * 0.8), 0, 100, BAR_HEIGHT);
//		this.add(signOut);

	}

	@Override
	protected void paintComponent(Graphics g) {
		// TODO Auto-generated method stub
		super.paintComponent(g);
		g.drawImage(bg, 0, 0, this);
	}
}
