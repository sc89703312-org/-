package edu.nju.express.blservice;

import java.util.ArrayList;

import edu.nju.express.vo.Paymentvo;



public interface ViewPaymentService {

	
	public ArrayList<Paymentvo> viewByHall(String number);
	public ArrayList<Paymentvo> viewByDate(String date);
	
	public double sumPaymentByHall(String number);
	public double sumPaymentByDay(String date);
	
	
	public void endView();
}
