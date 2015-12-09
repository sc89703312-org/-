package edu.nju.express.presentation.commodityui;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Locale;

import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JScrollPane;
import javax.swing.border.EmptyBorder;

import edu.nju.express.presentation.MainPanel;
import edu.nju.express.presentation.myUI.MyComboBox;
import edu.nju.express.presentation.myUI.MyNormalTable;
import edu.nju.express.presentation.myUI.MyScrollBarUI;
import edu.nju.express.vo.EnterReceiptVO;
import edu.nju.express.vo.ExitReceiptVO;

public class ShowCheckUI extends MainPanel{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	static Font font = new Font("黑体", Font.PLAIN, 18);
	static Color color = new Color(44, 62,80);

	MyComboBox<String> startyear, startmonth, startday;
	MyComboBox<String> endyear, endmonth, endday;
	
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
		
		this.bg = new ImageIcon("ui/image/combg.png").getImage();
		
		this.controller = c;
		
		this.add(new CommodityGuide(c));
		
		String[] header = {"单据种类","单据编号","提交日期","货物数量"};
		table = new MyNormalTable(header);
		table.setRowSelectionAllowed(true);
		
		initComBox();
		
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
		confirmdate.setBounds(745,80,80,30);
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
		table.setRowSelectionAllowed(true);
		
		initComBox();
		
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
	
	private void initComBox(){
		
		Calendar c = Calendar.getInstance(Locale.CHINA);
		
		startyear = new MyComboBox<String>();
		startmonth = new MyComboBox<String>();
		startday = new MyComboBox<String>();
		endyear = new MyComboBox<String>();
		endmonth = new MyComboBox<String>();
		endday = new MyComboBox<String>();
		
		startyear.setPreferredSize(new Dimension(90, 25));
		startmonth.setPreferredSize(new Dimension(65, 25));
		startday.setPreferredSize(new Dimension(65, 25));
		endyear.setPreferredSize(new Dimension(90, 25));
		endmonth.setPreferredSize(new Dimension(65, 25));
		endday.setPreferredSize(new Dimension(65, 25));
		
		for (int i = 1965; i <= 2025; i++){
			startyear.addItem(i+"");
			endyear.addItem(i+"");
		}
		startyear.setSelectedItem(c.get(Calendar.YEAR)+"");
		endyear.setSelectedItem(c.get(Calendar.YEAR)+"");

		for (int i = 1; i <= 12; i++){
			startmonth.addItem(String.format("%02d",i));
			endmonth.addItem(String.format("%02d",i));
		}
		startmonth.setSelectedItem(String.format("%02d",c.get(Calendar.MONTH)+1));
		endmonth.setSelectedItem(String.format("%02d",c.get(Calendar.MONTH)+1));
		
		for (int i = 1; i <= c.getActualMaximum(Calendar.DAY_OF_MONTH); i++){
			startday.addItem(String.format("%02d",i));
			endday.addItem(String.format("%02d",i));
		}
		startday.setSelectedItem(String.format("%02d",c.get(Calendar.DATE)));
		endday.setSelectedItem(String.format("%02d",c.get(Calendar.DATE)));
		
		JLabel starty = new JLabel("年");
		starty.setFont(font);
		starty.setForeground(color);
		JLabel startm = new JLabel("月");
		startm.setFont(font);
		startm.setForeground(color);
		JLabel startd = new JLabel("日");
		startd.setFont(font);
		startd.setForeground(color);
		
		JLabel endy = new JLabel("年");
		endy.setFont(font);
		endy.setForeground(color);
		JLabel endm = new JLabel("月");
		endm.setFont(font);
		endm.setForeground(color);
		JLabel endd = new JLabel("日");
		endd.setFont(font);
		endd.setForeground(color);
		
		startyear.setBounds(140, 82, 90, 25);
		startmonth.setBounds(250, 82, 65, 25);
		startday.setBounds(335,82,65,25);
		endyear.setBounds(440,82,90,25);
		endmonth.setBounds(550,82,65,25);
		endday.setBounds(635,82,65,25);
		starty.setBounds(230, 82, 20, 25);
		startm.setBounds(315, 82, 20, 25);
		startd.setBounds(400,82,20,25);
		endy.setBounds(530, 82, 20, 25);
		endm.setBounds(615, 82, 20, 25);
		endd.setBounds(700,82,20,25);
		
		this.add(startyear);
		this.add(startmonth);
		this.add(startday);
		this.add(starty);
		this.add(startm);
		this.add(startd);
		
		this.add(endyear);
		this.add(endmonth);
		this.add(endday);
		this.add(endy);
		this.add(endm);
		this.add(endd);
		
	}
	
	private void initData(){
		for(int i=0;i<enterList.size();i++){
			String[] data = {"入库单",enterList.get(i).getId(),enterList.get(i).getDate(),enterList.get(i).getList().size()+""};
			table.getTableModel().addRow(data);
		}
		for(int i=0;i<exitList.size();i++){
			String[] data = {"出库单",exitList.get(i).getId(),exitList.get(i).getDate(),exitList.get(i).getList().size()+""};
			table.getTableModel().addRow(data);
		}
	}
	
	public String getStartDate(){
		return startyear.getSelectedItem()+"/"+startmonth.getSelectedItem()+"/"+startday.getSelectedItem();
	}
	
	public String getEndDate(){
		return endyear.getSelectedItem()+"/"+endmonth.getSelectedItem()+"/"+endday.getSelectedItem();
	}
	
	public EnterReceiptVO getEnter(){
		int index = table.getSelectedRow();
		return enterList.get(index);
	}
	
	public ExitReceiptVO getExit(){
		int index = table.getSelectedRow();
		return exitList.get(index-enterList.size());
	}
	
	public String getSelectType(){
		int row = table.getSelectedRow();
		return table.getValueAt(row, 0)+"";
	}

}
