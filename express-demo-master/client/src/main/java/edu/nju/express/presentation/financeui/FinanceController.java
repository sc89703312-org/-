package edu.nju.express.presentation.financeui;

import java.awt.event.ActionEvent;

import javax.swing.JFrame;
import javax.swing.JPanel;

import edu.nju.express.presentation.UIController;

public class FinanceController implements UIController {
	JPanel currentPanel;
	JFrame frame;

	public FinanceController(JFrame f) {
		frame = f;
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
		}else if (e.getActionCommand().equals("SubmitBalance")) {
			
		}else if (e.getActionCommand().equals("SearchBanking")) {
			
		}

	}

}
