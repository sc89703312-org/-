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
import edu.nju.express.vo.TransferReceiptVO;

public class ExitManageUI extends MainPanel{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	CommodityController controller;
	ArrayList<TransferReceiptVO> volist;
	ArrayList<Object[]> list;
	private static Icon img1 = new ImageIcon("ui/button/createxit1.png");
	private static Icon img2 = new ImageIcon("ui/button/createxit2.png");
	
	MyNormalTable table;
	JButton createxit;
	
	public ExitManageUI(CommodityController c){
		
		this.controller = c;
		
		String[] header = {"编号","提交日期","货物来源","货物数量"};
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
		
		createxit = new JButton(img1);
		createxit.setRolloverIcon(img2);
		createxit.setContentAreaFilled(false);
		createxit.setBorderPainted(false);
		createxit.setBounds(450,537,80,30);
		createxit.setActionCommand("createxit");
		createxit.addActionListener(controller);
		this.add(createxit);
		
	}
	
	private void initData(){
		Object[] data = {"0250001","2015/12/7","Shanghai","1"};
		for(int i=1;i<=40;i++){
			data[0] = "0"+250000+i;
			data[3] = i+"";
			table.getTableModel().addRow(data);
		}
	}
	
	public TransferReceiptVO getSelectReceipt(){
		int i = table.getSelectedRow();
		return volist.get(i);
	}
	
}
