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

public class ShowInventoryUI extends MainPanel{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	CommodityController controller;
	ArrayList<ComGoodsVO> voList;
	private static Icon img1 = new ImageIcon("ui/button/movegoods1.png");
	private static Icon img2 = new ImageIcon("ui/button/movegoods2.png");
	
	MyNormalTable table;
	JButton movegoods;
	
	public ShowInventoryUI(CommodityController c, ArrayList<ComGoodsVO> list){
		
		this.bg = new ImageIcon("ui/image/combg.png").getImage();
		
		this.controller = c;
		this.voList = list;
		
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
		
		movegoods = new JButton(img1);
		movegoods.setRolloverIcon(img2);
		movegoods.setContentAreaFilled(false);
		movegoods.setBorderPainted(false);
		movegoods.setBounds(450,537,120,30);
		movegoods.setActionCommand("movegoods");
		movegoods.addActionListener(controller);
		this.add(movegoods);
		
	}
	
	private void initData(){
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
	
	public ArrayList<ComGoodsVO> getList(){
		return this.voList;
	}
	
}
