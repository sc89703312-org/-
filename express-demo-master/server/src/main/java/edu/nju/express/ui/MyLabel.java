package edu.nju.express.ui;

import java.awt.Color;
import java.awt.Font;

import javax.swing.JLabel;

public class MyLabel extends JLabel {

	private static final long serialVersionUID = 1L;

	public MyLabel(int x, int y, int width, int height){
		this.setBounds(x, y, width, height);
		this.setVisible(true);
		this.setOpaque(true);
		this.setFont(new Font("微软雅黑", Font.PLAIN, 16));
		this.setForeground(new Color(130,130,130));
		this.setHorizontalAlignment(MyLabel.CENTER);
	}
}
