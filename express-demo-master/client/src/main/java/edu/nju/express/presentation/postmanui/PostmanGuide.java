package edu.nju.express.presentation.postmanui;

import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JPanel;


public class PostmanGuide extends JPanel {

	static int width = 900, height = 600;
	static int y = 50; // 由标题栏高度决定

	private static final long serialVersionUID = 1L;
	private static Icon crt1 = new ImageIcon("ui/icon/新建订单1.png");
	private static Icon crt2 = new ImageIcon("ui/icon/新建订单2.png");
	private static Icon inq1 = new ImageIcon("ui/icon/查询订单1.png");
	private static Icon inq2 = new ImageIcon("ui/icon/查询订单2.png");
	private static Icon cfm1 = new ImageIcon("ui/icon/确认收货1.png");
	private static Icon cfm2 = new ImageIcon("ui/icon/确认收货2.png");

	PostmanController controller;

	JButton createOrder;
	JButton inquireOrder;
	JButton confirmReceival;

	public PostmanGuide(PostmanController controller) {
		this.controller = controller;
		initGuide();
		this.setLayout(null);
		this.setOpaque(false);
		this.setBounds(12, 0, 94, height);
	}

	void initGuide() {

		createOrder = new JButton(crt1);
		createOrder.setRolloverIcon(crt2);
		createOrder.setBorderPainted(false);
		createOrder.setContentAreaFilled(false);
		createOrder.setBounds(0,44,82,82);
		createOrder.setActionCommand("CreateOrderUI");
		createOrder.addActionListener(controller);

		inquireOrder = new JButton(inq1);
		inquireOrder.setRolloverIcon(inq2);
		inquireOrder.setBounds(0,144,82,82);
		inquireOrder.setBorderPainted(false);
		inquireOrder.setContentAreaFilled(false);
		inquireOrder.setActionCommand("InquireOrderUI");
		inquireOrder.addActionListener(controller);

		confirmReceival = new JButton(cfm1);
		confirmReceival.setRolloverIcon(cfm2);
		confirmReceival.setContentAreaFilled(false);
		confirmReceival.setBorderPainted(false);
		confirmReceival.setBounds(0,244,82,82);
		confirmReceival.setActionCommand("ConfirmReceivalUI");
		confirmReceival.addActionListener(controller);


		this.add(createOrder);
		this.add(inquireOrder);
		this.add(confirmReceival);

	}
}
