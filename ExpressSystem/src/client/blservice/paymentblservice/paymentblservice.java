package client.blservice.paymentblservice;

import client.ResultMessage;
import client.vo.paymentvo.Paymentvo;


public interface Paymentblservice {

	public ResultMessage  createReceipt(Paymentvo vo);
	
	public Paymentvo getPayment(String id);
	
	public void endPayment();
}
