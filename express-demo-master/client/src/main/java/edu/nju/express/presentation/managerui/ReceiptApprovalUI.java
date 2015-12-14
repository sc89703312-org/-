package edu.nju.express.presentation.managerui;

import java.awt.Graphics;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

import javax.security.auth.Refreshable;
import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JScrollPane;
import javax.swing.border.EmptyBorder;

import edu.nju.express.blservice.ReceiptBlService;
import edu.nju.express.common.ConcludeTypeById;
import edu.nju.express.presentation.MainPanel;
import edu.nju.express.presentation.myUI.MyCheckBoxTable;
import edu.nju.express.presentation.myUI.MyScrollBarUI;
import edu.nju.express.presentation.myUI.RefreshButton;
import edu.nju.express.vo.ReceiptVOBase;

public class ReceiptApprovalUI extends MainPanel {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	static int width = 900;
	static int height = 600;
	static int x = 240;
	static int y = 50;
	private static Image bg = new ImageIcon("ui/image/manager/单据审批.png").getImage();
	private static Icon img1 = new ImageIcon("ui/button/approve1.png");
	private static Icon img2 = new ImageIcon("ui/button/approve2.png");
	private ReceiptBlService receiptBl;
	private ManageGuide guide;
	private ManageController controller;
	private ArrayList<Object[]> list;
	private ArrayList<ReceiptVOBase> voList;

	private MyCheckBoxTable table;
	private JButton jbtApprove;

	public ReceiptApprovalUI(ManageController c) {
		controller = c;

		receiptBl = c.receipt;
		String[] header = { "全选", "单据种类", "单据编号", "提交时间" };
		table = new MyCheckBoxTable(header);
		initData();

		guide = new ManageGuide(c);
		guide.receipt.setIcon(null);
		this.add(guide);

		JScrollPane s = new JScrollPane(table);
		s.setBounds(128, 112, 727, 420);
		s.setViewportBorder(new EmptyBorder(0, 0, 0, 0));
		s.setOpaque(false);
		s.getViewport().setOpaque(false);
		s.setColumnHeaderView(table.getTableHeader());
		s.getColumnHeader().setOpaque(false);
		s.setBorder(new EmptyBorder(0, 0, 0, 0));
		s.getVerticalScrollBar().setUI(new MyScrollBarUI());
		s.getVerticalScrollBar().setOpaque(false);
		this.add(s);
		
		JButton refresh = new RefreshButton();
		refresh.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				refresh();
				
			}
		});
		this.add(refresh);

		jbtApprove = new JButton(img1);
		jbtApprove.setRolloverIcon(img2);
		jbtApprove.setContentAreaFilled(false);
		jbtApprove.setBorderPainted(false);
		jbtApprove.setBounds(450, 537, 80, 30);
		jbtApprove.setActionCommand("Approve");
		jbtApprove.addActionListener(controller);
		this.add(jbtApprove);
	}

	private void initData() {

		ArrayList<ReceiptVOBase> receipts = receiptBl.view();

		Object[] data1 = new Object[4];
		for (int i = 0; i < receipts.size(); i++) {

			data1[0] = false;
			String id = receipts.get(i).getId();
			switch (ConcludeTypeById.conclude(id)) {
			case 0:
				data1[1] = "收款单";
				break;
			case 1:
				data1[1] = "付款单";
				break;
			case 2:
				data1[1] = "中转中心到达单";
				break;
			case 3:
				data1[1] = "中转中心中转单";
				break;
			case 4:
				data1[1] = "中转中心入库单";
				break;
			case 5:
				data1[1] = "中转中心出库单";
				break;
			case 6:
				data1[1] = "营业厅到达单";
				break;
			case 7:
				data1[1] = "营业厅派送单";
				break;
			case 8:
				data1[1] = "营业厅装车单";
				break;
			default:
				break;
			}

			data1[2] = receipts.get(i).getId();
			data1[3] = receipts.get(i).getDate();
			table.getTableModel().addRow(data1);
		}
	}

	private void refresh() {

		int n = table.getRowCount();
		for (int i = 0; i < n; i++) {
			table.getTableModel().removeRow(0);
		}
		initData();
		guide.refreshMessage();

	}

	public ArrayList<String> getIDtoApprove() {
		return table.getSelectedID();
	}

	@Override
	protected void paintComponent(Graphics g) {
		g.drawImage(bg, 0, 0, null);
	}
}