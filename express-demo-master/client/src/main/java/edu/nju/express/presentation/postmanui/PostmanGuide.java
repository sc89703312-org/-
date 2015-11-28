package edu.nju.express.presentation.postmanui;

import javax.swing.JButton;
import javax.swing.JPanel;


public class PostmanGuide extends JPanel {

	static int width = 900, height = 600;
	static int y = 50; // 由标题栏高度决定

	private static final long serialVersionUID = 1L;

	PostmanController controller;

	JButton processOrder;
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

		processOrder = new JButton("处理订单");
		processOrder.setBounds(60, 30, 120, 40);
		processOrder.setActionCommand("ProcessOrderUI");
		processOrder.addActionListener(controller);

		inquireOrder = new JButton("查询订单");
		inquireOrder.setBounds(60, 100, 120, 40);
		inquireOrder.setActionCommand("InquireOrderUI");
		inquireOrder.addActionListener(controller);

		confirmReceival = new JButton("确认收货");
		confirmReceival.setBounds(60, 170, 120, 40);
		confirmReceival.setActionCommand("ConfirmReceivalUI");
		confirmReceival.addActionListener(controller);


		this.add(processOrder);
		this.add(inquireOrder);
		this.add(confirmReceival);

	}
}
