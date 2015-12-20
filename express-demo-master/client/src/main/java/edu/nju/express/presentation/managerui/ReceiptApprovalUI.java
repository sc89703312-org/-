package edu.nju.express.presentation.managerui;

import java.awt.Graphics;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.SwingUtilities;
import javax.swing.border.EmptyBorder;
import javax.swing.table.TableColumnModel;

import edu.nju.express.blservice.ReceiptBlService;
import edu.nju.express.common.ConcludeTypeById;
import edu.nju.express.presentation.MainPanel;
import edu.nju.express.presentation.myUI.MyCheckBoxButtonTable;
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
	private String selectId;
	private Map<String, ReceiptVOBase> id2vo;

	private MyCheckBoxButtonTable table;
	private JButton jbtApprove;

	public ReceiptApprovalUI(ManageController c) {
		controller = c;

		receiptBl = c.receipt;
		String[] header = { "全选", "单据种类", "单据编号", "提交时间", "详情" };
		table = new MyCheckBoxButtonTable(header);

		initData();
		table.addMouseListener(new JTableButtonMouseListener(table));

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
		id2vo = new HashMap<String, ReceiptVOBase>();

		Object[] data1 = new Object[5];
		for (int i = 0; i < receipts.size(); i++) {

			data1[0] = false;
			String id = receipts.get(i).getId();
			id2vo.put(id, receipts.get(i));
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
			JButton jbt = new JButton();
			jbt.setIcon(new ImageIcon("ui/button/detail1.png"));
			jbt.setContentAreaFilled(false);
			jbt.setBorderPainted(false);
			data1[4] = jbt;
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

	class JTableButtonMouseListener extends MouseAdapter{
		private JTable __table;

		/*private void __forwardEventToButton(MouseEvent e) {
			TableColumnModel columnModel = __table.getColumnModel();
			int column = columnModel.getColumnIndexAtX(e.getX());
			int row = e.getY() / __table.getRowHeight();
			Object value;
			JButton button;
			MouseEvent buttonEvent;

			if (row >= __table.getRowCount() || row < 0 || column >= __table.getColumnCount() || column < 0)
				return;

			value = __table.getValueAt(row, column);

			if (!(value instanceof JButton))
				return;

			button = (JButton) value;

			buttonEvent = (MouseEvent) SwingUtilities.convertMouseEvent(__table, e, button);
			button.dispatchEvent(buttonEvent);

			// This is necessary so that when a button is pressed and released
			// it gets rendered properly. Otherwise, the button may still appear
			// pressed down when it has been released.
			__table.repaint();
		}
*/
		public JTableButtonMouseListener(JTable table) {
			__table = table;
		}

		public void mouseClicked(MouseEvent e) {
			// __forwardEventToButton(e);
			TableColumnModel columnModel = __table.getColumnModel();
			int column = columnModel.getColumnIndexAtX(e.getX());
			int row = e.getY() / __table.getRowHeight();
			Object value;
			
			if (row >= __table.getRowCount() || row < 0 || column >= __table.getColumnCount() || column < 0)
				return;

			value = __table.getValueAt(row, column);

			if (!(value instanceof JButton))
				return;
			
			selectId = (String) table.getValueAt(row, 2);
			controller.viewReceiptUI((String) table.getValueAt(row, 1),id2vo.get(selectId));
			
		}

	
	}

}