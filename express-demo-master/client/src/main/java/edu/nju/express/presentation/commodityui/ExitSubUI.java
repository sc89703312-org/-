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
	private static Icon img3 = new ImageIcon("ui/button/backcom.png");
	private static Icon img4 = new ImageIcon("ui/button/backcom2.png");
	
	Font font = new Font("黑体",Font.PLAIN,16);
	Color color = new Color(100,100,100);
	
	JLabel title;
	
	MyNormalTable table;
	JButton subexit;
	JButton backexit;
	
	public ExitSubUI(CommodityController c, ExitReceiptVO vo){
		
		this.bg = new ImageIcon("ui/image/commodity/showexit.png").getImage();
		
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
		
		subexit = new JButton(img1);
		subexit.setRolloverIcon(img2);
		subexit.setContentAreaFilled(false);
		subexit.setBorderPainted(false);
		subexit.setBounds(450,537,80,30);
		subexit.setActionCommand("subexit");
		subexit.addActionListener(controller);
		this.add(subexit);
		
		backexit = new JButton(img3);
		backexit.setRolloverIcon(img4);
		backexit.setContentAreaFilled(false);
		backexit.setBorderPainted(false);
		backexit.setBounds(810,80,30,30);
		backexit.setActionCommand("backexit");
		backexit.addActionListener(controller);
		this.add(backexit);
		
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
	
	public ExitReceiptVO getExitReceipt(){
		return this.vo;
	}
	
}
