package edu.nju.express.presentation.financeui;

import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JPanel;

public class FinanceGuide extends JPanel{

	private static int width = 900, height = 600;
	private static Icon account1 = new ImageIcon("ui/icon/期初建帐1.png");
	private static Icon account2 = new ImageIcon("ui/icon/期初建帐2.png");
	private static Icon banking1 = new ImageIcon("ui/icon/账户管理1.png");
	private static Icon banking2 = new ImageIcon("ui/icon/账户管理2.png");
	private static Icon payment1 = new ImageIcon("ui/icon/结算管理1.png");
	private static Icon payment2 = new ImageIcon("ui/icon/结算管理2.png");
	private static Icon balance1 = new ImageIcon("ui/icon/成本管理1.png");
	private static Icon balance2 = new ImageIcon("ui/icon/成本管理2.png");
	private static Icon analyze1 = new ImageIcon("ui/icon/报表分析1.png");
	private static Icon analyze2 = new ImageIcon("ui/icon/报表分析2.png");
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	FinanceController controller;

	//期初建账，银行账户管理，结算管理，成本管理，统计报表分析
	JButton account;
	JButton banking;
	JButton payment;
	JButton balance;
	JButton analyze;
	
	public FinanceGuide(FinanceController controller) {
		this.controller = controller;
		initGuide();
		this.setLayout(null);
		this.setOpaque(false);
		this.setBounds(12, 0, 94, height);
	}

	void initGuide() {	
		
		balance = new JButton(balance1);
		balance.setRolloverIcon(balance2);
		balance.setBorderPainted(false);
		balance.setContentAreaFilled(false);
		balance.setBounds(1,44,82,82);
		balance.setActionCommand("BalanceUI");
		balance.addActionListener(controller);
		
		payment = new JButton(payment1);
		payment.setRolloverIcon(payment2);
		payment.setBounds(1,144,82,82);
		payment.setBorderPainted(false);
		payment.setContentAreaFilled(false);
		payment.setActionCommand("PaymentUI");
		payment.addActionListener(controller);	
		
		analyze = new JButton(analyze1);
		analyze.setRolloverIcon(analyze2);
		analyze.setContentAreaFilled(false);
		analyze.setBorderPainted(false);
		analyze.setBounds(1,244,82,82);
		analyze.setActionCommand("AnalyzeUI");
		analyze.addActionListener(controller);
		
		banking = new JButton(banking1);
		banking.setRolloverIcon(banking2);
		banking.setContentAreaFilled(false);
		banking.setBorderPainted(false);
		banking.setBounds(1,344,82,82);
		banking.setActionCommand("BankingUI");
		banking.addActionListener(controller);
				
		account = new JButton(account1);
		account.setRolloverIcon(account2);
		account.setBounds(1,444,82,82);
		account.setContentAreaFilled(false);
		account.setBorderPainted(false);
		account.setActionCommand("AccountUI");
		account.addActionListener(controller);
		
		this.add(account);
		this.add(banking);
		this.add(payment);
		this.add(balance);
		this.add(analyze);

	}
}
