package edu.nju.express.presentation.postmanui;

import java.awt.event.ActionEvent;
import java.util.ArrayList;

import javax.swing.JFrame;
import javax.swing.JPanel;

import edu.nju.express.blservice.OrderBLService;
import edu.nju.express.businesslogic.DataFactory;
import edu.nju.express.common.ArrivalState;
import edu.nju.express.common.Etype;
import edu.nju.express.presentation.UIController;
import edu.nju.express.vo.OrderVO;

public class PostmanController implements UIController {

	JPanel currentPanel;
	JFrame frame;
	private OrderBLService order;
	private OrderVO vo;

	public PostmanController(JFrame f) {
		this.frame = f;
		order = DataFactory.createOrderBLInstance();
		currentPanel = (JPanel)f.getContentPane();
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
			System.out.println("yingyingying");
			
			
			CreateOrderPanel panel = (CreateOrderPanel) currentPanel;
			
			OrderVO tempVo = panel.getInput();
			
			System.out.println(order.createOrder(tempVo));
//			System.out.println(order.createOrder(new OrderVO("丁盛阳","NJU","NJU","025-83621002","13900001234","顾晗","NJU",
//				"NJU","025-83621001","13900001231",1,20.5,30.0,"book",10*20,5.0,15.0,"0000000005",Etype.FAST,
//				ArrivalState.NO,"2 days","Nanjing")));
		
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
