package edu.nju.express.presentation.financeui;

import javax.swing.JButton;
import javax.swing.JPanel;

import edu.nju.express.presentation.MainPanel;
import edu.nju.express.presentation.myUI.CancelButton;
import edu.nju.express.presentation.myUI.ConfirmButton;
import edu.nju.express.presentation.myUI.LabelTextField;

public class ModifyBankingUI extends MainPanel{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	FinanceController controller;

	LabelTextField id1,id2;
	JButton confirm;
	JButton cancel;
	JPanel p;
	
	public ModifyBankingUI(FinanceController c) {
		controller = c;
		this.setLayout(null);
		this.add(new FinanceGuide(controller));
		initComponents();
		this.setOpaque(false);
	}
	
	private void initComponents() {
		
		id1 = new LabelTextField("原账号名称  ",15);
		id1.setBounds(200+94, 170,400,40);
		this.add(id1);
		
		id2 = new LabelTextField("修改后的账号",15);
		id2.setBounds(200+94,230,400,40);
		this.add(id2);
		
		confirm = new ConfirmButton();
		confirm.setBounds(400,537,80,30);
		confirm.setActionCommand("MOdifyBanking");
		confirm.addActionListener(controller);
		this.add(confirm);
		
		cancel = new CancelButton();
		this.add(cancel);
		cancel.addActionListener(controller);
		cancel.setActionCommand("BankingUI");
		
	}

	public String[] getID(){
		String[] id = new String[2];
		id[0]=id1.getText();
		id[1]=id2.getText();
		return id;
	}

	

	
	
}
