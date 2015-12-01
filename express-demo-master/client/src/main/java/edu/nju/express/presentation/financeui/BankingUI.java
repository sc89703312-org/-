package edu.nju.express.presentation.financeui;

import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

import javax.swing.JButton;
import javax.swing.JPanel;

import edu.nju.express.presentation.MainPanel;
import edu.nju.express.presentation.myUI.ConfirmButton;
import edu.nju.express.presentation.myUI.LabelTextField;
import edu.nju.express.presentation.myUI.MySearchFieldPanel;
import edu.nju.express.presentation.myUI.MyTablePanel;
import edu.nju.express.vo.BankingAccountVO;

public class BankingUI extends MainPanel {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private static int width = 900, height = 600;
	private static int x = 94, y = 50;

	FinanceController controller;

	MyTablePanel table;
	MySearchFieldPanel search;
	JButton add;
	JButton delete;
	JButton modify;
	JPanel popup;
	ConfirmButton cfm;
	BankingUI ui;

	private ArrayList<BankingAccountVO> list;

	public BankingUI(FinanceController c) {

		this.controller = c;

		ui = this;

		this.add(new FinanceGuide(c));

		search = new MySearchFieldPanel(c);
		search.setBounds(380, 120, 400, 40);
		search.setActionCommand("SearchBanking");
		this.add(search);

		initPopup();

		add = new JButton("增加账户");
		add.setBounds(x+95, 180, 80, 30);
		this.add(add);
		add.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				popup.setVisible(true);
				ui.repaint();
				cfm.setActionCommand("AddBanking");
			}
		});

		delete = new JButton("删除账户");
		delete.setBounds(x+360, 180, 80, 30);
		this.add(delete);
		delete.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				popup.setVisible(true);
				ui.repaint();
				cfm.setActionCommand("DeleteBanking");
			}
		});

		modify = new JButton("修改账户");
		modify.setBounds(x+630, 180, 80, 30);
		this.add(modify);
		modify.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				popup.setVisible(true);
				ui.repaint();
				cfm.setActionCommand("ModifyBanking");
			}
		});

		initData();

		String[] header = { "账户名称", "余额" };
		table = new MyTablePanel(header);
		Object[] rowdata = new Object[2];
		for (int i = 0; i < list.size(); i++) {
			rowdata[0] = list.get(i).getName();
			rowdata[1] = list.get(i).getMoney();
			table.getTableModel().addRow(rowdata);
		}
		this.add(table);
		table.setRowHeight(28);
		table.setBounds(128, 280, 726, 280);
		table.getTable().setPreferredScrollableViewportSize(new Dimension(727, 250));
	}

	private void initPopup() {
		popup = new JPanel();
		popup.setLayout(new FlowLayout(FlowLayout.LEADING, 100, 0));
		popup.setOpaque(false);
		popup.setBounds(x, 220, width - x, 80);
		LabelTextField account = new LabelTextField("账号", 22);
		popup.add(account);

		JPanel p = new JPanel();
		p.setOpaque(false);
		cfm = new ConfirmButton();
		cfm.addActionListener(controller);
		p.add(cfm);

		JButton cancel = new JButton("取消");
		cancel.setSize(80, 30);
		cancel.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				removePopup();

			}
		});
		p.add(cancel);
		popup.add(p);

		this.add(popup);
		popup.setVisible(false);
	}

	public void removePopup() {
		popup.setVisible(false);
		ui.repaint();
	}

	private void initData() {
		list = new ArrayList<BankingAccountVO>();
		for(int i=0;i<20;i++)
		list.add(new BankingAccountVO("622202194898561354889", 200000+i));
	}

}
