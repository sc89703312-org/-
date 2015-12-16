package edu.nju.express.presentation.myUI;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Component;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextArea;

import edu.nju.express.presentation.myUI.MyButton;


public class WarningPanel extends JPanel {

	/** serialVersionUID */
	private static final long serialVersionUID = -6879231059190210680L;

	/** 标题 */
	private JLabel titleLabel;
	/** 信息提示 */
	private JTextArea promptLabel;
	/** 确认按钮 */
	private MyButton confirmBtn;
	
	private Dimension preDimen = new Dimension(30, 30);
	private Font font = new Font("微软雅黑", Font.PLAIN, preDimen.height / 2);

	private Listener listener;

	public WarningPanel(String title, String prompt) {
		this.listener = new Listener();
		this.setLayout(new BorderLayout());
		titleLabel = new JLabel(title, JLabel.CENTER);
		titleLabel.setBackground(Color.LIGHT_GRAY);
		titleLabel.setOpaque(true);
		titleLabel.setPreferredSize(preDimen);
		titleLabel.setFont(font);
		this.add(titleLabel, BorderLayout.NORTH);
		promptLabel = new JTextArea("\r\n\r\n");
		promptLabel.append(prompt);
		
		promptLabel.setFont(font);
		promptLabel.setLineWrap(true);
		promptLabel.setEditable(false);
		this.add(promptLabel, BorderLayout.CENTER);
		confirmBtn = new MyButton(286,311,300,26);
		
		confirmBtn.setFont(font);
		confirmBtn.setPreferredSize(preDimen);
		confirmBtn.addMouseListener(listener);
		this.add(confirmBtn, BorderLayout.SOUTH);
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

}
