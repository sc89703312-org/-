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

public class EnterSubUI extends MainPanel{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	CommodityController controller;
	EnterReceiptVO vo;
	ArrayList<Object[]> data;
	private static Icon img1 = new ImageIcon("ui/button/subenter1.png");
	private static Icon img2 = new ImageIcon("ui/button/subenter2.png");
	
	MyNormalTable table;
	JButton subenter;
	
	public EnterSubUI(CommodityController c, EnterReceiptVO vo){
		
		this.bg = new ImageIcon("ui/image/combg.png").getImage();
		
		this.controller = c;
		this.vo = vo;
		
		String[] header = {"订单号","分区","排号","架号","位号"};
		table = new MyNormalTable(header);
		initData();
		
		this.add(new CommodityGuide(c));
		
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
		
		subenter = new JButton(img1);
		subenter.setRolloverIcon(img2);
		subenter.setContentAreaFilled(false);
		subenter.setBorderPainted(false);
		subenter.setBounds(450,537,80,30);
		subenter.setActionCommand("subenter");
		subenter.addActionListener(controller);
		this.add(subenter);
		
	}
	
	private void initData(){
		ArrayList<ComGoodsVO> voList = vo.getList();
		for(int i=0;i<voList.size();i++){
			String[] data = {voList.get(i).getOrder().getID(),voList.get(i).getLine()+"",
					voList.get(i).getShelf()+"",voList.get(i).getShelf()+""};
			table.getTableModel().addRow(data);
		}
	}
	
	public EnterReceiptVO getEnterReceipt(){
		return this.vo;
	}
	
}
