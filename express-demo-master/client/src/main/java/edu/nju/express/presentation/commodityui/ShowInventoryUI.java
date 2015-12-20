package edu.nju.express.presentation.commodityui;

import java.awt.FileDialog;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStreamWriter;
import java.util.ArrayList;

import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableModel;

import edu.nju.express.presentation.MainPanel;
import edu.nju.express.presentation.myUI.MyNormalTable;
import edu.nju.express.presentation.myUI.MyScrollBarUI;
import edu.nju.express.presentation.myUI.RefreshButton;
import edu.nju.express.vo.ComGoodsVO;

public class ShowInventoryUI extends MainPanel{

	/**
	 * 库存盘点
	 */
	private static final long serialVersionUID = 1L;

	CommodityController controller;
	ArrayList<ComGoodsVO> voList;
	private static Icon img1 = new ImageIcon("ui/button/movegoods1.png");
	private static Icon img2 = new ImageIcon("ui/button/movegoods2.png");
	private static Icon img3 = new ImageIcon("ui/button/refreshcom.png");
	private static Icon img4 = new ImageIcon("ui/button/refreshcom2.png");
	private static Icon img5 = new ImageIcon("ui/button/comexport1.png");
	private static Icon img6 = new ImageIcon("ui/button/comexport2.png");
	
	MyNormalTable table;
	JButton movegoods;
	JButton refreshinventory;
	JButton export;
	
	public ShowInventoryUI(CommodityController c, ArrayList<ComGoodsVO> list){
		this.bg = new ImageIcon("ui/image/commodity/showinventory.png").getImage();
		this.remove(logoLabel);
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
		movegoods.setBounds(320,537,120,30);
		movegoods.setActionCommand("movegoods");
		movegoods.addActionListener(controller);
		this.add(movegoods);
		
		export = new JButton(img5);
		export.setRolloverIcon(img6);
		export.setContentAreaFilled(false);
		export.setBorderPainted(false);
		export.setBounds(520,537,120,30);
		export.setActionCommand("exportinventory");
		export.addActionListener(controller);
		this.add(export);
		
		refreshinventory = new RefreshButton();
		refreshinventory.setActionCommand("refreshinventory");
		refreshinventory.addActionListener(controller);
		this.add(refreshinventory);
		
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
	
	public void exportTable(JTable tableA,File file) throws IOException {
	      
		DefaultTableModel model = (DefaultTableModel) tableA.getModel();
	       
	    OutputStreamWriter bWriter=new OutputStreamWriter((new FileOutputStream(file)),"GB2312");
	       for(int i=0; i < model.getColumnCount(); i++) {
	           bWriter.write(model.getColumnName(i));
	           bWriter.write("\t");
	       	}
	       
	       	bWriter.write("\n");	       		       	
	       	
	       	for(int i = 0; i< model.getRowCount(); i++) {
	    	   	
	       		for(int j = 0; j < model.getColumnCount(); j++) {
	    	   		String str;
	    	   	
	    	   		if(tableA.getValueAt(i, j) == null){
	    	   			str = " ";
	    	   		}else{
	    	   			str = tableA.getValueAt(i, j).toString();
	    	   		}
	    	   		
	        	   	bWriter.write(str);
	        	   	
	               	bWriter.write("\t");
	           	}
	    		bWriter.write("\n");
	       	}
	       	bWriter.write("\n");
		       
            bWriter.close();	       	
	       	
	   }
	
	public void outputExcel(){
    	
		FileDialog fd = new FileDialog(controller.frame, "导出至Excel", FileDialog.SAVE);
	    fd.setLocation(this.getX(), this.getY());
	    fd.setVisible(true);  
	    String stringfile = fd.getDirectory()+fd.getFile()+".xls";  
	    try {   	
	    	exportTable(table,new File(stringfile));
	    } catch (IOException ex) {
	    	System.out.println(ex.getMessage());
	    	ex.printStackTrace();
	    }
	}
	
}
