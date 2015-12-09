package edu.nju.express.presentation.postmanui;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.Calendar;

import javax.swing.BoxLayout;
import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.ScrollPaneConstants;
import javax.swing.border.EmptyBorder;

import edu.nju.express.common.ArrivalState;
import edu.nju.express.common.Etype;
import edu.nju.express.po.LoginInfo;
import edu.nju.express.presentation.FeeCalculator;
import edu.nju.express.presentation.MainPanel;
import edu.nju.express.presentation.myUI.ConfirmButton;
import edu.nju.express.presentation.myUI.DateComboBoxPanel;
import edu.nju.express.presentation.myUI.LabelTextField;
import edu.nju.express.presentation.myUI.MyComboBox;
import edu.nju.express.presentation.myUI.MyScrollBarUI;
import edu.nju.express.vo.OrderVO;

public class CreateOrderPanel extends MainPanel {

	private static final long serialVersionUID = 1L;
	static int width = 900;
	static int height = 600;
	static int y = 50;
	static int interval = 10;
	private static Font font = new Font("黑体", Font.PLAIN, 18);
	private static Color color = new Color(44, 62, 80);
	private static Icon fee1 = new ImageIcon("ui/button/fee1.png");
	private static Icon fee2 = new ImageIcon("ui/button/fee2.png");

	PostmanController controller;

	LabelTextField id;
	DateComboBoxPanel date;
	LabelTextField nameS, addressS, postS, telS, phoneS;
	LabelTextField nameR, addressR, postR, telR, phoneR;
	LabelTextField num, weight, size, goodsName;
	JComboBox<String> typeBox, pkgCostBox;
	JLabel totalCost, expectedArrival;

	double total, expect;
	double pkgCost;
	String cityR, cityS;

	JButton confirm, caculate;
	static JScrollPane s = new JScrollPane();

	ArrivalState arrivalState;
	String expectedTime;
	String currentSpot;
	String Deliver = "";

