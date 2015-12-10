package edu.nju.express.presentation;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;

import edu.nju.express.po.LoginInfo;

public class MainPanel extends JPanel {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	int WIDTH = 900;
	int HEIGHT = 600;
	protected Icon logo = new ImageIcon("ui/icon/logo.png");
	protected Image bg = new ImageIcon("ui/image/bg.png").getImage();
	protected Icon quitIcon1 = new ImageIcon("ui/button/X_darkGray.png");
	protected Icon quitIcon2 = new ImageIcon("ui/button/X_green.png");
	protected Icon icon = new ImageIcon("ui/icon/头像.png");
	private Font font = new Font("宋体",Font.PLAIN,18);
	private Color color = new Color(44,62,80);
	
	protected JButton quit;
	protected String userInfo;

	public MainPanel() {
		this.setLayout(null);
		this.setOpaque(false);

		userInfo = LoginInfo.getUserName()+"  "+LoginInfo.getUserID();
		
		JLabel logoLabel = new JLabel(logo);
		logoLabel.setBounds(118, 16, 100, 40);
		this.add(logoLabel);
		
		JLabel iconLabel = new JLabel(icon);
		iconLabel.setBounds(570, 19, 30, 30);
		this.add(iconLabel);
		
		JLabel userLabel = new JLabel(userInfo);
		userLabel.setBounds(605, 25, 250, 18);
		userLabel.setFont(font);
		userLabel.setForeground(color);
		this.add(userLabel);

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


	}

	@Override
	protected void paintComponent(Graphics g) {
		super.paintComponent(g);
		g.drawImage(bg, 0, 0, this);
	}
}
