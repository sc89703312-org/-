package edu.nju.express.presentation.financeui;

import edu.nju.express.presentation.MainPanel;
import edu.nju.express.presentation.myUI.MySearchFieldPanel;
import edu.nju.express.presentation.myUI.MyTablePanel;

public class BankingUI extends MainPanel{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private static int width = 900, height = 600;
	private static int x = 240, y = 50;
	
	FinanceController controller;
	
	MyTablePanel table;
	MySearchFieldPanel search;
	
	
	public BankingUI(FinanceController c) {
		
		this.controller = c;
		
		this.add(new FinanceGuide(c));
		
		search = new MySearchFieldPanel(c);
		search.setBounds(x+290-100, y+30,200,40);
		search.setActionCommand("SearchBanking");
		this.add(search);
	}

}
