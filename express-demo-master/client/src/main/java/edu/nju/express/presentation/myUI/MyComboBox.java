package edu.nju.express.presentation.myUI;

import java.awt.BasicStroke;
import java.awt.Color;
import java.awt.Component;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.RenderingHints;
import java.awt.Shape;
import java.awt.geom.RoundRectangle2D;

import javax.swing.DefaultListCellRenderer;
import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JComponent;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.ListCellRenderer;
import javax.swing.border.EmptyBorder;
import javax.swing.border.LineBorder;
import javax.swing.plaf.basic.BasicComboBoxUI;
import javax.swing.plaf.basic.BasicComboPopup;
import javax.swing.plaf.basic.ComboPopup;

public class MyComboBox<E> extends JComboBox<E> {
	private static final long serialVersionUID = 1L;
	private static Icon arrowImg = new ImageIcon("ui/button/arrow.png");
	private static Color fore = new Color(44, 62, 80);
	private static Font font = new Font("黑体", Font.PLAIN, 17);
	private static Color back = new Color(246, 249, 249);
	private static Color select = new Color(172, 229, 216);
	private static Color grid = new Color(210, 210, 210);

	public MyComboBox() {
		super();
		this.setOpaque(false);
		this.setBackground(back);
		this.setFont(font);
		this.setForeground(fore);
		this.setBorder(new EmptyBorder(0, 0, 0, 0));
		this.setUI(new MyComboBoxUI());
		this.setRenderer(new MyRenderer());
		this.setPreferredSize(new Dimension(120, 32));
		this.setMaximumRowCount(4);

	}

	// 画出文字栏的边框
	@Override
	protected void paintBorder(Graphics g) {
		Graphics2D g2d = (Graphics2D) g;
		g2d.setColor(grid);
		g2d.setStroke(new BasicStroke(1.8f));
		g2d.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
		g2d.drawRoundRect(0, 0, getWidth() - 2, getHeight() - 2, getHeight() - 2, getHeight() - 2);
	}

	private class MyComboBoxUI extends BasicComboBoxUI {

		MyComboBoxUI() {
			super();
		}

		@Override
		public void installUI(JComponent comboBox) {
			super.installUI(comboBox);
			listBox.setForeground(fore);
			listBox.setBorder(new EmptyBorder(0, 0, 0, 0));
		}

		// 返回右边的按钮
		@Override
		protected JButton createArrowButton() {
			JButton arrow = new JButton();
			arrow.setIcon(arrowImg);
			arrow.setRolloverEnabled(true);
			arrow.setRolloverIcon(arrowImg);
			arrow.setBorder(null);
			arrow.setContentAreaFilled(false);
			arrow.setBorderPainted(false);
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
		private static final long serialVersionUID = 1L;

		public MyComboPopup(JComboBox combo) {
			super(combo);

			// 画出下拉框的边框
			setBorder(new LineBorder(new Color(0, 0, 0, 0), 10, true) {
				public void paintBorder(Component c, Graphics g, int x, int y, int width, int height) {
					int offs = 2;
					int size = offs + offs;
					Graphics2D g2d = (Graphics2D) g;
					
					float arc = 1.2f;
					
					g2d.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
					Shape inner = new RoundRectangle2D.Float(x+offs+arc, y, 
							width - size-2*arc, height-arc, 24,24);
					g2d.setColor(back);
					g2d.fill(inner);
					g2d.setStroke(new BasicStroke(arc));
					g2d.setColor(grid);
					g2d.draw(inner);
				}
			});

			// 更改下拉框的滚动条
			MyScrollBarUI ui = new MyScrollBarUI();
			scroller.getVerticalScrollBar().setOpaque(false);
			scroller.getVerticalScrollBar().setBorder(new EmptyBorder(0, 0, 0, 0));
			scroller.getVerticalScrollBar().setUI(ui);
		}


	}

	public class MyRenderer implements ListCellRenderer {

		private DefaultListCellRenderer defaultCellRenderer = new DefaultListCellRenderer();

		public MyRenderer() {
			super();
		}

		public Component getListCellRendererComponent(JList list, Object value, int index, boolean isSelected,
				boolean cellHasFocus) {

			//设置下拉框列表的颜色
			JLabel renderer = (JLabel) defaultCellRenderer.getListCellRendererComponent(list, value, index, isSelected,
					cellHasFocus);

			if (isSelected) {
				renderer.setBackground(select);
				renderer.setForeground(fore.brighter().brighter());
			} else {
				renderer.setForeground(fore.brighter());
				renderer.setBackground(back);
			}
			list.setBackground(back);
			list.setSelectionBackground(back);

			renderer.setFont(font);
			renderer.setHorizontalAlignment(JLabel.CENTER);
			return renderer;
		}
	}
}
