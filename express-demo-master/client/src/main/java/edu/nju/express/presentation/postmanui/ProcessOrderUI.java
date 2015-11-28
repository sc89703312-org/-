package edu.nju.express.presentation.postmanui;

import javax.swing.JButton;
import javax.swing.JPanel;

import edu.nju.express.presentation.MainPanel;

public class ProcessOrderUI extends MainPanel {
	private static final long serialVersionUID = 1L;

	static int width = 900, height = 600;
	static int y = 50; // 由标题栏高度决定
	static int x = 240; // 由导航栏宽度决定
	static int h = 90; // 按钮面板高度

	JPanel buttons;
	JButton create;
	
	PostmanController controller;

	public ProcessOrderUI(PostmanController c) {

		controller = c;

		this.setOpaque(false);
		this.setLayout(null);
		this.add(new PostmanGuide(controller));
		
		initButtons();
		
		
	}


	private void initButtons() {
		buttons = new JPanel();
		buttons.setOpaque(false);
		buttons.setLayout(null);
		buttons.setBounds(x, y, width-x, h);
		
		create = new JButton("新建订单");
		create.setActionCommand("CreateOrderUI");
		create.addActionListener(controller);
		create.setBounds(290,45, 80,30);
		buttons.add(create);
		
		
		this.add(buttons);
		
	}


}
