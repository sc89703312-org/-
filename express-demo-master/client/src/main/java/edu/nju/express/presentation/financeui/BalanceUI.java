package edu.nju.express.presentation.financeui;

import java.awt.Color;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;

import edu.nju.express.blservice.CostControlService;
import edu.nju.express.common.Item;
import edu.nju.express.presentation.MainPanel;
import edu.nju.express.presentation.myUI.ConfirmButton;
import edu.nju.express.presentation.myUI.DateComboBoxPanel;
import edu.nju.express.presentation.myUI.LabelTextField;
import edu.nju.express.presentation.myUI.MyComboBox;
import edu.nju.express.presentation.myUI.MyTextField;
import edu.nju.express.vo.Balancevo;

public class BalanceUI extends MainPanel implements ActionListener {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private static Icon fee1 =new ImageIcon("ui/button/fee1.png");
	private static Icon fee2 =new ImageIcon("ui/button/fee2.png");
	private static Icon historyIcon1 =new ImageIcon("ui/button/查看历史单据1.png");
	private static Icon historyIcon2 =new ImageIcon("ui/button/查看历史单据2.png");
	private static int width = 900, height = 600;
	private static int x = 95, y = 50;
	private static Font font = new Font("黑体", Font.PLAIN, 18);
	private static Color color = new Color(44, 62,80);

	private FinanceController controller;
	private CostControlService costBL;

	private ConfirmButton cfm;
	private LabelTextField id;
	private DateComboBoxPanel date;
	private LabelTextField amount, name, banking, remark;
	private MyComboBox<String> itemBox;
	private JButton history;
	private JButton cal;

	public BalanceUI(FinanceController c) {
		this.controller = c;
		costBL = c.cost;

		this.add(new FinanceGuide(c));
		
		JPanel p = new JPanel();
		p.setBounds(x - 130, 100, width - x+90, height - y);
		p.setLayout(new FlowLayout(FlowLayout.LEFT, 360, 10));
		p.setOpaque(false);

		JLabel d = new JLabel("日期     ");
		d.setForeground(color);
		d.setFont(font);
		date = new DateComboBoxPanel();
		JPanel p1 = new JPanel();
		p1.setOpaque(false);
		p1.add(d);
		p1.add(date);
		p.add(p1);
		
		JLabel items = new JLabel("条目      ");
		items.setForeground(color);
		items.setFont(font);
		itemBox = new MyComboBox<String>();
		for (Item i : Item.values()) {
			itemBox.addItem(i.getName());
		}
		JPanel p2 = new JPanel();
		p2.setOpaque(false);
		p2.add(items);
		p2.add(itemBox);
		p.add(p2);
		
		id = new LabelTextField("单据编号 ", 10);
		p.add(id);

		amount = new LabelTextField("付款金额 ", 13, "元");
		p.add(amount);

		name = new LabelTextField("付款人   ", 17);
		p.add(name);

		banking = new LabelTextField("付款账户 ", 25);
		p.add(banking);

		remark = new LabelTextField("备注     ", 25);
		p.add(remark);

		this.add(p);
		
		cal = new JButton(fee1);
		cal.setContentAreaFilled(false);
		cal.setBorderPainted(false);
		cal.setRolloverIcon(fee2);
		
		cal.setBounds(440, 537, 120,30);
		cal.addActionListener(this);
		this.add(cal);
		
		cfm = new ConfirmButton();
		cfm.setBounds(580, 537, 80,30);
		cfm.addActionListener(controller);
		cfm.setActionCommand("SubmitBalance");
		this.add(cfm);
		
		history = new JButton(historyIcon1);
		history.setRolloverIcon(historyIcon2);
		history.setBorderPainted(false);
		history.setContentAreaFilled(false);
		history.setBounds(300, 537, 120, 30);
		history.addActionListener(controller);
		history.setActionCommand("BalanceHistory");
		this.add(history);
	}
	
	
	
	public String getComBoxComponent(){
		return (String)itemBox.getSelectedItem();
	}

	
	public void setAmount(double salary){
		this.amount.setText(salary+"");
	}
	
	
	public String getRemark(){
		return remark.getText();
	}



	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		
		double salary = 0;
		
		if(getComBoxComponent().equals("业务员月薪"))
			salary = costBL.caculateClerkSalary();
		else if (getComBoxComponent().equals("快递员提成")) {
			salary = costBL.caculatePostManSalary(getRemark());
		}else if (getComBoxComponent().equals("司机提成")) {
			salary = costBL.caculateDriverSalary(getRemark());
		}
			
		setAmount(salary);
		
	}
	
	
	public Balancevo createBalanceVO(){
		return new Balancevo(date.getDate(), Double.parseDouble(amount.getText()),
				name.getText(), banking.getText(),
				Item.getItem((String)itemBox.getSelectedItem()), remark.getText(),
				id.getText());
	}
	
	
}
