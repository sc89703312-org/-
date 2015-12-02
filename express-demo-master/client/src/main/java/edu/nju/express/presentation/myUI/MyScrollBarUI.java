package edu.nju.express.presentation.myUI;

import static sun.swing.SwingUtilities2.drawHLine;
import static sun.swing.SwingUtilities2.drawRect;
import static sun.swing.SwingUtilities2.drawVLine;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.GradientPaint;
import java.awt.Graphics;
import java.awt.Rectangle;

import javax.swing.JButton;
import javax.swing.JComponent;
import javax.swing.plaf.basic.BasicArrowButton;
import javax.swing.plaf.basic.BasicScrollBarUI;

public class MyScrollBarUI extends BasicScrollBarUI {

	@Override
	public Dimension getPreferredSize(JComponent c) {
		// TODO Auto-generated method stub
		return new Dimension(11, 11);
	}

	@Override
	protected void paintThumb(Graphics g, JComponent c, Rectangle thumbBounds) {
		// TODO Auto-generated method stub
		if (thumbBounds.isEmpty() || !scrollbar.isEnabled()) {
			return;
		}

		int w = thumbBounds.width;
		int h = thumbBounds.height;

		g.translate(thumbBounds.x, thumbBounds.y);

		g.setColor(new Color(44, 62, 80));
		g.fillRoundRect(0, 0, w - 1, h - 1, 8, 8);
		g.drawRoundRect(0, 0, w - 1, h - 1, 8, 8);

		/*
		 * g.setColor(thumbDarkShadowColor); drawRect(g, 0, 0, w - 1, h - 1);
		 * g.setColor(thumbColor); g.fillRect(0, 0, w - 1, h - 1);
		 * 
		 * g.setColor(thumbHighlightColor); drawVLine(g, 1, 1, h - 2);
		 * drawHLine(g, 2, w - 3, 1);
		 * 
		 * g.setColor(thumbLightShadowColor); drawHLine(g, 2, w - 2, h - 2);
		 * drawVLine(g, w - 2, 1, h - 3);
		 */

		g.translate(-thumbBounds.x, -thumbBounds.y);
	}

	@Override
	protected void paintTrack(Graphics g, JComponent c, Rectangle trackBounds) {

		g.setColor(new Color(238, 238, 238));
		g.fillRect(trackBounds.x, trackBounds.y, trackBounds.width, trackBounds.height);

		/*
		 * if(trackHighlight == DECREASE_HIGHLIGHT) { paintDecreaseHighlight(g);
		 * } else if(trackHighlight == INCREASE_HIGHLIGHT) {
		 * paintIncreaseHighlight(g); }
		 */
	}

	@Override
	protected JButton createIncreaseButton(int orientation) {
		// TODO Auto-generated method stub
		return new MyArrowButton(orientation);
	}

	@Override
	protected JButton createDecreaseButton(int orientation) {
		return new MyArrowButton(orientation);
	}

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
			// TODO Auto-generated method stub
			return new Dimension(0, 0);
		}
		
	}
}
