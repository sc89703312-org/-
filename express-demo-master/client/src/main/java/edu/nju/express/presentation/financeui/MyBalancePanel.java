package edu.nju.express.presentation.financeui;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.GraphicsEnvironment;
import java.awt.RenderingHints;
import java.math.BigDecimal;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class MyBalancePanel extends JPanel  implements Runnable{

	private static final long serialVersionUID = 1L;
	private Font font1 = new Font("Georgia", Font.ITALIC, 30);
	private Font font2 = new Font("Georgia", Font.ITALIC, 18);

	private Color dark = new Color(44, 62, 80);
	private Color green = new Color(26, 188, 156);
	private Color red = new Color(213, 83, 79);
	private int percent = 0;
	private int width = 282;

	double total, income, payment;

	public MyBalancePanel(double income, double payment) {

		this.income = income;
		this.payment = payment;
		BigDecimal bd = new BigDecimal(income - payment);
		this.total = bd.setScale(2, BigDecimal.ROUND_HALF_UP).doubleValue();

		this.setBounds(94, 109, 794, 270);
		this.setOpaque(false);
		this.setPreferredSize(new Dimension(794, 270));
		this.setLayout(null);

		JLabel mark = new JLabel("￥");
		mark.setBounds(297 - 80+40, 48, 200, 40);
		mark.setFont(new Font("微软雅黑",Font.ITALIC,30));
		mark.setForeground(total >= 0 ? green : red);
		mark.setOpaque(false);
		mark.setHorizontalAlignment(JLabel.CENTER);
		this.add(mark);
		
		JLabel totalLabel = new JLabel(total + "");
		totalLabel.setBounds(297+40, 48, 200, 40);
		totalLabel.setFont(font1);
		totalLabel.setForeground(total >= 0 ? green : red);
		totalLabel.setOpaque(false);
		totalLabel.setHorizontalAlignment(JLabel.CENTER);
		this.add(totalLabel);


	}

	@Override
	public void run() {
		for(int i = 0;i<25;i++){
			repaint();
			percent+=4;
			try {
				Thread.sleep(30);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}

	@Override
	protected void paintComponent(Graphics g) {
		super.paintComponent(g);
		Graphics2D g2d = (Graphics2D)g;
		g2d.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
		
		g2d.setFont(font2);

		if (total >= 0) {
			g2d.setColor(green);
			g2d.fillRect(338, 104, 282*percent/100, 12);
			g2d.setColor(red);
			g2d.fillRect(338, 135, (int) (282 * payment / income*percent/100), 12);
		} else {
			g2d.setColor(green);
			g2d.fillRect(338, 104, (int) (282 * income / payment*percent/100), 12);
			g2d.setColor(red);
			g2d.fillRect(338, 135, 282*percent/100, 12);
		}

		g2d.setColor(green);
		g2d.drawString("+" + income, 330 - g2d.getFontMetrics().stringWidth("+" + income), 115);
		g2d.setColor(red);
		g2d.drawString("- " + payment, 330 - g2d.getFontMetrics().stringWidth("- " + payment), 146);
		
		
	}
	
	public static void main(String[] args) {
		JFrame f = new JFrame();
		f.setSize(900, 600);
		f.setLayout(null);
		f.setVisible(true);
		f.add(new MyBalancePanel(1200, 200));
		
		for(String s: GraphicsEnvironment
				.getLocalGraphicsEnvironment().getAvailableFontFamilyNames()){
			System.out.println(s);
		}

	}
}

