package edu.nju.express.presentation.financeui;

import java.awt.event.ActionEvent;
import java.util.ArrayList;

import javax.swing.JFrame;
import javax.swing.JPanel;

import edu.nju.express.blservice.Balanceblservice;
import edu.nju.express.blservice.BankingBlService;
import edu.nju.express.blservice.CostControlService;
import edu.nju.express.blservice.ViewPaymentService;
import edu.nju.express.businesslogic.DataFactory;
import edu.nju.express.businesslogic.balancebl.CreateCost.CostControlbl;
import edu.nju.express.businesslogic.balancebl.balance.Balancebl;
import edu.nju.express.common.ResultMessage;
import edu.nju.express.presentation.UIController;
import edu.nju.express.presentation.myUI.MyComboBox;
import edu.nju.express.vo.BankingAccountVO;

public class FinanceController implements UIController {
	JPanel currentPanel;
	JFrame frame;
	Balanceblservice balance;
	CostControlService cost;
	ViewPaymentService view;
	BankingBlService banking;

	public FinanceController(JFrame f) {
		frame = f;
		balance = DataFactory.createBalanceBLInstance();
		cost    = DataFactory.createCostInstance();
		view    = DataFactory.createViewPaymentblInstance();
		banking = DataFactory.createBankingInstance();
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
		}else if (e.getActionCommand().equals("AddBankingUI")) {
			frame.getContentPane().removeAll();;
			currentPanel = new AddBankingUI(this);
			frame.add(currentPanel);
			frame.validate();
			frame.repaint();
		}else if (e.getActionCommand().equals("DeleteBankingUI")) {
			frame.getContentPane().removeAll();;
			currentPanel = new DeleteBankingUI(this);
			frame.add(currentPanel);
			frame.validate();
			frame.repaint();
		}else if (e.getActionCommand().equals("ModifyBankingUI")) {
			frame.getContentPane().removeAll();;
			currentPanel = new ModifyBankingUI(this);
			frame.add(currentPanel);
			frame.validate();
			frame.repaint();
		}else if (e.getActionCommand().equals("SubmitBalance")) {
		
			if(((BalanceUI)currentPanel).getComBoxComponent().equals("工资")){
//					double salary = cost.caculateClerkSalary();
				
				double salary = cost.caculatePostManSalary(((BalanceUI)currentPanel).getRemark());
					((BalanceUI)currentPanel).setAmount(salary);
			}
				
			
			
		}else if (e.getActionCommand().equals("SearchBanking")) {
			ArrayList<BankingAccountVO> list = banking.showAccount(((BankingUI)currentPanel).getKeyWords());
			((BankingUI)currentPanel).clear();
			((BankingUI)currentPanel).setNewComponents(list);
			
			
		}else if (e.getActionCommand().equals("AddBanking")) {
			banking.addAccount(((AddBankingUI)currentPanel).getTextInput());
			frame.getContentPane().removeAll();
			currentPanel = new BankingUI(this);
			frame.add(currentPanel);
			frame.validate();
			frame.repaint();
		}else if (e.getActionCommand().equals("DeleteBanking")) {
			ResultMessage isValid = banking.removeAccount(((DeleteBankingUI)currentPanel).getID());
			if(isValid==ResultMessage.VALID)
				System.out.println("Delete Successfully");
			else {
				System.out.println("The id doesn't exsit");
			}
			frame.getContentPane().removeAll();
			currentPanel = new BankingUI(this);
			frame.add(currentPanel);
			frame.validate();
			frame.repaint();
			
			
		}else if (e.getActionCommand().equals("ModifyBanking")) {
			
			ResultMessage isValid = banking.modifyAccount(((ModifyBankingUI)currentPanel).getID()[1],
					((ModifyBankingUI)currentPanel).getID()[0]);
			if(isValid==ResultMessage.VALID)
				System.out.println("Modify Successfully");
			else {
				System.out.println("The id doesn't exsit");
			}
			frame.getContentPane().removeAll();
			currentPanel = new BankingUI(this);
			frame.add(currentPanel);
			frame.validate();
			frame.repaint();
		}else if (e.getActionCommand().equals("SearchList")) {
		}else if (e.getActionCommand().equals("Export")) {
			((BussinessConditionPanel)currentPanel).getTables();
		}

	}

}
