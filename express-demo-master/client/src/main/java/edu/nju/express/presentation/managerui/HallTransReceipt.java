package edu.nju.express.presentation.managerui;

import javax.swing.ImageIcon;
import javax.swing.table.DefaultTableModel;

import edu.nju.express.presentation.MainPanel;
import edu.nju.express.presentation.myUI.MyTable;
import edu.nju.express.presentation.myUI.ReturnButton;
import edu.nju.express.vo.Balancevo;
import edu.nju.express.vo.HallTransferReceiptVO;
import edu.nju.express.vo.OrderVO;

/**
 * 装车单详情界面
 */
public class HallTransReceipt extends MainPanel {

	private static final long serialVersionUID = 1L;

	private ManageController controller;
	private int num;

	public HallTransReceipt(ManageController c, HallTransferReceiptVO vo) {
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
		num++;

		rowdata[0] = "时间";
		rowdata[1] = vo.getDate();
		model.addRow(rowdata);
		num++;

		rowdata[0] = "营业厅编号";
		rowdata[1] = vo.getHallID();
		model.addRow(rowdata);
		num++;

		rowdata[0] = "汽运编号";
		rowdata[1] = vo.getTransportID();
		model.addRow(rowdata);
		num++;

		rowdata[0] = "到达地";
		rowdata[1] = vo.getDestination();
		model.addRow(rowdata);
		num++;

		rowdata[0] = "车辆代号";
		rowdata[1] = vo.getCarID();
		model.addRow(rowdata);
		num++;

		rowdata[0] = "监装员";
		rowdata[1] = vo.getSupervisor();
		model.addRow(rowdata);
		num++;

		rowdata[0] = "押送员";
		rowdata[1] = vo.getGuard();
		model.addRow(rowdata);
		num++;

		for (OrderVO v : vo.getOrderlist()) {
			rowdata[0] = "订单编号";
			rowdata[1] = v.getID();
			model.addRow(rowdata);
			num++;
		}

		this.add(table);
		table.setBounds(128, 112, 726, num * table.ROW_HEIGHT);

	}

}
