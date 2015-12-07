package edu.nju.express.presentation.financeui;

import javax.swing.JButton;
import javax.swing.JPanel;

import edu.nju.express.presentation.MainPanel;
import edu.nju.express.presentation.myUI.CancelButton;
import edu.nju.express.presentation.myUI.ConfirmButton;
import edu.nju.express.presentation.myUI.LabelTextField;

public class DeleteBankingUI extends MainPanel{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	FinanceController controller;

	LabelTextField id;
	JButton confirm;
	JButton cancel;
	
	public DeleteBankingUI(FinanceController c) {
		controller = c;
		this.setLayout(null);
		this.add(new FinanceGuide(controller));
		initComponents();
		this.setOpaque(false);
	}
	
	private void initComponents() {
		
		id = new LabelTextField("账号", 15);
		id.setBounds(200+94, 170,400,40);
		this.add(id);
		
		confirm = new ConfirmButton();
		confirm.setBounds(400,537,80,30);
		confirm.setActionCommand("DeleteBanking");
		confirm.addActionListener(controller);
		this.add(confirm);
		
		cancel = new CancelButton();
		this.add(cancel);
		cancel.addActionListener(controller);
		cancel.setActionCommand("BankingUI");
		
	}

	public String getID(){
		return id.getText();
	}

	

	
	
}
