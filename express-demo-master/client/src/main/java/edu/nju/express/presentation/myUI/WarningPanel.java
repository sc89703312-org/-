package edu.nju.express.presentation.myUI;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Component;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextArea;

import edu.nju.express.presentation.myUI.MyButton;


public class WarningPanel extends JPanel {

	/** serialVersionUID */
	private static final long serialVersionUID = -6879231059190210680L;
	private static Image img = new ImageIcon("ui/image/dialog.png").getImage();

	/** 标题 */
	private JLabel titleLabel;
	/** 信息提示 */
	private JLabel promptLabel;
	/** 确认按钮 */
	private MyButton confirmBtn;
	
	private Dimension preDimen = new Dimension(30, 30);
	private Font font1 = new Font("宋体", Font.PLAIN, 18);
	private Color fore1 = new Color(246,249,249);
	private Font font2 = new Font("黑体", Font.PLAIN, 18);
	private Color fore2 = new Color(44,62,80);

	private Listener listener;

	public WarningPanel(String title, String prompt) {
		this.setOpaque(false);
		this.listener = new Listener();
		this.setLayout(null);
		titleLabel = new JLabel(title,JLabel.CENTER);
		titleLabel.setBounds(0, 6, 300, 30);
		titleLabel.setPreferredSize(preDimen);
		titleLabel.setFont(font1);
		titleLabel.setForeground(fore1);
		this.add(titleLabel);
		
		promptLabel = new JLabel(prompt,JLabel.CENTER);
		promptLabel.setBounds(0, 60, 300, 90);
		promptLabel.setFont(font2);
		promptLabel.setOpaque(false);
		this.add(promptLabel);
		confirmBtn = new MyButton(286,311,300,26);
		
		confirmBtn.setFont(font1);
		confirmBtn.setPreferredSize(preDimen);
		confirmBtn.addMouseListener(listener);
//		this.add(confirmBtn, BorderLayout.SOUTH);
		
	}

	private class Listener extends MouseAdapter {

		@Override
		public void mouseClicked(MouseEvent e) {
			if (e.getSource() == confirmBtn) {
				Component frame = WarningPanel.this.getParent();
				while(!(frame instanceof WarningDialog)) {
					frame = frame.getParent();
				}
				((WarningDialog)frame).dispose();
			}
		}
	}

	
	@Override
	public void paintComponent(Graphics g) {
		g.drawImage(img, 0, 0, null);
	}
}
