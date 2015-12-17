package edu.nju.express.presentation.postmanui;

import java.awt.event.ActionEvent;
import java.util.ArrayList;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.xml.ws.handler.MessageContext;

import edu.nju.express.blservice.OrderBLService;
import edu.nju.express.businesslogic.DataFactory;
import edu.nju.express.common.ResultMessage;
import edu.nju.express.log.ui.warning.PromptDialog;
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

			ResultMessage message = ResultMessage.INVALID;
			if(tempVo!=null){
			    message =order.createOrder(tempVo);
			if(message==ResultMessage.INVALID)
				PromptDialog.show("输入错误", "订单号已存在");
			}
		} else if (e.getActionCommand().equals("ConfirmReceival")) {
			
			String id = ((ConfirmReceivalUI) currentPanel).getTextInput().getId();
			ArrayList<OrderVO> orders = order.viewAll();
			boolean isContained = false;

			for(OrderVO vo:orders)
			{
				if(vo.getID().equals(id))
				{
					isContained = true;
					break;
				}
			}
				if(isContained){
					order.receiverCfm(id);
					PromptDialog.show("收货成功", "                你真棒");
					frame.getContentPane().removeAll();
					currentPanel = new ConfirmReceivalUI(this);
					frame.add(currentPanel);
					frame.validate();
					frame.repaint();

				}else {
					PromptDialog.show("输入有误", "             输入ID不存在");
				}
			
			
		
		} else if (e.getActionCommand().equals("SearchOrder")) {
			InquireOderUI inqUI = (InquireOderUI) currentPanel;
			String id  = inqUI.getOrder();
			ArrayList<OrderVO> orders = order.viewAll();
			boolean isContain = false;
			for(OrderVO vo:orders)
			{
				if(id.equals(vo.getID()))
				{
					isContain = true;
					break;
				}
				
			}
			
			if(isContain){
			
			vo = order.view(inqUI.getOrder());
			PromptDialog.show("查询成功", "                你真棒");
			inqUI.addRow(vo);
			}else {
				PromptDialog.show("输入有误", "            检查ID");
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
