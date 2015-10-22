package client.blservice.paymentblservice;

import client.ResultMessage;
import client.vo.paymentvo.paymentvo;


public interface paymentblservice {

	public ResultMessage  createReceipt(paymentvo vo);
	
	public paymentvo getPayment(String id);
	
	public void endPayment();
}
