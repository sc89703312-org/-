package edu.nju.express.presentation.commodityui;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.RenderingHints;

import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JPanel;

public class CommodityGuide extends JPanel{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	private static int height = 600;
	private static Icon enter1 = new ImageIcon("ui/icon/入库管理1.png");
	private static Icon enter2 = new ImageIcon("ui/icon/入库管理2.png");
	private static Icon exit1 = new ImageIcon("ui/icon/出库管理1.png");
	private static Icon exit2 = new ImageIcon("ui/icon/出库管理2.png");
	private static Icon inventory1 = new ImageIcon("ui/icon/库存盘点1.png");
	private static Icon inventory2 = new ImageIcon("ui/icon/库存盘点2.png");
	private static Icon check1 = new ImageIcon("ui/icon/库存查看1.png");
	private static Icon check2 = new ImageIcon("ui/icon/库存查看2.png");
	private static Icon adjust1 = new ImageIcon("ui/icon/库存调整1.png");
	private static Icon adjust2 = new ImageIcon("ui/icon/库存调整2.png");
	private static Font font = new Font("黑体",Font.BOLD,14);
	
	CommodityController controller;
	
	JButton enter;
	JButton exit;
	JButton inventory;
	JButton check;
	JButton adjust;
	
	public CommodityGuide(CommodityController c){
		this.controller = c;
		initGuide();
		this.setLayout(null);
		this.setOpaque(false);
		this.setBounds(12, 0, 94, height);
	}
	
	private void initGuide(){
		
		enter = new JButton(enter1);
		enter.setRolloverIcon(enter2);
		enter.setBorderPainted(false);
		enter.setContentAreaFilled(false);
		enter.setBounds(1,44,82,82);
		enter.setActionCommand("EnterManageUI");
		enter.addActionListener(controller);
		
		exit = new JButton(exit1);
		exit.setRolloverIcon(exit2);
		exit.setBorderPainted(false);
		exit.setContentAreaFilled(false);
		exit.setBounds(1,144,82,82);
		exit.setActionCommand("ExitManageUI");
		exit.addActionListener(controller);
		
		inventory = new JButton(inventory1);
		inventory.setRolloverIcon(inventory2);
		inventory.setBorderPainted(false);
		inventory.setContentAreaFilled(false);
		inventory.setBounds(1,244,82,82);
		inventory.setActionCommand("ComInventoryUI");
		inventory.addActionListener(controller);
		
		check = new JButton(check1);
		check.setRolloverIcon(check2);
		check.setBorderPainted(false);
		check.setContentAreaFilled(false);
		check.setBounds(1,344,82,82);
		check.setActionCommand("ComCheckUI");
		check.addActionListener(controller);
		
		adjust = new JButton(adjust1);
		adjust.setRolloverIcon(adjust2);
		adjust.setBorderPainted(false);
		adjust.setContentAreaFilled(false);
		adjust.setBounds(1,444,82,82);
		adjust.setActionCommand("ComAdjustUI");
		adjust.addActionListener(controller);
		
		this.add(enter);
		this.add(exit);
		this.add(inventory);
		this.add(check);
		this.add(adjust);
		
	}
	
	@Override
	protected void paintComponent(Graphics g) {
		super.paintComponent(g);
		boolean alarm = controller.getAlarm();
		if(alarm){
			Graphics2D g2d = (Graphics2D)g;
			g2d.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
			g2d.setColor(new Color(240,173,78));
			g2d.fillOval(79-12, 450, 24,24);
			g2d.setFont(font);
			g2d.setColor(new Color(246,249,249));
			int width = g2d.getFontMetrics().stringWidth("!");
			g2d.drawString("!", 79 - width/2, 466);
		}
		
		int message = controller.getEnterMessages();
		if(message != 0 ){
			Graphics2D g2d = (Graphics2D)g;
			g2d.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
			g2d.setColor(new Color(240,173,78));
			g2d.fillOval(79-12, 50, 24,24);
			g2d.setFont(font);
			g2d.setColor(new Color(246,249,249));
			int width = g2d.getFontMetrics().stringWidth(message+"");
			g2d.drawString(message+"", 79 - width/2, 66);
		}
	}
}
