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
	JButton income;
	JButton cost;
	JButton analyze;
	
	public FinanceGuide(FinanceController controller) {
		this.controller = controller;
		initGuide();
		this.setLayout(null);
		this.setOpaque(false);
		this.setBounds(0, y, 240, height-y);
	}

	void initGuide() {	
		
		cost = new JButton("成本管理");
		cost.setBounds(60,30,120,40);
		cost.setActionCommand("SalaryUI");
		cost.addActionListener(controller);
		
		income = new JButton("结算管理");
		income.setBounds(60,100,120,40);
		income.setActionCommand("IncomeUI");
		income.addActionListener(controller);	
		
		analyze = new JButton("报表分析");
		analyze.setBounds(60,170,120,40);
		analyze.setActionCommand("ConstantUI");
		analyze.addActionListener(controller);
		
		banking = new JButton("账户管理");
		banking.setBounds(60,240,120,40);
		banking.setActionCommand("BankingUI");
		banking.addActionListener(controller);
				
		account = new JButton("期初建账");
		account.setBounds(60,310,120,40);
		account.setActionCommand("AccountUI");
		account.addActionListener(controller);
		
		this.add(account);
		this.add(banking);
		this.add(income);
		this.add(cost);
		this.add(analyze);

	}
}
