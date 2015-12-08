package edu.nju.express.presentation.postmanui;

import java.awt.event.ActionEvent;
import java.util.ArrayList;

import javax.swing.JFrame;
import javax.swing.JPanel;

import edu.nju.express.blservice.ConstantSettingBlService;
import edu.nju.express.blservice.OrderBLService;
import edu.nju.express.businesslogic.DataFactory;
import edu.nju.express.businesslogic.strategybl.constantsettingbl.ConstantSettingBl;
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
	}

	@Override
	public void actionPerformed(ActionEvent e) {

		if (e.getActionCommand().equals("PostmanMainUI")){
			frame.getContentPane().removeAll();;
			currentPanel = new PostmanMainUI(this);
			frame.add(currentPanel);
			frame.validate();
			frame.repaint();
		}else if(e.getActionCommand().equals("CreateOrderUI")){
			frame.getContentPane().removeAll();;
			currentPanel = new CreateOrderPanel(this);
			frame.add(currentPanel);
			frame.validate();
			frame.repaint();
		}else if(e.getActionCommand().equals("InquireOrderUI")){
			frame.getContentPane().removeAll();;
			currentPanel = new InquireOderUI(this);
			frame.add(currentPanel);
			frame.validate();
			frame.repaint();
		}else if(e.getActionCommand().equals("ConfirmReceivalUI")){
			frame.getContentPane().removeAll();;
			currentPanel = new ConfirmReceivalUI(this);
			frame.add(currentPanel);
			frame.validate();
			frame.repaint();
		}else if(e.getActionCommand().equals("SubmitOrder")){
			order.createOrder(((CreateOrderPanel)currentPanel).getInput());
		}else if(e.getActionCommand().equals("ConfirmReceival")){
			System.out.println(((ConfirmReceivalUI)currentPanel).getTextInput());
		}else if(e.getActionCommand().equals("SearchOrder")){
			vo = order.view(((InquireOderUI)currentPanel).getOrder());
		}
	}

	public OrderVO getOrderVo(){
		return this.vo;
	}
	
	public ArrayList<OrderVO> getOrderList(){
		return order.viewAll();
	}
}

