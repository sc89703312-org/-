package edu.nju.express.presentation.commodityui;

import java.util.ArrayList;

import javax.swing.JButton;

import edu.nju.express.presentation.MainPanel;
import edu.nju.express.presentation.myUI.MyCheckBoxTable;
import edu.nju.express.vo.EnterReceiptVO;

public class EnterSubUI extends MainPanel{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	CommodityController controller;
	EnterReceiptVO vo;
	ArrayList<Object[]> data;
	
	MyCheckBoxTable table;
	JButton subenter;
	
	public EnterSubUI(CommodityController c, EnterReceiptVO vo){
		
		this.controller = c;
		this.vo = vo;
		
		String[] header = {"订单号","分区","排号","架号","位号"};
		table = new MyCheckBoxTable(header);
		initData();
		
		
	}
	
	private void initData(){
		
	}
	
}
