package client.businesslogic.balancebl.viewpayment;

import java.util.ArrayList;

import client.blservice.balanceblservice.ViewPaymentService;
import client.businesslogic.balancebl.Caculate;
import client.businesslogic.balancebl.PaymentList;
import client.vo.paymentvo.Paymentvo;

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
