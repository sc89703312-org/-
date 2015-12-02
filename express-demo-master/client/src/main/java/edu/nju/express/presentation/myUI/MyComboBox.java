package edu.nju.express.presentation.myUI;

import java.awt.BasicStroke;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.RenderingHints;

import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JComponent;
import javax.swing.border.EmptyBorder;
import javax.swing.border.LineBorder;
import javax.swing.plaf.basic.BasicComboBoxUI;
import javax.swing.plaf.basic.BasicComboPopup;
import javax.swing.plaf.basic.ComboPopup;

public class MyComboBox<E> extends JComboBox<E> {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private static Icon arrowImg = new ImageIcon("ui/button/arrow.png");
	private static Color fore = new Color(44, 62, 80);
	private static Font font = new Font("黑体", Font.PLAIN, 17);
	private static Color back = new Color(246, 249, 249);
	private static Color select = new Color(172, 229, 216);
	private static Color grid = new Color(210, 210, 210);

	public MyComboBox() {
		super();

		// this.setOpaque(false);
		this.setBackground(back);
		this.setFont(font);
		this.setForeground(fore);
		this.setBorder(new EmptyBorder(0, 0, 0, 0));
		this.setUI(new MyComboBoxUI());
		this.setPreferredSize(new Dimension(120, 32));

	}

	@Override
	public void paint(Graphics g) {
		// TODO Auto-generated method stub
		super.paint(g);

	}

	@Override
	protected void paintBorder(Graphics g) {
		// g.drawImage(img, 0, 0, this);
		Graphics2D g2d = (Graphics2D) g;
		g2d.setColor(grid);
		g2d.setStroke(new BasicStroke(1.8f));
		g2d.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
		g.drawRoundRect(0, 0, getWidth() - 2, getHeight() - 2, 6, 6);
	}

	private class MyComboBoxUI extends BasicComboBoxUI {

		MyComboBoxUI() {
			super();
		}

		@Override
		public void installUI(JComponent comboBox) {
			super.installUI(comboBox);
			listBox.setForeground(fore);
			listBox.setBorder(new LineBorder(grid));
			listBox.setSelectionBackground(select);
			listBox.setSelectionForeground(fore);
		}

		/**
		 * 该方法返回右边的按钮
		 */
		@Override
		protected JButton createArrowButton() {
			JButton arrow = new JButton();
			arrow.setIcon(arrowImg);
			arrow.setRolloverEnabled(true);
			arrow.setRolloverIcon(arrowImg);
			arrow.setBorder(null);
			arrow.setContentAreaFilled(false);
			arrow.setBorderPainted(false);
			arrow.setOpaque(false);
			arrow.setContentAreaFilled(false);
			arrow.setName("ComboBox.arrowButton");
			return arrow;
		}

		@Override
		protected ComboPopup createPopup() {
			return new MyComboPopup(comboBox);
		}
	}

	private class MyComboPopup extends BasicComboPopup {

		/**
		 * 
		 */
		private static final long serialVersionUID = 1L;

		public MyComboPopup(JComboBox combo) {
			super(combo);
			this.setForeground(fore);
			this.setBorder(new EmptyBorder(0, 0, 0, 0));

			MyScrollBarUI ui = new MyScrollBarUI();
			scroller.getVerticalScrollBar().setOpaque(false);
			scroller.getVerticalScrollBar().setBorder(new EmptyBorder(0, 0, 0, 0));
			ui.setWidth(9);
			scroller.getVerticalScrollBar().setUI(ui);
			scroller.getVerticalScrollBar().setBorder(new EmptyBorder(0, 0, 0, 0));
		}

	}
}
