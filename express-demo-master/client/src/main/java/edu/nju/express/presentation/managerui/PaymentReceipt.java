package edu.nju.express.presentation.managerui;

import javax.swing.ImageIcon;
import javax.swing.table.DefaultTableModel;

import edu.nju.express.presentation.MainPanel;
import edu.nju.express.presentation.myUI.MyTable;
import edu.nju.express.presentation.myUI.ReturnButton;
import edu.nju.express.vo.Paymentvo;

public class PaymentReceipt extends MainPanel {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	private ManageController controller;



	public PaymentReceipt(ManageController c, Paymentvo vo) {
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
		
		rowdata[0] = "日期";
		rowdata[1] = vo.getDate();
		model.addRow(rowdata);
		
		rowdata[0] = "收款金额";
		rowdata[1] = vo.getPay()+"元";
		model.addRow(rowdata);
		
		rowdata[0] = "快递员编号";
		rowdata[1] = vo.getCourier_id();
		model.addRow(rowdata);
		
		rowdata[0] = "订单编号";
		rowdata[1] = vo.getOrder_id();
		model.addRow(rowdata);
		
		
		
		this.add(table);
		table.setBounds(128, 112, 726, 5*table.ROW_HEIGHT);
		
	}
	
	
	
	
}
