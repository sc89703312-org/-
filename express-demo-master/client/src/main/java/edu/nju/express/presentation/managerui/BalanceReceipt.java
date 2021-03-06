package edu.nju.express.presentation.managerui;

import javax.swing.ImageIcon;
import javax.swing.table.DefaultTableModel;

import edu.nju.express.presentation.MainPanel;
import edu.nju.express.presentation.myUI.MyTable;
import edu.nju.express.presentation.myUI.ReturnButton;
import edu.nju.express.vo.Balancevo;

public class BalanceReceipt extends MainPanel {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	private ManageController controller;

	public BalanceReceipt(ManageController c, Balancevo vo) {
		this.controller = c;

		ManageGuide guide = new ManageGuide(controller);
		guide.receipt.setIcon(null);
		this.add(guide);
		this.bg = new ImageIcon("ui/image/manager/详细信息.png").getImage();

		ReturnButton jbtRe = new ReturnButton();
		this.add(jbtRe);
		jbtRe.addActionListener(controller);
		jbtRe.setActionCommand("ReceiptUI");

		String[] header = { "1", "2" };
		MyTable table = new MyTable(header);
		DefaultTableModel model = (DefaultTableModel) table.getModel();
		Object[] rowdata = new String[2];

		rowdata[0] = "编号";
		rowdata[1] = vo.getId();
		model.addRow(rowdata);

		rowdata[0] = "时间";
		rowdata[1] = vo.getDate();
		model.addRow(rowdata);

		rowdata[0] = "条目";
		rowdata[1] = vo.getItem().getName();
		model.addRow(rowdata);

		rowdata[0] = "付款金额";
		rowdata[1] = vo.getMoney() + "元";
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
		table.setBounds(128, 112, 726, 7 * table.ROW_HEIGHT);

	}

}
