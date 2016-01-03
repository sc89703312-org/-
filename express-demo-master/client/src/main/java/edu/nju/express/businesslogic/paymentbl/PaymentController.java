package edu.nju.express.businesslogic.paymentbl;

import java.util.ArrayList;

import edu.nju.express.blservice.Paymentblservice;
import edu.nju.express.businesslogic.DataFactory;
import edu.nju.express.common.ResultMessage;
import edu.nju.express.vo.Paymentvo;

/**
 * 
 * @author lenovo
 * @version 2015年12月10日11:35:10
 * 营业厅业务员对收款单进行新建并提供查询
 */

public class PaymentController implements Paymentblservice {

	
	Paymentblservice paymentblservice;
	private static PaymentController instance;
	
	private PaymentController() {
		// TODO Auto-generated constructor stub
	
		this.paymentblservice = DataFactory.createPaymentBLInstance() ;
	
	}
	
	public static PaymentController getInstance()
	{
		return instance = (instance==null)?new PaymentController():instance;
	}
	
	
	@Override
	public ResultMessage createReceipt(Paymentvo vo) {
		// TODO Auto-generated method stub
		
		return paymentblservice.createReceipt(vo);
	}

	@Override
	public Paymentvo getPayment(String id) {
		// TODO Auto-generated method stub
		return paymentblservice.getPayment(id);
	}

	@Override
	public ArrayList<Paymentvo> viewAll() {
		// TODO Auto-generated method stub
		return paymentblservice.viewAll();
	}

	@Override
	public void endPayment() {
		// TODO Auto-generated method stub
		paymentblservice.endPayment();
	}

}
