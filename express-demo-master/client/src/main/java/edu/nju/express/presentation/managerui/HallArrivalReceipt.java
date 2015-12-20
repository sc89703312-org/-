package edu.nju.express.presentation.managerui;

import javax.swing.ImageIcon;
import javax.swing.table.DefaultTableModel;

import edu.nju.express.presentation.MainPanel;
import edu.nju.express.presentation.myUI.MyTable;
import edu.nju.express.presentation.myUI.ReturnButton;
import edu.nju.express.vo.ArrivalReceiptVO;
import edu.nju.express.vo.OrderVO;

public class HallArrivalReceipt extends MainPanel {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	private ManageController controller;
	private int num;


	public HallArrivalReceipt(ManageController c, ArrivalReceiptVO vo) {
		this.controller = c;

		ManageGuide guide =new ManageGuide(controller);
		guide.receipt.setIcon(null);
		this.add(guide);
		this.bg = new ImageIcon("ui/image/manager/详细信息.png").getImage();

		ReturnButton jbtRe = new ReturnButton();
		this.add(jbtRe);
		jbtRe.addActionListener(controller);
		jbtRe.setActionCommand("ReceiptUI");

		String[] header = {"1","2"};
		MyTable table = new MyTable(header);
		DefaultTableModel model = (DefaultTableModel)table.getModel();
		Object[] rowdata = new String[2];
		
		rowdata[0] = "编号";
		rowdata[1] = vo.getId();
		model.addRow(rowdata);
		num++;
		
		rowdata[0] = "日期";
		rowdata[1] = vo.getDate();
		model.addRow(rowdata);
		num++;
		
		rowdata[0] = "出发地";
		rowdata[1] = vo.getFrom();
		model.addRow(rowdata);
		num++;
		
		rowdata[0] = "所在地";
		rowdata[1] = vo.getLocation();
		model.addRow(rowdata);
		num++;
		
		for(OrderVO v: vo.getOrderList()){
		rowdata[0] = "订单编号";
		rowdata[1] = v.getID();
		model.addRow(rowdata);
		num++;
		}
		
		this.add(table);
		table.setBounds(128, 112, 726, 5*table.ROW_HEIGHT);
		
	}
	
	
	
	
}
