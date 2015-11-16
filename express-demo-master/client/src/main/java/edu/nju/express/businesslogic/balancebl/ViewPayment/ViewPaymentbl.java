package edu.nju.express.businesslogic.balancebl.ViewPayment;

import java.util.ArrayList;

import edu.nju.express.blservice.ViewPaymentService;
import edu.nju.express.businesslogic.balancebl.Caculate;
import edu.nju.express.businesslogic.balancebl.PaymentList;
import edu.nju.express.vo.Paymentvo;



public class ViewPaymentbl implements ViewPaymentService{

	
	
	PaymentList paymentList ;
	
	public ViewPaymentbl(PaymentList paymentList) {
		// TODO Auto-generated constructor stub
	
	
		this.paymentList = paymentList ;
	
	}
	
	
	
	
	
	
	@Override
	public ArrayList<Paymentvo> viewByHall(String number) {
		// TODO Auto-generated method stub
		
		
		return paymentList.getListByStation(number);
	}

	
	
	
	
	
	@Override
	public ArrayList<Paymentvo> viewByDate(String date) {
		// TODO Auto-generated method stub
		return paymentList.getListByDate(date, date);
	}

	
	
	
	
	@Override
	public double sumPaymentByHall(String number) {
		// TODO Auto-generated method stub
		return Caculate.caculatePay(viewByHall(number));
	}

	@Override
	public double sumPaymentByDay(String date) {
		// TODO Auto-generated method stub
		return Caculate.caculatePay(viewByDate(date));
	}

	@Override
	public void endView() {
		// TODO Auto-generated method stub
		
	}

}
