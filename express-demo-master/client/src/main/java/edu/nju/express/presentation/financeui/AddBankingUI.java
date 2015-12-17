package edu.nju.express.presentation.financeui;


import javax.swing.ImageIcon;
import javax.swing.JPanel;

import edu.nju.express.blservice.BankingBlService;
import edu.nju.express.presentation.MainPanel;
import edu.nju.express.presentation.myUI.CancelButton;
import edu.nju.express.presentation.myUI.ConfirmButton;
import edu.nju.express.presentation.myUI.LabelTextField;

public class AddBankingUI extends MainPanel {

	private static final long serialVersionUID = 1L;
	
	FinanceController controller;
    BankingBlService bankingBL;
	LabelTextField id;
	ConfirmButton confirm;
	CancelButton cancel;
	JPanel p;
	
	

	public AddBankingUI(FinanceController c) {
		controller = c;
		bankingBL = controller.banking;
		this.setLayout(null);
		this.setOpaque(false);
		initComponents();
		
		FinanceGuide guide =new FinanceGuide(controller);
		guide.banking.setIcon(null);
		this.add(guide);
		bg = new ImageIcon("ui/image/finance/账户填写.png").getImage();
	}


	private void initComponents() {
		
		id = new LabelTextField("账号",15);
		id.setBounds(200+94, 170,400,40);
		this.add(id);
		
		confirm = new ConfirmButton();
		confirm.setBounds(400,537,80,30);
		confirm.setActionCommand("AddBanking");
		confirm.addActionListener(controller);
		this.add(confirm);
		
		cancel = new CancelButton();
		this.add(cancel);
		cancel.addActionListener(controller);
		cancel.setActionCommand("BankingUI");
	}

	public String getTextInput() {
		return id.getText();
	}
}
