package edu.nju.express.presentation.myUI;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Rectangle;
import java.awt.RenderingHints;

import javax.swing.JButton;
import javax.swing.JComponent;
import javax.swing.plaf.basic.BasicArrowButton;
import javax.swing.plaf.basic.BasicScrollBarUI;

public class MyScrollBarUI extends BasicScrollBarUI {

	private int width = 11;
	private Color thumbColor = new Color(44, 62, 80);
	private Color trackColor = new Color(210, 210, 210);

	public MyScrollBarUI() {
		super();
	}

	public void setThumbColor(Color thumbColor) {
		this.thumbColor = thumbColor;
	}

	public void setTrackColor(Color trackColor) {
		this.trackColor = trackColor;
	}

	public void setWidth(int width) {
		this.width = width;
	}

	@Override
	// 滚动条宽度
	public Dimension getPreferredSize(JComponent c) {
		return new Dimension(width, width);
	}

	@Override
	// 绘制滑块
	protected void paintThumb(Graphics g, JComponent c, Rectangle thumbBounds) {
		if (thumbBounds.isEmpty() || !scrollbar.isEnabled()) {
			return;
		}

		int w = thumbBounds.width;
		int h = thumbBounds.height;

		g.translate(thumbBounds.x, thumbBounds.y);

		g.setColor(thumbColor);
		((Graphics2D) g).setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
		g.fillRoundRect(0, 0, w - 1, h - 1, width - 1, width - 1);

		g.translate(-thumbBounds.x, -thumbBounds.y);
	}

	@Override
	// 绘制轨道
	protected void paintTrack(Graphics g, JComponent c, Rectangle trackBounds) {
		if (isThumbRollover()) {
			g.setColor(trackColor);
			((Graphics2D) g).setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
			g.fillRoundRect(trackBounds.x, trackBounds.y, trackBounds.width - 1, trackBounds.height, width - 1,
					width - 1);
		}

	}

	@Override
	protected Rectangle getThumbBounds() {
		// TODO Auto-generated method stub
		return super.getThumbBounds();
	}

	/*
	 * @Override protected void setThumbRollover(boolean active) { // TODO
	 * Auto-generated method stub super.setThumbRollover(active); if
	 * (thumbActive != active) { thumbActive = active;
	 * scrollbar.repaint(getThumbBounds()); } }
	 */

	@Override
	// 绘制上三角
	protected JButton createIncreaseButton(int orientation) {
		return new MyArrowButton(orientation);
	}

	@Override
	// 绘制下三角
	protected JButton createDecreaseButton(int orientation) {
		return new MyArrowButton(orientation);
	}

	// 三角箭头
	private class MyArrowButton extends BasicArrowButton {

		public MyArrowButton(int orientation) {
			super(orientation, new Color(0, 0, 0, 0), new Color(0, 0, 0, 0), new Color(0, 0, 0, 0),
					new Color(0, 0, 0, 0));
		}

		/**
		 * 
		 */
		private static final long serialVersionUID = 1L;

		@Override
		public Dimension getPreferredSize() {
			return new Dimension(0, 0);
		}

	}

}
