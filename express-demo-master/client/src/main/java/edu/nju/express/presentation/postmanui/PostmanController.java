package edu.nju.express.presentation.postmanui;

import java.awt.event.ActionEvent;
import java.util.ArrayList;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;

import edu.nju.express.blservice.OrderBLService;
import edu.nju.express.businesslogic.DataFactory;
import edu.nju.express.common.ResultMessage;
import edu.nju.express.presentation.UIController;
import edu.nju.express.presentation.myUI.WarningDialog;
import edu.nju.express.vo.OrderVO;

public class PostmanController implements UIController {

	JPanel currentPanel;
	JFrame frame;
	private OrderBLService order;
	private OrderVO vo;

	public PostmanController(JFrame f) {
		this.frame = f;
		currentPanel = (JPanel) frame.getContentPane();
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

			OrderVO tempVo = ((CreateOrderPanel) ((JButton) e.getSource()).getParent()).getInput();

			ResultMessage message = ResultMessage.INVALID;
			if (tempVo == null)
				return;

			message = order.createOrder(tempVo);
			if (message == ResultMessage.INVALID)
				WarningDialog.show("提交失败", "订单号已存在");
			else{
				WarningDialog.showSucess();
				frame.getContentPane().removeAll();
				currentPanel = new CreateOrderPanel(this);
				frame.add(currentPanel);
				frame.validate();
				frame.repaint();
			}
	}else if(e.getActionCommand().equals("ConfirmReceival"))

	{
		if(((ConfirmReceivalUI) currentPanel).getTextInput() == null)
			return;

		String id = ((ConfirmReceivalUI) currentPanel).getTextInput().getId();
		ArrayList<OrderVO> orders = order.viewAll();
		boolean isContained = false;

		for (OrderVO vo : orders) {
			if (vo.getID().equals(id)) {
				isContained = true;
				break;
			}
		}
		if (isContained) {
			order.receiverCfm(id);
			WarningDialog.show("收货成功", "稍后返回原页面");
			frame.getContentPane().removeAll();
			currentPanel = new ConfirmReceivalUI(this);
			frame.add(currentPanel);
			frame.validate();
			frame.repaint();

		} else {
			WarningDialog.show("输入有误", "订单编号不存在");
		}

	} else if(e.getActionCommand().equals("SearchOrder"))

	{
		InquireOderUI inqUI = (InquireOderUI) currentPanel;
		String id = inqUI.getOrder();
		ArrayList<OrderVO> orders = order.viewAll();
		boolean isContain = false;
		for (OrderVO vo : orders) {
			if (id.equals(vo.getID())) {
				isContain = true;
				break;
			}

		}

		if (isContain) {

			vo = order.view(inqUI.getOrder());
			inqUI.addRow(vo);
		} else {
			WarningDialog.show("输入有误", "订单编号不存在");
		}
	}

	}

	public OrderVO getOrderVo() {
		return this.vo;
	}

	public ArrayList<OrderVO> getOrderList() {
		return order.viewAll();
	}
}
