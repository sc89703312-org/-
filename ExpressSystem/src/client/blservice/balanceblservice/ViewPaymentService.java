package client.blservice.balanceblservice;

import java.util.ArrayList;

import client.vo.paymentvo.Paymentvo;

public interface ViewPaymentService {

	
	public ArrayList<Paymentvo> viewByHall(String number);
	public ArrayList<Paymentvo> viewByDate(String date);
	
	public double sumPaymentByHall(String number);
	public double sumPaymentByDay(String date);
	
	
	public void endView();
}
