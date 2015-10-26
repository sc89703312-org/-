package client.blservice.paymentblservice;

import java.util.ArrayList;

import client.ResultMessage;
import client.vo.paymentvo.Paymentvo;


public interface Paymentblservice {

	public ResultMessage  createReceipt(Paymentvo vo);
	
	public Paymentvo getPayment(String id);
	
	public ArrayList<Paymentvo> viewAll();
	
	public void endPayment();
}
