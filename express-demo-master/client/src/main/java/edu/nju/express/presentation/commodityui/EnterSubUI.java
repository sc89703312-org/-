package edu.nju.express.presentation.commodityui;

import java.awt.Color;
import java.awt.Font;
import java.util.ArrayList;

import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JLabel;
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
	private static Icon img3 = new ImageIcon("ui/button/backcom.png");
	private static Icon img4 = new ImageIcon("ui/button/backcom2.png");
	
	Font font = new Font("黑体",Font.PLAIN,16);
	Color color = new Color(100,100,100);
	
	JLabel title;
	
	MyNormalTable table;
	JButton subenter;
	JButton backenter;
	
	public EnterSubUI(CommodityController c, EnterReceiptVO vo){
		
		this.bg = new ImageIcon("ui/image/commodity/showenter.png").getImage();
		
		this.controller = c;
		this.vo = vo;
		
		String[] header = {"订单号","分区","排号","架号","位号"};
		table = new MyNormalTable(header);
		initData();
		
		this.add(new CommodityGuide(c));
		
		title = new JLabel("编号： "+vo.getId()+"        "+"日期： "+vo.getDate());
		title.setFont(font);
		title.setForeground(color);
		title.setBackground(new Color(229,233,234));
		title.setBounds(180,80,700,30);
		this.add(title);
		
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
		
		backenter = new JButton(img3);
		backenter.setRolloverIcon(img4);
		backenter.setContentAreaFilled(false);
		backenter.setBorderPainted(false);
		backenter.setBounds(810,80,30,30);
		backenter.setActionCommand("backenter");
		backenter.addActionListener(controller);
		this.add(backenter);
		
	}
	
	private void initData(){
		ArrayList<ComGoodsVO> voList = vo.getList();
		for(int i=0;i<voList.size();i++){
			int type = voList.get(i).getType();
			String area = "";
			switch(type){
			case 1: area = "航空区";break;
			case 2: area = "铁运区";break;
			case 3: area = "汽运区";break;
			case 4: area = "机动区";break;
			}
			String[] data = {voList.get(i).getOrder().getID(),area,voList.get(i).getLine()+"",
					voList.get(i).getShelf()+"",voList.get(i).getCell()+""};
			table.getTableModel().addRow(data);
		}
	}
	
	public EnterReceiptVO getEnterReceipt(){
		return this.vo;
	}
	
}
