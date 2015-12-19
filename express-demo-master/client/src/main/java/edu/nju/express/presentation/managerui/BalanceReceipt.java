package edu.nju.express.presentation.managerui;

import java.awt.Color;
import java.awt.Font;

import javax.swing.ImageIcon;
import javax.swing.table.DefaultTableModel;

import edu.nju.express.presentation.MainPanel;
import edu.nju.express.presentation.myUI.MyTable;
import edu.nju.express.vo.Balancevo;

public class BalanceReceipt extends MainPanel {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	private static int width = 900, height = 600;
	private static int x = 95, y = 50;
	private static Font font = new Font("黑体", Font.PLAIN, 18);
	private static Color color = new Color(44, 62,80);

	private ManageController controller;



	public BalanceReceipt(ManageController c, Balancevo vo) {
		this.controller = c;

		ManageGuide guide =new ManageGuide(controller);
		guide.receipt.setIcon(null);
		this.add(guide);
		this.bg = new ImageIcon("ui/image/manager/单据审批.png").getImage();
		
		
		String[] header = {"1","2"};
		MyTable table = new MyTable(header);
		DefaultTableModel model = (DefaultTableModel)table.getModel();
		Object[] rowdata = new String[2];
		
		rowdata[0] = "ID";
		rowdata[1] = vo.getId();
		model.addRow(rowdata);
		
		rowdata[0] = "条目";
		rowdata[1] = vo.getItem().getName();
		model.addRow(rowdata);
		
		rowdata[0] = "付款金额";
		rowdata[1] = vo.getMoney() +"元";
		model.addRow(rowdata);
		
		rowdata[0] = "付款人";
		rowdata[1] = vo.getName();
		model.addRow(rowdata);
		
		rowdata[0] = "付款账号";
		rowdata[1] = vo.getBanking();
		model.addRow(rowdata);
		
		rowdata[0] = "备注";
		rowdata[1] = vo.getRemark();
		model.addRow(rowdata);
		
		this.add(table);
		table.setBounds(128, 112, 726, 6*table.ROW_HEIGHT);
		
	/*	JPanel p = new JPanel();
		p.setOpaque(false);
		p.setLayout(new BoxLayout(p, BoxLayout.Y_AXIS));
		this.add(p);
		
		

		JLabel l11= new JLabel();
		p.add(l11);

		
		JLabel l12= new JLabel(vo.getDate());
		p.add(l12);*/
	}
	
	
	
	
}
