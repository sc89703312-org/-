package edu.nju.express.presentation.postmanui;

import javax.swing.JButton;
import javax.swing.JPanel;


public class PostmanGuide extends JPanel {

	static int width = 900, height = 600;
	static int y = 50; // 由标题栏高度决定

	private static final long serialVersionUID = 1L;

	PostmanController controller;

	JButton createOrder;
	JButton inquireOrder;
	JButton confirmReceival;

	public PostmanGuide(PostmanController controller) {
		this.controller = controller;
		initGuide();
		this.setLayout(null);
		this.setOpaque(false);
		this.setBounds(0, y, 240, height - y);
	}

	void initGuide() {

		createOrder = new JButton("新建订单");
		createOrder.setBounds(60, 30, 120, 40);
		createOrder.setActionCommand("CreateOrderUI");
		createOrder.addActionListener(controller);

		inquireOrder = new JButton("查询订单");
		inquireOrder.setBounds(60, 100, 120, 40);
		inquireOrder.setActionCommand("InquireOrderUI");
		inquireOrder.addActionListener(controller);

		confirmReceival = new JButton("确认收货");
		confirmReceival.setBounds(60, 170, 120, 40);
		confirmReceival.setActionCommand("ConfirmReceivalUI");
		confirmReceival.addActionListener(controller);


		this.add(createOrder);
		this.add(inquireOrder);
		this.add(confirmReceival);

	}
}
