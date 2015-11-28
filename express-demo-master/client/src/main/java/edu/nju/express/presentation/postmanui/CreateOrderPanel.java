package edu.nju.express.presentation.postmanui;

import java.awt.Color;
import java.awt.FlowLayout;
import java.awt.Font;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JPanel;

import edu.nju.express.common.ArrivalState;
import edu.nju.express.common.Etype;
import edu.nju.express.presentation.MainPanel;
import edu.nju.express.presentation.myUI.ConfirmButton;
import edu.nju.express.presentation.myUI.DateComboBoxPanel;
import edu.nju.express.presentation.myUI.LabelTextField;
import edu.nju.express.presentation.myUI.MyComboBox;
import edu.nju.express.presentation.myUI.ReturnButton;
import edu.nju.express.vo.OrderVOforInput;

public class CreateOrderPanel extends MainPanel {

	private static final long serialVersionUID = 1L;
	static int width = 900;
	static int height = 600;
	static int y = 50;
	static int interval = 70;
	static int h = 90;
	static Font font = new Font("黑体", Font.PLAIN, 16);
	static Color color = Color.white;

	PostmanController controller;

	JPanel senderPanel, receiverPanel, goodsPanel, orderPanel, idPanel;
	LabelTextField id;
	DateComboBoxPanel date;
	LabelTextField nameS, addressS, postS, telS, phoneS;
	LabelTextField nameR, addressR, postR, telR, phoneR;
	LabelTextField num, weight, size, goodsName;
	JComboBox<String> typeBox, pkgCostBox;
	JLabel totalCost, expectedArrival;
	JButton confirm,caculate;

	ArrivalState arrivalState;
	String expectedTime;
	String currentSpot;
	String Deliver = "";

	public CreateOrderPanel(PostmanController c) {
		controller = c;

		JButton jbtreturn = new ReturnButton();
		jbtreturn.setLocation(20, y+20);
		jbtreturn.addActionListener(controller);
		jbtreturn.setActionCommand("PostmanMainUI");
		this.add(jbtreturn);
		
		FlowLayout flo = new FlowLayout(FlowLayout.LEADING, 35,0);
		
		idPanel = new JPanel();
		idPanel.setLayout(flo);
		idPanel.setOpaque(false);
		idPanel.setBounds(10,y+h,width,40);
		id = new LabelTextField("快递编号  ",15);
		idPanel.add(id);
		
		JPanel dp = new JPanel();
		dp.setOpaque(false);
		JLabel time = new JLabel("日期");
		time.setFont(font);
		time.setForeground(color);
		date = new DateComboBoxPanel();
		dp.add(time);
		dp.add(date);
		idPanel.add(dp);		
		
		this.add(idPanel);
		
		senderPanel = new JPanel();
		senderPanel.setOpaque(false);
		senderPanel.setBounds(10, y + h+interval, width, 30);
		senderPanel.setLayout(flo);
		this.add(senderPanel);

		nameS = new LabelTextField("姓名", 6);
		addressS = new LabelTextField("地址", 17);
		postS = new LabelTextField("单位", 13);
		telS = new LabelTextField("电话", 10);
		phoneS = new LabelTextField("手机", 11);
		senderPanel.add(nameS);
		senderPanel.add(addressS);
		senderPanel.add(postS);
		senderPanel.add(telS);
		senderPanel.add(phoneS);

		
		receiverPanel = new JPanel();
		receiverPanel.setOpaque(false);
		receiverPanel.setLayout(flo);
		receiverPanel.setBounds(10, y + h+interval*2, width, 30);
		this.add(receiverPanel);

		nameR = new LabelTextField("姓名", 6);
		addressR = new LabelTextField("地址", 17);
		postR = new LabelTextField("单位", 13);
		telR = new LabelTextField("电话", 10);
		phoneR = new LabelTextField("手机", 11);
		receiverPanel.add(nameR);
		receiverPanel.add(addressR);
		receiverPanel.add(postR);
		receiverPanel.add(telR);
		receiverPanel.add(phoneR);

		goodsPanel = new JPanel();
		goodsPanel.setOpaque(false);
		goodsPanel.setLayout(flo);
		goodsPanel.setBounds(10, y + h+interval*3, width, 30);
		num = new LabelTextField("原件数", 4);
		weight = new LabelTextField("重量 ", 6,"kg");
		size = new LabelTextField("体积 ", 6);
		goodsName = new LabelTextField("内件品名", 10);
		goodsPanel.add(num);
		goodsPanel.add(weight);
		goodsPanel.add(size);
		goodsPanel.add(goodsName);
		this.add(goodsPanel);
		
		orderPanel = new JPanel();
		orderPanel.setOpaque(false);
		orderPanel.setLayout(flo);
		orderPanel.setBounds(10, y + h+interval*4, width, 30);
		
		JLabel l1= new JLabel("快递种类 ");
		l1.setOpaque(false);
		l1.setFont(font);
		l1.setForeground(color);
		typeBox = new MyComboBox<String>();
		for (Etype r : Etype.values())
			typeBox.addItem(r.getName());
		JPanel p1 = new JPanel();
		p1.setOpaque(false);
		p1.add(l1);
		p1.add(typeBox);
		orderPanel.add(p1);
		
		
		JLabel l2= new JLabel("包装种类 ");
		l2.setOpaque(false);
		l2.setFont(font);
		l2.setForeground(color);
		
		JPanel p2 = new JPanel();
		p2.setOpaque(false);
		p2.add(l2);
		pkgCostBox = new MyComboBox<String>();
		pkgCostBox.addItem("快递袋");
		pkgCostBox.addItem("纸箱");
		pkgCostBox.addItem("木箱");
		orderPanel.add(pkgCostBox);
		p2.add(pkgCostBox);
		orderPanel.add(p2);
		this.add(orderPanel);

		totalCost = new JLabel("报价：");
		totalCost.setFont(new Font("黑体", Font.PLAIN, 17));
		totalCost.setForeground(color);
		totalCost.setBounds(100, 480, 250, 30);
		this.add(totalCost);
		
		expectedArrival = new JLabel("预计送达时间：");
		expectedArrival.setFont(new Font("黑体", Font.PLAIN, 17));
		expectedArrival.setForeground(color);
		expectedArrival.setBounds(300, 480, 300, 30);
		this.add(expectedArrival);
		
		JPanel buttons = new JPanel();
		buttons.setOpaque(false);
		buttons.setBounds(0, 540, width, 30);
		caculate = new JButton("计算报价");
		caculate.setActionCommand("CaculateFee");
		caculate.addActionListener(controller);
		buttons.add(caculate);
		confirm = new ConfirmButton();
		confirm.setActionCommand("SubmitOrder");
		caculate.addActionListener(controller);
		buttons.add(confirm);
		this.add(buttons);
	}
}
