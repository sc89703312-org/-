package edu.nju.express.presentation.managerui;

import javax.swing.ImageIcon;
import javax.swing.table.DefaultTableModel;

import edu.nju.express.presentation.MainPanel;
import edu.nju.express.presentation.myUI.MyTable;
import edu.nju.express.presentation.myUI.ReturnButton;
import edu.nju.express.vo.Balancevo;
import edu.nju.express.vo.ComGoodsVO;
import edu.nju.express.vo.EnterReceiptVO;

public class ComEnterReceipt extends MainPanel {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	private ManageController controller;



	public ComEnterReceipt(ManageController c, EnterReceiptVO vo) {
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
		
		
		for(ComGoodsVO v:vo.getList()){
		rowdata[0] = "订单编号";
		rowdata[1] = v.getOrder().getID();
		model.addRow(rowdata);
		rowdata[0] = "分区";
		rowdata[1] = v.getType();
		model.addRow(rowdata);

		rowdata[0] = "位置";
		rowdata[1] = v.getLine()+"排"+v.getShelf()+"架"+v.getCell()+"位";
		model.addRow(rowdata);
		}
		this.add(table);
		table.setBounds(128, 112, 726, 3+3*vo.getList().size()*table.ROW_HEIGHT);
		
	}
	
	
	
	
}
