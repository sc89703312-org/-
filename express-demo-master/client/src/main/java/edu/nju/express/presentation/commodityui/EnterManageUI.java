package edu.nju.express.presentation.commodityui;

import java.util.ArrayList;

import javax.swing.JButton;

import edu.nju.express.presentation.MainPanel;
import edu.nju.express.presentation.myUI.MyCheckBoxTable;
import edu.nju.express.vo.ArriveReceiptVO;

public class EnterManageUI extends MainPanel{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	CommodityController controller;
	ArrayList<ArriveReceiptVO> volist;
	ArrayList<Object[]> list;
	
	MyCheckBoxTable table;
	JButton button;
	
	public EnterManageUI(CommodityController c){
		
		this.controller = c;
		
		String[] header = {"编号","提交日期","货物来源","货物数量"};
		table = new MyCheckBoxTable(header);
		initData();
		
		
		
	}
	
	private void initData(){
		Object[] data = {"0250001","2015/12/7","Shanghai","1"};
		for(int i=1;i<=40;i++){
			data[0] = "0"+250000+i;
			data[3] = i+"";
			table.getTableModel().addRow(data);
		}
	}
	

}
