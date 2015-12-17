package edu.nju.express.presentation.financeui;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.FileDialog;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStreamWriter;
import java.util.ArrayList;

import javax.swing.BoxLayout;
import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTable;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableModel;

import edu.nju.express.blservice.Balanceblservice;
import edu.nju.express.common.Item;
import edu.nju.express.presentation.MainPanel;
import edu.nju.express.presentation.myUI.DateComboBoxV2;
import edu.nju.express.presentation.myUI.LabelTextField;
import edu.nju.express.presentation.myUI.MyTablePanel;
import edu.nju.express.presentation.myUI.MyTextField;
import edu.nju.express.vo.Balancevo;
import edu.nju.express.vo.Paymentvo;

public class BussinessConditionPanel extends MainPanel implements ActionListener {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private Font font = new Font("黑体", Font.PLAIN, 18);
	private Color color = new Color(44, 62,80);
	private static Icon search1 = new ImageIcon("ui/button/searchbutton1.png");
	private static Icon search2 = new ImageIcon("ui/button/searchbutton2.png");
	private static Icon export1= new ImageIcon("ui/button/export1.png");
	private static Icon export2 = new ImageIcon("ui/button/export2.png");

	private DateComboBoxV2 date;
	private MyTextField date1;
	private LabelTextField date2;
	private JButton search;
	private MyTablePanel tableB, tableP;
	private JButton export;
	
	Balanceblservice balanceBL;

	private ArrayList<Balancevo> listB;
	private ArrayList<Paymentvo> listP;

	JFrame frame;
	
	
	public BussinessConditionPanel(FinanceController controller,JFrame frame) {

		FinanceGuide guide =new FinanceGuide(controller);
		guide.analyze.setIcon(null);
		this.add(guide);
		bg = new ImageIcon("ui/image/finance/经营情况表.png").getImage();
		
		
		this.frame = frame;
		balanceBL = controller.balance;
		
/*		date = new JPanel();
		date.setOpaque(false);
		date.setBounds(120, 68, 500, 50);
		date1 = new MyTextField(0);
		date2 = new LabelTextField("- ", 0);
		date.add(date1);
		date.add(date2);
		search = new JButton(search1);
		search.setContentAreaFilled(false);
		search.setFocusPainted(false);
		search.setBorder(new EmptyBorder(0, 0, 0, 0));
		search.setRolloverIcon(search2);
		search.addActionListener(this);
		search.setActionCommand("SearchList");
		date.add(search);
		this.add(date);*/
		date = new DateComboBoxV2();
		date.setBounds(115, 76, 610, 50);
		date.getSearchButton().addActionListener(controller);
		date.getSearchButton().setActionCommand("BussinessConditionUI");
		this.add(date);
		
		export = new JButton(export1);
		export.setRolloverIcon(export2);
		export.setBorderPainted(false);
		export.setContentAreaFilled(false);
		export.setBounds(750, 82, 80, 30);
		this.add(export);
		export.setActionCommand("export");
		export.addActionListener(this);

		initData();
		
		JPanel p =new JPanel();
		p.setOpaque(false);

		JLabel pb = new JLabel();
		pb.setOpaque(false);
		pb.setPreferredSize(new Dimension(300,50));
		p.add(pb);
		initTableB();
		p.add(tableB);

		JLabel pp = new JLabel();
		pp.setOpaque(false);
		pp.setPreferredSize(new Dimension(300,20));
		p.add(pp);
		initTableP();
		p.add(tableP);
		p.setLayout(new BoxLayout(p, BoxLayout.Y_AXIS));
		
		p.setBounds(128, 100, 729, 500);
		
		this.add(p);
		

	}

	private void initTableP() {
		String[] header = { "收款日期", "收款金额", "快递员编号", "订单编号" };
		tableP = new MyTablePanel(header);
		Object[] rowdata = new Object[4];
		Paymentvo vo;
		for (int i = 0; i < listP.size(); i++) {
			vo = listP.get(i);
			rowdata[0] = vo.getDate();
			rowdata[1] = vo.getPay()+"";
			rowdata[2] = vo.getCourier_id();
			rowdata[3] = vo.getOrder_id();
			
			tableP.getTableModel().addRow(rowdata);
		}
		tableP.setRowHeight(20);
		tableP.getTable().setPreferredScrollableViewportSize(new Dimension(704,160));
		tableP.setPreferredSize(new Dimension(715,180));
	}

