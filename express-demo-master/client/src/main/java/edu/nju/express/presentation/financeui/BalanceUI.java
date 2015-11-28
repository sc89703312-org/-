package edu.nju.express.presentation.financeui;

import java.awt.Color;
import java.awt.FlowLayout;
import java.awt.Font;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;

import edu.nju.express.common.Item;
import edu.nju.express.presentation.MainPanel;
import edu.nju.express.presentation.myUI.ConfirmButton;
import edu.nju.express.presentation.myUI.DateComboBoxPanel;
import edu.nju.express.presentation.myUI.LabelTextField;
import edu.nju.express.presentation.myUI.MyComboBox;

public class BalanceUI extends MainPanel {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private static int width = 900, height = 600;
	private static int x = 240, y = 50;

	private FinanceController controller;

	private ConfirmButton cfm;
	private DateComboBoxPanel date;
	private LabelTextField amount, name, banking, remark;
	private MyComboBox<String> itemBox;
	private JButton history;

	public BalanceUI(FinanceController c) {
		this.controller = c;

		this.add(new FinanceGuide(c));

		JPanel p = new JPanel();
		p.setBounds(x - 130, y+20, width - x+60, height - y);
		p.setLayout(new FlowLayout(FlowLayout.LEFT, 300, 30));
		p.setOpaque(false);

		JLabel d = new JLabel("日期 ");
		d.setForeground(Color.white);
		d.setFont(new Font("黑体", Font.PLAIN, 16));
		date = new DateComboBoxPanel();
		JPanel p1 = new JPanel();
		p1.setOpaque(false);
		p1.add(d);
		p1.add(date);
		p.add(p1);

		JLabel items = new JLabel("条目     ");
		items.setForeground(Color.white);
		items.setFont(new Font("黑体", Font.PLAIN, 16));
		itemBox = new MyComboBox<String>();
		for (Item i : Item.values()) {
			itemBox.addItem(i.getName());
		}
		JPanel p2 = new JPanel();
		p2.setOpaque(false);
		p2.add(items);
		p2.add(itemBox);
		p.add(p2);

		amount = new LabelTextField("付款金额 ", 13, "元");
		p.add(amount);

		name = new LabelTextField("付款人   ", 17);
		p.add(name);

		banking = new LabelTextField("付款账户 ", 25);
		p.add(banking);

		remark = new LabelTextField("备注     ", 25);
		p.add(remark);

		this.add(p);
		
		cfm = new ConfirmButton();
		cfm.setBounds(600, 500, 80,30);
		cfm.addActionListener(controller);
		cfm.setActionCommand("SubmitBalance");
		this.add(cfm);
		
		history = new JButton("查看历史单据");
		history.setBounds(430, 500, 110, 30);
		history.addActionListener(controller);
		history.setActionCommand("BalanceHistory");
		this.add(history);
	}

}
