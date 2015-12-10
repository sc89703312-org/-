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

public class MoveGoodsUI extends MainPanel{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	CommodityController controller;
	ArrayList<ComGoodsVO> voList;
	private static Icon img1 = new ImageIcon("ui/button/confirmmove1.png");
	private static Icon img2 = new ImageIcon("ui/button/confirmmove2.png");
	private static Icon img3 = new ImageIcon("ui/button/backcom.png");
	private static Icon img4 = new ImageIcon("ui/button/backcom2.png");
	
	MyNormalEditableTable table;
	JButton confirmmove;
	JButton backinventory;
	
	public MoveGoodsUI(CommodityController c, ArrayList<ComGoodsVO> list){
		
		this.bg = new ImageIcon("ui/image/commodity/movegoods.png").getImage();
		
		this.controller = c;
		this.voList = list;
		
		String[] header = {"订单号","分区","排号","架号","位号"};
		table = new MyNormalEditableTable(header);
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
		
		confirmmove = new JButton(img1);
		confirmmove.setRolloverIcon(img2);
		confirmmove.setContentAreaFilled(false);
		confirmmove.setBorderPainted(false);
		confirmmove.setBounds(450,537,80,30);
		confirmmove.setActionCommand("confirmmove");
		confirmmove.addActionListener(controller);
		this.add(confirmmove);
		
		backinventory = new JButton(img3);
		backinventory.setRolloverIcon(img4);
		backinventory.setContentAreaFilled(false);
		backinventory.setBorderPainted(false);
		backinventory.setBounds(810,80,30,30);
		backinventory.setActionCommand("backinventory");
		backinventory.addActionListener(controller);
		this.add(backinventory);
		
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
	
	public Object[][] getTableObjects(){
		int rowNum = table.getRowCount();
		Object[][] data = new Object[rowNum][5];
		for(int row=0;row<rowNum;row++)
			for(int column=0;column<5;column++)
				data[row][column] = table.getValueAt(row, column);
		return data;
	}
	
	class MyNormalEditableTable extends MyNormalTable{

		/**
		 * 
		 */
		private static final long serialVersionUID = 1L;

		public MyNormalEditableTable(String[] headerStr) {
			super(headerStr);
			// TODO Auto-generated constructor stub
		}
		
		@Override
		public boolean isCellEditable(int row, int column) {
            if(column==1||column==0)
            	return false;
            else
            	return true;
		}
		
	}

}
