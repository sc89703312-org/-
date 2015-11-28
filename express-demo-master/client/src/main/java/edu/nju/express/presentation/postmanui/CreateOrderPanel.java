package edu.nju.express.presentation.postmanui;

import java.awt.Color;
import java.awt.FlowLayout;
import java.awt.Font;

import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import edu.nju.express.common.ArrivalState;
import edu.nju.express.common.Etype;
import edu.nju.express.presentation.MainPanel;
import edu.nju.express.presentation.myUI.LabelTextField;

public class CreateOrderPanel extends MainPanel {

	private static final long serialVersionUID = 1L;
	static int width = 900;
	static int height = 600;
	static int y = 50;
	static Font font = new Font("黑体", Font.PLAIN, 16);
	static Color color = Color.white;

	PostmanController controller;

	JPanel senderPanel, receiverPanel, goodsPanel, orderPanel, idPanel;
	LabelTextField id;
	LabelTextField nameS, addressS, postS, telS, phoneS;
	LabelTextField nameR, addressR, postR, telR, phoneR;
	LabelTextField num, weight, size, goodsName;
	JComboBox<String> typeBox, pkgCostBox;
	JLabel totalCost;
	
	ArrivalState arrivalState;
	String expectedTime;
	String currentSpot;
	String Deliver = "";
	/*
	 * 寄件单（ 寄件人姓名、住址、单位、电话、手机； 收件人姓名、住址、单位、电话、手机； 托运货物信息（原件数、实际重量、体积、内件品名）；
	 * 经济快递，标准快递，特快专递； 包装费（纸箱（5元）、木箱（10元）、快递袋（1元）、其它）； 费用合计（自动计算，运费+包装费）；
	 * 订单条形码号（10位数）；
	 */

	public CreateOrderPanel(PostmanController c) {
		controller = c;

		FlowLayout flo = new FlowLayout(FlowLayout.LEADING, 40,0);
		
		idPanel = new JPanel();
		idPanel.setLayout(flo);
		idPanel.setOpaque(false);
		idPanel.setBounds(0,y+30,width,30);
		id = new LabelTextField("快递编号  ",15);
		idPanel.add(id);
		this.add(idPanel);
		
		senderPanel = new JPanel();
		senderPanel.setOpaque(false);
		senderPanel.setBounds(0, y + 90, width, 30);
		senderPanel.setLayout(flo);
		this.add(senderPanel);

		nameS = new LabelTextField("姓名", 6);
		addressS = new LabelTextField("地址", 17);
		postS = new LabelTextField("单位", 15);
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
		receiverPanel.setBounds(0, y + 150, width, 30);
		this.add(receiverPanel);

		nameR = new LabelTextField("姓名", 6);
		addressR = new LabelTextField("地址", 17);
		postR = new LabelTextField("单位", 15);
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
		goodsPanel.setBounds(0, y + 210, width, 30);
		num = new LabelTextField("原件数", 4);
		weight = new LabelTextField("重量", 6);
		size = new LabelTextField("体积", 6);
		goodsName = new LabelTextField("内件品名", 10);
		goodsPanel.add(num);
		goodsPanel.add(weight);
		goodsPanel.add(size);
		goodsPanel.add(goodsName);
		this.add(goodsPanel);
		
		orderPanel = new JPanel();
		orderPanel.setOpaque(false);
		orderPanel.setLayout(flo);
		orderPanel.setBounds(0, y + 270, width, 30);
		
		JLabel l1= new JLabel("快递种类 ");
		l1.setOpaque(false);
		l1.setFont(font);
		l1.setForeground(color);
		typeBox = new JComboBox<String>();
		typeBox.setOpaque(false);
		typeBox.setBackground(new Color(0,0,0,50));
		typeBox.setFont(new Font("黑体", Font.PLAIN, 14));
		typeBox.setBorder(new EmptyBorder(0,0,0,0));;
		for (Etype r : Etype.values())
			typeBox.addItem(r.getName());
		JPanel p1 = new JPanel();
		p1.setOpaque(false);
		p1.add(l1);
		p1.add(typeBox);
		orderPanel.add(p1);
		
		pkgCostBox = new JComboBox<String>();
		pkgCostBox.setOpaque(false);
		pkgCostBox.setFont(new Font("黑体", Font.PLAIN, 14));
		pkgCostBox.setBorder(new EmptyBorder(0,0,0,0));;
		pkgCostBox.addItem("快递袋");
		pkgCostBox.addItem("纸箱");
		pkgCostBox.addItem("木箱");
		orderPanel.add(pkgCostBox);
		this.add(orderPanel);

	}
}
