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
		this.setBounds(12, 0, 94, height);
	}

	void initGuide() {

		createOrder = new JButton();
		createOrder.setBorderPainted(false);
		createOrder.setContentAreaFilled(false);
		createOrder.setBounds(0,44,82,82);
		createOrder.setActionCommand("CreateOrderUI");
		createOrder.addActionListener(controller);

		inquireOrder = new JButton();
		inquireOrder.setBounds(0,144,82,82);
		inquireOrder.setBorderPainted(false);
		inquireOrder.setContentAreaFilled(false);
		inquireOrder.setActionCommand("InquireOrderUI");
		inquireOrder.addActionListener(controller);

		confirmReceival = new JButton();
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
