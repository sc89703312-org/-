package edu.nju.express.businesslogic.orderbl;

import java.util.ArrayList;

import edu.nju.express.blservice.OrderBLService;
import edu.nju.express.businesslogic.DataFactory;
import edu.nju.express.common.ResultMessage;
import edu.nju.express.vo.OrderVO;


/**
 * 
 * @author lenovo
 * @version 2015年12月10日11:52:05
 * 
 * 快递员揽件后进行订单填写和收货确认时  界面和业务逻辑的交互
 */
public class OrderController implements OrderBLService{

	private OrderBLService orderBL;
	private static OrderController instance;
	
	
	private OrderController() {
		// TODO Auto-generated constructor stub

		orderBL = DataFactory.createOrderBLInstance();
	
	
	}
	
	public static OrderController getInstance()
	{
		return instance = (instance==null)?new OrderController():instance;
	}
	
	
	
	@Override
	public ResultMessage createOrder(OrderVO vo) {
		// TODO Auto-generated method stub
		return orderBL.createOrder(vo);
	}

	@Override
	public OrderVO view(String id) {
		// TODO Auto-generated method stub
		return orderBL.view(id);
	}

	@Override
	public ArrayList<OrderVO> viewAll() {
		// TODO Auto-generated method stub
		return orderBL.viewAll();
	}

	@Override
	public void receiverCfm(String id) {
		// TODO Auto-generated method stub
		orderBL.receiverCfm(id);
	}

	@Override
	public void endOrder() {
		// TODO Auto-generated method stub
		
	}

}
