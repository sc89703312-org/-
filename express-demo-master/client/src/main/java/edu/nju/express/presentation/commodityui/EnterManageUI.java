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
import edu.nju.express.vo.ArriveReceiptVO;

public class EnterManageUI extends MainPanel{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	CommodityController controller;
	ArrayList<ArriveReceiptVO> volist;
	ArrayList<Object[]> list;
	private static Icon img1 = new ImageIcon("ui/button/createnter1.png");
	private static Icon img2 = new ImageIcon("ui/button/createnter2.png");
	private static Icon img3 = new ImageIcon("ui/button/refreshcom.png");
	private static Icon img4 = new ImageIcon("ui/button/refreshcom2.png");
	
	MyNormalTable table;
	JButton createnter;
	JButton refresharrive;
	
	public EnterManageUI(CommodityController c, ArrayList<ArriveReceiptVO> list){
		
		this.bg = new ImageIcon("ui/image/commodity/showarrive.png").getImage();
		
		this.controller = c;
		this.volist = list;
		
		String[] header = {"编号","提交日期","货物来源","货物数量"};
		table = new MyNormalTable(header);
		initData();
		table.setRowSelectionAllowed(true);
		
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
		
		createnter = new JButton(img1);
		createnter.setRolloverIcon(img2);
		createnter.setContentAreaFilled(false);
		createnter.setBorderPainted(false);
		createnter.setBounds(430,537,120,30);
		createnter.setActionCommand("createnter");
		createnter.addActionListener(controller);
		this.add(createnter);
		
		refresharrive = new JButton(img3);
		refresharrive.setRolloverIcon(img4);
		refresharrive.setContentAreaFilled(false);
		refresharrive.setBorderPainted(false);
		refresharrive.setBounds(810,80,30,30);
		refresharrive.setActionCommand("refresharrive");
		refresharrive.addActionListener(controller);
		this.add(refresharrive);
		
	}
	
	private void initData(){
        for(int i=0;i<volist.size();i++){
        	String[] data = {volist.get(i).getId().substring(13, volist.get(i).getId().length()),volist.get(i).getDate(),volist.get(i).getFrom(),volist.get(i).getList().size()+""};
        	table.getTableModel().addRow(data);
        }
	}
	
	public ArriveReceiptVO getSelectReceipt(){
		int i = table.getSelectedRow();
		return volist.get(i);
	}

}
