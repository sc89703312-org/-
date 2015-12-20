package edu.nju.express.presentation.financeui;

import java.awt.event.ActionEvent;
import java.util.ArrayList;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;

import edu.nju.express.blservice.Accountblservice;
import edu.nju.express.blservice.Balanceblservice;
import edu.nju.express.blservice.BankingBlService;
import edu.nju.express.blservice.CostControlService;
import edu.nju.express.blservice.ViewPaymentService;
import edu.nju.express.businesslogic.DataFactory;
import edu.nju.express.common.ResultMessage;
import edu.nju.express.log.ui.warning.PromptDialog;
import edu.nju.express.presentation.UIController;
import edu.nju.express.vo.Accountvo;
import edu.nju.express.vo.Balancevo;
import edu.nju.express.vo.BankingAccountVO;

public class FinanceController implements UIController {
	JPanel currentPanel;
	JFrame frame;
	Balanceblservice balance;
	CostControlService cost;
	ViewPaymentService view;
	BankingBlService banking;
	Accountblservice account;

	public FinanceController(JFrame f) {
		frame = f;
		balance = DataFactory.createBalanceBLInstance();
		cost    = DataFactory.createCostInstance();
		view    = DataFactory.createViewPaymentblInstance();
		banking = DataFactory.createBankingInstance();
		account = DataFactory.createAccountblInstance();
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
			refresh();
			frame.getContentPane().removeAll();;
			currentPanel = new PaymentUI(this);
			frame.add(currentPanel);
			frame.validate();
			frame.repaint();
		} else if (e.getActionCommand().equals("AnalyzeUI")) {
			refresh();
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
			frame.getContentPane().removeAll();;
			currentPanel = new AccountUI(this);
			frame.add(currentPanel);
			frame.validate();
			frame.repaint();
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
		   
			Balancevo temp = ((BalanceUI)((JButton)e.getSource()).getParent()).createBalanceVO();
			ResultMessage message = ResultMessage.INVALID;
			if(temp!=null)
			{
				message = cost.createCost(temp);
				
				if(message == ResultMessage.INVALID)
					PromptDialog.show("创建失败", "  请检查编号和银行账户");
				else{
					PromptDialog.show("创建成功", "         你真棒");
					frame.getContentPane().removeAll();;
					currentPanel = new BalanceUI(this);
					frame.add(currentPanel);
					frame.validate();
					frame.repaint();
				}
			}
			
			
				
			
			
		}else if (e.getActionCommand().equals("SearchBanking")) {
			
			ArrayList<BankingAccountVO> list = banking.showAccount(((BankingUI)currentPanel).getKeyWords());
			
			if(list.size()!=0){
			((BankingUI)currentPanel).clear();
			((BankingUI)currentPanel).setNewComponents(list);
			}else {
				PromptDialog.show("", "    未查找到相关用户");
			}
			
		}else if (e.getActionCommand().equals("AddBanking")) {
			
			ArrayList<BankingAccountVO> accounts = banking.getAllAccounts();
			boolean isContained = false;
			
			for(BankingAccountVO vo:accounts)
			{
				if(((AddBankingUI)currentPanel).getTextInput().equals(vo.getName()))
				{
					isContained = true;
					break;
				}
			}
			
			
			if(isContained)
			{
				PromptDialog.show("添加无效", "     输入的账号已存在");
			}
			else{
			
			banking.addAccount(((AddBankingUI)currentPanel).getTextInput());
			frame.getContentPane().removeAll();
			currentPanel = new BankingUI(this);
			frame.add(currentPanel);
			frame.validate();
			frame.repaint();
			}
		}else if (e.getActionCommand().equals("DeleteBanking")) {
			ResultMessage isValid = banking.removeAccount(((DeleteBankingUI)currentPanel).getID());
			if(isValid==ResultMessage.VALID)
			{
				PromptDialog.show("删除成功", "         你真棒");
		
			frame.getContentPane().removeAll();
			currentPanel = new BankingUI(this);
			frame.add(currentPanel);
			frame.validate();
			frame.repaint();
			
			}
				
			
			else {
				PromptDialog.show("删除失败", "    输入账户不存在");
			}
			
			
			
		}else if (e.getActionCommand().equals("ModifyBanking")) {
			
			ResultMessage isValid = banking.modifyAccount(((ModifyBankingUI)currentPanel).getID()[1],
					((ModifyBankingUI)currentPanel).getID()[0]);
			if(isValid==ResultMessage.VALID)
			{
				PromptDialog.show("修改成功", "          你真棒");
				frame.getContentPane().removeAll();
				currentPanel = new BankingUI(this);
				frame.add(currentPanel);
				frame.validate();
				frame.repaint();
			}
			else 
			{
				PromptDialog.show("修改失败", "      输入无效");
			}
			
		}else if (e.getActionCommand().equals("SearchList")) {
		}else if (e.getActionCommand().equals("Export")) {
			((BussinessConditionPanel)currentPanel).getTables();
			
		}else if(e.getActionCommand().equals("CreateAccount")){
			
			account.createAccount();
			
		}else if(e.getActionCommand().equals("SearchAccount")){
			Accountvo avo = account.viewAccount(((AccountUI)currentPanel).getDate());
            
			if(avo!=null){
			frame.getContentPane().removeAll();
			currentPanel = new AccountPanel(this, avo);
			frame.add(currentPanel);
			frame.validate();
			frame.repaint();
		}
		}
	}

	
	
	public void refresh(){
		balance = DataFactory.createBalanceBLInstance();
		view    = DataFactory.createViewPaymentblInstance();
	}
}
