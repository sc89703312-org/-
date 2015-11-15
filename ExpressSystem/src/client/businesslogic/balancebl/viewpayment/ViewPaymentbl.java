package client.businesslogic.balancebl.viewpayment;

import java.util.ArrayList;

import client.blservice.balanceblservice.ViewPaymentService;
import client.vo.paymentvo.Paymentvo;

public class ViewPaymentbl implements ViewPaymentService{

	@Override
	public ArrayList<Paymentvo> viewByHall(String number) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public ArrayList<Paymentvo> viewByDate(String date) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public double sumPaymentByHall(String number) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public double sumPaymentByDay(String date) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public void endView() {
		// TODO Auto-generated method stub
		
	}

}
