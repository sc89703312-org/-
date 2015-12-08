package edu.nju.express.presentation.commodityui;

import java.util.ArrayList;

import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JScrollPane;
import javax.swing.border.EmptyBorder;

import edu.nju.express.presentation.MainPanel;
import edu.nju.express.presentation.myUI.MyNormalTable;
import edu.nju.express.presentation.myUI.MyScrollBarUI;
import edu.nju.express.vo.EnterReceiptVO;
import edu.nju.express.vo.ExitReceiptVO;

public class ShowCheckUI extends MainPanel{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	CommodityController controller;
	ArrayList<EnterReceiptVO> enterList;
	ArrayList<ExitReceiptVO> exitList;
	private static Icon img1 = new ImageIcon("ui/button/showreceipt1.png");
	private static Icon img2 = new ImageIcon("ui/button/showreceipt2.png");
	private static Icon img3 = new ImageIcon("ui/button/confirmmove1.png");
	private static Icon img4 = new ImageIcon("ui/button/confirmmove2.png");
	
	MyNormalTable table;
	JButton showreceipt;
	JButton confirmdate;
	
	public ShowCheckUI(CommodityController c){
		
		this.controller = c;
		
		this.add(new CommodityGuide(c));
		
		String[] header = {"单据种类","单据编号","提交日期","货物数量"};
		table = new MyNormalTable(header);
		
		JScrollPane s = new JScrollPane(table);
		s.setBounds(128,112,727,420);
		s.setViewportBorder(new EmptyBorder(0, 0, 0, 0));
		s.setOpaque(false);
		s.getViewport().setOpaque(false);
		s.setColumnHeaderView(table.getTableHeader());
		s.getColumnHeader().setOpaque(false);
		s.setBorder(new EmptyBorder(0, 0, 0, 0));
		s.getVerticalScrollBar().setUI(new MyScrollBarUI());
		s.getVerticalScrollBar().setOpaque(false);
		this.add(s);
		
		showreceipt = new JButton(img1);
		showreceipt.setRolloverIcon(img2);
		showreceipt.setContentAreaFilled(false);
		showreceipt.setBorderPainted(false);
		showreceipt.setBounds(450,537,120,30);
		showreceipt.setActionCommand("showreceipt");
		showreceipt.addActionListener(controller);
		this.add(showreceipt);
		
		confirmdate = new JButton(img3);
		confirmdate.setRolloverIcon(img4);
		confirmdate.setContentAreaFilled(false);
		confirmdate.setBorderPainted(false);
		confirmdate.setBounds(750,100,80,30);
		confirmdate.setActionCommand("confirmdate");
		confirmdate.addActionListener(controller);
		this.add(confirmdate);
		
	}
	
	public ShowCheckUI(CommodityController c, ArrayList<EnterReceiptVO> enter, ArrayList<ExitReceiptVO> exit){
		
		this.controller = c;
		this.enterList = enter;
		this.exitList = exit;
		
		this.add(new CommodityGuide(c));
		
		String[] header = {"单据种类","单据编号","提交日期","货物数量"};
		table = new MyNormalTable(header);
		initData();
		
		JScrollPane s = new JScrollPane(table);
		s.setBounds(128,112,727,420);
		s.setViewportBorder(new EmptyBorder(0, 0, 0, 0));
		s.setOpaque(false);
		s.getViewport().setOpaque(false);
		s.setColumnHeaderView(table.getTableHeader());
		s.getColumnHeader().setOpaque(false);
		s.setBorder(new EmptyBorder(0, 0, 0, 0));
		s.getVerticalScrollBar().setUI(new MyScrollBarUI());
		s.getVerticalScrollBar().setOpaque(false);
		this.add(s);
		
	}
	
	private void initData(){
		
	}
	

}
