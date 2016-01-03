package edu.nju.express.businesslogic.balancebl.ViewPayment;

import java.util.ArrayList;

import edu.nju.express.blservice.ViewPaymentService;
import edu.nju.express.businesslogic.DataFactory;
import edu.nju.express.vo.Paymentvo;



/**
 * 
 * @author lenovo
 * @version 2015年12月10日11:25:12
 * 财务人员查看和结算收款单 界面与业务逻辑层交互
 */
public class ViewPaymentController implements ViewPaymentService {

	
	/** 查看收款单的业务逻辑实现 */
	private ViewPaymentService viewPaymentbl ;
	private static ViewPaymentController instance;
	
	private ViewPaymentController() {
		// TODO Auto-generated constructor stub
	
	
		viewPaymentbl = DataFactory.createViewPaymentblInstance();
	
	}
	
	
	public static ViewPaymentController getInstance()
	{
		return instance = (instance==null)?new ViewPaymentController():instance;
	}
	
	
	
	@Override
	public ArrayList<Paymentvo> viewByHall(String number) {
		// TODO Auto-generated method stub
		return viewPaymentbl.viewByHall(number);
	}

	@Override
	public ArrayList<Paymentvo> viewByDate(String date) {
		// TODO Auto-generated method stub
		return viewPaymentbl.viewByDate(date);
	}

	@Override
	public ArrayList<Paymentvo> getAll() {
		// TODO Auto-generated method stub
		return viewPaymentbl.getAll();
	}

	@Override
	public double sumPaymentByHall(String number) {
		// TODO Auto-generated method stub
		return viewPaymentbl.sumPaymentByHall(number);
	}

	@Override
	public double sumPaymentByDay(String date) {
		// TODO Auto-generated method stub
		return viewPaymentbl.sumPaymentByDay(date);
	}

	@Override
	public void endView() {
		// TODO Auto-generated method stub
		
	}

}
