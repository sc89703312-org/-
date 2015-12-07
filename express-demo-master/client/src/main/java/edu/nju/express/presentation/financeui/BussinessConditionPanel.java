package edu.nju.express.presentation.financeui;

import java.awt.FileDialog;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStreamWriter;
import java.util.ArrayList;

import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableModel;

import edu.nju.express.blservice.Balanceblservice;
import edu.nju.express.presentation.MainPanel;
import edu.nju.express.presentation.myUI.LabelTextField;
import edu.nju.express.presentation.myUI.MyScrollBarUI;
import edu.nju.express.presentation.myUI.MyTablePanel;
import edu.nju.express.presentation.myUI.MyTextField;
import edu.nju.express.vo.Balancevo;
import edu.nju.express.vo.Paymentvo;

public class BussinessConditionPanel extends MainPanel implements ActionListener {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private static Icon search1 = new ImageIcon("ui/button/searchbutton1.png");
	private static Icon search2 = new ImageIcon("ui/button/searchbutton2.png");
	private static Icon export1= new ImageIcon("ui/button/export1.png");
	private static Icon export2 = new ImageIcon("ui/button/export2.png");
	private static Image bg = new ImageIcon("ui/image/bg1.png").getImage();

	private JPanel date;
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

		this.add(new FinanceGuide(controller));
		
		
		this.frame = frame;
		balanceBL = controller.balance;
		
		date = new JPanel();
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
		this.add(date);
		
		export = new JButton(export1);
		export.setRolloverIcon(export2);
		export.setBorderPainted(false);
		export.setContentAreaFilled(false);
		export.setBounds(680, 82, 80, 30);
		this.add(export);
		export.setActionCommand("export");
		export.addActionListener(this);

		initData();
		
		JScrollPane sp = new JScrollPane();
		sp.setOpaque(false);
		sp.setBounds(128, 156, 727, 714);
		sp.getVerticalScrollBar().setUI(new MyScrollBarUI());
		JPanel p =new JPanel();
		p.setOpaque(false);

		initTableB();
		p.add(tableB);

		initTableP();
		p.add(tableP);
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
			tableB.getTableModel().removeRow(i);
			
			for(int i=0;i<listP.size();i++)
			tableP.getTableModel().removeRow(i);
			
			
			
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
	
	@Override
	protected void paintComponent(Graphics g) {
		// TODO Auto-generated method stub
		super.paintComponent(g);
		g.drawImage(bg, 0, 0, null);
	}
}
