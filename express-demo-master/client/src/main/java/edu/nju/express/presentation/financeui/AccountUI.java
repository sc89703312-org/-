package edu.nju.express.presentation.financeui;

import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JButton;

import edu.nju.express.presentation.MainPanel;
import edu.nju.express.presentation.myUI.DateComboBoxPanel;

public class AccountUI extends MainPanel{
	
	
	/**
	 * 期初建账
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
		
		FinanceGuide guide =new FinanceGuide(controller);
		guide.account.setIcon(null);
		this.add(guide);
		this.bg = new ImageIcon("ui/image/finance/期初建帐.png").getImage();

		
		date = new DateComboBoxPanel();
		date.setBounds(200+94, 260,400,60);
		this.add(date);
		
		add = new JButton(add1);
		add.setRolloverIcon(add2);
		add.setBounds(400,537,80,30);
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
		search.setBounds(500,537,80,30);
		this.add(search);
	}
	
	public String getDate() {
		System.out.println(date.getDate());
		return date.getDate();
	}

}