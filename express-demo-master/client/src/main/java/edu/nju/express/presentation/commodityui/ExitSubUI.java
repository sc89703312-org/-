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
import edu.nju.express.vo.ExitReceiptVO;

public class ExitSubUI extends MainPanel{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	CommodityController controller;
	ExitReceiptVO vo;
	ArrayList<Object[]> data;
	private static Icon img1 = new ImageIcon("ui/button/subenter1.png");
	private static Icon img2 = new ImageIcon("ui/button/subenter2.png");
	
	MyNormalTable table;
	JButton subexit;
	
	public ExitSubUI(CommodityController c, ExitReceiptVO vo){
		
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
		
		subexit = new JButton(img1);
		subexit.setRolloverIcon(img2);
		subexit.setContentAreaFilled(false);
		subexit.setBorderPainted(false);
		subexit.setBounds(450,537,80,30);
		subexit.setActionCommand("subexit");
		subexit.addActionListener(controller);
		this.add(subexit);
		
	}
	
	private void initData(){
		ArrayList<ComGoodsVO> voList = vo.getList();
		for(int i=0;i<voList.size();i++){
			String[] data = {voList.get(i).getOrder().getID(),voList.get(i).getLine()+"",
					voList.get(i).getShelf()+"",voList.get(i).getShelf()+""};
			table.getTableModel().addRow(data);
		}
	}
	
	public ExitReceiptVO getExitReceipt(){
		return this.vo;
	}
	
}