	private void initTableB() {
		String[] header = { "付款日期", "付款金额", "付款人", "付款账号", "条目", "备注" };
		tableB = new MyTablePanel(header);
		Object[] rowdata = new Object[6];
		Balancevo vo;
		for (int i = 0; i < listB.size(); i++) {
			vo = listB.get(i);
			rowdata[0] = vo.getDate();
			rowdata[1] = vo.getMoney();
			rowdata[2] = vo.getName();
			rowdata[3] = vo.getBanking();
			rowdata[4] = vo.getItem().getName();
			rowdata[5] = vo.getRemark();
			tableB.getTableModel().addRow(rowdata);
		}
		tableB.setRowHeight(20);
		tableB.getTable().setPreferredScrollableViewportSize(new Dimension(704,160));
		tableB.setPreferredSize(new Dimension(715,180));
	}

	private void initData() {
		listB = new ArrayList<Balancevo>();
		
		listB = balanceBL.viewCost(AnalyzeUI.getDates()[0], AnalyzeUI.getDates()[1]);
		

		listP = new ArrayList<Paymentvo>();

		
		listP = balanceBL.viewReport(AnalyzeUI.getDates()[0], AnalyzeUI.getDates()[1]);
		
		
	}
	
	//获得payment和cost table
	public JTable[] getTables(){
		JTable[] tables= new JTable[2];
		tables[0] = tableP.getTable();
		tables[1] = tableB.getTable();
		return tables;
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		
		if(e.getSource()==search){
			System.out.println("???");
			

			for(int i=0;i<listB.size();i++)
			tableB.getTableModel().removeRow(0);
			
			for(int i=0;i<listP.size();i++)
			tableP.getTableModel().removeRow(0);
			
			
			
			listB = balanceBL.viewCost(date1.getText(), date2.getText());
			listP = balanceBL.viewReport(date1.getText(), date2.getText());

			
				Object[] rowdata = new Object[6];
				Balancevo vo;
				for (int i = 0; i < listB.size(); i++) {
					vo = listB.get(i);
					rowdata[0] = vo.getDate();
					rowdata[1] = vo.getMoney();
					rowdata[2] = vo.getName();
					rowdata[3] = vo.getBanking();
					rowdata[4] = vo.getItem().getName();
					rowdata[5] = vo.getRemark();
					tableB.getTableModel().addRow(rowdata);
				}
			
				
				
				Object[] rowdata_1 = new Object[4];
				Paymentvo vo_1;
				for (int i = 0; i < listP.size(); i++) {
					vo_1 = listP.get(i);
					rowdata_1[0] = vo_1.getDate();
					rowdata_1[1] = vo_1.getPay()+"";
					rowdata_1[2] = vo_1.getCourier_id();
					rowdata_1[3] = vo_1.getOrder_id();
					
					tableP.getTableModel().addRow(rowdata_1);
				}
		
	}else if (e.getSource()==export) {
		outputExcel();
	}
		
		
	}
	
	
	
	
	public void exportTable(JTable tableA,JTable tableb, File file) throws IOException {
	       DefaultTableModel model = (DefaultTableModel) tableA.getModel();
	       
	       
	       //"ANSI");
	       OutputStreamWriter bWriter=new OutputStreamWriter((new FileOutputStream(file)),"GB2312");
	       //BufferedWriter bWriter = new BufferedWriter(new FileWriter(file));  
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
	       	
	       	
	       	
	       	
	       	 
	       	
	            model = (DefaultTableModel) tableb.getModel();
		       
		       
		       //"ANSI");
		       
		       //BufferedWriter bWriter = new BufferedWriter(new FileWriter(file));  
		       for(int i=0; i < model.getColumnCount(); i++) {
		           bWriter.write(model.getColumnName(i));
		           bWriter.write("\t");
		       	}
		       
		       	bWriter.write("\n");
		       	
		       	
		       	for(int i = 0; i< model.getRowCount(); i++) {
		    	   	for(int j = 0; j < model.getColumnCount(); j++) {
		    	   		
		    	   		String str;
		    	   		
		    	   		if(tableb.getValueAt(i, j) == null){
		    	   			str = " ";
		    	   		}else{
		    	   			str = tableb.getValueAt(i, j).toString();
		    	   		}
		    	   		
		        	   	bWriter.write(str);
		        	   	
		               	bWriter.write("\t");
		           	}
		    		bWriter.write("\n");
		       	}
		       	
		       	
		       	
		       	
		       	
		       	bWriter.close();
	       	
	       	
	   }
	   
	public void outputExcel(){
	    	
		FileDialog fd = new FileDialog(frame, "导出至Excel", FileDialog.SAVE);
	    fd.setLocation(this.getX(), this.getY());
	    fd.setVisible(true);  
	    String stringfile = fd.getDirectory()+fd.getFile()+".xls";  
	    try {   	
	    	exportTable(tableB.getTable(),tableP.getTable(), new File(stringfile));
	    } catch (IOException ex) {
	    	System.out.println(ex.getMessage());
	    	ex.printStackTrace();
	    }
	}
	
}
