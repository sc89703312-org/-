package edu.nju.express.presentation.financeui;

import edu.nju.express.presentation.MainPanel;
import edu.nju.express.presentation.myUI.MyTablePanel;
import edu.nju.express.vo.Accountvo;

public class AccountPanel extends MainPanel{
	
	private MyTablePanel table;
	
	FinanceController controller;
	
	public AccountPanel(FinanceController controller, Accountvo vo) {
		this.controller = controller;
		this.add(new FinanceGuide(controller));
		
		System.out.println(vo.getDate());
	}

}