	public CreateOrderPanel(PostmanController c) {
		controller = c;

		this.add(new PostmanGuide(c));

		JPanel p = new JPanel();
		p.setOpaque(false);
		p.setBounds(94, 112, width - 175, height - 180);
		p.setLayout(new BoxLayout(p, BoxLayout.Y_AXIS));
		this.add(p);

		s.setOpaque(false);
		s.setViewportView(p);
		s.getViewport().setOpaque(false);
		s.getVerticalScrollBar().setOpaque(false);

		final MyScrollBarUI ui = new MyScrollBarUI();
		s.getVerticalScrollBar().setUI(ui);

		s.getVerticalScrollBar().addMouseListener(new MouseAdapter() {
			@Override
			public void mouseEntered(MouseEvent e) {
				super.mouseEntered(e);
				s.getVerticalScrollBar().repaint();
				;
			}

			@Override
			public void mouseExited(MouseEvent e) {
				// TODO Auto-generated method stub
				super.mouseExited(e);
				s.getVerticalScrollBar().repaint();
				;

			}
		});

		s.setBorder(new EmptyBorder(0, 0, 0, 0));
		s.setViewportBorder(new EmptyBorder(0, 0, 0, 0));
		s.setHorizontalScrollBarPolicy(ScrollPaneConstants.HORIZONTAL_SCROLLBAR_NEVER);
		s.setBounds(128, 112, width - 175, height - 180);
		this.add(s);

		id = new LabelTextField("快递编号    ", 15);
		p.add(id);

		JPanel dp = new JPanel();
		dp.setOpaque(false);
		JLabel time = new JLabel("日期   ");
		time.setFont(font);
		time.setForeground(color);
		date = new DateComboBoxPanel();
		dp.add(time);
		dp.add(date);
		p.add(dp);

		nameS = new LabelTextField("收件人姓名  ", 6);
		addressS = new LabelTextField("收件人地址  ", 17);
		postS = new LabelTextField("收件人单位  ", 13);
		telS = new LabelTextField("收件人电话  ", 10);
		phoneS = new LabelTextField("收件人手机  ", 11);
		p.add(nameS);
		p.add(addressS);
		p.add(postS);
		p.add(telS);
		p.add(phoneS);

		nameR = new LabelTextField("寄件人姓名  ", 6);
		addressR = new LabelTextField("寄件人地址  ", 17);
		postR = new LabelTextField("寄件人单位  ", 13);
		telR = new LabelTextField("寄件人电话  ", 10);
		phoneR = new LabelTextField("寄件人手机  ", 11);
		p.add(nameR);
		p.add(addressR);
		p.add(postR);
		p.add(telR);
		p.add(phoneR);

		num = new LabelTextField("原件数      ", 4);
		weight = new LabelTextField("重量        ", 0, "kg       ");
		size = new LabelTextField("体积        ", 6);
		goodsName = new LabelTextField("内件品名    ", 10);
		p.add(num);
		p.add(weight);
		p.add(size);
		p.add(goodsName);

		JLabel l1 = new JLabel("快递种类     ");
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
		p1.setPreferredSize(new Dimension(350, 50));
		p.add(p1);

		JLabel l2 = new JLabel("包装种类     ");
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
		p.add(pkgCostBox);
		p2.add(pkgCostBox);
		p2.setPreferredSize(new Dimension(350, 50));
		p.add(p2);

		JLabel l = new JLabel();
		l.setOpaque(false);
		l.setPreferredSize(new Dimension(200, 10));
		p.add(l);

		totalCost = new JLabel();
		totalCost.setFont(font);
		totalCost.setForeground(color);
		totalCost.setPreferredSize(new Dimension(200, 60));
		p.add(totalCost);

		expectedArrival = new JLabel();
		expectedArrival.setFont(font);
		expectedArrival.setForeground(color);
		expectedArrival.setPreferredSize(new Dimension(200, 60));
		p.add(expectedArrival);

		caculate = new JButton(fee1);
		caculate.setRolloverIcon(fee2);
		caculate.setContentAreaFilled(false);
		caculate.setBorderPainted(false);
		caculate.setBounds(360, 537, 120, 30);
		caculate.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				cityR = (addressR.getText().split(" "))[0];
				cityS = (addressS.getText().split(" "))[0];
				total = calculate();
				
				System.out.println(FeeCalculator.getDistance("北京", "广州"));
				System.out.println(FeeCalculator.getDistance( "广州","上海"));
				
				expect = FeeCalculator.getExpectedDays(cityS, cityR);
				
				totalCost.setText("   报价： " + total + " 元        ");
				expectedArrival.setText("预计送达时间： " + expect + " 天        ");
				totalCost.setHorizontalAlignment(JLabel.CENTER);
				expectedArrival.setHorizontalAlignment(JLabel.CENTER);
				s.getVerticalScrollBar().setValue(s.getVerticalScrollBar().getMaximum());

			}

		});
		this.add(caculate);

		confirm = new ConfirmButton();
		confirm.setBounds(500, 537, 80, 30);
		confirm.setActionCommand("SubmitOrder");
		confirm.addActionListener(controller);
		this.add(confirm);
	}

	public OrderVO getInput() {

		Etype type;
		type = Etype.getType((String) typeBox.getSelectedItem());
		Calendar c = Calendar.getInstance();
		c.add(Calendar.DATE, (int) expect);
		String expectedDate = c.get(Calendar.YEAR) + "/" + String.format("%02d", c.get(Calendar.MONTH+1)) + "/"
				+ String.format("%02d", c.get(Calendar.DATE));
		System.out.println(expectedDate);

		return new OrderVO(nameS.getText(), addressS.getText(), postS.getText(), telS.getText(), phoneS.getText(),
				nameR.getText(), addressR.getText(), postR.getText(), telR.getText(), phoneR.getText(),
				Integer.parseInt(num.getText()), Double.parseDouble(weight.getText()),
				Double.parseDouble(size.getText()), goodsName.getText(), Double.parseDouble(size.getText()), pkgCost,
				total, id.getText(), type, ArrivalState.NO, expectedDate, cityS);
	}

	private double calculate() {
		double result = 0;
		pkgCost = FeeCalculator.getPkgCost((String) pkgCostBox.getSelectedItem());
		result = pkgCost + FeeCalculator.getTransFee(cityR, cityS, Etype.getType((String) typeBox.getSelectedItem()));

		return result;
	}
}
