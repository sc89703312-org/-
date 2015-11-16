package edu.nju.express.blservice;

import java.util.ArrayList;

import edu.nju.express.common.ResultMessage;
import edu.nju.express.vo.Paymentvo;




public interface Paymentblservice {

	public ResultMessage  createReceipt(Paymentvo vo);
	
	public Paymentvo getPayment(String id);
	
	public ArrayList<Paymentvo> viewAll();
	
	public void endPayment();
}
