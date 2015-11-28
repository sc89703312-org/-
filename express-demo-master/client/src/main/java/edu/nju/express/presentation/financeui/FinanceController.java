package edu.nju.express.presentation.financeui;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JFrame;
import javax.swing.JPanel;

public class FinanceController implements ActionListener {
	JPanel currentPanel;
	JFrame frame;

	public FinanceController(JFrame f) {
		frame = f;
	}

	@Override
	public void actionPerformed(ActionEvent e) {

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

		} else if (e.getActionCommand().equals("AccountUI")) {

		} else if (e.getActionCommand().equals("BalanceHistory")) {
			frame.getContentPane().removeAll();;
			currentPanel = new BalanceHistoryPanel(this);
			frame.add(currentPanel);
			frame.validate();
			frame.repaint();
		}else if (e.getActionCommand().equals("SubmitBalance")) {
			
		}

	}

}
