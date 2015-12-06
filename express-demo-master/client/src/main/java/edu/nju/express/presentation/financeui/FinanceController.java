package edu.nju.express.presentation.financeui;

import java.awt.event.ActionEvent;

import javax.swing.JFrame;
import javax.swing.JPanel;

import edu.nju.express.blservice.Balanceblservice;
import edu.nju.express.blservice.CostControlService;
import edu.nju.express.blservice.ViewPaymentService;
import edu.nju.express.businesslogic.DataFactory;
import edu.nju.express.businesslogic.balancebl.CreateCost.CostControlbl;
import edu.nju.express.businesslogic.balancebl.balance.Balancebl;
import edu.nju.express.presentation.UIController;

public class FinanceController implements UIController {
	JPanel currentPanel;
	JFrame frame;
	Balanceblservice balance;
	CostControlService cost;
	ViewPaymentService view;

	public FinanceController(JFrame f) {
		frame = f;
		balance = DataFactory.createBalanceBLInstance();
		cost    = DataFactory.createCostInstance();
		view    = DataFactory.createViewPaymentblInstance();
	}

	@Override
	public void actionPerformed(ActionEvent e) {

		System.out.println(e.getActionCommand());
		
		if (e.getActionCommand().equals("BalanceUI")) {
			frame.getContentPane().removeAll();;
			currentPanel = new BalanceUI(this);
			frame.add(currentPanel);
			frame.validate();
			frame.repaint();
		} else if (e.getActionCommand().equals("PaymentUI")) {
			frame.getContentPane().removeAll();;
			currentPanel = new PaymentUI(this);
			frame.add(currentPanel);
			frame.validate();
			frame.repaint();
		} else if (e.getActionCommand().equals("AnalyzeUI")) {
			frame.getContentPane().removeAll();;
			currentPanel = new AnalyzeUI(this);
			frame.add(currentPanel);
			frame.validate();
			frame.repaint();
		} else if (e.getActionCommand().equals("BankingUI")) {
			frame.getContentPane().removeAll();;
			currentPanel = new BankingUI(this);
			frame.add(currentPanel);
			frame.validate();
			frame.repaint();
		} else if (e.getActionCommand().equals("AccountUI")) {

		} else if (e.getActionCommand().equals("BalanceHistory")) {
			frame.getContentPane().removeAll();;
			currentPanel = new BalanceHistoryPanel(this);
			frame.add(currentPanel);
			frame.validate();
			frame.repaint();
		}else if (e.getActionCommand().equals("BussinessConditionUI")) {
			frame.getContentPane().removeAll();;
			currentPanel = new BussinessConditionPanel(this,frame);
			frame.add(currentPanel);
			frame.validate();
			frame.repaint();
		}else if (e.getActionCommand().equals("SubmitBalance")) {
			
		}else if (e.getActionCommand().equals("SearchBanking")) {
			
		}else if (e.getActionCommand().equals("AddBanking")) {
			((BankingUI)currentPanel).removePopup();
		}else if (e.getActionCommand().equals("DeleteBanking")) {
			((BankingUI)currentPanel).removePopup();
		}else if (e.getActionCommand().equals("ModifyBanking")) {
			((BankingUI)currentPanel).removePopup();
		}else if (e.getActionCommand().equals("SearchList")) {
		}else if (e.getActionCommand().equals("Export")) {
			((BussinessConditionPanel)currentPanel).getTables();
		}

	}

}
