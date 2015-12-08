package edu.nju.express.presentation.financeui;

import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JButton;

import edu.nju.express.presentation.MainPanel;
import edu.nju.express.presentation.myUI.DateComboBoxPanel;

public class AccountUI extends MainPanel{
	
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private static final Icon add1 = new ImageIcon("ui/button/建帐1.png");
	private static final Icon add2 = new ImageIcon("ui/button/建帐2.png");
	private static final Icon search1 = new ImageIcon("ui/button/查询1.png");
	private static final Icon search2 = new ImageIcon("ui/button/查询2.png");

	private FinanceController controller;
	
	private DateComboBoxPanel date;
	private JButton add;
	private JButton search;
	
	public AccountUI(FinanceController controller) {
		this.controller = controller;
		this.add(new FinanceGuide(controller));
		
		date = new DateComboBoxPanel();
		date.setBounds(200+94, 180,400,50);
		this.add(date);
		
		add = new JButton(add1);
		add.setRolloverIcon(add2);
		add.setBounds(390,537,100,30);
		add.setBorderPainted(false);
		add.setContentAreaFilled(false);
		add.setActionCommand("CreateAccount");
		add.addActionListener(controller);
		this.add(add);
		
		search = new JButton(search1);
		search.setRolloverIcon(search2);
		search.addActionListener(controller);
		search.setActionCommand("SearchAccount");
		search.setBorderPainted(false);
		search.setContentAreaFilled(false);
		search.setBounds(410,537,80,30);
		this.add(search);
	}
	
	public String getDate() {
		return date.getDate();
	}

}