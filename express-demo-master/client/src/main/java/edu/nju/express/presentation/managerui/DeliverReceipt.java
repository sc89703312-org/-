package edu.nju.express.presentation.managerui;

import javax.swing.ImageIcon;
import javax.swing.table.DefaultTableModel;

import edu.nju.express.presentation.MainPanel;
import edu.nju.express.presentation.myUI.MyTable;
import edu.nju.express.presentation.myUI.ReturnButton;
import edu.nju.express.vo.Balancevo;
import edu.nju.express.vo.DeliverReceiptVO;
import edu.nju.express.vo.OrderVO;

public class DeliverReceipt extends MainPanel {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	private ManageController controller;



	public DeliverReceipt(ManageController c, DeliverReceiptVO vo) {
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
		
		rowdata[0] = "时间";
		rowdata[1] = vo.getDate();
		model.addRow(rowdata);
		
		rowdata[0] = "所在地";
		rowdata[1] = vo.getLocation();
		model.addRow(rowdata);
		
		rowdata[0] = "派件员";
		rowdata[1] = vo.getDeliver();
		model.addRow(rowdata);
		
		for(OrderVO v: vo.getOrderList()){
			rowdata[0] = "派件订单编号";
			rowdata[1] = v.getID();
			model.addRow(rowdata);
		}
		this.add(table);
		table.setBounds(128, 112, 726, (vo.getOrderList().size()+4)*table.ROW_HEIGHT);
		
	}
	
	
	
	
}
