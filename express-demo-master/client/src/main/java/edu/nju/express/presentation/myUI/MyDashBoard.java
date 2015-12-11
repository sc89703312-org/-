package edu.nju.express.presentation.myUI;

import java.awt.BasicStroke;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.RenderingHints;
import java.awt.Shape;
import java.awt.geom.Arc2D;

import javax.swing.JFrame;
import javax.swing.JPanel;

public class MyDashBoard extends JPanel implements Runnable{

	public int temp = 0;
	private int percent;
	private static int width = 120;
	private static int height = 120;
	private static Color fore = new Color(44, 62, 80);
	private static Font font = new Font("黑体", Font.BOLD, 30);
	// 绿黄红
	private static Color[] colorInnerList = { new Color(23,188,156), new Color(240, 173, 78), new Color(217, 83, 79) };
	private static Color[] colorOuterList = {new Color(125,200,185), new Color(244,197,130), new Color(246,142,139),};
	private static int[] percentList = { 40, 70, 100 };
	private Color colorInner,colorOuter;

	public MyDashBoard(int percent) {
		for (int i = 0; i < 3; i++) {
			if (percent <= percentList[i]) {
				colorInner = colorInnerList[i];
				colorOuter = colorOuterList[i];
				break;
			}
		}

		this.percent = percent;
		this.setOpaque(false);
		this.setPreferredSize(new Dimension(width, height));

	}

	public void setTemp(int temp) {
		this.temp = temp;
	}

	@Override
	protected void paintComponent(Graphics g) {
		Graphics2D g2d = (Graphics2D) g;
		float w = 12;
		g2d.setStroke(new BasicStroke(w));
		g2d.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);

		g2d.setColor(colorOuter);
		g2d.draw(new Arc2D.Float(w / 2, w / 2, width - w - 1, height - w - 1, 0, 360, Arc2D.OPEN));

		g2d.setColor(colorInner);
		Arc2D arc = new Arc2D.Float(w / 2, w / 2, width - w - 1, height - w - 1, 90f, -(temp / 100.0f * 360.0f),
				Arc2D.OPEN);
		g2d.draw(arc);

		g2d.setColor(fore);
		g2d.setFont(font);
		g2d.setStroke(new BasicStroke(2));
		int fw = g2d.getFontMetrics().stringWidth(temp + "");
		g2d.drawString(temp + "", width / 2 - fw/2, height / 2 + 10);
	}

	public static void main(String[] args) {
		JFrame f = new JFrame();

		f.setSize(new Dimension(width, height));
		f.setLocationRelativeTo(null);
		f.setUndecorated(true);

		int percent =50;
		MyDashBoard p = new MyDashBoard(percent);
		f.add(p);
		f.setVisible(true);
		f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

		p.run();

	}

	@Override
	public void run() {
		for (int i = 0; i <= percent; i++) {
			this.temp = i;
			this.repaint();
			try {
				Thread.sleep(20 - i / 5);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}

}
