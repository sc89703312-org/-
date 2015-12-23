package edu.nju.express.presentation.financeui;

import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JButton;

import edu.nju.express.blservice.BankingBlService;
import edu.nju.express.presentation.MainPanel;
import edu.nju.express.presentation.myUI.MyButton;
import edu.nju.express.presentation.myUI.MySearchFieldPanel;
import edu.nju.express.presentation.myUI.MyTablePanel;
import edu.nju.express.vo.BankingAccountVO;

public class BankingUI extends MainPanel {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private static Icon add1  = new ImageIcon("ui/button/新增账号1.png");
	private static Icon add2  = new ImageIcon("ui/button/新增账号2.png");
	private static Icon del1  = new ImageIcon("ui/button/删除账号1.png");
	private static Icon del2  = new ImageIcon("ui/button/删除账号2.png");
	private static Icon mod1  = new ImageIcon("ui/button/修改账号1.png");
	private static Icon mod2  = new ImageIcon("ui/button/修改账号2.png");
	
	private FinanceController controller;
	private BankingBlService bankingBL;

	private MyTablePanel table;
	private MySearchFieldPanel search;

	private JButton add;
	private JButton delete;
	private JButton modify;

	private ArrayList<BankingAccountVO> list;

	public BankingUI(FinanceController c) {

		this.controller = c;

        bankingBL = c.banking;
        FinanceGuide guide =new FinanceGuide(controller);
		guide.banking.setIcon(null);
		this.add(guide);
		this.bg = new ImageIcon("ui/image/finance/账户管理.png").getImage();


		search = new MySearchFieldPanel(c);
		search.setBounds(380,75, 400, 40);
		search.setActionCommand("SearchBanking");
		this.add(search);

	/*	initPopup();*/

		add = new JButton(add1);
		add.setRolloverIcon(add2);
		add.setBorderPainted(false);
		add.setContentAreaFilled(false);
		add.setBounds(300,537,100,30);
		this.add(add);
		add.addActionListener(controller);
		add.setActionCommand("AddBankingUI");

		delete= new JButton(del1);
		delete.setRolloverIcon(del2);
		delete.setBorderPainted(false);
		delete.setContentAreaFilled(false);
		delete.setBounds(450,537,100,30);
		this.add(delete);
		delete.addActionListener(controller);
		delete.setActionCommand("DeleteBankingUI");

		modify = new JButton(mod1);
		modify.setRolloverIcon(mod2);
		modify.setBorderPainted(false);
		modify.setContentAreaFilled(false);
		modify.setBounds(600,537,100,30);
		this.add(modify);
		modify.addActionListener(controller) ;
		modify.setActionCommand("ModifyBankingUI");

		initData();

		String[] header = { "账户名称", "余额" };
		table = new MyTablePanel(header);
		Object[] rowdata = new Object[2];
		for (int i = 0; i < list.size(); i++) {
			rowdata[0] = list.get(i).getName();
			rowdata[1] = list.get(i).getMoney();
			table.getTableModel().addRow(rowdata);
		}
		this.add(table);
		table.setRowHeight(28);
		table.setBounds(128, 126, 727, 408);
		table.getTable().setPreferredScrollableViewportSize(new Dimension(716, 370));
	}


	private void initData() {
		list = bankingBL.getAllAccounts();
		
	}

	
	
	
	public void clear(){
		for(int i=0;i<list.size();i++)
			table.getTableModel().removeRow(0);
		
	}
	
	
	public void setNewComponents(ArrayList<BankingAccountVO> tempList){
		
		list = tempList;
		
		Object[] rowdata = new Object[2];
		for (int i = 0; i <list.size(); i++) {
			rowdata[0] = list.get(i).getName();
			rowdata[1] = list.get(i).getMoney();
			table.getTableModel().addRow(rowdata);
		}
		this.repaint();
	}
	
	public String getKeyWords(){
		return search.getText();
	}

}
