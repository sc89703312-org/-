package edu.nju.express.presentation.commodityui;

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
	
}
