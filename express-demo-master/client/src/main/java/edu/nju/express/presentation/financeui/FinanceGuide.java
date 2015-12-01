package edu.nju.express.presentation.financeui;

import javax.swing.JButton;
import javax.swing.JPanel;

public class FinanceGuide extends JPanel{

	static int width = 900, height = 600;
	static int y = 50;		//由标题栏高度决定
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
		
		balance = new JButton();
		balance.setBorderPainted(false);
		balance.setContentAreaFilled(false);
		balance.setBounds(0,44,82,82);
		balance.setActionCommand("BalanceUI");
		balance.addActionListener(controller);
		
		payment = new JButton();
		payment.setBounds(0,144,82,82);
		payment.setBorderPainted(false);
		payment.setContentAreaFilled(false);
		payment.setActionCommand("PaymentUI");
		payment.addActionListener(controller);	
		
		analyze = new JButton();
		analyze.setContentAreaFilled(false);
		analyze.setBorderPainted(false);
		analyze.setBounds(0,244,82,82);
		analyze.setActionCommand("AnalyzeUI");
		analyze.addActionListener(controller);
		
		banking = new JButton();
		banking.setContentAreaFilled(false);
		banking.setBorderPainted(false);
		banking.setBounds(0,344,82,82);
		banking.setActionCommand("BankingUI");
		banking.addActionListener(controller);
				
		account = new JButton();
		account.setBounds(0,444,82,82);
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
