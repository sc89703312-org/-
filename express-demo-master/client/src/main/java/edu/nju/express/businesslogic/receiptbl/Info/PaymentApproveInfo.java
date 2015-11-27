package edu.nju.express.businesslogic.receiptbl.Info;

import java.util.ArrayList;

import edu.nju.express.vo.Paymentvo;

public interface PaymentApproveInfo {

	public ArrayList<Paymentvo> viewAllPaymentSubmitted();
	
	public void approvePayment(String id);
}
