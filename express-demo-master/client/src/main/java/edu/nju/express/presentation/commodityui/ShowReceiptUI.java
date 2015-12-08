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
import edu.nju.express.vo.ComGoodsVO;
import edu.nju.express.vo.EnterReceiptVO;
import edu.nju.express.vo.ExitReceiptVO;

public class ShowReceiptUI extends MainPanel{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	ShowCheckUI saveUI;

	CommodityController controller;
	EnterReceiptVO enter;
	ExitReceiptVO exit;
	private static Icon img1 = new ImageIcon("ui/button/commodityreturn1.png");
	private static Icon img2 = new ImageIcon("ui/button/commodityreturn2.png");
	
	MyNormalTable table;
	JButton back;
	
	public ShowReceiptUI(CommodityController c, EnterReceiptVO vo, ShowCheckUI ui){
		
		this.bg = new ImageIcon("ui/image/combg.png").getImage();
		
		this.saveUI = ui;
		this.controller = c;
		this.enter = vo;
		this.add(new CommodityGuide(c));
		
		String[] header = {"订单号","分区","排号","架号","位号"};
		table = new MyNormalTable(header);
		initEnter();
		
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
		
		back = new JButton(img1);
		back.setRolloverIcon(img2);
		back.setContentAreaFilled(false);
		back.setBorderPainted(false);
		back.setBounds(450,537,120,30);
		back.setActionCommand("back");
		back.addActionListener(controller);
		this.add(back);
		
	}
	
	public ShowReceiptUI(CommodityController c, ExitReceiptVO vo, ShowCheckUI ui){
		
		this.saveUI = ui;
		this.controller = c;
		this.exit = vo;
		this.add(new CommodityGuide(c));
		
		String[] header = {"订单号","分区","排号","架号","位号"};
		table = new MyNormalTable(header);
		initExit();
		
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
		
		back = new JButton(img1);
		back.setRolloverIcon(img2);
		back.setContentAreaFilled(false);
		back.setBorderPainted(false);
		back.setBounds(450,537,120,30);
		back.setActionCommand("back");
		back.addActionListener(controller);
		this.add(back);
		
	}
	
	public void initExit(){
		ArrayList<ComGoodsVO> voList = exit.getList();
		for(int i=0;i<voList.size();i++){
			String[] data = {voList.get(i).getOrder().getID(),voList.get(i).getLine()+"",
					voList.get(i).getShelf()+"",voList.get(i).getShelf()+""};
			table.getTableModel().addRow(data);
		}
	}
	
	private void initEnter(){
		ArrayList<ComGoodsVO> voList = enter.getList();
		for(int i=0;i<voList.size();i++){
			String[] data = {voList.get(i).getOrder().getID(),voList.get(i).getLine()+"",
					voList.get(i).getShelf()+"",voList.get(i).getShelf()+""};
			table.getTableModel().addRow(data);
		}
	}
	
	public ShowCheckUI getSaveUI(){
		return this.saveUI;
	}
	
}
