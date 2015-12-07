package edu.nju.express.presentation.financeui;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Image;

import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import edu.nju.express.blservice.Balanceblservice;
import edu.nju.express.presentation.MainPanel;
import edu.nju.express.presentation.myUI.LabelTextField;
import edu.nju.express.presentation.myUI.MyTextField;

public class AnalyzeUI extends MainPanel {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private Font font = new Font("微软雅黑", Font.BOLD, 20);
	private Color color = new Color(44, 62,80);
	private static Icon search1 = new ImageIcon("ui/button/searchbutton1.png");
	private static Icon search2 = new ImageIcon("ui/button/searchbutton2.png");
	private static Image bg = new ImageIcon("ui/image/bg1.png").getImage();

	private FinanceController controller;

	private JPanel date;
	private static MyTextField date1;
	private static LabelTextField date2;
	private JButton search;

	
	Balanceblservice balanceBL;
	
	private double[] balance;

	public AnalyzeUI(FinanceController c) {

		controller = c;
		this.add(new FinanceGuide(controller));

		
	    balanceBL = c.balance;
		
		initDate();

		initBalance();

	}

	private void initBalance() {
		initData();
		
		JLabel l1 = new JLabel("总收入：    "+balance[0]);
		l1.setBounds(400, 160, 400, 40);
		l1.setFont(font);
		l1.setForeground(color);
		l1.setOpaque(false);
		this.add(l1);
		
		JLabel l2 = new JLabel("总支出：    "+balance[1]+"");
		l2.setBounds(400, 220, 400, 40);
		l2.setFont(font);
		l2.setForeground(color);
		l2.setOpaque(false);
		this.add(l2);
		
		JLabel l3 = new JLabel("总收益：    "+balance[2]+"");
		l3.setBounds(400, 280, 400, 40);
		l3.setFont(font);
		l3.setForeground(color);
		l3.setOpaque(false);
		this.add(l3);
		
		
	}

	private void initData() {
		balance = balanceBL.viewBalance();
		
	}

	private void initDate() {
		date = new JPanel();
		date.setOpaque(false);
		date.setBounds(250, 400, 500, 60);
		date1 = new MyTextField(0);
		date2 = new LabelTextField("- ", 0);
		date.add(date1);
		date.add(date2);
		search = new JButton(search1);
		search.setContentAreaFilled(false);
		search.setFocusPainted(false);
		search.setBorder(new EmptyBorder(0, 0, 0, 0));
		search.setRolloverIcon(search2);
		search.addActionListener(controller);
		search.setActionCommand("BussinessConditionUI");
		date.add(search);
		this.add(date);
	}

	public static String[] getDates() {
		String[] d = new String[2];
		d[0] = date1.getText();
		d[1] = date2.getText();
		return d;
	}

	@Override
	protected void paintComponent(Graphics g) {
		// TODO Auto-generated method stub
		super.paintComponent(g);
		g.drawImage(bg, 0, 0, null);
	}
}
