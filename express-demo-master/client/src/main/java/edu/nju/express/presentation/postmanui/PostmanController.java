package edu.nju.express.presentation.postmanui;

import java.awt.event.ActionEvent;
import java.util.ArrayList;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;

import edu.nju.express.blservice.OrderBLService;
import edu.nju.express.businesslogic.DataFactory;
import edu.nju.express.presentation.UIController;
import edu.nju.express.vo.OrderVO;

public class PostmanController implements UIController {

	JPanel currentPanel;
	JFrame frame;
	private OrderBLService order;
	private OrderVO vo;

	public PostmanController(JFrame f) {
		this.frame = f;
		currentPanel = (JPanel)frame.getContentPane();
		order = DataFactory.createOrderBLInstance();
	}

	@Override
	public void actionPerformed(ActionEvent e) {

		if (e.getActionCommand().equals("PostmanMainUI")) {
			
			frame.getContentPane().removeAll();
			currentPanel = new PostmanMainUI(this);
			frame.add(currentPanel);
			frame.validate();
			frame.repaint();
		} else if (e.getActionCommand().equals("CreateOrderUI")) {
			frame.getContentPane().removeAll();
			currentPanel = new CreateOrderPanel(this);
			frame.add(currentPanel);
			frame.validate();
			frame.repaint();
		} else if (e.getActionCommand().equals("InquireOrderUI")) {
			
			frame.getContentPane().removeAll();
			currentPanel = new InquireOderUI(this);
			frame.add(currentPanel);
			frame.validate();
			frame.repaint();
		} else if (e.getActionCommand().equals("ConfirmReceivalUI")) {
			
			frame.getContentPane().removeAll();
			currentPanel = new ConfirmReceivalUI(this);
			frame.add(currentPanel);
			frame.validate();
			frame.repaint();
		} else if (e.getActionCommand().equals("SubmitOrder")) {
			
			OrderVO tempVo = ((CreateOrderPanel) ((JButton)e.getSource()).getParent()).getInput();
			System.out.println(tempVo);
			
			System.out.println(order.createOrder(tempVo));
		
		} else if (e.getActionCommand().equals("ConfirmReceival")) {
			
			order.receiverCfm(((ConfirmReceivalUI) currentPanel).getTextInput().getId());
		
		} else if (e.getActionCommand().equals("SearchOrder")) {
			InquireOderUI inqUI = (InquireOderUI) currentPanel;
			vo = order.view(inqUI.getOrder());
			inqUI.addRow(vo);
			
		}
	}

	public OrderVO getOrderVo() {
		return this.vo;
	}

	public ArrayList<OrderVO> getOrderList() {
		return order.viewAll();
	}
}
